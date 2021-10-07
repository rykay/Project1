import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort implements Sort{

    public double[] getLeft(double[] arr) {
        int size = arr.length/2;
        double[] left = new double[size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    public double[] getRight(double[] arr) {
        int size = arr.length - arr.length/2;
        double[] right = new double[size];
        if (arr.length % 2 == 0) {
            for (int i = size; i < arr.length; i++) {
                right[i - size] = arr[i];
            }
        }
        else {
            for (int i = size - 1; i < arr.length; i++) {
                right[i - size + 1] = arr[i];
            }
        }
        return right;
    }

    public void merge(double[] arr, double[] left, double[] right) {
        int arrIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while (arrIndex < arr.length) {
            if (leftIndex == left.length) {
                arr[arrIndex++] = right[rightIndex++];
            }
            else if (rightIndex == right.length) {
                arr[arrIndex++] = left[leftIndex++];
            }
            else if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            }
            else { // right[rightIndex] < left[leftIndex]
                arr[arrIndex++] = right[rightIndex++];
            }
        }
    }

    public void sort(double[] arr) {
        if (arr.length > 1) {
            double[] left = getLeft(arr);
            double[] right = getRight(arr);

            sort(left);
            sort(right);

            merge(arr, left, right);
        }
    }


    public static void main(String[] args) {
        MergeSort merge = new MergeSort();
        double start = System.currentTimeMillis();
        double[] randoms = ThreadLocalRandom.current().doubles(450000).toArray();
        merge.sort(randoms);
        double finish = System.currentTimeMillis();
        System.out.println(Arrays.toString(randoms));
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);
    }
}
