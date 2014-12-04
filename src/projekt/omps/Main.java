package projekt.omps;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game gameOfLife;
        gameOfLife = new Game();
        gameOfLife.display();
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
            gameOfLife.changeCellValue(row,col);
            gameOfLife.display();
        }
        //gameOfLife.changeCellValue(3,5);
        //gameOfLife.changeCellValue(4,4);
        //gameOfLife.changeCellValue(4,5);
        //gameOfLife.changeCellValue(4,6);
        //gameOfLife.changeCellValue(5,5);
        gameOfLife.display();
        int steps=0;
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
