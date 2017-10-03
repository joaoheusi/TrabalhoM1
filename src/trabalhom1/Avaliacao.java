/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joaomheusi
 */
public class Avaliacao {

    private String disciplina;
    private char media[];
    private String nome;
    private double peso;
    private double nota;
    private int indexNo;

    //CONTROLE
    private int identificadorNoArquivo;

    public void salvar() {

        String s = this.disciplina + "," + String.copyValueOf(this.media) + "," + this.nome + "," + this.peso;
        String csvFile = "/Users/joaomheusi/NetBeansProjects/TrabalhoM1/build/teste.csv";
        String line = "";
        String cvsSplitBy = ",";
        String tempData = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detAvaliacao = line.split(cvsSplitBy);
                String avDisciplina = detAvaliacao[0];
                String avMedia = detAvaliacao[1];
                String avNome = detAvaliacao[2];
                String avPeso = detAvaliacao[3];

                System.out.println(avDisciplina + "," + avMedia + "," + avNome + "," + avPeso);
                if (detAvaliacao.length > 4) {
                    String avNota = detAvaliacao[4];
                    tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "," + avNota + "\n";
                } else {
                    tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "\n";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(csvFile);
            writer.append(tempData);
            writer.append(s);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }

    }

    public void atualizar(int indexNo) {

        String s = this.disciplina + "," + String.copyValueOf(this.media) + "," + this.nome + "," + this.peso + "," + this.nota + "\n";
        String csvFile = "/Users/joaomheusi/NetBeansProjects/TrabalhoM1/build/teste.csv";
        String line = "";
        String cvsSplitBy = ",";
        String tempData = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detAvaliacao = line.split(cvsSplitBy);
                String avDisciplina = detAvaliacao[0];
                String avMedia = detAvaliacao[1];
                String avNome = detAvaliacao[2];
                String avPeso = detAvaliacao[3];
                if (i == indexNo) {
                    tempData += s;
                } else if (detAvaliacao.length > 4 ) {
                    String avNota = detAvaliacao[4];
                    tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "," + avNota + "\n";
                } else {
                    tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "\n";
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(csvFile);
            writer.append(tempData);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }

    }

    public static ArrayList<Avaliacao> obterListaAvaliacoes() {
        ArrayList<Avaliacao> listaAvaliacoes = new ArrayList();
        String csvFile = "/Users/joaomheusi/NetBeansProjects/TrabalhoM1/build/teste.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i = 0;
            while ((line = br.readLine()) != null) {
                Avaliacao avaliacaoAdd = new Avaliacao();
                //
                String[] detAvaliacao = line.split(cvsSplitBy);
                String avDisciplina = detAvaliacao[0];
                String avMedia = detAvaliacao[1];
                String avNome = detAvaliacao[2];
                String avPeso = detAvaliacao[3];

                if (detAvaliacao.length> 4){
                    String avNota = detAvaliacao[4];
                    avaliacaoAdd.setNota(Double.parseDouble(avNota));
                }
                avaliacaoAdd.setDisciplina(avDisciplina);
                avaliacaoAdd.setNome(avNome);
                avaliacaoAdd.setMedia(avMedia.toCharArray());
                avaliacaoAdd.setPeso(Double.parseDouble(avPeso));
                avaliacaoAdd.setIndexNo(i);
                
                i++;
                listaAvaliacoes.add(avaliacaoAdd);
                //System.out.println(avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + ",");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAvaliacoes;
    }

    public double calculaMediaDisciplina(String disc, String med) {
        double valorMedia = 0;
        ArrayList<Avaliacao> x = new ArrayList<Avaliacao>();
        x = Avaliacao.obterListaAvaliacoes();
        double valorNotas =0;
        double valorPesos =0;
        for(int i =0;i < x.size();i++){
            if(x.get(i).getDisciplina().equals(disc) && x.get(i).getMediaAsString().equals(med)){
                valorNotas+=x.get(i).getNota()*x.get(i).getPeso();
                valorPesos+=x.get(i).getPeso();
            }
        }if(valorPesos != 0){
        valorMedia = valorNotas/valorPesos;
        }
        return valorMedia;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the media
     */
    public char[] getMedia() {
        return media;
    }

    public String getMediaAsString() {
        return String.valueOf(media);
    }

    /**
     * @param media the media to set
     */
    public void setMedia(char[] media) {
        this.media = media;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return the indexNo
     */
    public int getIndexNo() {
        return indexNo;
    }

    /**
     * @param indexNo the indexNo to set
     */
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }
}
