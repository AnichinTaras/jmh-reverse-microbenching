package reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OldApproach {
  public static void main(String[] args) {
    List<Integer> list = generateListWithRandomIntegers(10000000);
    long startTime, endTime;

    // Approach 1: sorted().toList().reversed()
    startTime = System.nanoTime();
    reverseSortedFirstApproach(list);
    endTime = System.nanoTime();
    System.out.println("Approach # 1 Time: " + (endTime - startTime) + " nanoseconds");

    // Approach 2: sorted(Comparator.reverseOrder())
    startTime = System.nanoTime();
    reverseSortedSecondApproach(list);
    endTime = System.nanoTime();
    System.out.println("Approach # 2 Time: " + (endTime - startTime) + " nanoseconds");

    // Approach 3: Collections.reversed()
    startTime = System.nanoTime();
    reverseSortedThirdApproach(list);
    endTime = System.nanoTime();
    System.out.println("Approach # 3 Time: " + (endTime - startTime) + " nanoseconds");

    // Approach 4: Using sort() with Comparator.reverseOrder()
    startTime = System.nanoTime();
    reverseSortedFourthApproach(list);
    endTime = System.nanoTime();
    System.out.println("Approach # 4 Time: " + (endTime - startTime) + " nanoseconds");
  }

  public static List<Integer> generateListWithRandomIntegers(int size) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * size));
    }
    return list;
  }

  // Approach 1
  private static List<Integer> reverseSortedFirstApproach(List<Integer> list) {
    return list.stream()
        .sorted()
        .toList()
        .reversed();
  }

  // Approach 2
  private static List<Integer> reverseSortedSecondApproach(List<Integer> list) {
    return list.stream()
        .sorted(Comparator.reverseOrder())
        .toList();
  }

  // Approach 3
  public static List<Integer> reverseSortedThirdApproach(List<Integer> list) {
    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);
    Collections.reverse(sortedList);
    return sortedList;
  }

  // Approach 4
  public static List<Integer> reverseSortedFourthApproach(List<Integer> list) {
    List<Integer> sortedList = new ArrayList<>(list);
    sortedList.sort(Comparator.reverseOrder());
    return sortedList;
  }
}