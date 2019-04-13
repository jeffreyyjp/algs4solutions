package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.In;
import fundamentals.dataabstraction.Transaction;

public class Exercise1_3_17 {

    public static Transaction[] readDates(String name) {
        In in = new In(name);
        Queue<Transaction> q = new Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(new Transaction(in.readString()));
        }

        int N = q.size();
        Transaction[] dates = new Transaction[N];
        for (int i = 0; i < N; i++)
            dates[i] = q.dequeue();

        return dates;
    }
}
