public class StoogeSort {
 //   public static long o;
    public static void stoogeSort(int[] arr, int a, int b) {
 //       o++;
        if (arr[a] > arr[b]) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        if (b - a + 1 > 2) {
            int t = (b - a + 1) / 3;
            stoogeSort(arr, a, b - t);
            stoogeSort(arr, a + t, b);
            stoogeSort(arr, a, b - t);
        }
    }
}
