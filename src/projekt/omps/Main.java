package projekt.omps;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game gameOfLife;
        gameOfLife = new Game();
        gameOfLife.display();
        gameOfLife.changeCellValue(3,5);
        gameOfLife.changeCellValue(4,4);
        gameOfLife.changeCellValue(4,5);
        gameOfLife.changeCellValue(4,6);
        gameOfLife.changeCellValue(5,5);
        gameOfLife.display();
        gameOfLife.gameOn();

    }
}
