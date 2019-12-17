package service;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@WebService()
public class TextService implements TextServiceInterface {
    @Override
    public int countOneWord(String text, String currentWord) {
        List<String> words = Arrays.asList(text.split("[\\s\\W]"));
        int count = 0;
        for (String word : words) {
            if (word.equals(currentWord)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String countCharacters(String text) {
        HashMap<String, Integer> countedChars = new HashMap<>();
        List<String> words = Arrays.asList(text.split("[\\s\\W]"));
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char character : chars) {
                if (countedChars.containsKey(character)) {
                    int count = countedChars.get(character);
                    countedChars.replace(String.valueOf(character), count++);
                } else countedChars.put(String.valueOf(character), 1);
            }
        }
        return new HashMapWrapper(countedChars).toString();
    }

    @Override
    public String countWords(String text) {
        HashMap<String, Integer> countedWords = new HashMap<>();
        List<String> words = Arrays.asList(text.split("[\\s\\W]"));
        for (String word : words) {
            if (countedWords.containsKey(word)){
                int count = countedWords.get(word);
                countedWords.replace(word, count++);

            } else countedWords.put(word, 1);
        }
        return new HashMapWrapper(countedWords).toString();
    }

    @Override
    public String makeCaps(String text) {
        return text.toUpperCase();
    }

//    @Override
//    public HashMap<String, Integer> countWordsOnWebPage(String URL) {
//        return null;
//    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        Object implementor = new TextService();
        System.out.println("Enter service IP: ");
        String host = scan.nextLine();
        System.out.println("Enter service port: ");
        String port = scan.nextLine();
        String address = "http://" + host + ":" + port + "/TextService";
        Endpoint.publish(address, implementor);
    }
}
