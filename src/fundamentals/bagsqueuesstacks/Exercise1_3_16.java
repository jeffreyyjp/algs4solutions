package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.In;
import fundamentals.dataabstraction.SmartDate;

public class Exercise1_3_16 {

    public static SmartDate[] readDates(String name) {
        In in = new In(name);
        Queue<SmartDate> q = new Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(new SmartDate(in.readString()));
        }

        int N = q.size();
        SmartDate[] dates = new SmartDate[N];
        for (int i = 0; i < N; i++)
            dates[i] = q.dequeue();

        return dates;
    }
}
