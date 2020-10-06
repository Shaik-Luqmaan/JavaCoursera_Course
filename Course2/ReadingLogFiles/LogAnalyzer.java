package Java_Coursera.ReadingLogFiles;

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String fileName) {
        FileResource fr =new FileResource(fileName);
        for(String line : fr.lines()){
            LogEntry entry =WebLogParser.parseEntry(line);
            records.add(entry);
        }
    }
    public int countUniqueIPs(){
        ArrayList<String> uniqueIP = new ArrayList<>();
        for(LogEntry le : records){
            String ip = le.getIpAddress();
            if(!uniqueIP.contains(ip)){
                uniqueIP.add(ip);
            }
        }
        return uniqueIP.size();
    }
    void printAllHigherThanNum(int num){
        ArrayList<Integer> higherCodes = new ArrayList<>();
        for(LogEntry le:records){
            int statusCode = le.getStatusCode();
            if(statusCode > num){
                higherCodes.add(statusCode);
            }
        }
        System.out.println("The number of status code higher than "+num+" are "+higherCodes.size());
        for(int i:higherCodes){
            System.out.println(i);
        }



    }
    ArrayList<LogEntry> uniqueIPVisitsOnDay(String someday){
        ArrayList<LogEntry> uniqueIP = new ArrayList<>();
        for(LogEntry le:records){
            String time = le.getAccessTime().toString();
            String substr = time.substring(4,10);
            if(substr.contains(someday)){
                uniqueIP.add(le); //Adding whole record as it also contains IP address
            }
        }
        return uniqueIP;
    }
    public int countUniqueIPsInRange(int low,int high){
        ArrayList<String> uniqueIP = new ArrayList<>();
        for(LogEntry le: records){
            int status = le.getStatusCode();
            String ip = le.getIpAddress();
            if((status>=low && status<=high) && !uniqueIP.contains(ip)){
                uniqueIP.add(ip);
            }
        }
        return uniqueIP.size();
    }

    public HashMap<String,Integer> countVisitIP(){
        HashMap<String,Integer> hm =new HashMap<>();
        for(LogEntry le:records){
        String ip = le.getIpAddress();
        if(!hm.containsKey(ip)){
            hm.put(ip,1);
        }
        else{
            hm.put(ip,hm.get(ip) +1);
        }
        }
        return hm;
    }
    public int countUniqueIPInHashMap(){
        HashMap<String , Integer> count = countVisitIP();
        return count.size();
    }

    public int mostNumberVisitsByIP(HashMap<String,Integer> hm){
        int maxValue =0;
        for(Map.Entry<String,Integer> m : hm.entrySet()){
            if( m.getValue() > maxValue){
                maxValue = m.getValue();
            }
        }
        return maxValue;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> hm = new HashMap<>();

        for(LogEntry le:records){
            String ip = le.getIpAddress();
            String date = le.getAccessTime().toString();
            String substr = date.substring(4,10);

            if(hm.containsKey(substr)){
                ArrayList ipAddr = new ArrayList();
                ipAddr.add(ip);
                hm.put(substr,ipAddr);
            }
            else {
                ArrayList<String> ipAddresses=new ArrayList<>();
                ipAddresses.add(ip);
                hm.put(substr,ipAddresses);
            }
        }
        return hm;
    }

    String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        map=iPsForDays();
        int count=0;
        String dayWithMostIPs="";
        for(String day:map.keySet()){
            if(map.get(day).size() > count){
                count=map.get(day).size();
                dayWithMostIPs=day;
            }
        }
        return dayWithMostIPs;
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
}