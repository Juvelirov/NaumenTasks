package HomeWork2.Task5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
        TaskImplementation task = new TaskImplementation();
        Queue<String> queue = task.queue;
        queue.add("Медведь");
        queue.add("Собака");
        queue.add("Жираф");


        task.start();
        task.stop();
    }

    Scanner scanner = new Scanner(System.in);
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
     * Непрерывно проверяет очередь на наличие элементов, после чего обработает их.
     * В случае отсутствия элементов в очереди будем ожидать ввода пользователя для добавления нового элемента или завершения обработки.
     *
     * <p>Возможные команды пользователя:
     * <ul>
     *     <li><b>stop</b>: Останавливает обработку.</li>
     *     <li><b>add</b>: Добавляет новый элемент в очередь.</li>
     * </ul>
     * </p>
     */
    private void processing() {
        while (isRunning) {
            if(!queue.isEmpty()){ // Если очередь не пуста, то обрабатываем в ней элементы
                String data = queue.poll(); // Получаем элемент после удаления
                System.out.println("Обработка: " + data);
                try {
                    Thread.sleep(1000); // Процесс обработки...
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            else{
                System.out.println("Введите 'stop' для окончания обработки, элементов в очереди больше нет!");
                System.out.println("Введите 'add' для добавления элемента в очередь...");
                String message = scanner.nextLine();
                if(message.equals("stop")){
                    stop();
                }
                else if (message.equals("add")){
                    System.out.println("Введите название добавляемого элемента (Очередь принимает только строки).");
                    String elem = scanner.nextLine();
                    queue.add(elem);
                }
                else{
                    System.out.println("Недопустимая команда!");
                }
            }
        }

    }
}