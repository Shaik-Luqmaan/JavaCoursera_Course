package Java_Coursera.ArrayList;
import edu.duke.FileResource;
import java.util.ArrayList;

public class CharacterNames {
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> countOfNames = new ArrayList<>();

    public void update(String Person){
            int index = names.indexOf(Person);
            if(index == -1){
                names.add(Person);
                countOfNames.add(1);
            }
            else{
                int value = countOfNames.get(index);
                countOfNames.set(index,value+1);
         }
    }
    void findAllCharacters(){
        FileResource fr =new FileResource();
        for (String lines : fr.lines()){
            int index = lines.indexOf('.');
            if(index!=-1){
                lines = lines.substring(0,index);
                update(lines);
            }
        }
    }
    public int findIndexOfMax(){
        int maxValue=0;
        for(int i:countOfNames){
            if(countOfNames.get(i) > maxValue ){
                maxValue = countOfNames.get(i);
            }
        }
        return maxValue;
    }
    void charactersWithNumParts(int num1,int num2){
        for(int i: countOfNames){
            int number = countOfNames.get(i);
            if(number > num1 && number < num2){
                System.out.println(names);
            }
        }
    }
    void test(){
        findAllCharacters();
        int index = findIndexOfMax();
        System.out.println(names);
        System.out.println("The number of characters till period are: "+ countOfNames);
        System.out.println("Max number of speaking part is: " + names.get(index));
        charactersWithNumParts(10,15);
    }

    public static void main(String[] args) {
        CharacterNames c=new CharacterNames();
        c.test();
    }
}
