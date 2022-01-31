import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlightMapTest {

    @Test
    void testReadFile1() {
        FlightMap m = new FlightMap("input.txt");
        m.readFileHelper();

        int[][] matrixTest = {
                {0,200,300,0,0,0,0,0,0},
                {0,0,0,0,0,250,0,500,0},
                {0,0,0,200,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,375,0,0,0,0,0},
                {0,0,0,0,0,0,300,0,0},
                {0,350,0,0,0,0,0,0,0},
                {0,0,600,0,0,0,0,0,450},
                {0,0,0,0,0,0,0,0,0}};
        Assertions.assertArrayEquals(matrixTest, m.getMatrix(), "Checking if input.txt is read");
    }

}
