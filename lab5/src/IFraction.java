// Интерфейс для дроби с дженериками
public interface IFraction<T extends Number> {
    double getRealValue(); // Получение вещественного значения
    void setNumerator(T numerator); // Установка числителя
    void setDenominator(T denominator); // Установка знаменателя
}