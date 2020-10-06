package Java_Coursera.MiniProject;

import java.io.File;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {

        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices){
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];

        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++){

            String s = sliceString(encrypted, i, klength);
            int a = ccr.getKey(s);
            key[i] = a;

        }
        return key;
    }

    public void breakVigenere(int keyLength) {
        FileResource fr = new FileResource();
        String s = fr.asString();
        int[] key = tryKeyLength(s, keyLength, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String msg = vc.decrypt(s);
        System.out.println(msg);

    }

    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet<>();
        for(String line : fr.lines()){
            line = line.toLowerCase();
            dictionary.add(line);
        }
        return dictionary;
    }

    public int countWords(String message , HashSet<String> dictionary){
        int count = 0;
        String[] split = message.split("\\W+");
        for(int i=0;i< split.length;i++){
            if(dictionary.contains(split[i])){
                count++;
            }
        }
        return  count++;
    }
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        VigenereCipher vigenereCipher;
        int maxCount = 0;
        String actualDeciphered = "";
        for (int i = 1; i <= 100; i++) {
            int[] currKeys = tryKeyLength(encrypted, i, mostCommonCharIn(dictionary));
            vigenereCipher = new VigenereCipher(currKeys);
            String currDeciphered = vigenereCipher.decrypt(encrypted);
            int currCount = countWords(currDeciphered, dictionary);
            if (currCount > maxCount) {
                maxCount = currCount;
                actualDeciphered = currDeciphered;
            }

        }
        return actualDeciphered;
    }
    public char mostCommonCharIn(HashSet<String> dictionary) {
        int[] counter = new int[26];
        for (String word : dictionary) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                    int index = Character.toLowerCase(ch) - 97;
                    counter[index] += 1;
                }
            }
        }
        int maxVal = 0;
        char maxChar = 'e';
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > maxVal) {
                maxVal = counter[i];
                maxChar = (char) (i + 97);
            }
        }
        return maxChar;
    }

}

