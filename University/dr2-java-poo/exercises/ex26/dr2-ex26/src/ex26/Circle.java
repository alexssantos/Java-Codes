package ex26;

/**
 * Circle
 */
public class Circle {

    private double x, y, radius;

    public Circle(double i, double _y, double _radius) 
    {
        //super();
        this.x = i;
        this.y = _y;
        this.radius =_radius;
    }

    //d^2 = (x2-x1)^2 + (y2-y1)^2
    public double distance(Circle c2) {
        double difPowXY = Math.pow((c2.x - this.x), 2) + Math.pow((c2.y - this.y), 2);
        double dist = Math.sqrt(difPowXY);

        System.out.printf("Distance: ", dist);
        return dist;
    };
}