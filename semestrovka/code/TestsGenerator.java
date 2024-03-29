import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestsGenerator {
    private int[] lengths;
    TestsGenerator(){
        lengths = createArraysLength();
    }
    private int[] createArraysLength(){
        int[] lengths = new int[100];
        for(int i = 0, j = 100; i<100; i++, j+=100){
            lengths[i] = j;
        }
        return lengths;
    }
    private int[] generateArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i< length; i++){
            arr[i] = (int)(Math.random()*1000);
        }
        return arr;
    }
    public void createFiles() throws IOException {
        for (int i = 1; i<=100; i++) {
            OutputStream fw = new FileOutputStream("Files2\\Test" + Integer.toString(i) + ".txt");
            int[] currArray = generateArray(lengths[i - 1]);
            for (int j = 0; j < lengths[i - 1]; j++) {
                fw.write(Integer.toString(currArray[j]).getBytes());
                fw.write('\n');
            }
            fw.close();
        }
    }
    public static int[] testReader(int testNumber) throws IOException {
        return Files.readAllLines(Paths.get("Files2\\Test" + Integer.toString(testNumber) + ".txt"))
                .stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public int[] getLengths() {
        return lengths;
    }
}
