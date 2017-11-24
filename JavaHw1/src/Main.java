
public class Main {
    public static void main(String []args){
        Line line1 = new Line(new Point(1, 1), new Point(2, 2));
        Line line2 = new Line(new Point(-3, 0), new Point(1, 1));

        if(line1.isEqualLength(line2)) System.out.println("This line is equal.");
        else System.out.println("This line is not equal.");

    }
}
