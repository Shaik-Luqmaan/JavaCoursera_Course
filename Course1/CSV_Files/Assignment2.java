package Java_Coursera.CSV_Files;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Assignment2 {
    CSVRecord coldestHourFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord record : parser) {
            if (coldestSoFar == null) {
                coldestSoFar = record;
            } else {
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                double largestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));

                if (currentTemp < largestTemp) {
                    coldestSoFar = record;
                }

            }
        }
        return coldestSoFar;
    }
    void test() {
        FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord result = coldestHourFile(parser);
        System.out.println(result.get("TemperatureF")+" at"+result.get("TimeEST"));
}

    public static void main(String[] args) {
        Assignment2 a =new Assignment2();
        a.test();
    }
}
