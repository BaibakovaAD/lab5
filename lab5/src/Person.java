import java.util.*;
import java.util.stream.*;

public class Person {
    private final String name;
    private final int number;

    // Конструктор
    public Person(String name, int number) {
        this.name = capitalizeName(name); // Преобразуем имя с первой заглавной буквой
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // Преобразование имени с первой заглавной буквой
    private String capitalizeName(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    // Метод для обработки файла и группировки людей по номерам
    public static Map<Integer, List<String>> processFile(List<String> lines) {
        return lines.stream() // Используем стрим для обработки данных
                .map(line -> line.split(":")) // Разделяем строку на имя и номер
                .filter(parts -> parts.length == 2 && !parts[1].isEmpty()) // Отфильтровываем строки с пустыми номерами
                .map(parts -> new Person(parts[0], Integer.parseInt(parts[1]))) // Преобразуем в объекты Person
                .collect(Collectors.groupingBy(
                        Person::getNumber, // Группировка по номеру
                        TreeMap::new, // Использование TreeMap для сортировки по номерам
                        Collectors.mapping(Person::getName, Collectors.toList()) // Собираем имена в список
                ));
    }
}
