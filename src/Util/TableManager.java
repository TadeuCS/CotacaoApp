/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tadeu
 */
public class TableManager {

    public void filtrar(JTable tabela, JTextField filtro) {
        TableRowSorter sorter = new TableRowSorter(tabela.getModel());
        tabela.setRowSorter(sorter);
        String texto = filtro.getText();
        try {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Valor Não Encontrado!!!", "AVISO - Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel getTableModel(JTable tabela) {
        try {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            return model;
        } catch (Exception e) {
            return null;
        }
    }

    public void limpaTabela(JTable tabela) {
        try {
            while (0 < getTableModel(tabela).getRowCount()) {
                getTableModel(tabela).removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
