import java.util.concurrent.*;

import static java.lang.Thread.currentThread;

public class Thread {
    public static void main(String arg[]){
        ExecutorService executorService = new ThreadPoolExecutor(3,5,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<6;i++){
            executorService.execute(()->{
                System.out.println(java.lang.Thread.currentThread().getName()+"办理业务");

            });
        }
        executorService.shutdown();
    }
}
