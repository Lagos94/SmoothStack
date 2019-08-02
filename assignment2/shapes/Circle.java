package assignment2.shapes;
class Circle implements Shape {
    @Override
    public double calculateArea(double radius, double pi) {
        pi = Math.PI;
        double area = (pi*radius*radius);
        return area;
    }

    @Override
    public void display() {
        System.out.println(calculateArea(5, Math.PI));
    }
}
