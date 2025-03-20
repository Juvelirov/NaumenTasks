package HomeWork2;

import java.util.Arrays;
import java.util.Random;

/**
 * Задание 1. Работа с массивом.
 * <p>
 * Программа заполняет массив (тип элементов "int") случайными числами и выполняет задание в соответствии с вариантом 4:
 * <strong>Найти последний положительный элемент в массиве.</strong>
 * </p>
 * <p>
 * <b>Входные данные:</b> количество элементов в формируемом массиве {@code n} (где {@code n >= 0}).
 * </p>
 * <p>
 * <b>Выходные данные:</b> в консоль выводятся сформированный массив и результат поиска последнего положительного элемента.
 * </p>
 *
 * @author Artem Denisov
 */
public class Task1 {
    private static final int MAX_RANDOM_VALUE = 100;

    /**
     * Точка входа.
     * <p>
     * Создает массив из случайных целых чисел, находит последний положительный элемент в массиве и выводит результат в консоль.
     * </p>
     */
    public static void main(String[] args) {
        int[] array = fillArrayWithRandomIntegers(10);
        int lastPositiveElem = findLastPositiveElement(array);
        printArrayAndResult(array, lastPositiveElem);
    }

    /**
     * Заполняет массив случайными целыми числами в диапазоне от {@code -MAX_RANDOM_VALUE} до {@code MAX_RANDOM_VALUE - 1}.
     *
     * @param n количество элементов в массиве
     * @return массив целых чисел размером {@code n}
     */
    public static int[] fillArrayWithRandomIntegers(int n){
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(MAX_RANDOM_VALUE * 2) - MAX_RANDOM_VALUE;
        }
        return array;
    }

    /**
     * Находит последний положительный элемент в array.
     * <p>
     * Если массив является пустым или вообще не содержит положительных элементов, выбрасывает исключение.
     * </p>
     *
     * @param array массив целых чисел
     * @return последний положительный элемент в массиве
     * @throws IllegalArgumentException если массив пустой или не содержит положительных элементов
     */
    public static int findLastPositiveElement(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пустой");
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                return array[i];
            }
        }

        throw new IllegalArgumentException("В массиве нет положительных элементов");
    }

    /**
     * Выводит в консоль сформированный массив и результат поиска последнего положительного элемента.
     *
     * @param array массив целых чисел
     * @param lastPositiveElement последний положительный элемент в массиве
     */
    public static void printArrayAndResult(int[] array, int lastPositiveElement){
        System.out.println(Arrays.toString(array));
        System.out.println(lastPositiveElement);
    }
}
