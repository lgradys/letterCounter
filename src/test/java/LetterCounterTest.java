import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LetterCounterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test()
    void correctInputShouldReturnListOfLettersWithRepeatsValue() {
        //given
        String phrase = "Java Academy";
        String consoleOutput = "Counted letters:\r\n" +
                "a=4\r\n" +
                "c=1\r\n" +
                "d=1\r\n" +
                "e=1\r\n" +
                "j=1\r\n" +
                "m=1\r\n" +
                "v=1\r\n" +
                "y=1";

        //when
        System.setOut(new PrintStream(outputStreamCaptor));
        LetterCounter.countLetter(phrase);

        //then
        assertEquals(consoleOutput, outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }

    @Test()
    void emptyInputShouldThrowException() {
        //given
        String phrase = "";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> LetterCounter.countLetter(phrase));
    }

    @Test()
    void nullInputShouldThrowException() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> LetterCounter.countLetter(null));
    }

    @Test()
    void inputWithoutLettersShouldThrowException() {
        //given
        String phrase = ";)";

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> LetterCounter.countLetter(phrase));
    }

}