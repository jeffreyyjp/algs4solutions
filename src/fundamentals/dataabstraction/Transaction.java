package fundamentals.dataabstraction;

public class Transaction implements Comparable<Transaction> {

    private final String who;
    private final SmartDate when;
    private final double amount;

    public Transaction(String who, SmartDate when, double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");

        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] data = transaction.split("\\s+");
        who = data[0];
        when = new SmartDate(data[1]);
        amount = Double.parseDouble(data[2]);

        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }

    public String who() {
        return who;
    }

    public SmartDate when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (!this.who.equals(that.who)) return false;
        if (!this.when.equals(that.when)) return false;
        return this.amount == that.amount;
    }
}
