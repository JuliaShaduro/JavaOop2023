
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите 1-ое число интервала = ");
        double from = scanner.nextDouble();

        System.out.print("Введите 2-ое число интервала = ");
        double to = scanner.nextDouble();

        System.out.print("Введите число = ");
        double number = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.println("Длина 1-ого диапазона  = " + range.getLength(range.getFrom(), range.getTo()));
        System.out.println("Число входит в интервал (true = да, false = нет.) = " + range.isInside(number));

        range.setFrom(3);
        range.setTo(10);

        System.out.println("Длина 2-ого диапазона = " + range.getLength(range.getFrom(), range.getTo()));
        System.out.println("Число входит в интервал (true = да, false = нет.) =  " + range.isInside(number));

        System.out.println("Результат проверки пересечения (null = нет) = "
                + range.getIntersection(from, to));

        double[][] arrayUnification = range.getIntervalsUnification(from, to);

        for (double[] e : arrayUnification) {
            System.out.println("Результат объединения интервалов = " + Arrays.toString(e));
        }

        double[][] arrayDifference = range.getIntervalsDifference(from, to);

        if (arrayDifference == null) {
            System.out.println("Пустое множество.");
        } else {
            for (double[] e : arrayDifference) {
                System.out.println("Разница интервалов = " + Arrays.toString(e));
            }
        }
    }
}