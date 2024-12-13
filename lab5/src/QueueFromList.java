import java.util.*;

public class QueueFromList {
    public static Queue<Integer> buildQueue(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();

        // Добавляем элементы из списка в очередь
        for (int element : list) {
            queue.add(element);
        }

        // Добавляем элементы из списка в обратном порядке
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }

        return queue;
    }
}

