package fundamentals.bagsqueuesstacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Exercise1_3_43 {

    private static Queue<String> q = new Queue<>();
    private static final int INDENT = 4;

    public static void listFilesNoQueue(File file, int depth) {
        if (!file.exists()) return;
        printName(file, depth);

        File[] subFiles = file.listFiles();
        if (subFiles == null) return;
        for (File f : subFiles) {
            if (f.isDirectory()) {
                listFilesNoQueue(f, depth + INDENT);
            } else {
                printName(f, depth + INDENT);
            }
        }
    }

    public static void printName(File file, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }
        StdOut.println(file.getName());
    }

    // Using queue to save each file name.
    public static void listFiles(File file, int depth) {
        if (!file.exists()) return;
        // Add current file(or folder).
        fileEnqueue(file, depth);

        File[] subLists = file.listFiles();
        if (subLists == null) return;
        for (File f : subLists) {
            if (f.isDirectory()) {
                // Recursive add sub directory.
                listFiles(f, depth + INDENT);
            } else {
                // add current's sub files.
                fileEnqueue(f, depth + INDENT);
            }
        }
    }

    public static void fileEnqueue(File file, int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append(" ");
        }
        sb.append(file.getName());
        q.enqueue(sb.toString());
    }

    public static void main(String[] args) {
        StdOut.println("Input pathname: ");
        String pathname = StdIn.readString();
        listFiles(new File(pathname), 0);

        for (String item : q) {
            StdOut.println(item);
        }
    }
}
