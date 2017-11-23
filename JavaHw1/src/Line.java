
public class Line {
    private Point p1, p2;
    private final static double eps = 0.0000001;

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isEqualLength(Line line){
        if(Math.abs(this.getLength() - line.getLength()) < eps) return true;
        return false;
    }

    public double getLength(){
        double result = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        return result;
    }

}

