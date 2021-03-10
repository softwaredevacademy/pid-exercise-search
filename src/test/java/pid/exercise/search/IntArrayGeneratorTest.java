package pid.exercise.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Test class for the IntGenerator
 *
 * @author Kwabena Asante-Poku
 * @version 2020-10-03
 * <p>
 */
public class IntArrayGeneratorTest {

    private final int RANDOM_SEED = 0;
    private IntArrayGenerator intArrayGenerator;
    private Random random;


    @BeforeEach
    public void setUp() {
        random = new Random(RANDOM_SEED);
        intArrayGenerator = new IntArrayGenerator(random);
    }

    private List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Assert that the generated array has the correct length as given by input.
     */
    @Test
    public void generatedArrayHasCorrectLength() {
        // Arrange
        int inputLength50 = 50;
        int inputLength1000 = 1000;
        int inputLength20000 = 20000;

        // Act
        int[] outputArray50 = intArrayGenerator.generateRandomSequence(inputLength50);
        int[] outputArray1000 = intArrayGenerator.generateRandomSequence(inputLength1000);
        int[] outputArray20000 = intArrayGenerator.generateRandomSequence(inputLength20000);

        // Assert
        assertEquals(inputLength50, outputArray50.length);
        assertEquals(inputLength1000, outputArray1000.length);
        assertEquals(inputLength20000, outputArray20000.length);
    }


    /**
     * Assert that the generated array contains integers in requiredInts.
     */
    @Test
    public void generatedArrayContainsExpectedInts() {
        // Arrange
        int inputLength = 10;

        // Act
        int[] outputArray = intArrayGenerator.generateRandomSequence(inputLength);

        // Assert
        for (int i = 0; i < inputLength; ++i) {
            assertThat(arrayToList(outputArray), hasItem(i));
        }
    }

    /**
     * Assert that generate throws an IllegalArgumentException when input is lower than 1.
     */
    @Test
    public void generateThrowsExceptionWhenLengthIsLowerThanZero() {
        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    intArrayGenerator.generateRandomSequence(-1);
                }
        );
    }

    /**
     * Assert that generate throws an IllegalArgumentException when input is lower than 1.
     */
    @Test
    public void generateThrowsExceptionWhenLengthIsMuchLowerThanZero() {
        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    intArrayGenerator.generateRandomSequence(-9999);
                }
        );
    }
}
