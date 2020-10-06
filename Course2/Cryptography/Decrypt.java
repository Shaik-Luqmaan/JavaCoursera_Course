package Java_Coursera.Course2;

public class Decrypt {
    public String dencryption(String message ,int key){
        int i;
        int dkey = 26-key;
        StringBuilder stb =new StringBuilder(message);
        String upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabets = "abcdefghijklmnopqrstuvwxyz";

        String shiftedUpperAlphabets = upperAlphabets.substring(dkey) + upperAlphabets.substring(0,dkey);
        String shiftedLowerAlphabets = lowerAlphabets.substring(dkey) + lowerAlphabets.substring(0,dkey);

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

    public static void main(String[] args) {
        Decrypt d =new Decrypt();
        System.out.println(d.dencryption("Z rd" ,17));
    }
}
