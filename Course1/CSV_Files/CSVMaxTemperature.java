package Java_Coursera.CSV_Files;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMaxTemperature {
    public CSVRecord hottestHourInFile(CSVParser parser ){
        CSVRecord largestSoFar = null;
        for(CSVRecord record:parser){
            if(largestSoFar == null){
                largestSoFar = record;
            }
            else{
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));

                if(currentTemp > largestTemp){
                    largestSoFar = record;
                }

            }
        }
        return largestSoFar;
    }

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));

                if (currentTemp > largestTemp) {

                    largestSoFar = currentRow;
                }
            }
        }

        return largestSoFar;
    }

    void test() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord result = hottestHourInFile(parser);
        System.out.println(result.get("TemperatureF") + " at" + result.get("TimeEST"));


        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                " at " + largest.get("DateUTC"));
    }

    public static void main(String[] args) {
        CSVMaxTemperature m =new CSVMaxTemperature();
        m.test();
    }
}
