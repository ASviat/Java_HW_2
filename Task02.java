/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Task02 {

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fh = new FileHandler("Task02_log.txt");
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Scanner inputFScanner = new Scanner(System.in);
        System.out.println("Введите количество значений в массиве: ");
        int[] myArray = new int[inputFScanner.nextInt()];
        logger.info("Указан размер массива.");
        System.out.println();

        for (int i = 0; i < myArray.length; i++) {
            System.out.printf("Введите число %d: ", i+1);
            myArray[i] = inputFScanner.nextInt();
        }
        System.out.println();

        inputFScanner.close();

        int[] sortedArray = SortArray(myArray, logger);
        System.out.println("Отсортированный массив в порядке убывания: ");

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.printf("%d ", sortedArray[i]);
        }
    }

    public static int[] SortArray(int[] array, Logger logger) {
        int copy = 0;
        logger.info("Начата сортировка массива");
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] < array[j]) {
                    copy = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = copy;
                    logger.info("Стадия сортировки прошла успешно.");
                }
            }
        }
        logger.info("Сортировка завершена");
        return array;
    }
}