import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Anagrams {

    /**
     * You need to read the wordlist common-passwords.txt containing one word per line, find all the
     * anagram of the given word (the word itself excluded) and return a set of the words found
     *
     * @param word the word you have to find the anagrams
     * @return a Set<String> with the anagrams found
     */
     private final static String FILE_NAME = "common-passwords.txt";
    
    public Set<String> findAnagrams(String word) throws FileNotFoundException {

        Set<String> words = new HashSet<String>();
        Set<String> anagrams = new HashSet<String>();
                

        fetchData(words);

        for (String key : words) {
            if (key.length() == word.length() && !key.equals(word)) {

                String tmpKey = key;

                for (int i = 0; i < word.length(); i++) {

                    String letter = word.substring(i, i + 1);

                    if (tmpKey.contains(letter)) {
                        tmpKey = tmpKey.replaceFirst(letter, "");

                    }

                    if (tmpKey.trim().length() == 0) {
                        anagrams.add(key);
                    }
                }
            }

        }
        return anagrams;

    }

    private void fetchData(Set<String> words) throws FileNotFoundException {

        InputStream in = ClassLoader.getSystemResourceAsStream(FILE_NAME);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String currentWord;

        try {
            while ((currentWord = br.readLine()) != null)   {
                words.add(currentWord);
                                 
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
