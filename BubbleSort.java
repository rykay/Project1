import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleSort implements Sort{

    public void sort(double[] array){
        for(int i = 1; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j+1]){
                    swap(array, j, j+1);
                }

            }
        }
    }

    public void swap(double[] array, int i, int j){
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        double start = System.currentTimeMillis();
        double[] randoms = ThreadLocalRandom.current().doubles(50000).toArray();
        bubbleSort.sort(randoms);
        double finish = System.currentTimeMillis();
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);
    }
}
