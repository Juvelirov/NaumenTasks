package HomeWork2.Task5;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Задача 5.
 *
 * @author Artem Denisov
 */
public class TaskImplementation implements Task {

    /**
     * Точка входа.
     *
     * @throws InterruptedException Если поток был прерван.
     */
    public static void main(String[] args) throws InterruptedException {
        TaskImplementation queue = new TaskImplementation();

        queue.addElement("Медведь");
        queue.addElement("Собака");
        queue.addElement("Жираф");

        queue.start();
        queue.stop();
    }

    /**
     * Очередь для хранения элементов.
     */
    private Queue<String> queue;

    /**
     * Флаг, указывающий, запущен ли процесс обработки.
     */
    private boolean isRunning;

    /**
     * Инициализирует queue и устанавливает флаг isRunning в false.
     */
    public TaskImplementation() {
        this.queue = new LinkedList<>();
        this.isRunning = false;
    }

    /**
     * Запускает процесс обработки элементов в очереди.
     */
    @Override
    public void start() {
        if (!isRunning) {
            isRunning = true;
            processing();
        }
    }

    /**
     * Останавливает процесс обработки элементов.
     */
    @Override
    public void stop() {
        isRunning = false;
    }

    /**
     * Добавит элемент в очередь.
     *
     * @param elem Элемент на добавление.
     */
    public void addElement(String elem) {
        queue.add(elem);
    }

    /**
     * Обрабатывает элементы в queue.
     * Обработка продолжится, пока очередь не будет пуста.
     */
    private void processing() {
        while (isRunning && !queue.isEmpty()) {
            String data = queue.poll(); // Получаем элемент после удаления
            System.out.println("Обработка: " + data);
            try {
                Thread.sleep(1000); // Процесс обработки...
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isRunning = false;
    }
}
