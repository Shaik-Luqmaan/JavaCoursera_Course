package Java_Coursera.HashMap;
import edu.duke.FileResource;
import java.util.*;

public class WordFrequency {
    HashMap<String,Integer> hm = new HashMap<>();
    public void findUnique(){
        FileResource fr =new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            if(!hm.containsKey(s)){
                hm.put(s,1);
            }
            else{
                hm.put(s,hm.get(s)+1);
            }
        }
    }

    void test(){
        findUnique();
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" " + m.getValue());
        }
    }

    public static void main(String[] args) {
        WordFrequency w = new WordFrequency();
        w.test();
    }
}
