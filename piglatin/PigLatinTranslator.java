package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: add code here later for translating whole books
        // for now this does nothing but looks fancy

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // if it's empty just return empty
        if (input == null || input.trim().isEmpty()) return "";

        // split the sentence into words
        String[] words = input.split(" ");

        // go through all the words
        for (int i = 0; i < words.length; i++) {
            result += translateWord(words[i]);

            // add space after each word except the last one
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // handle empty strings
        if (input.length() == 0) return input;

        // handle punctuation at the end
        String punctuation = "";
        String last = input.substring(input.length() - 1);
        if (!Character.isLetter(last.charAt(0))) {
            punctuation = last;
            input = input.substring(0, input.length() - 1);
        }

        // check if first letter is uppercase
        boolean startsUpper = Character.isUpperCase(input.charAt(0));

        // make the word lowercase to work with
        String lower = input.toLowerCase();

        String first = lower.substring(0, 1);

        boolean startsWithVowel =
            first.equals("a") || first.equals("e") ||
            first.equals("i") || first.equals("o") ||
            first.equals("u");

        if (startsWithVowel) {
            result = lower + "ay";
        } else {
            // find where the first vowel is
            int vowelLocation = -1;
            int i = 0;
            while (i < lower.length() && vowelLocation == -1) {
                String letter = lower.substring(i, i + 1);
                if (letter.equals("a") || letter.equals("e") ||
                    letter.equals("i") || letter.equals("o") ||
                    letter.equals("u")) {
                    vowelLocation = i;
                }
                i = i + 1;
            }

            if (vowelLocation != -1) {
                String start = lower.substring(0, vowelLocation);
                String end = lower.substring(vowelLocation);
                result = end + start + "ay";
            } else {
                // if no vowels at all
                result = lower + "ay";
            }
        }

        // make first letter uppercase again if original started uppercase
        if (startsUpper && result.length() > 0) {
            result = result.substring(0, 1).toUpperCase() + result.substring(1);
        }

        // put punctuation back
        result = result + punctuation;

        return result;
    }
}
