package Java_Coursera.ReadingLogFiles;

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("/home/luqmaan/Desktop/Course2/Week3/WebLogProgram/weblog1_log");
        //la.readFile("/home/luqmaan/Desktop/Course2/Week3/UniqueIPData/short-test_log");
        la.printAll();

        System.out.println("Number of unique Ips are: "+ la.countUniqueIPs());

        la.printAllHigherThanNum(400);

        System.out.println(la.uniqueIPVisitsOnDay("Mar 17").size());

        System.out.println("The IP Address in given range are "+la.countUniqueIPsInRange(300,399));

        HashMap<String,Integer> counts =la.countVisitIP();
        System.out.println(counts);

        int count = la.countUniqueIPInHashMap();
        System.out.println("The number of Unique Ip addresses are: " + count);

        System.out.println("The max number of visit per Ip are: "+la.mostNumberVisitsByIP(counts));

        System.out.println(la.iPsForDays());

        System.out.println(la.dayWithMostIPVisits(la.iPsForDays()));

    }
    public static void main(String[] args) {
        Tester t =new Tester();
        t.testLogAnalyzer();

    }
}
