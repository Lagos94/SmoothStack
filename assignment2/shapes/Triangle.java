package assignment2.shapes;
class Triangle implements Shape {
    @Override
    public double calculateArea(double base, double height) {
        double area = (.5*base*height);
        return area;
    }

    @Override
    public void display() {
        System.out.println(calculateArea(4,5));
    }
}
