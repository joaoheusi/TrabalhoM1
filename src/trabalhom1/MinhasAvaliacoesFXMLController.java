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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author joaomheusi
 */
public class MinhasAvaliacoesFXMLController extends InterfaceUsuario {

    public MinhasAvaliacoesFXMLController() {
        super("MinhasAvaliacoesFXML.fxml");
    }
   
    @FXML private TableView<Avaliacao> table;
    @FXML private TableColumn tableNome;
    @FXML private TableColumn tableDisciplina;
    @FXML private TableColumn tableMedia;
    @FXML private TableColumn tablePeso;
    @FXML private TableColumn tableNota;

  
   public void loadTable(){
       
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Avaliacao> data = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());
        table.setItems(data);
        tableNome.setCellValueFactory(new PropertyValueFactory<Avaliacao,String>("nome"));
        tableDisciplina.setCellValueFactory(new PropertyValueFactory<Avaliacao,String>("disciplina"));
        tableMedia.setCellValueFactory(new PropertyValueFactory<Avaliacao,String>("mediaAsString"));
        tablePeso.setCellValueFactory(new PropertyValueFactory<Avaliacao,Double>("peso"));
        tableNota.setCellValueFactory(new PropertyValueFactory<Avaliacao,Double>("nota"));
    }    
    @FXML
    public void adicionarA(ActionEvent evento){
        AdicionarAvaliacaoFXMLController adicionarAvaliacao = new AdicionarAvaliacaoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(adicionarAvaliacao);
    }
    
    @FXML
    public void adicionarN(ActionEvent evento){
        if(table.getItems().isEmpty() == true){
                Alert erroDialogo = new Alert(Alert.AlertType.ERROR);
                erroDialogo.setTitle("Erro");
                erroDialogo.setHeaderText("Tabela vazia.");
                erroDialogo.setContentText("É necessario uma avaliação para adicionar uma nota.");
                erroDialogo.showAndWait();
        } else {
            try{
            AdicionarNotaFXMLController adicionarNota = new AdicionarNotaFXMLController();
            GerenciadorJanela.setIndexNo(table.getSelectionModel().getSelectedItem().getIndexNo());
            GerenciadorJanela.obterInstancia().abreJanela(adicionarNota);}
            catch(Exception e){
                Alert erroDialogo = new Alert(Alert.AlertType.ERROR);
                erroDialogo.setTitle("Erro");
                erroDialogo.setHeaderText("Não selecionou uma Avaliacão.");
                erroDialogo.setContentText("É necessario selecionar uma avaliação.");
                erroDialogo.showAndWait();
            }
        }
        
 
    }
    
    @FXML
    public void voltarDash(ActionEvent evento){
        GerenciadorJanela.obterInstancia().obterInstancia().abreJanela(new DashboardController());
        GerenciadorJanela.limpaPilha();
    }
}
