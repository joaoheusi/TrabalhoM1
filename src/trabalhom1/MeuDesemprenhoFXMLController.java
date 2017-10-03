/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.chart.XYChart;

import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author joaomheusi
 */
public class MeuDesemprenhoFXMLController extends InterfaceUsuario {

    public MeuDesemprenhoFXMLController() {
        super("MeuDesemprenhoFXML.fxml");
    }
    @FXML
    private BarChart<String, Double> bCMedias;
    @FXML
    private ChoiceBox<String> cBDisciplinas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        avaliacoes = Avaliacao.obterListaAvaliacoes();
        ObservableList<String> disciplinas = FXCollections.observableArrayList();
        for (int i = 0; i < avaliacoes.size(); i++) {
            if (!disciplinas.contains(avaliacoes.get(i).getDisciplina())) {
                disciplinas.add(avaliacoes.get(i).getDisciplina());
                // System.out.println(avaliacoes.get(i).getDisciplina());
            }
        }
        cBDisciplinas.setItems(disciplinas);
    }

    @FXML
    public void carregarMateria(ActionEvent evento) {
        String disNome = (String) cBDisciplinas.getSelectionModel().getSelectedItem();
        Avaliacao a = new Avaliacao();
        double notaM1 = a.calculaMediaDisciplina(disNome, "M1");
        double notaM2 = a.calculaMediaDisciplina(disNome, "M2");
        double notaM3 = a.calculaMediaDisciplina(disNome, "M3");
        double notaMF = (notaM1 + notaM2 + notaM3) / 3;
        XYChart.Series medias = new XYChart.Series<>();

        if (notaM1 != 0) {
        medias.setName(disNome);
        XYChart.Data valor = new XYChart.Data<>("M1", notaM1);
        medias.getData().add(valor);
         }
         if (notaM2 != 0) {
        medias.setName(disNome);
        XYChart.Data valor = new XYChart.Data<>("M2", notaM2);
        medias.getData().add(valor);
         }
         if (notaM3 != 0) {
        medias.setName(disNome);
        XYChart.Data valor = new XYChart.Data<>("M3", notaM3);
        medias.getData().add(valor);
         }
         if (notaMF != 0 && notaM1 != 0&&notaM2 != 0 &&notaM3 != 0) {
        medias.setName(disNome);
        XYChart.Data valor = new XYChart.Data<>("MF", notaMF);
        medias.getData().add(valor);

          }
        bCMedias.getData().addAll(medias);

    }

    @FXML
    public void voltarDash(ActionEvent evento) {
        GerenciadorJanela.obterInstancia().voltar();
    }
}
