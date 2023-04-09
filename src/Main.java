public class Main {
    public static void main(String[] args) {
        boolean player1 = true,nyert = false, hibask2 = true, hibask1 = true,foglalt=true;

        //2d tömb létrehozássa(maga az alap)
        String[][] kocka = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        //
        kiir kiobj = new kiir();

        kiobj.ellenorzesek(kocka,player1,nyert,hibask1,hibask2,foglalt);

    }
}









