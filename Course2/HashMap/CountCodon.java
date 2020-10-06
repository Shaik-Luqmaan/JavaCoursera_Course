package Java_Coursera.HashMap;

import edu.duke.FileResource;

import java.util.HashMap;
import java.util.Map;

public class CountCodon {
    private HashMap<String,Integer> hm;
    CountCodon(){
       hm = new HashMap<>();
    }
    void buildCodonMap(int Start, String dna) {
        int initial = Start;
        for (int i = Start; i < dna.length() - 3; i += 3) {
            String codon = dna.substring(initial, initial + 3);
            initial = dna.indexOf(codon) + 3;
                if (hm.keySet().contains(codon)) {
                hm.put(codon, hm.get(codon) + 1);
            }
            else{
                hm.put(codon,1);
            }
        }
    }
    String getMostCommonCodon(){
        int codonCount=0;
        String codon=" ";
        for(String key : hm.keySet() ){
            if(hm.get(key)>codonCount){
                codonCount=hm.get(key);
                codon=key;
            }
        }
        return codon;
    }
        void printCodonCounts(int start, int end){
        for(String s:hm.keySet()){
            if(hm.get(s)>=start && hm.get(s)<=end){
                System.out.println("The count of "+s+" is :"+ hm.get(s));
            }
            }
        }
        void print(){
        for(Map.Entry<String,Integer> m :hm.entrySet()){
            System.out.println("The codon between 1 and 5 are: ");
            System.out.println(m.getKey()+ " " + m.getValue());
        }
        }

    void test(){
        FileResource fr = new FileResource();
        String dnaString=fr.asString().toUpperCase();
        buildCodonMap(2,dnaString);
        System.out.println("Most common codon is: "+ getMostCommonCodon());
        printCodonCounts(1,5);
        print();
    }
    public static void main(String[] args) {
        CountCodon cc = new CountCodon();
        cc.test();
    }
}