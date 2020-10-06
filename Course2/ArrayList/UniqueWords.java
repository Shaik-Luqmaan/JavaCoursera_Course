package Java_Coursera.ArrayList;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class UniqueWords {
    StorageResource myWords = new StorageResource();
    void getElements(){
        FileResource fr =new FileResource();
        for(String s:fr.words()){
            s=s.toLowerCase();
            myWords.add(s);
        }
    }

    boolean contains(String[] list , String word){
        for(int i=0;i<list.length;i++){
            if(list.equals(word)){
                return true;
            }
        }
        return false;
    }

    int numberOfUniqueWords(){
        String[] words = new String[myWords.size()];
        int count =0 ;
        for(String s : myWords.data()){
            if(!contains(words,s)){
                words[count] = s;
                count++;
            }
        }
        return count;
    }

    void test(){
        getElements();
        int unique = numberOfUniqueWords();
        System.out.println("Number of unique words are: "+unique);
    }

    public static void main(String[] args) {
        UniqueWords u =new UniqueWords();
        u.test();
    }
}
