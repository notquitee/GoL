package projekt.omps;
import java.lang.*;

/**
 * Created by student18 on 2014-11-13.
 */
public class Game {
    private Plansza gra;
    private boolean[][] nextStep = new boolean[9][11];
    public Counter stepCounter;
    public Game(){
        gra = new Plansza();
        stepCounter = new Counter();
        for (int i=0; i< nextStep.length; i++) {
            for (int j = 0; j < nextStep[i].length; j++) {
                nextStep[i][j] = false;
            }
        }
    }
    private void evaluateNextStep(){
        for (int i=0; i< gra.getTablica().length; i++) {
            for (int j = 0; j < gra.getTablica()[i].length; j++) {
                if (gra.countNeighbours(i,j)<2 || gra.countNeighbours(i,j)>3)
                    nextStep[i][j] = false;
                else if (gra.countNeighbours(i,j)==3 )
                    nextStep[i][j] = true;
                else if (gra.countNeighbours(i,j)==2)
                    nextStep[i][j]=gra.getCellValue(i,j);
            }
        }
    }
    public void step(int steps){
        for (int i=0; i<steps; i++){
            evaluateNextStep();
            gra.setTablica(nextStep);
            stepCounter.increment();
            gra.display();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void changeCellValue(int i, int j){
        this.gra.changeCellValue(i,j);
    }
    public void display() {this.gra.display();}
}
