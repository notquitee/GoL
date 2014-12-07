package projekt.omps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;



public class Game {
    private Plansza gra;
    private boolean[][] nextStep = new boolean[9][11];
    public Counter stepCounter;
    public boolean stop;


    public Game(){
        gra = new Plansza();
        stop = false;
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
            this.display();
            System.out.println(stepCounter.getCount()+"\n");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void markCells(){
        String line =null;
        int row =0;
        int col =0;
        while (true) {
            System.out.println("Podaj rzad");
            try {
                BufferedReader is = new BufferedReader(
                        new InputStreamReader(System.in));
                line = is.readLine();
                row = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.err.println("Not a valid number: " + line);
                break;
            } catch (IOException e) {
                System.err.println("Unexpected IO ERROR: " + e);
                break;
            }
            System.out.println("Podaj kolumne");
            try {
                BufferedReader is = new BufferedReader(
                        new InputStreamReader(System.in));
                line = is.readLine();
                col = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.err.println("Not a valid number: " + line);
                break;
            } catch (IOException e) {
                System.err.println("Unexpected IO ERROR: " + e);
                break;
            }
            this.gra.changeCellValue(row,col);
            this.display();
        }
    }

    public void display() {
        for (int i=0; i<gra.getTablica().length; i++) {
            for (int j = 0; j < gra.getTablica()[i].length; j++) {
                if(gra.getTablica()[i][j])
                    System.out.print("x ");
                else
                    System.out.print("o ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        }
}
