package Java_Coursera.StringAssignment;

public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String ans="";
        String start;
        String stop;
        char firstChar=dna.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            start = startCodon;
            stop = stopCodon;
        }
        else{
            start = startCodon.toLowerCase();
            stop = stopCodon.toLowerCase();
        }

        int indexStart=dna.indexOf(startCodon);
        //System.out.println(indexStart);
        int indexStop=dna.indexOf(stopCodon);
        //System.out.println(indexStop);
        int length=0;

        System.out.println("Input String is: "+dna);

        if(indexStart==-1 && indexStop==-1) {
            System.out.println("ATG not found: ");
            System.out.println("TAA not found: ");

        }

        else if(indexStart!=-1 && indexStop==-1){
            System.out.println("TAA not found: ");
            System.out.println("Start index ATG: "+indexStart);

        }

        else if(indexStart==-1 && indexStop!=-1) {
            System.out.println("ATG not found: ");
            System.out.println("Stop index TAA: "+indexStop);

        }
        else
        {
            System.out.println("The String contains ATG and TAA");
            length=indexStart+3-indexStop;
            if (length%3==0){

                System.out.println("DNA is multiple of 3");
                return dna.substring(indexStart,indexStop+3);
            }
            System.out.println("DNA is not multiple of 3");
        }
        return ans;
    }

    public void testSimpleGene(){
        findSimpleGene("ASCDSATAA","ATG","TAA");
        findSimpleGene("ATGABCASD","ATG","TAA");
        findSimpleGene("ASDFGHJKL","ATG","TAA");
        findSimpleGene("ATGASDTAA","ATG","TAA");
        findSimpleGene("ATGABTAA","ATG","TAA");
        findSimpleGene("ATGABTAA","ATG","TAA");
        findSimpleGene("atgtgdtaa","atg","taa");
    }

    public static void main(String[] args) {
        Part2 p2=new Part2();
        p2.testSimpleGene();

    }

}
