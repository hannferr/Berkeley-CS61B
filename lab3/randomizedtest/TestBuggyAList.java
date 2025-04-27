package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> noResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        noResizing.addLast(1);
        noResizing.addLast(2);
        noResizing.addLast(3);
        buggy.addLast(1);
        buggy.addLast(2);
        buggy.addLast(3);
        assertEquals(noResizing.size(), buggy.size());

        assertEquals(noResizing.removeLast(), buggy.removeLast());
        assertEquals(noResizing.removeLast(), buggy.removeLast());
        assertEquals(noResizing.removeLast(), buggy.removeLast());

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int lSize = L.size();
                int bSize = B.size();
                assertEquals(L.size(), B.size());
            } else if (operationNumber == 2) {
                if (L.size() > 0 && B.size() > 0) {
                    int lLast = L.getLast();
                    int bLast = B.getLast();
                    L.removeLast();
                    B.removeLast();
                    assertEquals(lLast, bLast);
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0 && B.size() > 0) {
                    int lLast = L.getLast();
                    int bLast = B.getLast();
                    assertEquals(lLast, bLast);
                }
            }
        }
    }

}
