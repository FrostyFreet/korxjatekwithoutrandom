import java.util.Scanner;

public class kiir {
    public void kiiras(String[][] kocka) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + kocka[i][j]);
            }
            System.out.println();
        }
    }

    public void ellenorzesek(String [][] kocka, boolean player1, boolean nyert, boolean hibask1, boolean hibask2, boolean foglalt) {
        int teli=0,kor1=0,kor2=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Üdvözöllek a Kör-X játékunkban!");
        kiir kiobj = new kiir();
        //sortörés
        System.out.println();

        //Oldal választás

        System.out.println("A körrel vagy X-szel szeretnél lenni? Nyomj 0-át ha a körrel és 1-est ha az X-szel");

        int oldalvalasztas = sc.nextInt();
        while (oldalvalasztas != 1) {
            if (oldalvalasztas > 1) {
                System.out.println("Rossz érték kérem válasszon a 0 és 1 érték között!");
                oldalvalasztas = sc.nextInt();
            }
            if (oldalvalasztas == 0) {

                System.out.println("Ön a kört választotta!");
                player1 = false;
                break;
            }

        }
        if (oldalvalasztas == 1) {

            System.out.println("Ön az X-et választotta!");
            player1 = true;
        }

        //sortörés
        System.out.println("\n");
        if (player1) {
            System.out.println("Az X kezd!\n");
        } else {
            System.out.println("A kör kezd!\n");
        }
        while (!nyert)
        {
            while (foglalt) {
                while (hibask1) {
                    System.out.println("Kérem a sor kordinátáját 0 és 2 között: ");
                    kor1 = sc.nextInt();
                    if (kor1 < 3) {
                        hibask1 = false;
                    } else System.out.println("Rossz érték!!!! \nKérem válasszon a 0 és 2 érték között!");
                }
                while (hibask2) {
                    System.out.println("Kérem az oszlop kordinátáját 0 és 2 között: ");
                    kor2 = sc.nextInt();
                    if (kor2 < 3) {
                        hibask2 = false;
                    } else System.out.println("Rossz érték!!!! \nKérem válasszon a 0 és 2 érték között!");
                }
                if (kocka[kor1][kor2] == "-") {
                    foglalt = false;
                } else {
                    foglalt = true;
                    System.out.println("Foglalt kordináta válasz másikat!");
                    hibask1=true;hibask2=true;
                }
            }
            hibask1=true;hibask2=true;foglalt = true;
            if (player1){
                kocka[kor1][kor2] = "x";
            }
            else{
                kocka[kor1][kor2] = "o";
            }
            if (player1){
                player1=false;
            }
            else {
                player1=true;
            }
            kiobj.kiiras(kocka);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (kocka[i][j] == "-") {
                        teli=1 ;
                        break;
                    }
                }
            }
            if(teli==0)
            {
                nyert=true;
            }



            //győztes ellenörzés

            if (kocka[0][0] != "-" && kocka[0][1] != "-" && kocka[0][2] != "-" &&
                    kocka[1][0] != "-" && kocka[1][1] != "-" && kocka[1][2] != "-" &&
                    kocka[2][0] != "-" && kocka[2][1] != "-" && kocka[2][2] != "-") {
                nyert = false;
            }


            //sorok ellenörzése X után
            if (kocka[0][0] == "x" && kocka[0][0] == kocka[0][1] && kocka[0][1] == kocka[0][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            if (kocka[1][0] == "x" && kocka[1][0] == kocka[1][1] && kocka[1][1] == kocka[1][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            if (kocka[2][0] == "x" && kocka[2][0] == kocka[2][1] && kocka[2][1] == kocka[2][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            //keresztek ellenörzése X után
            if (kocka[0][0] == "x" && kocka[0][0] == kocka[1][1] && kocka[1][1] == kocka[2][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            if (kocka[2][0] == "x" && kocka[2][0] == kocka[1][1] && kocka[1][1] == kocka[0][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            //függőleges ellenörzés X
            if (kocka[0][0] == "x" && kocka[0][0] == kocka[1][0] && kocka[1][0] == kocka[2][0]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            if (kocka[0][1] == "x" && kocka[0][1] == kocka[1][1] && kocka[1][1] == kocka[2][1]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }
            if (kocka[0][2] == "x" && kocka[0][2] == kocka[1][2] && kocka[1][2] == kocka[2][2]) {
                nyert = true;
                System.out.println("Az X nyert!");
            }

            //sorok ellenörzése o után
            if (kocka[0][0] == "o" && kocka[0][0] == kocka[0][1] && kocka[0][1] == kocka[0][2]) {
                nyert = true;
                System.out.println("A kör nyert!");
            }
            if (kocka[1][0] == "o" && kocka[1][0] == kocka[1][1] && kocka[1][1] == kocka[1][2]) {
                nyert = true;
                System.out.println("A kör nyert!");
            }
            if (kocka[2][0] == "o" && kocka[2][0] == kocka[2][1] && kocka[2][1] == kocka[2][2]) {
                nyert = true;
                System.out.println("A kör nyert!");
            }
            //keresztek ellenörzése o után
            if (kocka[0][0] == "o" && kocka[0][0] == kocka[1][1] && kocka[1][1] == kocka[2][2]) {
                nyert = true;
                System.out.println("A kör nyert!");
            }
            if (kocka[2][0] == "o" && kocka[2][0] == kocka[1][1] && kocka[1][1] == kocka[0][2]) {
                nyert = true;
                System.out.println("A kör nyert!");
            }
            //függőleges ellenörzés O
            if (kocka[0][0] == "o" && kocka[0][0] == kocka[1][0] && kocka[1][0] == kocka[2][0]) {
                nyert = true;
                System.out.println("Az O nyert!");
            }
            if (kocka[0][1] == "o" && kocka[0][1] == kocka[1][1] && kocka[1][1] == kocka[2][1]) {
                nyert = true;
                System.out.println("Az O nyert!");
            }
            if (kocka[0][2] == "o" && kocka[0][2] == kocka[1][2] && kocka[1][2] == kocka[2][2]) {
                nyert = true;
                System.out.println("Az O nyert!");
            }
            teli=0;

            if (!nyert){
                if(player1)System.out.println("Az x következik!");
                else System.out.println("A kör következik!");
            }
        }
    }
}

