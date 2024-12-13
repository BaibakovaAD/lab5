public class Cat implements Meowable {
    private final String name; // Имя кота
    private int meowCount = 0; // Счетчик мяуканий

    // Конструктор для создания кота с именем
    public Cat(String name) {
        this.name = name;
    }

    // Метод мяуканья
    @Override
    public void meow() {
        meowCount++;
        System.out.println(name + ": мяу!");
    }

    // Метод для получения количества мяуканий
    public int getMeowCount() {
        return meowCount;
    }

    // Преобразование кота в строку
    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Метод для работы с набором объектов Meowable
    public static void meowsCare(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
