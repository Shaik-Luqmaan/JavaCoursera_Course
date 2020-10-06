package Java_Coursera.HashMap;
import edu.duke.FileResource;
import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
    HashMap<String,Integer> hm = new HashMap();
    void totalWords(){
        int total=0;
        FileResource fr = new FileResource();
        for(String s : fr.words()) {
            s = s.toLowerCase();
            total=+1;
        }
        System.out.println("Total words are: "+total   );
    }
    void numberOfUniqueWords(){
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s=s.toLowerCase();
         if(!hm.containsKey(s)){
             hm.put(s,1);
         }
         else {
             hm.put(s,hm.get(s)+1);
         }
        }
        for(Map.Entry<String,Integer> m : hm.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());

            }
        }
        void test(){
        totalWords();
       numberOfUniqueWords();
    }

    public static void main(String[] args) {
        UniqueWords u =new UniqueWords();
        u.test();
    }
}
