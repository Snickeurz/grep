import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Exercice {
    /**
     * Read file and print all lines that match given ER.
     *
     * @param regex a given ER
     * @param nomFichier the file's name
     */
    public static void grep(final String regex, final String nomFichier) throws IOException {
        // some parameters
        File file = new File(nomFichier);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine = "";
        int counter = 0;

        // create new pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        // read the file
        while ((currentLine = br.readLine()) != null) {
            // Try to match current line
            matcher = pattern.matcher(currentLine);
            if (matcher.find()) {
//                System.out.println(String.format("New word found : %s", currentLine));
                counter++;
            }
        }
        System.out.println(String.format("Number of word found : %d", counter));
    }

    /**
     * Read given file and for each lines replace regex by repl.
     * If something happen, print it.
     *
     * @param regex given regex
     * @param repl replacement
     * @param nomFichier given file
     * @throws IOException blablabla
     */
    public static void substit(final String regex, final String repl, final String nomFichier) throws IOException {
        // some parameters
        File file = new File(nomFichier);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine = "";

        // create new pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        // read the file
        while ((currentLine = br.readLine()) != null) {
            // Try to replace current line
            matcher = pattern.matcher(currentLine);
            String line = matcher.replaceAll(repl);
            if(!currentLine.equals(line))
            {
                System.out.println(String.format("Line : %s", line));
            }
        }
    }

    public static void main(String[] args)
    {
        // some regular expression to test for grep
        String regexAtLeast5i = "([^i]*i){5}";
        String regexOnly5i = "^([^i]*i){5}[^i]*$";
        String regexSubString = "gr[aio]s";
        String regex3SameChar = "^(...).*\\1$";
        String regexStartingAndFinishingBySameLetter = "^([mbp]).*\\1$";
        // get file Absolute Path
        String filePath = "C:\\Users\\Nicol\\Desktop\\MIAGE\\M1 - MIAGE\\inf4\\grep\\tp\\src\\fr-dico.txt";

        // Some parameters for substit
        String filePathFeries = "C:\\Users\\Nicol\\Desktop\\MIAGE\\M1 - MIAGE\\inf4\\grep\\tp\\src\\feries.txt";
        String regexFerie = "([0-9]{4})([0-9]{2})([0-9]{2}), ([0-9]{4})([0-9]{2})([0-9]{2}).*\"(.*)\"$";
        String replacement = "du $3/$2/$1 au $6/$5/$4 $7";

        try {
            // Regex
//            System.out.println("Finding word with at least 5 'i'");
//            grep(regexAtLeast5i, filePath);
//            System.out.println("Finding word with only 5 'i'");
//            grep(regexOnly5i, filePath);
//            System.out.println("Finding word substring gras, gris or gros ");
//            grep(regexSubString, filePath);
//            System.out.println("Finding word starting and finishing with the same 3 characters (ex : anticoalugant <- ant)  ");
//            grep(regex3SameChar, filePath);
//            System.out.println("Finding word starting and finishing with the same letter (modem, baobab,..) ");
//            grep(regexStartingAndFinishingBySameLetter, filePath);

            // Feries
            System.out.println("Printing feries days of year 2012");
            substit(regexFerie, replacement, filePathFeries);

        }
        catch (FileNotFoundException e) {
            System.out.println("Error : File is not found !");
        }
        catch (IOException e) {
            System.out.println("Error : error while reading file !");
        }
    }
}
