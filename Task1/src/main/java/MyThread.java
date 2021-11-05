import java.time.format.DateTimeFormatter;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2_500);
                System.out.printf("%s %s что-то делает ...\n",
                        java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), getName());
            }

        } catch (InterruptedException err) {
            System.out.printf("%s %s спал\n",
                    java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), getName());
        } finally {
            System.out.printf("%s %s завершен\n",
                    java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), getName());
        }
    }
}