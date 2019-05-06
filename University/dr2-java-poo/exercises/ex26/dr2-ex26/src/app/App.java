package app;

import ex26.Circle;

public class App {
    public static void main(String[] args) throws Exception {
        
        Circle c1 = new Circle(24.0, 32.0, 4.0);
        Circle c2 = new Circle(29.0, 12.0, 7.0);

        double distance = c1.distance(c2);
    }
}