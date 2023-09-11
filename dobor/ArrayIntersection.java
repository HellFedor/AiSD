package DoborAisd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
    public static int[] findIntersection(int[] x, int[] y) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> intersectionList = new ArrayList<>();

        // Построение частотной карты для массива x
        for (int num : x) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Проверка элементов массива y и добавление их в пересечение
        for (int num : y) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                intersectionList.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        // Преобразование списка в массив
        int[] intersectionArray = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            intersectionArray[i] = intersectionList.get(i);
        }

        return intersectionArray;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 2, 3, 4, 5};
        int[] y = {2, 3, 3, 4, 4, 5, 6};

        int[] intersection = findIntersection(x, y);

        // Вывод пересечения
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}
