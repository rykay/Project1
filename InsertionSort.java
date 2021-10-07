import java.util.concurrent.ThreadLocalRandom;

public class InsertionSort implements Sort{

    public void sort(double[] array){
        int i, j;
        double key;
        for (i = 1; i < array.length; i++)
        {
            key = array[i];
            j = i - 1;

        /* Move elements of arr[0..i-1], that are
        greater than key, to one position ahead
        of their current position */
            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        double start = System.currentTimeMillis();
        double[] randoms = ThreadLocalRandom.current().doubles(50000).toArray();
        insertionSort.sort(randoms);
        double finish = System.currentTimeMillis();
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);
    }
}
