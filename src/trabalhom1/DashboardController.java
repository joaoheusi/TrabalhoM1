/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author joaomheusi
 */
public class DashboardController extends InterfaceUsuario {

    public DashboardController() {
        super("Dashboard.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void irParaMa(ActionEvent evento){
        MinhasAvaliacoesFXMLController minhasAvaliacoes = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(minhasAvaliacoes);
    }
    
    @FXML
    public void irParaDesempenho(ActionEvent evento){
        MeuDesemprenhoFXMLController meuDesempenho = new MeuDesemprenhoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(meuDesempenho);
    }
}
