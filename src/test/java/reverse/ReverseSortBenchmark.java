package reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
public class ReverseSortBenchmark {

  @Param({"1000000"})
  private int size;

  private List<Integer> list;

  @Setup
  public void setup() {
    list = generateListWithRandomIntegers(size);
  }

  @Benchmark
  public List<Integer> reverseSortedFirstApproach() {
    return list.stream()
        .sorted()
        .collect(Collectors.toList())
        .reversed();
  }

  @Benchmark
  public List<Integer> reverseSortedSecondApproach() {
    return list.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
  }

  @Benchmark
  public List<Integer> reverseSortedThirdApproach() {
    List<Integer> sortedList = new ArrayList<>(list);
    Collections.sort(sortedList);
    Collections.reverse(sortedList);
    return sortedList;
  }

  @Benchmark
  public List<Integer> reverseSortedFourthApproach() {
    List<Integer> reversedList = new ArrayList<>();
    Collections.sort(reversedList);
    ListIterator<Integer> listIterator = reversedList.listIterator(reversedList.size());
    while (listIterator.hasPrevious()) {
      reversedList.add(listIterator.previous());
    }
    return reversedList;
  }

  @Benchmark
  public List<Integer> reverseSortedFifthApproach() {
    List<Integer> sortedList = new ArrayList<>(list);
    sortedList.sort(Comparator.reverseOrder());
    return sortedList;
  }

  public List<Integer> generateListWithRandomIntegers(int size) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add((int) (Math.random() * size));
    }
    return list;
  }

  public static void main(String[] args) throws Exception {
    org.openjdk.jmh.Main.main(args);
  }
}