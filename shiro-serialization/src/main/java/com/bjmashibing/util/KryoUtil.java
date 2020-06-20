package com.bjmashibing.util;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.DefaultInstantiatorStrategy;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-19 9:50
 */
public class KryoUtil {

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static Map<Class, Registration> registrationMap = new ConcurrentHashMap<Class, Registration>();

    //每个线程的 Kryo 实例
    private static final ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();

            /**
             * 不要轻易改变这里的配置！更改之后，序列化的格式就会发生变化，
             * 上线的同时就必须清除 Redis 里的所有缓存，
             * 否则那些缓存再回来反序列化的时候，就会报错
             */
            //支持对象循环引用（否则会栈溢出）
            kryo.setReferences(true);

            //不强制要求注册类（注册行为无法保证多个 JVM 内同一个类的注册编号相同；而且业务系统中大量的 Class 也难以一一注册）
            kryo.setRegistrationRequired(false);

            //Fix the NPE bug when deserializing Collections.
            ((DefaultInstantiatorStrategy) kryo.getInstantiatorStrategy())
                    .setFallbackInstantiatorStrategy(new StdInstantiatorStrategy());

            return kryo;
        }
    };

    /**
     * 获得当前线程的 Kryo 实例
     *
     * @return 当前线程的 Kryo 实例
     */
    public static Kryo getInstance() {
        return kryoLocal.get();
    }


    /**
     * 将对象【及类型】序列化为字节数组
     *
     * @param obj 任意对象
     * @param <T> 对象的类型
     * @return 序列化后的字节数组
     */
    public static <T> byte[] writeToByteArray(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Kryo kryo = KryoUtil.getInstance();
        if (!registrationMap.containsKey(clazz)) {
            Registration registration = kryo.register(clazz);
            registrationMap.put(clazz, registration);
        }
        ByteArrayOutputStream outputStream = null;
        Output output = null;
        byte[] bytes;
        try {
            outputStream = new ByteArrayOutputStream();
            output = new Output(outputStream);
            kryo.writeObject(output, obj);
            output.flush();
            bytes = outputStream.toByteArray();
            return bytes;
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception ignore) {

            }
        }

    }


    /**
     * 将字节数组反序列化为原对象
     *
     * @param data writeToByteArray 方法序列化后的字节数组
     * @param <T>       原对象的类型
     * @return 原对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T readObjectFromByteArray(byte[] data, Class<T> clazz) {
        Kryo kryo = KryoUtil.getInstance();
        Registration registration = registrationMap.get(clazz);
        if (registration == null) {
            registration = kryo.register(clazz);
            registrationMap.put(clazz, registration);
        }
        T object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        Input input;
        try {
            byteArrayInputStream = new ByteArrayInputStream(data);
            input = new Input(byteArrayInputStream);
            object = (T) kryo.readObject(input, registration.getType());
            input.close();
        } finally {
            try {
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (IOException ignore) {
            }
        }
        return object;
    }

}