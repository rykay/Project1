import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort implements Sort{

    public void sort(double[] array){
        for(int i = 0; i < array.length; i++){
            swap(array, i, findSmallest(array, i));
        }
    }

    public int findSmallest(double[] arr, int start){
        int smallest = start;
        for(int i = start+1; i < arr.length; i++){
            if (arr[i] < arr[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }

    public void swap(double[] array, int i, int j){
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        double start = System.currentTimeMillis();
        double[] randoms = ThreadLocalRandom.current().doubles(50000).toArray();
        selectionSort.sort(randoms);
        double finish = System.currentTimeMillis();
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);
    }

}
