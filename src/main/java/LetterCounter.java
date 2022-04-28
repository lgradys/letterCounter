import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class LetterCounter {

    private static final String LETTER_REGEX = "[^a-zA-Z]";

    static void countLetter(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            throw new IllegalArgumentException("Illegal input value!");
        } else {
            Map<String, Integer> lettersRepeats = new HashMap<>();
            String letters = phrase.replaceAll(LETTER_REGEX, "");
            if (letters.length() == 0) {
                throw new IllegalArgumentException("Input value without letters!");
            }
            Arrays.stream(letters.split(""))
                    .map(s -> s.toLowerCase(Locale.ROOT))
                    .forEach(s -> countLettersRepeats(s, lettersRepeats));
            printCountingResult(lettersRepeats);

        }
    }

    private static void printCountingResult(Map<String, Integer> letters) {
        System.out.println("Counted letters:");
        letters.keySet().stream()
                .sorted()
                .forEach(s -> System.out.println(s + "=" + letters.get(s)));
    }

    private static void countLettersRepeats(String s, Map<String, Integer> letters) {
        letters.merge(s, 1, Integer::sum);
    }

}
