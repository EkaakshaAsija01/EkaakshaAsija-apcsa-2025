package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Current do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";
        String first = input.substring(0, 1);

        boolean startsWithVowel =
            first.equals("a") || first.equals("A") ||
            first.equals("e") || first.equals("E") ||
            first.equals("i") || first.equals("I") ||
            first.equals("o") || first.equals("O") ||
            first.equals("u") || first.equals("U");

        if (startsWithVowel) {
            result = input + "yay";
        } else {
            // find where the first vowel is
            int vowelLocation = -1;
            int i = 0;
            while (i < input.length() && vowelLocation == -1) {
                String letter = input.substring(i, i + 1);
                if (letter.equals("a") || letter.equals("A") ||
                    letter.equals("e") || letter.equals("E") ||
                    letter.equals("i") || letter.equals("I") ||
                    letter.equals("o") || letter.equals("O") ||
                    letter.equals("u") || letter.equals("U")) {
                    vowelLocation = i;
                }
                i = i + 1;
            }

            if (vowelLocation != -1) {
                String start = input.substring(0, vowelLocation);
                String end = input.substring(vowelLocation);
                result = end + start + "ay";
            } else {
                // if no vowels at all
                result = input + "ay";
            }
        }

        return result;
    }
}
