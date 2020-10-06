package Java_Coursera.StringAssignment2;

public class Part3 {
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
    public int countGene(String dna){
        int count=0;
        int startFirstOccurence = dna.indexOf("ATG");
        int stopFirstOccurence = 0;
        String ans="";
        int result = 0;

        if (startFirstOccurence != -1) {
            String stopCodonArr[] = {"TAA", "TAG", "TGA"};
            for (int i = 0; i < stopCodonArr.length; i++) {
                stopFirstOccurence = dna.indexOf(stopCodonArr[i]);
                if (dna.contains(stopCodonArr[i]) && stopFirstOccurence != -1 && stopFirstOccurence % 3 == 0) {
                    result = stopFirstOccurence;
                    ans = dna.substring(startFirstOccurence, stopFirstOccurence + 3);
                    count++;
                }
            }
        }

        return count;
    }

    public String multipleGenes(String dna){
        int startFirstOccurence = dna.indexOf("ATG");
        int stopFirstOccurence = 0;
        String ans="";
        int result = 0;

        if (startFirstOccurence != -1) {
            String stopCodonArr[] = {"TAA", "TAG", "TGA"};
            for (int i = 0; i < stopCodonArr.length; i++) {
                stopFirstOccurence = dna.indexOf(stopCodonArr[i]);
                if (dna.contains(stopCodonArr[i]) && stopFirstOccurence != -1 && stopFirstOccurence % 3 == 0) {
                    result = stopFirstOccurence;
                    ans = dna.substring(startFirstOccurence, stopFirstOccurence + 3);

                }
            }
        }

        return ans;
    }

    void testCountGene(){
        System.out.println(countGene("ATGCCCTAGGHTTGA"));
        System.out.println(countGene("ATGTAAABAATGCAATAGCCCATGTTTTAG"));
        System.out.println(countGene("ATGTAAATGTAGATGTGA"));
    }

    void testMultipleGene(){
        System.out.println(multipleGenes("ATGTAAATGTAGATGTGACCCCCCCAT"));
    }
    public static void main(String[] args) {
        Part3 p3=new Part3();
        p3.testCountGene();
        p3.testMultipleGene();
    }
}
