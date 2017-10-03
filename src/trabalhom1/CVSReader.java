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

/**
 *
 * @author joaomheusi
 */
public class CVSReader {

    String csvFile = "/Users/joaomheusi/NetBeansProjects/TrabalhoM1/build/teste.cvs";
    String line = "";
    String cvsSplitBy = ",";

    public void lerCVS(String s) {
    String tempData = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i =0;
            while ((line = br.readLine()) != null) {
                
                // use comma as separator
                // String[] country = line.split(cvsSplitBy);
                String[] detAvaliacao = line.split(cvsSplitBy);
                String avDisciplina = detAvaliacao[0];
                String avMedia = detAvaliacao[1];
                String avNome = detAvaliacao[2];
                String avPeso = detAvaliacao[3];
                String avNota = new String();
                
                System.out.println(avDisciplina + "," + avMedia + "," + avNome + "," + avPeso);
                
                tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso +"\n";
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
    public void lerCVS() {
    //String tempData = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int i =0;
            while ((line = br.readLine()) != null) {
                
                // use comma as separator
                // String[] country = line.split(cvsSplitBy);
                String[] detAvaliacao = line.split(cvsSplitBy);
                String avDisciplina = detAvaliacao[0];
                String avMedia = detAvaliacao[1];
                String avNome = detAvaliacao[2];
                String avPeso = detAvaliacao[3];
                String avNota = detAvaliacao[4];
                
                System.out.println(avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "," + avNota);
                
                //tempData += avDisciplina + "," + avMedia + "," + avNome + "," + avPeso + "," + avNota +"\n";
            }

       
    } catch (IOException e) {
            e.printStackTrace();
        }


}
    
}