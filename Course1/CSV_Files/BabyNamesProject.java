package Java_Coursera.CSV_Files;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyNamesProject {
    public void printNames (FileResource fr) {
            for (CSVRecord record : fr.getCSVParser(false)) {
                int numBorn = Integer.parseInt(record.get(2));
                if (numBorn <= 100) {
                    System.out.println("Name " + record.get(0) +
                            " Gender " + record.get(1) +
                            " Num Born " + record.get(2));
                }
            }
        }
        public void totalBirths(FileResource fr){
        int numGirls = 0;
        int numBoys = 0;
        int totalBabies=0;
        for(CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals("F")){
                numGirls+=Integer.parseInt(record.get(2));

            }else{
                numBoys+=Integer.parseInt(record.get(2));
            }
        }
            totalBabies = numBoys + numGirls;
            System.out.println("Total number of births:"+ totalBabies);
            System.out.println("Total number of  girls:"+ numGirls);
            System.out.println("Total number of boys:" + numBoys);
    }

    public void getNames(FileResource fr){
        int count=0;
        for(CSVRecord record : fr.getCSVParser(false)){
            if(record.get(1).equals("F")){
                System.out.println("Girls name are: "+record.get(0));
            }
            else{
                System.out.println("Boys names are: "+ record.get(0));
            }
            count++;
        }
        System.out.println("Total number of names are: "+ count);
    }

    public long getRank(int year, String name, String gender) {
        long rank = -1;
        FileResource fr =
                new FileResource("/home/luqmaan/Desktop/JAVA/us_babynames/us_babynames_by_year/yob"
                +year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                rank = record.getRecordNumber();
            }
        }
        return rank;
    }

    public String getName(int year, int rank, String gender) {
        String name = null;
        FileResource fr = new FileResource("/home/luqmaan/Desktop/JAVA/us_babynames/us_babynames_by_year/yob"
                +year+".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            long currentRank = record.getRecordNumber();
            if(currentRank == rank && record.get(1).equals(gender)) {
                name = record.get(0);
            }
        }
        if(name != null) {
            return  name;
        } else {
            return "NO NAME";
        }
    }

    public void whatIsNameInYear(String name,int year, int newYear, String gender){
        long currentRank = getRank(year,name,gender);
        FileResource fr = new
                FileResource("/home/luqmaan/Desktop/JAVA/us_babynames/us_babynames_by_year/yob"
                +newYear+".csv");
        for (CSVRecord record : fr.getCSVParser(false)){
            if(currentRank == record.getRecordNumber() && gender.equals(record.get(1))){
                System.out.println(name + " born in " + year + " would be " + record.get(0)
                        + " if she was born in "+ newYear);
            }
        }
    }

    public long getAverageRank(String name, String gender) {
        int count = 0;
        long totalRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            for (CSVRecord record : fr.getCSVParser(false)) {
                if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                    totalRank = totalRank + record.getRecordNumber();
                    count++;
                }
            }
        }
        long averageRank = (totalRank/count);
        return averageRank;
    }

    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int numBorn = 0;
        long rank = getRank(year, name, gender);
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser()){
            long currentRank = record.getRecordNumber();
            if(record.get(1).equals(gender) && currentRank < rank){
                numBorn = numBorn + Integer.parseInt(record.get(2));
            }
        }
        return numBorn;
    }

    void test(){

          FileResource fr =new FileResource("/home/luqmaan/Desktop/JAVA/babyNames/data/example-small.csv");
          getNames(fr);
          printNames(fr);
          totalBirths(fr);
          getRank(2012,"Mason","M");
          System.out.println(getRank(1971, "Frank", "M"));
          System.out.println(getName(2014,1,"F"));
          whatIsNameInYear("Isabella",2012,2014,"F");
          System.out.println("Average of ranks is:"+ getAverageRank("Jacob","M"));
          System.out.println("Total Births ranked higher than given name are: " +
                  getTotalBirthsRankedHigher(2012,"Ethan","M"));
    }

    public static void main(String[] args) {
        BabyNamesProject b=new BabyNamesProject();
        b.test();

    }
}
