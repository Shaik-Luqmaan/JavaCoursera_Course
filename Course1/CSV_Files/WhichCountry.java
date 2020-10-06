package Java_Coursera.CSV_Files;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WhichCountry {
    public String listExporters(CSVParser parser,String exportOfInterest){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportOfInterest)){
                String ans= record.get("Country");
                System.out.println(ans);
            }
        }
        return null;
    }
    void whoExportsCoffee(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        parser = fr.getCSVParser();
        listExporters(parser,"Coffee");
    }
    public static void main(String[] args) {
        WhichCountry w=new WhichCountry();
        w.whoExportsCoffee();
    }
}
