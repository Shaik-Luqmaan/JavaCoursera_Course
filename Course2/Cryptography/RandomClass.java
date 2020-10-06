package Java_Coursera.Course2;

import java.util.Random;

public class RandomClass {
    void rollDice(int rolls){
        Random rand  =new Random();
        int[] count = new int[13];
        for(int i=0;i<rolls;i++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            count[d1 + d2] += 1;
        }
        System.out.println("Count array");
            for(int k=1;k<=12;k++){
                System.out.println(" The sum "+ k+ " came "+ count[k] + " times when we rolled the two dice");
            }

    }

    void test(){
        rollDice(100);
    }

    public static void main(String[] args) {
        RandomClass r = new RandomClass();
        r.test();
    }
}
