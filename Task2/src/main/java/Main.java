import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void invoke(List<Callable<Integer>> list, boolean isInvokeAll) throws InterruptedException, ExecutionException {
        // Создаем пул потоков фиксированного размера
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        if (isInvokeAll) {
            List<Future<Integer>> futures = threadPool.invokeAll(list);

            // Завершаем работу пула потоков
            threadPool.shutdown();

            // Выводим результат
            int i = 1;
            for (Future<Integer> integerFuture : futures) {
                System.out.println("Потоком " + i++ + " выведено " + integerFuture.get() + " сообщений на экран");
            }
        } else {
            Integer f = threadPool.invokeAny(list);

            // Завершаем работу пула потоков
            threadPool.shutdown();

            // Выводим результат
            System.out.println("Потоком самым быстрым выведено " + f + " сообщений на экран");
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Integer> myThread1 = new MyCallable();
        Callable<Integer> myThread2 = new MyCallable();
        Callable<Integer> myThread3 = new MyCallable();
        Callable<Integer> myThread4 = new MyCallable();

        invoke(Arrays.asList(myThread1, myThread2, myThread3, myThread4), true);
        invoke(Arrays.asList(myThread1, myThread2, myThread3, myThread4), false);
    }
}
