import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread  myThread1  =  new  MyThread();
        myThread1.setName("Поток 1");

        Thread  myThread2  =  new  MyThread();
        myThread2.setName("Поток 2");

        Thread  myThread3  =  new  MyThread();
        myThread3.setName("Поток 3");

        Thread  myThread4  =  new  MyThread();
        myThread4.setName("Поток 4");

        // Создаем пул потоков фиксированного размера
        final ExecutorService threadPool  =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        threadPool.submit(myThread1);
        threadPool.submit(myThread2);
        threadPool.submit(myThread3);
        threadPool.submit(myThread4);

        sleep(10_000);

        // Завершаем работу пула потоков
        threadPool.shutdownNow();
    }
}
