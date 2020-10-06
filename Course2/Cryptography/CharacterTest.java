package Java_Coursera.Course2;

public class CharacterTest {
    String s = "ABSHJHFDJSFDJFGJF26745634DHFGHDFDG";
    int i;
    void testing(){
        for(i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                System.out.println(ch + "is Digit");
            }
            if(Character.isAlphabetic(ch)){
                System.out.println(ch + " is Alphabetic");
            }
        }
    }
    void conversion(){
        for(i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char lower = Character.toLowerCase(ch);
            char upper = Character.toUpperCase(ch);
            System.out.println(ch + " " + lower + " " + upper);
        }
    }

    public static void main(String[] args) {
        CharacterTest ct = new CharacterTest();
        ct.testing();
        ct.conversion();
    }
}
