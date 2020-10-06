package Java_Coursera.Course2;

public class WordPlay {
    boolean isVowel(char ch){
        char Vowels[] = {'a','e','i','o','u','A','E','I','O','U'};
        for(int i=0;i<Vowels.length;i++){
            if(ch == Vowels[i]){
                return true;
            }
        }
        return false;
    }
    public String replaceVowels(String phrase,char ch) {
            StringBuilder replacevowel=new StringBuilder(phrase);
            for(int i=0;i<phrase.length();i++){
                if(isVowel(phrase.charAt(i))){
                    replacevowel.setCharAt(i,ch);
                }
            }
            return replacevowel.toString();
        }
    String emphasize(String phrase, char ch) {
        StringBuilder stb = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            if (stb.charAt(i) == ch && (i % 2 == 0)) {
                stb.setCharAt(i, '*');
            } else if (stb.charAt(i) == ch)
                stb.setCharAt(i, '+');
        }
        return stb.toString();
    }
    public void test(){
            System.out.println(isVowel('A'));
            System.out.println(replaceVowels("aeiou",'*'));
            System.out.println(emphasize("dna ctgaaactga", 'a'));
        }

    public static void main(String[] args) {
        WordPlay w = new WordPlay();
        w.test();
    }




}

