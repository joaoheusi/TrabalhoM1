/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.util.Stack;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author marcelo
 */
public class GerenciadorJanela {
    
    private static GerenciadorJanela instancia;
    private static int indexNo;
    
    private GerenciadorJanela(){
        this.pilhaRetorno = new Stack<>();
    }
    
    public static GerenciadorJanela obterInstancia(){
        if(GerenciadorJanela.instancia == null){
            GerenciadorJanela.instancia = new GerenciadorJanela();
        }
        return GerenciadorJanela.instancia;
    }
    
    private Stage palco;
    private static Stack<InterfaceUsuario> pilhaRetorno;
    private InterfaceUsuario janelaAtual;
    
    public static void limpaPilha(){
        GerenciadorJanela.pilhaRetorno.clear();
    }
    
    public void inicializaPalco(Stage p, InterfaceUsuario interfaceInicial){
        this.palco = p;
        this.janelaAtual = interfaceInicial;
        this.palco.setScene(interfaceInicial.obterCena());
        this.palco.show();
    }
    
    private Stage getPalco(){
        return this.palco;
    }
    
    public void abreJanela(InterfaceUsuario novaJanela) {
        this.pilhaRetorno.push(this.janelaAtual);
        this.getPalco().setScene(novaJanela.obterCena());
        this.janelaAtual = novaJanela;
        System.out.println(this.pilhaRetorno.size());
    }
    
    public void voltar() {
        if(!this.pilhaRetorno.empty()){
            InterfaceUsuario anterior = this.pilhaRetorno.pop();
            this.getPalco().setScene(anterior.obterCena());
            this.janelaAtual = anterior;
            anterior.retornar();
            return;
        }
        System.err.println("A pilha de retorno vazia");
    }
    
    public void voltar(int quantasTelas) {
        if(quantasTelas <= this.pilhaRetorno.size()){
            while(quantasTelas > 1){
                this.pilhaRetorno.pop();
                quantasTelas--;
            }
            InterfaceUsuario anterior = this.pilhaRetorno.pop();
            this.getPalco().setScene(anterior.obterCena());   
            this.janelaAtual = anterior;
            anterior.retornar();
            return;
        }
        System.err.println("Numero de retornos maior que o tamanho da pilha");       
    }
    
    
    public void abreEmPopup(InterfaceUsuario novaJanela){
        Stage popUp = new Stage();
        popUp.setScene(novaJanela.obterCena());
    }

    /**
     * @return the indexNo
     */
    static public int getIndexNo() {
        return indexNo;
    }

    /**
     * @param indexNo the indexNo to set
     */
    static public void  setIndexNo(int indexNo) {
        GerenciadorJanela.indexNo = indexNo;
    }
    
    
}
