package Java_Coursera.StringAssignment2;

public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");

        int temp=Math.min(taaIndex,tagIndex);
        int minIndex=Math.min(temp,tgaIndex);
        if(minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }

    public void testFindGene() {
        System.out.println("Gene is: "+findGene("ATGFDSTAA"));
        System.out.println("Gene is: "+findGene("ATGFDSTAG"));
        System.out.println("Gene is: "+findGene("ATGFDSTGA"));
        System.out.println("Gene is: "+findGene("ATGTHGFDS"));
    }

    public void testFindStopCodon() {
        System.out.println("Stop codon is " +
                findStopCodon("ATGASDTAA",0,"TAA"));
    }

    public static void main(String[] args) {
        Part1 p1=new Part1();
        p1.testFindStopCodon();
        p1.testFindGene();
    }
}
