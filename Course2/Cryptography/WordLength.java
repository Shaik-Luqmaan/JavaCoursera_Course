package Java_Coursera.Course2;

import edu.duke.FileResource;

public class WordLength {
    public void countWordLengths(FileResource fr, int[] count) {
        int length, flag = 0;
        for (String words : fr.words()) {

            length = words.length();
            if (Character.isLetter(words.charAt(0)) &&
                    Character.isLetter(words.charAt(words.length() - 1)) &&
                    !words.isEmpty()) {
                length -= 2;

            } else if ((Character.isLetter(words.charAt(0)) ||
                    Character.isLetter(words.charAt(words.length() - 1))) &&
                    !words.isEmpty()) {
                length -= 1;
            }
            count[length] += 1;
        }
    }
    public void test(){
            FileResource fileResource=new FileResource();
            int counts[]=new int[20];
            countWordLengths(fileResource,counts);
            for(int index=0;index<counts.length;index++){
                System.out.println(counts[index]+ "words of length"+index);
            }
        }

    public static void main(String[] args) {
        WordLength w = new WordLength();
        w.test();
    }
}
