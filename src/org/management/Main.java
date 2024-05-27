package org.management;

import org.management.exceptions.DataEventoInvalidaException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean prosegui = true;

        ArrayList<Evento> eventi = new ArrayList<>();


        System.out.println("Inserisci il tuo evento");

        try{
            System.out.print("Titolo Evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Data Evento (yyyy-mm-dd): ");
            LocalDate data = LocalDate.parse(scanner.nextLine());

            System.out.print("Posti Totali: ");
            int nTotali = scanner.nextInt();


            Evento evento = new Evento(titolo, data, nTotali);
            eventi.add(evento);

            System.out.println(evento.toString());

            while(prosegui) {
                System.out.println("Clicca 1:(Prenota) - 2:(Disdici) - 3:(ESCI) ");

                int sceltaUtente;

                sceltaUtente = scanner.nextInt();

                if (sceltaUtente == 1) {
                    System.out.print("Prenota posti per l'evento: ");
                    int nPrenotazione = scanner.nextInt();
                    evento.prenota(nPrenotazione);
                    System.out.println(evento.toString());
                } else if (sceltaUtente == 2) {
                    System.out.print("Disdici posti per l'evento: ");
                    int nPrenotazione = scanner.nextInt();
                    evento.disdici(nPrenotazione);
                    System.out.println(evento.toString());
                } else if (sceltaUtente == 3) {
                    prosegui = false;
                }
            }
        } catch (DataEventoInvalidaException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
        }catch (DateTimeParseException e){
            System.out.println("Formato data non valido");
        }


    }
}
