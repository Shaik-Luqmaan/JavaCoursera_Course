package Java_Coursera.Course2;
import edu.duke.*;

public class CipherBreaker {
    public int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;

        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }

    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];

        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alph.indexOf(ch);
            if (index != -1){
                counts[index] +=1;
            }
        }
        return counts;
    }
    public int getKey(String e_message){
        int[] freqs = countLetters(e_message);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    public String decrypt(String encrypted){
        CaesarCipher cc1 = new CaesarCipher();
        int key = getKey(encrypted);
        return cc1.encrypt(encrypted,(26-key));
    }
    public void test_decrypt(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(message, 20);
        String decrypted = decrypt(encrypted);
        System.out.println(encrypted + "   " + decrypted);
        //System.out.println(decrypt("Z rd"));
    }
    public void test_getKey(){
        FileResource resource = new FileResource();
        String message = resource.asString();
        CaesarCipher cc = new CaesarCipher();
        String e_message = cc.encrypt(message, 5);
        System.out.println(getKey(e_message) + " is the key for: " + message + " to: " + e_message);

    }

    void testing(){
        test_decrypt();
        test_getKey();
    }

    public static void main(String[] args) {
        CipherBreaker cb = new CipherBreaker();
        cb.testing();
    }
}
