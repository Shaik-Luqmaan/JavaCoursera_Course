package Java_Coursera.StringAssignment2;

public class Part2 {
    public int howMany(String stringA,String stringB){
        int count=0;
        int i,j;
        i=stringB.indexOf(stringA);
        if(i>-1) {
            count++;
            for (j = i; j < stringB.length(); j++) {
                i = stringB.indexOf(stringA, j + stringA.length());
                if (i!=-1) {
                    count++;
                }
            }
        }
        return count;
    }
    void testHowMany(){
        System.out.println(howMany("ana","banana"));
        System.out.println( howMany("an","banana"));
        System.out.println( howMany("x","banana"));
    }

    public static void main(String[] args) {
        Part2 p2=new Part2();
        p2.testHowMany();
    }
}

