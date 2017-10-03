/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joaomheusi
 */
public class AdicionarNotaFXMLController extends InterfaceUsuario {

    public AdicionarNotaFXMLController() {
        super("AdicionarNotaFXML.fxml");
    }
    @FXML private Label lblNome;
    @FXML private Label lblDis;
    @FXML private Label lblMed;
    @FXML private TextField txtNota;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
        lista = Avaliacao.obterListaAvaliacoes();
        Avaliacao ref = lista.get(GerenciadorJanela.getIndexNo());
        this.lblNome.setText(ref.getNome());
        this.lblDis.setText(ref.getDisciplina());
        this.lblMed.setText(ref.getMediaAsString());
    }    
    @FXML
    public void salvarAdicionarN(ActionEvent evento){
        ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
        lista = Avaliacao.obterListaAvaliacoes();
        Avaliacao ref = lista.get(GerenciadorJanela.getIndexNo());
        ref.setNota(Double.parseDouble(txtNota.getText()));
        System.out.println(ref.getNota());
        ref.atualizar(GerenciadorJanela.getIndexNo());
        GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoesFXMLController());
    }
    @FXML
    public void voltar(ActionEvent evento){
         GerenciadorJanela.obterInstancia().voltar();
    }
}
