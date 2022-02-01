package src.project1a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * FlightMap Class reads the a specified input file which contains a start point as well as flights from a city to another with the associated cost
 * @author rahilbharatram
 *
 */
public class FlightMap {
    private List<Character> rtable;
    private int[][] matrix;
    private int numberOfAirports;
    private Character startPoint;
    private final String filename;

    /**
     * Instantiation of FlightMap Class
     * @param filename It is the filename for the input file which contains the data
     */
    public FlightMap(String filename) {
        this.filename = filename;
    }

    /**
     * ReadFileHelper class handles IOExceptions during the read file process
     */
    public void readFileHelper() {
        try {
            checkFile();
            createMatrix();
            readFile();
        } catch (IOException e) {
            System.out.println("Trouble reading the file. Goodbye.");

        }
    }

    /**
     * Prelim reading of the file to create a reference table of all the airports and to identify the total number of airports that exist
     * @throws IOException in case of file reading errors
     * @throws NullPointerException in case that the line is null
     */
    private void checkFile () throws IOException, NullPointerException {
        rtable = new Vector<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = "";

        //adding first port to the reference list
        line = br.readLine();


        //checks if file is empty
        if (line == null) {
            System.out.println("File is empty");
            br.close();
            return;
        }

        //adding start point to reference table and saving it as a start point
        rtable.add(line.charAt(0));
        startPoint = line.charAt(0);


        //reading the rest of the file
        while ((line = br.readLine()) != null) {

            //splitting the line into the 3 values: Airport1, Airport2, costOfTravel
            String[] temp = line.split(" ");
            Character char1 = temp[0].charAt(0);
            Character char2 = temp[1].charAt(0);
            Boolean char1Exists = false;
            Boolean char2Exists = false;

            //checking if airports already exist in reference table
            for (Character x : rtable) {
                if (x.equals(char1)) char1Exists = true;
                if (x.equals(char2)) char2Exists = true;
            }

            //If airports do not exist, saving them in reference table
            if (!char1Exists) rtable.add(char1);
            if (!char2Exists) rtable.add(char2);
        }
        br.close();

        //saving number of Airports
        numberOfAirports = rtable.size();
    }

    /**
     * CreatMatrix creates the adjacency list (2D array) to store the flight options.
     * By parsing the rows, you will be able to see the cities vistable from that airport
     * The row index can be referenced to the rtable to see which exact airport it is
     */
    private void createMatrix(){
        matrix = new int[numberOfAirports][numberOfAirports];
    }

    /**
     * Displays matrix to the output file in a table like format
     */
    public void checkMatrix() {
        System.out.print("\t");
        for (int i = 0; i < numberOfAirports; i++) {
            System.out.print(rtable.get(i) + "\t");
        }
        System.out.println();

        for (int i = 0; i < numberOfAirports; i++) {
            System.out.print(rtable.get(i) + "\t");
            for (int j = 0; j < numberOfAirports; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Actually reads the file and saves data to the matrix variable
     * @throws IOException in case file cannot be read properly
     */
    private void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = "";

        line = br.readLine();

        //closes file if it is empty or missing first line
        if(line == null) {
            br.close();
            return;
        }

        //parses file to save to matrix
        while((line=br.readLine())!=null){
            String[] temp = line.split(" ");
            matrix[rtable.indexOf(temp[0].charAt(0))][rtable.indexOf(temp[1].charAt(0))]=Integer.parseInt(temp[2]);
        }
        br.close();
        //checkMatrix();

    }

    /**
     * Access to reference table
     * @return rtable
     */
    public List<Character> getRTable(){
        return rtable;
    }

    /**
     * Access to Matrix
     * @return matrix
     */
    public int[][] getMatrix(){
        return matrix;
    }

    /**
     * Access to NumberOfAirports
     * @return numberOfAirports
     */
    public int getNumberOfAirports() {
        return numberOfAirports;
    }

    /** Access to startPoint
     * @return startPoint
     */
    public Character getStartPoint() {
        return startPoint;
    }

}