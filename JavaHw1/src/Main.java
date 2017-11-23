
public class Main {
    public static void main(String []args){
        Line line1 = new Line(new Point(1, 2), new Point(3, 4));
        Line line2 = new Line(new Point(-1, -2), new Point(-3, -4));
        Line line3 = new Line(new Point(1, 1), new Point(10, 10));

        System.out.println(line1.getLength());
        System.out.println(line2.getLength());
        System.out.println(line3.getLength());

        System.out.println(line1.isEqualLength(line2));
        System.out.println(line1.isEqualLength(line3));
    }
}
