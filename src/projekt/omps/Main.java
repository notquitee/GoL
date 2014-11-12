package projekt.omps;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Plansza gra;
        gra = new Plansza();
        gra.display();
        System.out.println("\n");
        gra.changeFieldValue(0,9);
        gra.changeFieldValue(0,8);
        gra.changeFieldValue(1,8);
        gra.display();
        System.out.println("\n");
        System.out.println(gra.countNeighbours(0,9));
    }
}
