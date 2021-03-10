package pid.exercise.search;

import java.util.Arrays;
import java.util.Random;

/**
 * This class takes the time of your implementation of linear search and binary search and prints it to the the
 * console.
 */
public class Timer {

    public static void main(String[] args) {
        final int DATASIZE = 10000000;

        // TODO: Uncomment lines below after both searches are implemented
        /*
        IntArrayGenerator intArrayGenerator = new IntArrayGenerator(new Random());
        System.out.println("Generating array...");
        int[] array = intArrayGenerator.generateOrderedSequence(DATASIZE);
        System.out.println("Done generating array!\n");

        timeLinearSearch(array);
        timeBinarySearch(array);
        */
    }

    /**
     * This method measures the time performance of your implementation of linear search by running it several times
     * and printing the average time taken.
     * @param array array which will be searched.
     */
    public static void timeLinearSearch(int[] array) {
        timeSearch(array, true );
    }

    public static void timeBinarySearch(int[] array) {
        timeSearch(array, false );
    }

    /**
     * This method measures the time performance of your implementation of linear or binary search by running it
     * 30 times and printing the average time taken for the last 20 runs. We ignore the first 10 runs because of JVM
     * warm-up. It's an advanced topic but basically the JVM performs better when it's running for a while due to
     * lazy loading and caches. If you're interested in learning more you can take a look here
     * https://www.baeldung.com/java-jvm-warmup
     * @param array array which will be searched.
     * @param useLinear if true, run linear search. If false, run binary search.
     */
    private static void timeSearch(int[] array, boolean useLinear) {
        IntArrayGenerator intArrayGenerator = new IntArrayGenerator(new Random());

        Random random = new Random();
        int rounds = 30;
        int testRounds = 10;
        double[] timings = new double[rounds];
        for (int i = 0; i < rounds; i++) {
            int targetValue = random.nextBoolean() ? random.nextInt(array.length) : random.nextInt(2000) + array.length;
            // Create a timestamp
            long start = System.nanoTime();
            if (useLinear) {
                Search.linearSearch(array, targetValue);
            } else {
                Search.binarySearch(array, targetValue);
            }
            long end = System.nanoTime();
            long timing = end - start;
            timings[i] = timing / 1E3;
        }

        String algoString = useLinear ? "linear" : "binary";
         double averageTiming = Arrays.stream(timings).skip(testRounds).average().orElse(Double.NaN);

        System.out.println("Results for " + algoString + " search (average of " + rounds + " rounds discarding the first " + testRounds + " runs):\n" +
                "Datasize:\t\t\t\t\t\t" + array.length + "\nTime taken(microseconds):\t\t" + averageTiming + " microseconds\n" );

    }

}