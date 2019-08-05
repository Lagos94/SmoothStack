package assignment4.junit;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    private final Line line1 = new Line(0,0,2,2);
    private final Line line2 = new Line(0,0,4,4);

    private LineTest(){} //restricted to this class

    public void  slopeTest(){
        assertEquals(line1.getSlope(),line2.getSlope());
    }

    public void parallelTest(){
        assertFalse(line1.getDistance() == line2.getDistance() && line1.parallelTo(line2));
    }

    public void distanceTest(){
        assertTrue(line1.getDistance()>line2.getDistance() || line1.getDistance()<line2.getDistance());
    }

    public static void main(String[] args) {
        LineTest displayResultOf = new LineTest();
        displayResultOf.distanceTest();
        displayResultOf.parallelTest();
        displayResultOf.slopeTest();
    }
}
