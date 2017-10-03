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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joaomheusi
 */
public class AdicionarAvaliacaoFXMLController extends InterfaceUsuario {

    public AdicionarAvaliacaoFXMLController() {
        super("AdicionarAvaliacaoFXML.fxml");
    }
    Avaliacao avCriada = new Avaliacao();
    @FXML private ChoiceBox cbDisciplina;
    @FXML
    private ChoiceBox cbMedia;
    @FXML
    private TextField nomeAv;
    @FXML
    private TextField pesoAv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMedia.getItems().addAll("M1", "M2", "M3");
        cbDisciplina.getItems().addAll("Ética em Informática", "Introdução à Física", "Introdução ao Calculo"
        ,"Matemática Computacional","Algoritmos e Programação I","Álgebra","Iniciação Técnico-Cientifica"
        ,"Introdução a engenharia de computação","Cálculo I","Algorítmos e Programação II","Circuitos Digitais"
        ,"Desenho Técnico","Física Geral","Álgebra II","Cálculo II"
        ,"Estruturas de Dados","Programação Orientada a Objetos I","Arquitetura de Computadores I","Física"
        ,"Química I","Arquitetura de Computadores II","Programação Orientada a Objetos II","Cálculo III"
        ,"Análise de Circuitos Elétricos","Química II","Ótica e Física para semicondutores","Resistencia dos Materiais"
        ,"Banco de Dados","Sistemas Operacionais","Matemática aplicada à Engenharia","Engenharia de Software"
        ,"Probabilidade e Estatística","Eletrônica Básica","Interface Humano-Computador","Engenharia de Software II"
        ,"Redes de Computadores","Cálculo Numerico","Linguagens Formais","Eletrônica Aplicada"
        ,"Análise e Controle de Processos","Engenharia Econômica","Redes de Computadores II","Grafos"
        ,"Controle Lógico de Sistemas","Microcontroladores","Projeto de Sistemas Digitais","Inteligencia Artificial"
        ,"Trabalho Téc.-Científ de Conclusão de Curso","Projeto de Sistemas Embarcados","Sistemas em tempo real","Comunicação Digital"
        ,"Processador Digital de Sinais","Sistemas Robóticos","Simulação Discreta","Gerência de Projetos"
        ,"Tópicos Especiais em Engenharia de Computação","Tópicos Especias em Hardware","Trabalho Téc-Científ de Conclusão de Curso II"
        ,"Administração de Negócios de base Tecnológica","Tópicos Especiais em Integração Software Hardware","Trabalho Téc-Científ de Conclusão de Curso III","Sistemas Distribuídos");
    }
    @FXML
    public void voltar(ActionEvent evento){
         GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void salvarAdicionarA(ActionEvent evento) {
        Avaliacao novaAvaliacao = new Avaliacao();
        CVSReader tentar = new CVSReader();
        String tempAdd = new String();
        try {
            novaAvaliacao.setDisciplina(String.valueOf(cbDisciplina.getSelectionModel().getSelectedItem()));
            String s = String.valueOf(cbMedia.getSelectionModel().getSelectedItem());
            char[] c = s.toCharArray();
            novaAvaliacao.setMedia(c);
            novaAvaliacao.setNome(nomeAv.getText());
            novaAvaliacao.setPeso(Double.parseDouble(pesoAv.getText()));
           // novaAvaliacao.setNota(0);

        } catch (Exception e) {
               
        }
        if(cbDisciplina.getSelectionModel().getSelectedItem() != null && cbMedia.getSelectionModel().getSelectedItem() != null && nomeAv.getText()!= null && pesoAv.getText()!= null){
        novaAvaliacao.salvar();
        GerenciadorJanela.obterInstancia().abreJanela(new MinhasAvaliacoesFXMLController());
        }else {
                Alert erroDialogo = new Alert(Alert.AlertType.ERROR);
                erroDialogo.setTitle("Erro");
                erroDialogo.setHeaderText("Dados Incompátiveis");
                erroDialogo.setContentText("Verifique se eles estão corretos.");
                erroDialogo.showAndWait();
        }
        

    }
}
