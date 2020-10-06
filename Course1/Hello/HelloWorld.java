package Java;
public class HelloWorld {
    public static void main(String[] args) {
        Thing f = new Thing(6);
        Thing g = new Thing(8);
        f.combine(g);
        System.out.println(f.geta());
        System.out.println(g.geta());
    }
}
class Thing {
    private int a;
    public Thing(int x) {
        a = x;
    }
    public int geta() {
        return a ;
    }
    public void combine (Thing y) {
        a = a + y.geta();
    }
}