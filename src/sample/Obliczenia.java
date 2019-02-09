package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Obliczenia {

    private String[] Liczby;
    static public ArrayList<String> liczbyBezPowtorzen = new ArrayList<>();

    public Obliczenia(){

        permutation("", "123456");
        Liczby = liczbyBezPowtorzen.toArray(String[]::new);

    }


    public String sprawdzenie(String proba, String kod){
        // metoda generujaca odpowiedz na zadany kod

        //

        String wynik="0000";
        // sprawdzenie czy jakas liczba z kodu znajduje sie w probie
        // jezeli liczba z kodu i z proby sa rowne wypisuje jeden
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(kod.charAt(i) == proba.charAt(j)){
                    if(i<3) {
                        wynik = wynik.substring(0, i) + '1' + wynik.substring(i + 1, 4);
                        j = 5;
                    }else{
                        wynik = wynik.substring(0, i) + '1' ;
                        j = 5;
                    }
                }
            }

        }

        // jezeli zgadza sie pozycja wypisuje 2
        for(int i=0;i<4;i++){
            if(proba.charAt(i)==kod.charAt(i)){
                if(i<3) {
                    wynik = wynik.substring(0, i) + '2' + wynik.substring(i + 1, 4);
                }else {
                    wynik = wynik.substring(0, i) + '2';
                }
            }
        }

        return wynik;
    }

    public String[] Prawdopodobne (String[] table,String proba,String wynik1){

        // metoda sprawdzajaca jakie inne kombinacje wygenerowalyby taka sama odpowiedz


        String wynik2;
        int pomoc,pomoc2;
        char[] chars1;
        char[] chars2;

        while(wynik1.contains("0")){
            pomoc = wynik1.indexOf('0');
            if(pomoc<wynik1.length()-1){
                pomoc2 = wynik1.length();
                wynik1 = wynik1.substring(0,pomoc) + wynik1.substring(pomoc+1,pomoc2);
            }else{
                wynik1 = wynik1.substring(0,pomoc);
            }
        }

        // generowanie wszystkich mozliwych odpowiedzi

        for(int i=0;i<table.length;i++){
            if(!table[i].isEmpty()) {



                wynik2 = sprawdzenie(proba, table[i]);
// Kiedy pobierze wartość do wyniku2 to w pętli while znów usuwa 0 z wyniku 2 poniewaz 0 nie daje zadnej informacji
// Np. jeżeli wynik1=1001 a wynik2=0110, to tak naprawdę te wyniki są sobie równe, ale żeby program to wiedział to usuwamy 0


                while (wynik2.contains("0")) {
                    pomoc = wynik2.indexOf('0');
                    if (pomoc < wynik2.length() - 1) {
                        pomoc2 = wynik2.length();
                        wynik2 = wynik2.substring(0, pomoc) + wynik2.substring(pomoc + 1, pomoc2);
                    } else {
                        wynik2 = wynik2.substring(0, pomoc);
                    }
                }
// sortowanie wynikow:
// Po to, żeby np. jak wynik1=21 ( po usunięciu "0") a wynik2=12 (po usunięciu "0") to program nie rozpozna tego że są równe



                chars1 = wynik2.toCharArray();
                Arrays.sort(chars1);
                wynik2 = new String(chars1);

                chars2 = wynik1.toCharArray();
                Arrays.sort(chars2);
                wynik1 = new String(chars2);


                // jezeli oba uzyskane wyniki nie sa rowne, usuwa liczbe dla ktorej uzyskalismy wynik z tablicy
                // po przejsciu calej tablicy zostaja nam tylko liczby ktore moga byc wynikiem
                if (!wynik1.equals(wynik2)) {
                    table[i] = "";
                }
            }
        }

        return table;
    }


    // metoda statyczna generujaca liste mozliwych ustawien
    private static void permutation(String prefix, String str) {

        int n = str.length();
        if (n == 2) {
            liczbyBezPowtorzen.add(prefix);
        } else
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));

    }




// wlasciwy "program", wywolanie metod i odgadywanie kodu



    public String[] obliczanieStart(String kod) {
        String wynik;
        String[] proba = new String[6];
        proba[0] = "1234";

        for(int i=0;i<6;i++) {
            wynik = sprawdzenie(proba[i], kod);

                Liczby = Prawdopodobne(Liczby, proba[i], wynik);
                for (int k = 0; k < Liczby.length; k++) {
                    if (!Liczby[k].isEmpty()) {
                        proba[i+1] = Liczby[k];
                        k = Liczby.length + 1;
                    }
                }
            if(proba[i+1].equals(kod))
                i=10;

        }
        return proba;
    }




    // metoda zwracajaca sprawdzacze , czarne i biale kropki

    public String[] getwyniki(String kod) {
        String[] wyniki = new String[6];
        String[] proba = new String[6];
        proba[0] = "1234";

        for(int i=0;i<6;i++) {
            wyniki[i] = sprawdzenie(proba[i], kod);

// generowanie mozliwych ustawien
            Liczby = Prawdopodobne(Liczby, proba[i], wyniki[i]);
            for (int k = 0; k < Liczby.length; k++) {
                if (!Liczby[k].isEmpty()) {
                    proba[i+1] = Liczby[k];
                    k = Liczby.length + 1;
                }
            }

            if(proba[i+1].equals(kod)){
                i=10;
            }
        }

        permutation("", "123456");
        Liczby = liczbyBezPowtorzen.toArray(String[]::new);
        return wyniki;
    }


    }
