/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author joaomheusi
 */
public class TrabalhoM1 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)  {
        CVSReader tentar = new CVSReader();
        //tentar.lerCVS();
        DashboardController dash = new DashboardController();
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, dash);
    }
    
}
