package Java_Coursera.MiniProject;

import edu.duke.FileResource;
import java.util.HashSet;

public class Tester {
    public static void main(String[] args) {
        VigenereBreaker vignereBreaker = new VigenereBreaker();
        vignereBreaker.breakVigenere(4);
        FileResource fr = new FileResource();
        String s =fr.asString();
        int[] a = vignereBreaker.tryKeyLength(s,4 ,'e');
        for(int i:a){
            System.out.println(i);
        }
        HashSet<String> dictionary = vignereBreaker.readDictionary(
                new FileResource("/home/luqmaan/Desktop/MiniProject/VigenereProgram/dictionaries/English"));
        char ch = vignereBreaker.mostCommonCharIn(dictionary);
        System.out.println(ch);
    }
}
