/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;

import java.io.IOException;
import javax.swing.JFileChooser;

import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;

public class Ler {

    public static void main(String[] args)
            throws BiffException, IOException {

        /**
         *
         * Carrega a planilha
         *
         */
        String filename = null;
        JFileChooser chooser = new JFileChooser();

        int retorno = chooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            filename = chooser.getSelectedFile().getAbsolutePath();

//            Workbook workbook = Workbook.getWorkbook(new File("C:/Users/Tadeu/Desktop/teste.xls"));
            Workbook workbook = Workbook.getWorkbook(new File(filename));

            /**
             *
             * Aqui Ã© feito o controle de qual aba do xls * serÃ¡ realiza a
             * leitura dos dados
             *
             */
            Sheet sheet = workbook.getSheet(0);

            /**
             *
             * Numero de linhas com dados do xls
             *
             */
            int linhas = sheet.getRows();

            for (int i = 0; i < linhas; i++) {
                Cell celula1 = sheet.getCell(0, i);
                Cell celula2 = sheet.getCell(1, i);
                System.out.println(celula1.getContents() + " , " + celula2.getContents());


            }

        }

    }
}
