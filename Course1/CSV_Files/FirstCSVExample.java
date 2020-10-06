package Java_Coursera.CSV_Files;
import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            System.out.print(record.get("Name")+" ");
            System.out.print(record.get("Favorite Food")+" ");
            System.out.println(record.get("Favorite Color"));
        }
    }

    public static void main(String[] args) {
        FirstCSVExample f=new FirstCSVExample();
        f.readFood();
    }
}
