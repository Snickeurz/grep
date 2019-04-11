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
            if (matcher.matches()) {
                System.out.println(String.format("New word found : %s", currentLine));
                counter++;
            }
        }
        System.out.println(String.format("Number of word found : %d", counter));
    }

    public static void main(String[] args)
    {
        String regexAuMoins5i = "([^i]*i){5}";
        String regexOnly5i = "(.*i.*){5}";
        String filePath = "C:\\Users\\Nicol\\Desktop\\MIAGE\\M1 - MIAGE\\inf4\\grep\\tp\\src\\fr-dico.txt";
        try {
            grep(regexAuMoins5i, filePath);
//            grep(regexOnly5i, filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error : File is not found !");
        } catch (IOException e) {
            System.out.println("Error : error while reading file !");
        }
    }
}
