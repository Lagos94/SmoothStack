package assignment2.shapes;
class Rectangle implements Shape{
    @Override
    public double calculateArea(double length, double width) {
        double area = length*width;
        return area;
    }

    @Override
    public void display() {
        System.out.println(calculateArea(2,2));
    }
}
