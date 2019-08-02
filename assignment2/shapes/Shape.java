package assignment2.shapes;

public interface Shape {
    double calculateArea(double x, double y);
    default void display(){};
}
