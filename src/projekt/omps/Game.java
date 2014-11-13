package projekt.omps;

/**
 * Created by student18 on 2014-11-13.
 */
public class Game {
    private Plansza gra;
    private boolean[][] nextStep = new boolean[6][10];
    public Game(){
        gra = new Plansza();
        for (int i=0; i< nextStep.length; i++) {
            for (int j = 0; j < nextStep[i].length; j++) {
                nextStep[i][j] = false;
            }
        }
    }
    private void evaluateNextStep(){
        for (int i=0; i< gra.getTablica().length; i++) {
            for (int j = 0; j < gra.getTablica()[i].length; j++) {
                if (gra.countNeighbours(i,j)<2 && gra.countNeighbours(i,j)>3)
                    nextStep[i][j] = false;
                else if (gra.countNeighbours(i,j)==3 )
                    nextStep[i][j] = true;
                else
                    nextStep[i][j]=gra.getCellValue(i,j);
            }
        }
    }
}
