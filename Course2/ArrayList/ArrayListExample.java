package Java_Coursera.ArrayList;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al.indexOf(4));
        for(int i:al){
            System.out.println(i);
        }
    }



    }

