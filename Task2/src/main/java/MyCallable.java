import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        int res = 0;
        try {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s %s что-то делает ...\n",
                        java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                        Thread.currentThread().getName());
                res = i;
                Thread.sleep(2_000);
            }

        } catch (InterruptedException err) {
            System.out.printf("%s %s спал\n",
                    java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    Thread.currentThread().getName());
            res++;
        } finally {
            System.out.printf("%s %s завершен\n",
                    java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                    Thread.currentThread().getName());
            res++;
        }
        return res;
    }
}