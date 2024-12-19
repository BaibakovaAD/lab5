public class Fraction<T extends Number> implements IFraction<T> {
    private T numerator;   // Числитель
    private T denominator; // Знаменатель
    private Double cachedRealValue; // Кэш вещественного значения

    // Конструктор
    public Fraction(T numerator, T denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        normalize(numerator, denominator);
    }

    // Метод нормализации знака: знаменатель всегда положителен
    private void normalize(T numerator, T denominator) {
        if (denominator.doubleValue() < 0) {
            this.numerator = (T) Double.valueOf(-numerator.doubleValue());
            this.denominator = (T) Double.valueOf(-denominator.doubleValue());
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        this.cachedRealValue = null; // Сброс кэша
    }

    // Установка числителя
    @Override
    public void setNumerator(T numerator) {
        this.numerator = numerator;
        this.cachedRealValue = null; // Сброс кэша
    }

    // Установка знаменателя
    @Override
    public void setDenominator(T denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        normalize(this.numerator, denominator);
    }

    // Получение вещественного значения с кэшированием
    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = numerator.doubleValue() / denominator.doubleValue();
        }
        return cachedRealValue;
    }

    // Строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Сравнение объектов по значению
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Fraction<?> other = (Fraction<?>) obj;
        return Double.compare(this.getRealValue(), other.getRealValue()) == 0;
    }

    // Хеш-код для корректной работы с коллекциями
    @Override
    public int hashCode() {
        return Double.hashCode(getRealValue());
    }
}