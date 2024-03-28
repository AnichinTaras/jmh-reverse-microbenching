Results:

Benchmark using JMH

Size 10000000

Benchmark                                           (size)  Mode  Cnt           Score           Error  Units
ReverseSortBenchmark.reverseSortedFirstApproach   10000000  avgt   20  2923303864,600 ± 123287364,113  ns/op
ReverseSortBenchmark.reverseSortedSecondApproach  10000000  avgt   20  2946076258,350 ±  50319367,037  ns/op
ReverseSortBenchmark.reverseSortedThirdApproach   10000000  avgt   20  2463060941,650 ±  43480620,539  ns/op
ReverseSortBenchmark.reverseSortedFourthApproach  10000000  avgt   20  2786910118,850 ±  36947925,844  ns/op

Custom benchmark (Old approach)

Size 10000000

Approach # 1 Time: 3137523500 nanoseconds
Approach # 2 Time: 3596863625 nanoseconds
Approach # 3 Time: 2836802542 nanoseconds
Approach # 4 Time: 3147360875 nanoseconds