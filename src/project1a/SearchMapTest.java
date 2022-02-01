package src.project1a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Vector;

class SearchMapTest {

    @Test
    void testDFS() {
        FlightMap m = new FlightMap("input.txt");
        SearchMap s = new SearchMap(m);
        m.readFileHelper();
        s.dfs();

        List<Character> visitedTest = new Vector<>();
        visitedTest.add('P');
        visitedTest.add('W');
        visitedTest.add('S');
        visitedTest.add('T');
        visitedTest.add('Y');
        visitedTest.add('R');
        visitedTest.add('X');
        visitedTest.add('Z');

        Assertions.assertEquals(s.getVisited().size(), visitedTest.size(), "Visited vector of input.txt");

    }

}
