import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort implements Sort {

    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(double[] array, int low, int high) {
        double pivot = array[high];  // pivot

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }


    public void quickSort(double[] array, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(array, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public void sort(double[] arr) {
        quickSort(arr, 0, arr.length-1);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        double start = System.currentTimeMillis();
        double[] randoms = ThreadLocalRandom.current().doubles(350000).toArray();
        quickSort.sort(randoms);
        double finish = System.currentTimeMillis();
        System.out.println(Arrays.toString(randoms));
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);
    }
}
