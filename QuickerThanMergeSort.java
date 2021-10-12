import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickerThanMergeSort implements Sort {


    private ArrayList<int[]> sortArray(double[] arr) {
        ArrayList<int[]> subArrays = new ArrayList<int[]>();
        int startIndex = 0; //to keep track of sub arrays
        int endIndex;
        while (startIndex < arr.length) { //loop through arr param
            endIndex = endIndex(arr, startIndex); //set end index to last element that is in bounds and sorted
            int[] subArray = {startIndex, endIndex};
            //System.out.println(Arrays.toString(subArray));
            startIndex = endIndex + 1; // increment index to continue creating sub arrays. bookkeeping
            subArrays.add(subArray); //add the pairs to arraylist
        }
        return subArrays;
    }

    private int endIndex(double[] arr, int start) { //finds index of last element of a sorted sub-array
        int index = start;
        while (index < arr.length - 1 && arr[index] <= arr[index+1]) {
            index++;
        }
        //System.out.println("THIS IS LAST SUB ARRAY INDEX: " + index);
        return index;
    }

    public void sort(double[] arr) { // sort method from interface
        ArrayList<int[]> indexPairs = sortArray(arr); //an array of the indexes of sorted portions. Ex. [[0,2] , [3,3] ......

        while (indexPairs.size() > 1) { //size 1 = sorted array
            int firstStart = indexPairs.get(0)[0]; // starting index of first sorted sub-array
            int firstEnd = indexPairs.get(0)[1]; // end index of first sorted sub-array
            int secondStart = indexPairs.get(1)[0]; // starting index of second sorted sub-array
            int secondEnd = indexPairs.get(1)[1]; // end index of second sorted sub-array

            merge(arr, Arrays.copyOfRange(arr, firstStart, firstEnd + 1), Arrays.copyOfRange(arr, secondStart,  secondEnd + 1)); //copyOfRange function to create left and right arrays
            int[] sortedRegion = {indexPairs.get(0)[0], indexPairs.get(1)[1]};
            indexPairs.add(0, sortedRegion); //insert sorted portion to beginning of array. length of indexPairs + 1
            indexPairs.remove(2); //remove 2 and 1 (the two first sorted index pairs). Length is now + 1 since we added at pos 0.
            indexPairs.remove(1);
        }

    }

    public void merge(double[] arr, double[] left, double[] right) {
        int arrIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                arr[arrIndex++] = left[leftIndex++];
            }
            else {
                arr[arrIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }


    public static void main(String[] args) {
        QuickerThanMergeSort test = new QuickerThanMergeSort(); //is it quicker.... *think*...no i did a glorified bubble sort
        double[] arr = {31, 60, 80, 76, 16, 79, 47, 47, 23, 67};
        double[] randoms = ThreadLocalRandom.current().doubles(5000).toArray();
        double start = System.currentTimeMillis();
        test.sort(randoms);
        double finish = System.currentTimeMillis();
        System.out.println(Arrays.toString(randoms));
        double timeElapsed = finish - start;
        System.out.println("Seconds: " + timeElapsed);


    }
}
