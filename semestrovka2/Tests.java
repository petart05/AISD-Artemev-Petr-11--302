import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tests {
    public static double[] generateArray(int length) {
        double[] arr = new double[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static void createFile(double[] array, String name) {
        try (OutputStream fw = new FileOutputStream(name + "txt")) {
            for (int i = 0; i < array.length; i++) {
                fw.write(Double.toString(array[i]).getBytes());
                fw.write('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readFile(String file) throws IOException {
        return Files.readAllLines(Paths.get(file))
                .stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
