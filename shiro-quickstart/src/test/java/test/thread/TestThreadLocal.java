package test.thread;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

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
     ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    static ThreadPoolExecutor executor2 = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    //sso
    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        TestThreadLocal testThreadLocal= new TestThreadLocal();

        for (int i = 0; i < 2; i++) {
            String finalI = "jdPin-" + i;
            executor2.execute(() -> {
                Thread.currentThread().setName(finalI);
                testThreadLocal.sso(finalI);

                testThreadLocal.YeWuMethod(Thread.currentThread().getName());
            });
        }

    }

    private  void sso(String finalI) {
        threadLocal.set(finalI);
    }

    private void YeWuMethod(String name) {

//         executor = new ThreadPoolExecutor(2, 2,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());

        for (int j = 0; j < 10; j++) {


//            Runnable task = new RunnableTask();
//            Runnable ttlRunnable = TtlRunnable.get(task);

//            executor.execute(ttlRunnable);

            executor.execute(() -> {
                System.out.println("=========="+name+"==="+threadLocal.get());
            });
        }

//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                System.out.println(name+"==="+threadLocal.get());
//            }, "input thread name").start();
//        }




    }

//    public static void testInThreadLocal() {
//        InheritableThreadLocalMap<Map<Object, Object>> threadLocal = new InheritableThreadLocalMap<>();
//
//        new Thread(() -> {
//            System.out.println(threadLocal.get().get("key"));
//        }, "input thread name").start();
//    }
//
//    public static void testThreadLocal() {
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        threadLocal.set("测试threadLocal");
//        new Thread(() -> {
//            System.out.println(threadLocal.get());
//        }, "input thread name").start();
//
//    }

//    private static final class InheritableThreadLocalMap<T extends Map<Object, Object>> extends InheritableThreadLocal<Map<Object, Object>> {
//
//        /**
//         * This implementation was added to address a
//         * <a href="http://jsecurity.markmail.org/search/?q=#query:+page:1+mid:xqi2yxurwmrpqrvj+state:results">
//         * user-reported issue</a>.
//         * @param parentValue the parent value, a HashMap as defined in the {@link #initialValue()} method.
//         * @return the HashMap to be used by any parent-spawned child threads (a clone of the parent HashMap).
//         */
//        @SuppressWarnings({"unchecked"})
//        protected Map<Object, Object> childValue(Map<Object, Object> parentValue) {
//            if (parentValue != null) {
//                return (Map<Object, Object>) ((HashMap<Object, Object>) parentValue).clone();
//            } else {
//                return null;
//            }
//        }
//    }
}
