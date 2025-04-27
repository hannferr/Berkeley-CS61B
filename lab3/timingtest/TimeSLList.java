package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        nSize(1000, Ns, times, opCounts);
        nSize(2000, Ns, times, opCounts);
        nSize(4000, Ns, times, opCounts);
        nSize(8000, Ns, times, opCounts);
        nSize(16000, Ns, times, opCounts);
        nSize(32000, Ns, times, opCounts);
        nSize(64000, Ns, times, opCounts);
        nSize(128000, Ns, times, opCounts);

        printTimingTable(Ns, times, opCounts);
    }

    public static void nSize(int x, AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        int m = 10000;
        SLList<Integer> N = new SLList<>();
        for (int i = 0; i < x; i++) {
            N.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < m; i++) {
            N.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(N.size());
        opCounts.addLast(m);
        times.addLast(timeInSeconds);
    }

}
