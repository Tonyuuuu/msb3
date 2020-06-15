package test.thread;

import org.apache.shiro.SecurityUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-11 22:40
 */
public class TestThreadLocal {
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public static void main(String[] args) {
        ThreadLocal<Map<Object, Object>> threadLocal = new InheritableThreadLocalMap<>();
        for (int i = 0; i < 10; i++) {
            Map<Object, Object> map = new HashMap<>();
            map.put("key", i);
            threadLocal.set(map);
            executor.execute(()->{
                System.out.println(threadLocal.get().get("key"));
            });
        }
    }

    public static void testInThreadLocal(){
        ThreadLocal<Map<Object, Object>> threadLocal = new InheritableThreadLocalMap<>();
        Map<Object, Object> map = new HashMap<>();
        map.put("key", "value");
        threadLocal.set(map);
        new Thread(() -> {
            System.out.println(threadLocal.get().get("key"));
        }, "input thread name").start();
    }
    public static void testThreadLocal(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("测试threadLocal");
        new Thread(() -> {
            System.out.println(threadLocal.get());
        }, "input thread name").start();

    }

    private static final class InheritableThreadLocalMap<T extends Map<Object, Object>> extends InheritableThreadLocal<Map<Object, Object>> {

        /**
         * This implementation was added to address a
         * <a href="http://jsecurity.markmail.org/search/?q=#query:+page:1+mid:xqi2yxurwmrpqrvj+state:results">
         * user-reported issue</a>.
         * @param parentValue the parent value, a HashMap as defined in the {@link #initialValue()} method.
         * @return the HashMap to be used by any parent-spawned child threads (a clone of the parent HashMap).
         */
        @SuppressWarnings({"unchecked"})
        protected Map<Object, Object> childValue(Map<Object, Object> parentValue) {
            if (parentValue != null) {
                return (Map<Object, Object>) ((HashMap<Object, Object>) parentValue).clone();
            } else {
                return null;
            }
        }
    }
}
