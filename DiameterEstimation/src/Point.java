public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public double angle(Point origin) {
        return Math.atan2(this.y - origin.y, this.x - origin.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

