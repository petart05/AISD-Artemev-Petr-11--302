import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        TestsGenerator tg = new TestsGenerator();
        int[] a = tg.getLengths();
        OutputStream os = new FileOutputStream("results.txt");
        tg.createFiles();
        int[] currTest;
        for (int i = 1; i<=100;i++){
            currTest = TestsGenerator.testReader(i);
            Long startTime = System.nanoTime();
            StoogeSort.stoogeSort(currTest, 0, currTest.length - 1);
            Long endTime = System.nanoTime();
//            os.write(Integer.toString(a[i-1]).getBytes());
//            os.write('\t');
            os.write(Double.toString((double) (endTime - startTime) / 1000000).getBytes());
//            os.write('\t');
//            os.write(Long.toString(StoogeSort.o).getBytes());
//            StoogeSort.o = 0;
            os.write('\n');
        }
    }
}
