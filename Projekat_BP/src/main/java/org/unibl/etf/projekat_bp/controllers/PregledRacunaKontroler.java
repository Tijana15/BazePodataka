package org.unibl.etf.projekat_bp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.unibl.etf.projekat_bp.dao.RacunStavkeViewDAO;
import org.unibl.etf.projekat_bp.entity.RacunStavkeView;
import org.unibl.etf.projekat_bp.impl.RacunStavkeViewDAOImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PregledRacunaKontroler {
    @FXML
    private DatePicker datePicker;
    @FXML
    private Accordion accordion;

    @FXML
    void onDatePicker(MouseEvent event) {
        LocalDate selectedDate = datePicker.getValue();
        String datum;
        datum = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        RacunStavkeViewDAO racunStavkeViewDAO = new RacunStavkeViewDAOImpl();
        List<RacunStavkeView> listaRacuna = racunStavkeViewDAO.selectByDatum(datum);

        accordion.getPanes().clear();

        // Dodatna struktura za praćenje već prikazanih računa
        Set<Integer> prikazaniRacuni = new HashSet<>();

        for (RacunStavkeView racun : listaRacuna) {
            // Provjeravam je li račun već prikazan
            if (prikazaniRacuni.contains(racun.getIdRačun())) {
                continue; // Preskačem ovaj račun ako je već prikazan
            }

            TitledPane titledPane = new TitledPane();
            titledPane.setText(String.format("ID računa: %d  |  ID naloga: %d  |  Iznos: %.2f", racun.getIdRačun(), racun.getNALOG_IdNaloga(), racun.getIznos()));

            ListView<String> stavkeListView = new ListView<>();
            List<RacunStavkeView> stavkeRacuna = racunStavkeViewDAO.selectByRacunId(racun.getIdRačun());
            for (RacunStavkeView stavka : stavkeRacuna) {
                String stavkaInfo = String.format("Proizvod: %s  |  Količina: %d  |  Cijena: %.2f", stavka.getNazivProizvoda(), stavka.getKoličina(), stavka.getCijenaProdajna());
                stavkeListView.getItems().add(stavkaInfo);
            }
            titledPane.setContent(stavkeListView);
            accordion.getPanes().add(titledPane);

            prikazaniRacuni.add(racun.getIdRačun());
        }
    }

}
