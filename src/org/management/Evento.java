package org.management;


import org.management.exceptions.CifraNonValida;
import org.management.exceptions.DataEventoInvalidaException;
import org.management.exceptions.IllegalArgumentExceptionDato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {

    //ATTRIBUTI

    private String titolo;
    private LocalDate data;
    private int nTotali;
    private int nPrenotati = 0;

    //COSTRUTTORI

    public Evento(String titolo, LocalDate data, int nTotali) throws DataEventoInvalidaException, IllegalArgumentExceptionDato {
        this.titolo = titolo;
        this.data = validaData(data);
        this.nTotali = nTotaliPositivi(nTotali);
        this.nPrenotati = nPrenotati;

    }


    //METODI

    private LocalDate validaData(LocalDate data)  throws DataEventoInvalidaException {
        if (data == null ||data.isBefore(LocalDate.now())){
            throw new DataEventoInvalidaException("Impossibile impostare una data in passato.");
        }
        return data;
    }

    private int nTotaliPositivi(int nTotali) throws IllegalArgumentExceptionDato{
        if (nTotali <= 0){
            throw new IllegalArgumentExceptionDato("Il numero deve essere maggiore di 0: "+ nTotali);
        }
        return nTotali;
    };

//    public int prenota(int nPrenotazione){
//        if(data.isAfter(LocalDate.now()) || nTotali < nPrenotati){
//            System.out.println("Stai sbagliando qualcosa");
//        }
//        if(nPrenotazione < nTotali && nPrenotati < nTotali){
//            nTotali = nTotali - nPrenotazione;
//            nPrenotati = nPrenotati+ nPrenotazione;
//        }
//        return nPrenotazione;
//    };
//
//    public int disdici(int nPrenotazione){
//        if(data.isAfter(LocalDate.now()) || nTotali < nPrenotati){
//            System.out.println("Stai sbagliando qualcosa");
//        }
//        if(nPrenotazione < nTotali && nPrenotati < nTotali){
//            nTotali = nTotali + nPrenotazione;
//            nPrenotati = nPrenotati - nPrenotazione;
//        }
//        return nPrenotazione;
//
//    }

    public int prenota(int nPrenotazione) throws CifraNonValida {

        nTotali = nTotali - nPrenotazione;
        nPrenotati = nPrenotati+ nPrenotazione;

        if (nTotali < nPrenotati) {
            throw new CifraNonValida("Posti esauriti per la data selezionata.");
        }
        return nPrenotazione;

    }

    public int disdici(int nPrenotazione) throws CifraNonValida {
        nTotali = nTotali + nPrenotazione;
        nPrenotati = nPrenotati - nPrenotazione;

        if (nPrenotati == 0) {
            throw new CifraNonValida("Nessuna prenotazione da disdire per la data selezionata.");
        }
        return nPrenotazione;

    }

    @Override
    public String toString() {
        return "titolo='" + titolo + '\'' + ", data=" + data ;
    }

    //GETTER

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getnTotali() {
        return nTotali;
    }

    public int getnPrenotati() {
        return nPrenotati;
    }

    //SETTER

    public void setTitolo(String titolo) {
           this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }




}
