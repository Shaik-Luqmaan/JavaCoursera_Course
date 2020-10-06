package Java_Coursera.CSV_Files;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

    public class Assignment {
    public void countryInfo(CSVParser parser,String country){
        for(CSVRecord record:parser){
            String countryNames = record.get("Country");
            if(countryNames.contains(country)){
                System.out.println(record.get("Country")+": "
                        +record.get("Exports")+ ": "
                        +record.get("Value (dollars)"));
            }
        }
    }

    public String listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    String result="";
    String exportItemInput;

    for (CSVRecord record:parser) {
        exportItemInput = record.get("Exports");
        if ((exportItemInput.contains(exportItem1)) && (exportItemInput.contains(exportItem2))){
            result = record.get("Country");
            System.out.println("listExportersTwoProducts: "+result);
        }
    }
    return null;
}

    public int numberOfExporters(CSVParser parser,String exportItem){
        int count=0;
        for(CSVRecord record:parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                record.get("Country");
                count+=1;
            }
        }
        return count;
}

        public void bigExporters(CSVParser parser, String amount){
            String outputAmount;
            String ans;
            int count=0;
            for (CSVRecord record:parser) {
                outputAmount = record.get("Value (dollars)");
                if(outputAmount.length() > amount.length()){
                    ans = record.get("Country")+":"+record.get("Value (dollars)");
                    System.out.println("bigExporters: "+ans);
                }
            }
        }

    void tester(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        countryInfo(parser,"Nauru");

        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");

        parser = fr.getCSVParser();
        int resultCount = numberOfExporters(parser,"gold");
        System.out.println(resultCount);

        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");

    }

    public static void main(String[] args) {
        Assignment a=new Assignment();
        a.tester();
    }
}
