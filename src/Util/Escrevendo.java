/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.util.Locale;
import javax.swing.JFileChooser;
import jxl.Sheet;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
//import jxl.write.*;  
import jxl.write.Label;

public class Escrevendo {

    public static void main(String[] args) {
        Escrevendo e = new Escrevendo();
    }

    public Escrevendo() {
        String filename = null;
        JFileChooser chooser = new JFileChooser();

        int retorno = chooser.showSaveDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile().getAbsolutePath().contains(".xls") == true) {
                filename = chooser.getSelectedFile().getAbsolutePath();
            } else {
                filename = chooser.getSelectedFile().getAbsolutePath()+ ".xls";
            }
            try {
                WorkbookSettings ws = new WorkbookSettings();
                ws.setLocale(new Locale("pt_br"));
                WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
                WritableSheet s = workbook.createSheet("Cotação", 0);

                int linhaInicial = 1;
                int colunaInicia = 1;

                while (linhaInicial < 2) {
                    WritableCellFormat cf2 = new WritableCellFormat();
                    cf2.setAlignment(Alignment.CENTRE);
                    Label label = new Label(colunaInicia, linhaInicial, "teste", cf2);
                    s.addCell(label);
                    s.setProtected(true);
                    linhaInicial++;
                }
                workbook.write();
                workbook.close();
                System.out.println("Deu Certo!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
