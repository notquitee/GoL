package projekt.omps;

/**
 * Created by not_quite on 2014-11-12.
 */
public class Plansza {
    private boolean[][] tablica = new boolean[6][10];
    public Plansza(){
        for (int i=0; i<tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = false;
            }
        }
    }
    public void changeCellValue(int i, int j){
        tablica[i][j] = !tablica[i][j];
    }
    public void display(){
        for (int i=0; i<tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                if(tablica[i][j])
                    System.out.print("x ");
                else
                    System.out.print("o ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
    public int countNeighbours(int w,int k){
        int n=0;
        for (int i=0; i<tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                if (Math.abs(w-i)<2 && Math.abs(k-j)<2 && !(w==i && k==j) && tablica[i][j])
                    n++;
            }
        }
        return n;
    }
    public boolean getCellValue(int w,int k){
        return tablica[w][k];
    }
    public boolean[][] getTablica(){
        return tablica;
    }

}