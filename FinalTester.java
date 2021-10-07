import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class FinalTester {


    public static void printTimes(long[] timeArr, int arrayNumber){
        String[] sortingNames = {"Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "My implementation of Merge Sort", "Quick Sort"};
        //String[] sequenceArr = {"First" , "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth"};
        for (int i = 0; i < timeArr.length; i++) {
            //System.out.println("-------" + sequenceArr[i] + " Array -------" );
            System.out.println("Time it took to sort " + sortingNames[i] + ": " + timeArr[i] + " in ms.");
        }
    }

    public long[] calculateTime(double[] arr) {
        SelectionSort selectionSort = new SelectionSort(); // create objects to call each specific sort.
        InsertionSort insertionSort = new InsertionSort();
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        QuickerThanMergeSort quickerThanMergeSort = new QuickerThanMergeSort();
        QuickSort quickSort = new QuickSort();

        long[] time = new long[6];
        long startTime = 0;
        long endTime = 0;
        Sort[] sortArray = {selectionSort, bubbleSort, insertionSort, mergeSort, quickerThanMergeSort, quickSort}; //create array of type Sort that holds sorting algo objects to access specific methods

        for (int i = 0; i < time.length; i++) {
            double[] cloned = arr.clone();

            startTime = System.currentTimeMillis();
            sortArray[i].sort(cloned); //access specific sort through sortArray
            endTime = System.currentTimeMillis();
            time[i] = endTime - startTime;

            if (!isSorted(cloned)) {
                System.out.println("The array is not sorted!!!");
                System.exit(0);
            }
        }
        return time;
    }


    public boolean isSorted(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<double[]> createRandArrays() {
        ArrayList<double[]> storageArray = new ArrayList<double[]>();
        int size = 50000;
        for (int i = 0; i <= 10; i++) {
            double[] randoms = ThreadLocalRandom.current().doubles(size).toArray(); //create ten random arrays all with sizes += 50,000
            storageArray.add(randoms);
            size += 50000;
        }
        return storageArray;
    }

    public static void main(String[] args) {


        FinalTester finalTester = new FinalTester();
        ArrayList<double[]> randArrays = finalTester.createRandArrays();

        String[] sequenceArr = {"First" , "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth"};
        for(int i = 0; i < 10; i++){
            long[] arrayTime = finalTester.calculateTime(randArrays.get(i));
            System.out.println("------- " + sequenceArr[i] + " Array -------" );
            printTimes(arrayTime, i+1);
            System.out.println();
        }



    }

}
