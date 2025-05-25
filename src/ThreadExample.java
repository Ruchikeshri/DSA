import java.util.concurrent.*;

public class ThreadExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException,Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        Future<String> result = executorService.submit(() -> {
//            System.out.println("call executed");
//            return "Success";
//        });
//        System.out.println(result.get());
//        executorService.shutdown();
//
//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("using annonumopus inner class");
//                try {
//                    System.out.println("done");
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        th.start();
//        System.out.println(th.getName());
//
//        Thread th1 = new Thread(() -> {
//            try {
//                Thread.sleep(10);
//                System.out.println("Using Lambda Expression");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        th1.start();
//        System.out.println(th1.getName());
//        Thread t = new Thread();
//
//        new Thread(() ->
//        {
//            synchronized (ThreadExample.class) {
//                TestSynchronized();
//            }
//        }).start();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                synchronized (ThreadExample.class) {
//                    TestSynchronized();
//                }
//            }
//        };
//        Thread t4 = new Thread(runnable);
//        t4.start();
//
//
//        Runnable r = ()->{
//            synchronized (ThreadExample.class) {
//                TestSynchronized();
//            }
//        };
//
//        Thread t5 = new Thread(r);
//         t5.start();



         String s1 = "Hi";
         String s2 = "Hello";


         Thread t11 = new Thread(
                 ()->{
                     synchronized (s1) {
                         System.out.println("Thread-1 locked resource-1");
                         try {
                             Thread.sleep(1);
                             System.out.println("releasing");

                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
//                     }
                         synchronized (s2) {
                             System.out.println("wating for 2");
                             System.out.println("Thread-1 waiting for resouce-2");
                         }
                     }
                 }
         );

         Thread t12 = new Thread(
                 () -> {
                     synchronized (s1) {
                         System.out.println("Thread-2 locked resouced2");
                         try {
                             Thread.sleep(1);
                             System.out.println("releasing");
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         //acquire lock after locjk comletes or acquitre lock in the asam order lock1-> lock2 in both threads
//                     }
                         synchronized (s2) {
                             System.out.println("wating for 1");
                             System.out.println("Thread-2 waiting for resouce-1");
                         }
                     }
                 }
         );

         t11.start();
         t12.start();


    }








    private static void TestSynchronized() {
        System.out.println("Lets Test Synchronized");
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=>" + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
