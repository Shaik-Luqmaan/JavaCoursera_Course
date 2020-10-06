package Java_Coursera.ArrayList;
import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequency {
    ArrayList<String> myWords = new ArrayList<>();
    ArrayList<Integer> myFreq =  new ArrayList<>();
    public void  findUnique(){
        FileResource fr =new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreq.add(1);
            }
            else{
                int value = myFreq.get(index);
                myFreq.set(index, value+1);
            }
        }
    }
    public int findIndexOfMax(){
        int maxValue=0;
        for(int i:myFreq){
            if(myFreq.get(i) > maxValue ){
                maxValue = myFreq.get(i);
            }
        }
        return maxValue;
    }
    void test() {
        findUnique();
        for (int k = 0; k < myWords.size(); k++) {
            System.out.println(myWords.get(k) + " has a frquency of " + myFreq.get(k));
        }
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs the most is: " + maxIndex);
        System.out.println("Word with maxIndex is: "+ myWords.get(maxIndex));
    }
    public static void main(String[] args) {
        WordFrequency w =new WordFrequency();
        w.test();
    }

}
