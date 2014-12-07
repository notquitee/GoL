package projekt.omps;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlanszaTest extends junit.framework.TestCase {
    Plansza plansza1;

    public PlanszaTest() {}

    protected void setUp(){
        plansza1 = new Plansza();
    }

    protected void tearDown(){}


    @Test
    public void testChangeCellValue() throws Exception {
        plansza1.changeCellValue(2,2);
        assertTrue(plansza1.getCellValue(2,2));
        plansza1.changeCellValue(2,2);
        assertFalse(plansza1.getCellValue(2,2));
    }

    @Test
    public void testCountNeighbours() throws Exception {
        plansza1.changeCellValue(3,3);
        plansza1.changeCellValue(3,4);
        plansza1.changeCellValue(4,4);
        assertTrue(plansza1.countNeighbours(4,3) == 3);

        plansza1.changeCellValue(8,10);
        plansza1.changeCellValue(8,9);
        plansza1.changeCellValue(7,9);
        assertTrue(plansza1.countNeighbours(8,10) == 2);

    }

    @Test
    public void testGetCellValue() throws Exception {
        assertFalse(plansza1.getCellValue(4,5));
    }

    @Test
    public void testGetTablica() throws Exception {
        boolean[][] tablica1 = new boolean[9][11];
        for (int i=0; i<tablica1.length; i++) {
            for (int j = 0; j < tablica1[i].length; j++) {
                tablica1[i][j] = false;
            }
        }
        assertTrue(Arrays.deepEquals(tablica1,plansza1.getTablica()));
    }

    @Test
    public void testSetTablica() throws Exception {
        boolean[][] tablica1 = new boolean[9][11];
        for (int i=0; i<tablica1.length; i++) {
            for (int j = 0; j < tablica1[i].length; j++) {
                tablica1[i][j] = false;
            }
        }
        tablica1[2][3] = true;
        plansza1.setTablica(tablica1);
        assertTrue(plansza1.getTablica()[2][3]);
    }
}