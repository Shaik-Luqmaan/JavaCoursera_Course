package Java_Coursera.StringAssignment;

public class Part3 {
    public boolean twoOccurences(String stringA,String stringB){
        int i=0;
        int j=0;
        int count=0;
        boolean isTwice=false;
        for(j=i+1; j<stringB.length(); j++){
            i=stringB.indexOf(stringA,j+stringA.length());
            if(i==-1)  {
                isTwice=false;
            }
            else if(i>0){
                count++;
            }
            if(count>=2)
                isTwice=true;
        }
        return isTwice;
    }


    public String lastPart(String stringa,String stringb){
        int i;
        String ans="";
        if((i=stringb.indexOf(stringa))!=-1)
            ans = stringb.substring(stringb.indexOf(stringa)+1,stringb.length());
        else
            ans = stringb;
        return ans;
    }

    public void testing(){
        System.out.println(twoOccurences("by","A story by Abby Long"));
        System.out.println(twoOccurences("atg", "ctgtatgta"));
        System.out.println(twoOccurences("a", "banana"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }

    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.testing();
    }
}
