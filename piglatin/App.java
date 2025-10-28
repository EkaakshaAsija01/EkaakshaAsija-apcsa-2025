package piglatin;

public class App {
    public static void main(String[] args)
    {
        /*  Introduction and TODO List

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // Translate Romeo and Juliette
            Book romeoBook = new Book();
            romeoBook.readFromUrl("Romeo and Juliette", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");
            Book romeoTranslated = PigLatinTranslator.translate(romeoBook);
            romeoTranslated.writeToFile("RomeoAndJuliette_PigLatin.txt");
            romeoTranslated.printlines(0, 10); // first 10 lines

            // Translate Hamlet
            Book hamletBook = new Book();
            hamletBook.readFromUrl("Hamlet", "https://www.gutenberg.org/cache/epub/1787/pg1787.txt?utm");
            Book hamletTranslated = PigLatinTranslator.translate(hamletBook);
            hamletTranslated.writeToFile("Hamlet_PigLatin.txt");
            hamletTranslated.printlines(0, 10); // first 10 lines
        }
    }
}
