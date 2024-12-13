import java.util.*;
class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = points;
    }

    public static Polyline createPolyline(List<Point> points) {
        // Убираем точки с одинаковыми координатами
        Set<Point> uniquePoints = new HashSet<>(points);

        // Преобразуем отрицательные значения Y в положительные
        List<Point> processedPoints = new ArrayList<>();
        for (Point point : uniquePoints) {
            processedPoints.add(new Point(point.getX(), Math.abs(point.getY())));
        }

        // Сортируем точки по X
        processedPoints.sort(Comparator.comparingInt(Point::getX));

        // Создаем и возвращаем Polyline
        return new Polyline(processedPoints);
    }

    @Override
    public String toString() {
        return "Линия [" + String.join(",", points.stream().map(Point::toString).toArray(String[]::new)) + "]";
    }
}