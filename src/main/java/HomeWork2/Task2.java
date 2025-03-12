package HomeWork2;

import java.util.ArrayList;
import java.util.Random;
/**
 Задание 2
 * @author Artem Denisov
 */
public class Task2 {
    private static final int MAX_RANDOM_VALUE = 100;

    /**
     * Точка входа.
     * <p>
     * Создает список из случайных вещественных чисел, сортирует его с помощью алгоритма Selection Sort и выводит результат в консоль.
     * </p>
     */
    public static void main(String[] args) {
        int n = 10;
        ArrayList<Double> list = fillListWithRandomDoubles(n);
        System.out.println("Исходный список: " + list);

        ArrayList<Double> sortedList = selectionSort(list);
        System.out.println("Отсортированный список: " + sortedList);
    }

    /**
     * Заполняет список случайными вещественными числами в диапазоне от 0 до {@code MAX_RANDOM_VALUE}.
     *
     * @param n количество элементов в списке
     * @return список вещественных чисел размером {@code n}
     */
    public static ArrayList<Double> fillListWithRandomDoubles(int n){
        Random rnd = new Random();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(rnd.nextDouble() * MAX_RANDOM_VALUE);
        }
        return list;
    }

    /**
     * Сортирует список с помощью алгоритма Selection Sort.
     *
     * @param list список вещественных чисел
     * @return отсортированный список
     */
    public static ArrayList<Double> selectionSort(ArrayList<Double> list){
        ArrayList<Double> sortedList = new ArrayList<>(list);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            int minIndex = i;

            // Ищем минимальный элемент в неотсортированной части
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j) < sortedList.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Меняем местами минимальный элемент с текущим
            Double temp = sortedList.get(minIndex);
            sortedList.set(minIndex, sortedList.get(i));
            sortedList.set(i, temp);
        }

        return sortedList;
    }
}
