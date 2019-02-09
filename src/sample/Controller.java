package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


public class Controller {

    @FXML
    private ImageView im4;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im2;

    @FXML
    private ImageView im1;

    @FXML
    private HBox h1;
    @FXML
    private ImageView im11;

    @FXML
    private ImageView im12;

    @FXML
    private ImageView im13;

    @FXML
    private ImageView im14;

    @FXML
    private HBox h2;

    @FXML
    private ImageView im21;

    @FXML
    private ImageView im22;

    @FXML
    private ImageView im23;

    @FXML
    private ImageView im24;

    @FXML
    private HBox h3;

    @FXML
    private ImageView im31;

    @FXML
    private ImageView im32;

    @FXML
    private ImageView im33;

    @FXML
    private ImageView im34;

    @FXML
    private HBox h4;

    @FXML
    private ImageView im41;

    @FXML
    private ImageView im42;

    @FXML
    private ImageView im43;

    @FXML
    private ImageView im44;

    @FXML
    private HBox h5;

    @FXML
    private ImageView im51;

    @FXML
    private ImageView im52;

    @FXML
    private ImageView im53;

    @FXML
    private ImageView im54;

    @FXML
    private ImageView im15;

    @FXML
    private ImageView im16;

    @FXML
    private ImageView im17;

    @FXML
    private ImageView im18;


    @FXML
    private ImageView im25;

    @FXML
    private ImageView im26;

    @FXML
    private ImageView im27;

    @FXML
    private ImageView im28;
    @FXML
    private ImageView im35;

    @FXML
    private ImageView im36;

    @FXML
    private ImageView im37;

    @FXML
    private ImageView im38;

    @FXML
    private ImageView im45;

    @FXML
    private ImageView im46;

    @FXML
    private ImageView im47;

    @FXML
    private ImageView im48;

    @FXML
    private ImageView im55;

    @FXML
    private ImageView im56;

    @FXML
    private ImageView im57;

    @FXML
    private ImageView im58;

    private boolean czyStart = false;
    private boolean klikniecie = false;
    private int licznik = 0;
    private ImageView[] kulki = new ImageView[24];
    private ImageView[] kulki_wynik = new ImageView[20];
    private HBox[] boxy = new HBox[5];

    Image[] tablicaKolorow = new Image[8];

    Image image1 = new Image("pomaranczowy.png");
    Image image2 = new Image("fioletowy.png");
    Image image3 = new Image("niebieski.png");
    Image image4 = new Image("rozowy.png");
    Image image5 = new Image("zielony.png");
    Image image6 = new Image("czerwony.png");
    Image sprawdzaczC = new Image("czarny.png");
    Image sprawdzaczB = new Image("biały.png");

    public  void initialize(){
        tablicaKolorow[0] = image1;
        tablicaKolorow[1] = image2;
        tablicaKolorow[2] = image3;
        tablicaKolorow[3] = image4;
        tablicaKolorow[4] = image5;
        tablicaKolorow[5] = image6;
        tablicaKolorow[6] = sprawdzaczC;
        tablicaKolorow[7] = sprawdzaczB;
        kulki[0] = im1;
        kulki[1] = im2;
        kulki[2] = im3;
        kulki[3] = im4;
        kulki[4] = im11;
        kulki[5] = im12;
        kulki[6] = im13;
        kulki[7] = im14;
        kulki[8] = im21;
        kulki[9] = im22;
        kulki[10] = im23;
        kulki[11] = im24;
        kulki[12] = im31;
        kulki[13] = im32;
        kulki[14] = im33;
        kulki[15] = im34;
        kulki[16] = im41;
        kulki[17] = im42;
        kulki[18] = im43;
        kulki[19] = im44;
        kulki[20] = im51;
        kulki[21] = im52;
        kulki[22] = im53;
        kulki[23] = im54;
        kulki_wynik[0] = im16;
        kulki_wynik[1] = im15;
        kulki_wynik[2] = im18;
        kulki_wynik[3] = im17;
        kulki_wynik[4] = im28;
        kulki_wynik[5] = im27;
        kulki_wynik[6] = im26;
        kulki_wynik[7] = im25;
        kulki_wynik[8] = im38;
        kulki_wynik[9] = im37;
        kulki_wynik[10] = im35;
        kulki_wynik[11] = im36;
        kulki_wynik[12] = im46;
        kulki_wynik[13] = im48;
        kulki_wynik[14] = im45;
        kulki_wynik[15] = im47;
        kulki_wynik[16] = im57;
        kulki_wynik[17] = im55;
        kulki_wynik[18] = im58;
        kulki_wynik[19] = im56;
        boxy[0] = h1;
        boxy[1] = h2;
        boxy[2] = h3;
        boxy[3] = h4;
        boxy[4] = h5;
        im1.setImage(image6);
        im2.setImage(image1);
        im3.setImage(image3);
        im4.setImage(image4);
    }



    @FXML
    void btnNowaGraPressed(ActionEvent event) {
        czyStart = false;

        for (int i = 0; i < boxy.length; i++) {
            boxy[i].setVisible(false);
        }

        for (int i = 0; i < kulki_wynik.length; i++) {
            kulki_wynik[i].setVisible(false);
        }
    }


    @FXML
    void btnStartPressed(ActionEvent event) {
        czyStart = true;
        Obliczenia obliczenia = new Obliczenia();
        String proby[];
        String wyniki[];
        String proba;
        String wynik;
        int iterator = 4;
        int iterator2 = 0;
        int kolor = 0;
        String kod = "";

        //odczytywanie kodu podanego przez uzytkownika i ustawienie kulek
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (kulki[i].getImage().toString().equals(tablicaKolorow[j].toString())) {
                    kod = kod + (j + 1);
                }
            }
        }

        wyniki = obliczenia.getwyniki(kod);
        proby = obliczenia.obliczanieStart(kod);

        int licznik = 0;
        while (proby[licznik] != null) {
            // wyswietlanie ilosci prob
            boxy[licznik].setVisible(true);
            wynik = wyniki[licznik];
            // integer(1) == char(1+48)
            // zamiana char na integer nastepuje poprzez kod ASCII, zeby dostac liczbe ktora sie chce
//            trzeba odjac 48, tzn. 1=49, 2=50, 3=51, 4=52, 5=53


            // wyswietlanie odpowiedniego koloru dla danej liczby
            proba = proby[licznik];
            kulki[iterator].setImage(tablicaKolorow[proba.charAt(0) - 49]);
            iterator += 1;
            kulki[iterator].setImage(tablicaKolorow[proba.charAt(1) - 49]);
            iterator += 1;
            kulki[iterator].setImage(tablicaKolorow[proba.charAt(2) - 49]);
            iterator += 1;
            kulki[iterator].setImage(tablicaKolorow[proba.charAt(3) - 49]);
            iterator += 1;


            // wyswietlanie odpowiedniego koloru dla sprawdzacza (bialy/czarny)
            if (wynik != null) {
                if (wynik.charAt(0) - 48 == 1) {

                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[7]);
                } else if (wynik.charAt(0) - 48 == 2) {

                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                }
                iterator2 += 1;
                if (wynik.charAt(1) - 48 == 1) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[7]);
                } else if (wynik.charAt(1) - 48 == 2) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                }
                iterator2 += 1;
                if (wynik.charAt(2) - 48 == 1) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[7]);
                } else if (wynik.charAt(2) - 48 == 2) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                }
                iterator2 += 1;
                if (wynik.charAt(3) - 48 == 1) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[7]);
                } else if (wynik.charAt(3) - 48 == 2) {
                    kulki_wynik[iterator2].setVisible(true);
                    kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                }
                iterator2 += 1;


            } else {
                kulki_wynik[iterator2].setVisible(true);
                kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                iterator2 += 1;
                kulki_wynik[iterator2].setVisible(true);
                kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                iterator2 += 1;
                kulki_wynik[iterator2].setVisible(true);
                kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                iterator2 += 1;
                kulki_wynik[iterator2].setVisible(true);
                kulki_wynik[iterator2].setImage(tablicaKolorow[6]);
                iterator2 += 1;
            }
            licznik += 1;
        }

    }


    @FXML
    void im1Clicked(MouseEvent event) {
        if (czyStart == false) {
            licznik++;
            while (im2.getImage().equals(tablicaKolorow[licznik]) || im3.getImage().equals(tablicaKolorow[licznik]) || im4.getImage().equals(tablicaKolorow[licznik])) {

                licznik++;
                if (licznik > 5) licznik = 0;
            }
            im1.setImage(tablicaKolorow[licznik]);
            if (licznik >= 5) licznik = 0;

        }
    }

    @FXML
    void im2Clicked(MouseEvent event) {
        if (czyStart == false) {
            licznik++;
            while (im1.getImage().equals(tablicaKolorow[licznik]) || im4.getImage().equals(tablicaKolorow[licznik]) || im3.getImage().equals(tablicaKolorow[licznik])) {
                licznik++;
                if (licznik > 5) licznik = 0;
            }
            im2.setImage(tablicaKolorow[licznik]);
            if (licznik >= 5) licznik = 0;
        }
    }

    @FXML
    void im3Clicked(MouseEvent event) {
        if (czyStart == false) {
            licznik++;
            while (im4.getImage().equals(tablicaKolorow[licznik]) || im2.getImage().equals(tablicaKolorow[licznik]) || im1.getImage().equals(tablicaKolorow[licznik])) {
                licznik++;
                if (licznik > 5) licznik = 0;
            }
            im3.setImage(tablicaKolorow[licznik]);
            if (licznik >= 5) licznik = 0;

        }
    }


    @FXML
    void im4Clicked(MouseEvent event) {
        if (czyStart == false) {
            licznik++;
            while (im1.getImage().equals(tablicaKolorow[licznik]) || im3.getImage().equals(tablicaKolorow[licznik]) || im2.getImage().equals(tablicaKolorow[licznik])) {
                licznik++;
                if (licznik >= 5) licznik = 0;
            }
            im4.setImage(tablicaKolorow[licznik]);
            if (licznik >= 5) licznik = 0;
        }
    }


}

