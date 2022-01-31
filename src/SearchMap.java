import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Vector;

/**
 * SearchMap class is an overarching class that executes dfs on a flightMap
 * @author rahilbharatram
 */
public class SearchMap {
    private static FlightMap m;
    private static List<Character> visited;

    public SearchMap(FlightMap m) {
        this.m = m;
    }

    /**
     * Helper function that instantiates visited vector, sets start point and actually executes the dfs
     */
    public static void dfs() {

        // Setting visited vector
        visited = new Vector<>();


        // Setting initial port
        String route = m.getStartPoint().toString();

        //formatting for file writing
        System.out.format("%15s %15s %15s\n","Destination","Route from "+m.getStartPoint(),"Cost");

        //calling dfsUtil
        dfsUtil(m.getStartPoint(), visited,route, 0);

    }
    

    /**
     * Executes finding paths to all cities from a given start city
     * @param args input filename, output filename
     * @throws IOException in case of file error
     */
    public static void main(String[] args) throws IOException {

        //setting output file
        PrintStream o = new PrintStream("output.txt");
        System.setOut(o);
        m = new FlightMap("input.txt");
        m.readFileHelper();
        //m.checkMatrix();

        dfs();

    }


    /**
     * Helper for debugging to get visited vector
     * @return visited table
     */
    public static List<Character> getVisited(){
        return visited;
    }
}
