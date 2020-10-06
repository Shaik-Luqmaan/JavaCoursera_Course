package Java_Coursera.Course2;

import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt(String message ,int key){
        int i;
        StringBuilder stb =new StringBuilder(message);
        String upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabets = "abcdefghijklmnopqrstuvwxyz";

        String shiftedUpperAlphabets = upperAlphabets.substring(key) + upperAlphabets.substring(0,key);
        String shiftedLowerAlphabets = lowerAlphabets.substring(key) + lowerAlphabets.substring(0,key);

        for(i=0;i<stb.length();i++){
            char ch = stb.charAt(i);
            if(ch>='a' && ch<='z') {
                int index = lowerAlphabets.indexOf(ch);
                if (index != -1) {
                    char newCh = shiftedLowerAlphabets.charAt(index);
                    stb.setCharAt(i, newCh);
                }
            }
           else if(ch>='A' && ch<='Z') {
                int index = upperAlphabets.indexOf(ch);
                if (index != -1) {
                    char newCh = shiftedUpperAlphabets.charAt(index);
                    stb.setCharAt(i, newCh);
                }
            }
        }
        return  stb.toString();
    }

    public String encryptTwoKeys(String input, int key1,int key2){
        StringBuilder stb= new StringBuilder(input);

        for(int i=0;i<input.length();i++) {
            if (i % 2 == 0) {
                char ch = input.charAt(i);
                String encrypted = encrypt(Character.toString(ch), key1);
                stb.setCharAt(i, encrypted.charAt(0));
            } else {
                char ch = input.charAt(i);
                String encrypted = encrypt(Character.toString(ch), key2);
                stb.setCharAt(i, encrypted.charAt(0));
            }
        }
        return stb.toString();
    }

        void testCaesar(){
        int key=17;
        FileResource fr =  new FileResource();
        String message =fr.asString();

        String encrypted = encrypt(message , key);
        System.out.println(
                encrypt("At noon be in the conference room with your hat on for a surprise party. " +
                        "YELL LOUD!",15));
        System.out.println(encrypt("I am", 17));
            System.out.println(encrypt("Z rd", 21));
        //System.out.println("Message is: " + message);
        //System.out.println("Encrypted Message is: "+ encrypted);

        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party." +
                " YELL LOUD!", 8, 21));
    }

    public static void main(String[] args) {
        CaesarCipher c =new CaesarCipher();
        c.testCaesar();
    }


}
