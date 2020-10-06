package Java_Coursera.StringAssignment;

public class Part1 {
    public String findSimpleGene(String dna){

        String ans="";
        int indexStart=dna.indexOf("ATG");
        int indexStop=dna.indexOf("TAA");
        int length=0;

        System.out.println("DNA is: "+dna);

        if(indexStart==-1 && indexStop==-1) {
            System.out.println("ATG not found: ");
            System.out.println("TAA not found: ");
        }

        else if(indexStart!=-1 && indexStop==1){
            System.out.println("TAA not found: ");
            System.out.println("Start index ATG: "+indexStart);

        }

        else if(indexStart==1 && indexStop!=-1) {
            System.out.println("ATG not found: ");
            System.out.println("Stop index TAA: "+indexStop);

        }
        else
        {
            System.out.println("DNA contains ATG and TAA");
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
        findSimpleGene("ASCDSATAA");
        findSimpleGene("ATGABCASD");
        findSimpleGene("ASDFGHJKL");
        findSimpleGene("ATGASDTAA");
        findSimpleGene("ATGABTAA");
        findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC");
    }
    public static void main(String[] args){
        Part1 p = new Part1();
        p.testSimpleGene();
    }
}
