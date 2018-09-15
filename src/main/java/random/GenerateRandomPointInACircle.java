package random;

import java.util.Random;

public class GenerateRandomPointInACircle {
    Random random = new Random();

    double radius;
    double x_center, y_center;
    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double theta = random.nextDouble();
        double angel = theta * Math.PI;
        double cos = Math.cos(angel);
        double sin = Math.sin(angel);
        double radius_random = radius * Math.sqrt(random.nextDouble());
        double x_random = radius_random * cos;
        double y_random = radius_random * sin;

        x_random = x_center + x_random;
        y_random = y_center + y_random;

        double[] point = new double[2];
        point[0] = x_random;
        point[1] = y_random;
        return point;
    }
}
