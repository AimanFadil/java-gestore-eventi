package org.management;

import org.management.exceptions.DataEventoInvalidaException;
import org.management.exceptions.IllegalArgumentExceptionDato;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public class Concerto extends Evento{

    //ATTRIBUTI
    private LocalTime ora;
    private BigDecimal prezzo;



    //COSTRUTTORI

    public Concerto(String titolo, LocalDate data, int nTotali, BigDecimal prezzo) throws DataEventoInvalidaException, IllegalArgumentExceptionDato {
        super(titolo, data, nTotali);
        this.ora = LocalTime.now();
        this.prezzo = prezzo;
    }




    //METODI


    @Override
    public String toString() {
        return "Concerto{" +
                "ora=" + ora +
                ", prezzo=" + prezzo +
                '}';
    }

    //GETTER
    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    //SETTER

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }
    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }
}
