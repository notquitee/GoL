package projekt.omps;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        Game gameOfLife;
        gameOfLife = new Game();
        gameOfLife.display();
        gameOfLife.markCells();
        gameOfLife.display();
        int steps=0;
        String line = null;
        System.out.println("Ile krokow wykonac?");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            line = is.readLine();
            steps = Integer.parseInt(line);
        } catch (NumberFormatException ex) {
            System.err.println("Not a valid number: " + line);
        } catch (IOException e) {
            System.err.println("Unexpected IO ERROR: " + e);
        }
        gameOfLife.step(steps);



    }
}
