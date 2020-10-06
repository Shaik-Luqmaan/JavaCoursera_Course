package Java_Coursera.StringAssignment;

import edu.duke.URLResource;

public class Part4 {
    public void search(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.lines()) {
            s.toLowerCase();
            if(s.contains("youtube.com")){
                int position = s.lastIndexOf("youtube",s.length());
                System.out.println(" Youtube link found "+s+"At the position "+position);
            }
        }
    }
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        part4.search();
    }

}
