import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //ЗАДАЧА 1.1
        System.out.println("Задача 1.1 Дробь \n ");

        // Создаем несколько дробей для проверки
        Fraction fraction1 = new Fraction(3, 4); // 3/4
        Fraction fraction2 = new Fraction(2, 5); // 2/5

        // Выводим дроби и их вещественные значения
        System.out.println("Первая простая дробь: " + fraction1);
        System.out.println("Первая дробь в десятичном представлении: " + fraction1.toDouble());

        System.out.println("Вторая простая дробь: " + fraction2);
        System.out.println("Вторая дробь в десятичном представлении: " + fraction2.toDouble());

        // Проверка кэширования
        System.out.println("Первая дробь в десятичном представлении (кешированная): " + fraction1.toDouble());

        // Изменяем числитель и знаменатель
        fraction1.setNumerator(5);
        System.out.println("Первая дробь после изменения числителя: " + fraction1);
        System.out.println("Первая дробь в вещественном представлении: " + fraction1.toDouble());

        fraction1.setDenominator(8);
        System.out.println("Первая дробь после изменения знаменателя: " + fraction1);
        System.out.println("Первая дробь в вещественном представлении: " + fraction1.toDouble());

        // Проверка операций с дробями
        Fraction sum = fraction1.add(fraction2);
        System.out.println("Сумма дробей 1 и 2: " + sum + " в вещественном представлении: " + sum.toDouble());

        Fraction difference = fraction1.subtract(fraction2);
        System.out.println("Разность дробей 1 и 2: " + difference + " в вещественном представлении: " + difference.toDouble());

        Fraction product = fraction1.multiply(fraction2);
        System.out.println("Умножение дробей 1 и 2: " + product + " в вещественном представлении: " + product.toDouble());

        Fraction quotient = fraction1.divide(fraction2);
        System.out.println("Деление 1 дроби на 2: " + quotient + " в вещественном представлении: " + quotient.toDouble());

        // Проверка деления на ноль
        try {
            Fraction invalidFraction = new Fraction(1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // ЗАДАЧА 2.1
        System.out.println("\nЗадача 2.1 Количество мяуканий \n ");

        // Создаем кота
        Cat cat = new Cat("Барсик");

        // Вызываем метод meowsCare несколько раз для одного кота
        Cat.meowsCare(cat, cat, cat, cat, cat);

        // Выводим количество мяуканий
        System.out.println("Кот мяукал " + cat.getMeowCount() + " раз");

        //ЗАДАЧА 3.2
        System.out.println("\nЗадача 3.2 Замена в списках \n ");

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 3, 4, 5));

        // Создание списка L1 (subList)
        List<Integer> subList = new ArrayList<>(Arrays.asList(3, 4, 5));

        // Создание списка L2 (replacement)
        List<Integer> replacement = new ArrayList<>(Arrays.asList(7, 8, 9));

        System.out.println("Исходный список: " + list);

        // Замена первого вхождения L1 на L2
        ListReplacer.replaceFirstOccurrence(list, subList, replacement);

        System.out.println("Изменённый список: " + list);


        //ЗАДАЧА 5.2
        System.out.println("\nЗадача 5.2 Глухие согласные \n ");

        String fileName = "C:\\Users\\Анастасия Байбакова\\IdeaProjects\\lab5\\src\\input.txt"; // Имя входного файла

        try {
            // Чтение содержимого файла
            String content = Files.readString(Path.of(fileName));

            // Вывод содержимого файла
            System.out.println("Содержимое файла:");
            System.out.println(content);

            // Поиск глухих согласных, которые не входят в слова
            Set<Character> unusedDeafConsonants = DeafConsonants.findUnusedDeafConsonants(content);

            // Печать результата
            System.out.println("\nГлухие согласные, не входящие ни в одно слово:");
            unusedDeafConsonants.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        //ЗАДАЧА 6.2
        System.out.println("\nЗадача 6.2 Очередь Палиндром \n ");
        // Исходный список
        List<Integer> exampleList = Arrays.asList(1, 2, 3);

        // Построение очереди из списка
        Queue<Integer> queue = QueueFromList.buildQueue(exampleList);

        // Вывод содержимого очереди
        System.out.println("Построенная очередь: " + queue);

        //ЗАДАЧА 7.1
        System.out.println("\nЗадача 7.1 Ломанная линия \n ");
        List<Point> points = Arrays.asList(
                new Point(1, -2),
                new Point(3, 4),
                new Point(1, -2), // Дубликат
                new Point(3, -4),
                new Point(0, -5)
        );

        Polyline polyline = Polyline.createPolyline(points);
        System.out.println(polyline);

        //ЗАДАЧА 7.2
        System.out.println("\nЗадача 7.2 Номер-имя \n ");
        // Укажите путь к вашему файлу
        Path path = Paths.get("C:\\Users\\Анастасия Байбакова\\IdeaProjects\\lab5\\src\\people.txt");

        try {
            // Чтение строк из файла
            List<String> lines = Files.readAllLines(path);

            System.out.println("Содержимое файла:");
            System.out.println(lines);

            // Обработка данных с помощью метода processFile класса Person
            Map<Integer, List<String>> groupedNames = Person.processFile(lines);

            System.out.println("Группировка по номеру:");
            System.out.println(groupedNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}