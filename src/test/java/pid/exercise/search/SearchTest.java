package pid.exercise.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Search.
 *
 * Some parts are shamelessly stolen from INDA-17 assignments originally made by Simon Larsén and
 * Anton Lyxell.
 *
 * @author Kwabena Asante-Poku
 * @ version 2020-10-06
 */
public class SearchTest {

    private final int RANDOM_SEED = 0;
    private IntArrayGenerator intArrayGenerator;

    /* The length of the even length array used in the tests */
    private final int EVEN_ARRAY_LENGTH = 100;
    /* The length of the odd length array used in the tests */
    private final int ODD_ARRAY_LENGTH = 99;

    /* The upper bound of integers to be generated in arrays */
    private final int UPPER_BOUND = 10000;

    /* An array of even length */
    private int[] evenArray;
    /* An array of odd length */
    private int[] oddArray;

    /**
     * Set up variables to be available for each test case.
     *
     * Assistant's note: this method is executed once before every test
     * case in this class. In this method we initialize some default
     * values that will use to verify the correctness of our search implementations.
     */
    @BeforeEach
    public void setUp() {
        intArrayGenerator = new IntArrayGenerator(new Random(RANDOM_SEED));
        evenArray = intArrayGenerator.generateRandomSequence(EVEN_ARRAY_LENGTH);
        oddArray = intArrayGenerator.generateRandomSequence(ODD_ARRAY_LENGTH);
    }

    /**
     * Assert that linearSearch returns the correct index
     * for all elements in an even length array with multiple elements.
     */
    @Test
    public void linearSearchFindsAllElementsInEvenArray() {
        // Arrange
        for (int i = 0; i < evenArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.linearSearch(evenArray, evenArray[i]));
        }
    }

    /**
     * Assert that linearSearch returns the correct index
     * for all elements in an odd length array with multiple elements.
     */
    @Test
    public void linearSearchFindsAllElementsInOddArray() {
        // Arrange
        for (int i = 0; i < oddArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.linearSearch(oddArray, oddArray[i]));
        }
    }

    /**
     * Assert that linearSearch returns negative one as index
     * when the element is not found in the array.
     */
    @Test
    public void linearSearchReturnsNegativeOneOnNotFound() {
        // Arrange
        int[] array = intArrayGenerator.generateRandomSequence(10);

        assertEquals(-1,
                Search.linearSearch(array, 15));
    }

    /**
     * Assert that linearSearch returns negative one as index
     * when array is empty.
     */
    @Test
    public void linearSearchReturnsNegativeOneOnEmptyArray() {
        // Arrange
        int[] array = new int[]{};

        assertEquals(-1,
                Search.linearSearch(array, 0));
    }

    /**
     * Assert that binarySearch (iterative) returns the correct index
     * for all elements in an even length array with multiple elements.
     */
    @Test
    public void iterativeBinarySearchFindsAllElementsInEvenArray() {
        // Arrange
        Arrays.sort(evenArray);
        for (int i = 0; i < evenArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.binarySearch(evenArray, evenArray[i]));
        }
    }

    /**
     * Assert that binarySearch (iterative) returns the correct index
     * for all elements in an odd length array with multiple elements.
     */
    @Test
    public void iterativeBinarySearchFindsAllElementsInOddArray() {
        // Arrange
        Arrays.sort(oddArray);
        for (int i = 0; i < oddArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.binarySearch(oddArray, oddArray[i]));
        }
    }

    /**
     * Assert that binarySearch (iterative) returns negative one as index
     * when the element is not found in the array.
     */
    @Test
    public void iterativeBinarySearchReturnsNegativeOneOnNotFound() {
        // Arrange
        int[] array = intArrayGenerator.generateRandomSequence(10);
        Arrays.sort(array);

        assertEquals(-1,
                Search.binarySearch(array, 17));
    }

    /**
     * Assert that binarySearch (iterative) returns negative one as index
     * when array is empty.
     */
    @Test
    public void iterativeBinarySearchReturnsNegativeOneOnEmptyArray() {
        // Arrange
        int[] array = new int[]{};
        Arrays.sort(array);

        assertEquals(-1,
                Search.binarySearch(array, 0));
    }

    /**
     * Assert that binarySearchRecursive returns the correct index
     * for all elements in an even length array with multiple elements.
     */
    @Test
    public void binarySearchRecursiveFindsAllElementsInEvenArray() {
        // Arrange
        Arrays.sort(evenArray);
        for (int i = 0; i < evenArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.binarySearchRecursive(evenArray, evenArray[i]));
        }
    }

    /**
     * Assert that binarySearchRecursive returns the correct index
     * for all elements in an odd length array with multiple elements.
     */
    @Test
    public void binarySearchRecursiveFindsAllElementsInOddArray() {
        // Arrange
        Arrays.sort(oddArray);
        for (int i = 0; i < oddArray.length; i++) {
            // Act, Assert
            assertEquals(i,
                    Search.binarySearchRecursive(oddArray, oddArray[i]));
        }
    }

    /**
     * Assert that binarySearchRecursive returns negative one as index
     * when the element is not found in the array.
     */
    @Test
    public void binarySearchRecursiveReturnsNegativeOneOnNotFound() {
        // Arrange
        int[] array = intArrayGenerator.generateRandomSequence(10);
        Arrays.sort(array);

        assertEquals(-1,
                Search.binarySearchRecursive(array, 17));
    }

    /**
     * Assert that binarySearchRecursive returns negative one as index
     * when array is empty.
     */
    @Test
    public void binarySearchRecursiveReturnsNegativeOneOnEmptyArray() {
        // Arrange
        int[] array = new int[]{};
        Arrays.sort(array);

        assertEquals(-1,
                Search.binarySearchRecursive(array, 0));
    }
}
