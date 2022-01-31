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
     * Util function to recursively execute dfs on flightMap
     * @param node current node being checked
     * @param visited list of all the visited notes
     * @param route current route being taken from startPoint
     * @param totalCost total cost of the route till now
     */
    private static void dfsUtil(Character node, List<Character> visited, String route, int totalCost) {

        // add node to visited
        visited.add(node);

        //making sure it does not print a flight from the startPoint to the startPoint
        if(!node.equals(m.getStartPoint())) {
            route+=","+node;
            //Printing out the route + cost
            System.out.format("%15s %15s %15s\n",node,route,totalCost);
        }

        //searching through current nodes flights to other cities
        for(int i =0; i < m.getNumberOfAirports();i++) {

            //making sure that a flight exists, and that we have not already visited that airport/node
            if((m.getMatrix()[m.getRTable().indexOf(node)][i] != 0) && (!visited.contains(m.getRTable().get(i)))) {
                //System.out.println("In: "+node);

                //calling dfs on next node
                dfsUtil(m.getRTable().get(i), visited, route, totalCost+m.getMatrix()[m.getRTable().indexOf(node)][i]);
            }
        }

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
