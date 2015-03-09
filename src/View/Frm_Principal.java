/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cotacao;
import Util.Data;
import Util.Manager;
import Util.PropertiesManager;
import Util.TableManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tadeu
 */
public class Frm_Principal extends javax.swing.JFrame {

    PropertiesManager prop = new PropertiesManager();
    Manager em = new Manager();
    Frm_Conexao con;
    TableManager tm = new TableManager();
    ResultSet rs;
    public static Cotacao cotacao;
    public Frm_Principal() {
        initComponents();
        btn_configurar.setVisible(false);
        testaConexao();
    }

    public void setDadosCotacao() {
        try {
            txt_codigoCotacao.setText(cotacao.getCodCotacao());
            txt_observacaoCotacao.setText(cotacao.getObservacao());
        } catch (Exception e) {
        }

    }

    private String getDiretorioConexao(String ip, String diretorio) {
        return "jdbc:firebirdsql://" + ip + ":3050/" + diretorio;
    }

    private void testaConexao() {
        if (em.getConexao(getDiretorioConexao(prop.get("ip"), prop.get("diretorio")), prop.get("usuario"), prop.get("senha")) == null) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados.\n");
            btn_configurar.setVisible(true);
        } else {
            listaFornecedores();
        }
    }

    private void listaFornecedores() {
        rs = em.consulta("select * from fornece f "
                + "where f.nomefantasia is not null "
                + "and f.cgccpf is not null "
                + "and f.cgccpf<>'' "
                + "and f.email is not null "
                + "and f.email<>'' order by f.nomefantasia");
        try {
            while (rs.next()) {
                String[] linha = new String[]{rs.getString("CODFORNEC"), rs.getString("NOMEFANTASIA"), rs.getString("CGCCPF"), rs.getString("EMAIL")};
                tm.getTableModel(tb_fornecedores).addRow(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO.\n" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_fundo = new javax.swing.JPanel();
        pnl_dados = new javax.swing.JPanel();
        pnl_listas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_fornecedores = new javax.swing.JTable();
        txt_filtroFornecedores = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_inserir = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        pnl_fornecedoresSelecionados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_fornecedoresSelecionados = new javax.swing.JTable();
        txt_filtroFornecedoresSelecionados = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnl_dadosCotacao = new javax.swing.JPanel();
        btn_buscarCotacao = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_codigoCotacao = new javax.swing.JTextField();
        txt_observacaoCotacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_exportar = new javax.swing.JButton();
        btn_importar = new javax.swing.JButton();
        barraProgresso = new javax.swing.JProgressBar();
        btn_configurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exportação/Importação de Cotação");

        pnl_dados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnl_listas.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Fornecedores"));

        tb_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOME", "CNPJ", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_fornecedores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_fornecedores);
        if (tb_fornecedores.getColumnModel().getColumnCount() > 0) {
            tb_fornecedores.getColumnModel().getColumn(0).setMinWidth(75);
            tb_fornecedores.getColumnModel().getColumn(0).setPreferredWidth(75);
            tb_fornecedores.getColumnModel().getColumn(0).setMaxWidth(75);
            tb_fornecedores.getColumnModel().getColumn(2).setMinWidth(100);
            tb_fornecedores.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_fornecedores.getColumnModel().getColumn(2).setMaxWidth(180);
        }

        txt_filtroFornecedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroFornecedoresKeyReleased(evt);
            }
        });

        jLabel4.setText("Filtro:");

        javax.swing.GroupLayout pnl_listasLayout = new javax.swing.GroupLayout(pnl_listas);
        pnl_listas.setLayout(pnl_listasLayout);
        pnl_listasLayout.setHorizontalGroup(
            pnl_listasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_listasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnl_listasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_filtroFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_listasLayout.setVerticalGroup(
            pnl_listasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_listasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_listasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_filtroFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_inserir.setText(">>");
        btn_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inserirActionPerformed(evt);
            }
        });

        btn_remover.setText("<<");

        pnl_fornecedoresSelecionados.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Fornecedores Selecionados"));

        tb_fornecedoresSelecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOME", "CNPJ", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_fornecedoresSelecionados.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tb_fornecedoresSelecionados);
        if (tb_fornecedoresSelecionados.getColumnModel().getColumnCount() > 0) {
            tb_fornecedoresSelecionados.getColumnModel().getColumn(0).setMinWidth(75);
            tb_fornecedoresSelecionados.getColumnModel().getColumn(0).setPreferredWidth(75);
            tb_fornecedoresSelecionados.getColumnModel().getColumn(0).setMaxWidth(75);
            tb_fornecedoresSelecionados.getColumnModel().getColumn(2).setMinWidth(100);
            tb_fornecedoresSelecionados.getColumnModel().getColumn(2).setPreferredWidth(120);
            tb_fornecedoresSelecionados.getColumnModel().getColumn(2).setMaxWidth(180);
        }

        txt_filtroFornecedoresSelecionados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtroFornecedoresSelecionadosKeyReleased(evt);
            }
        });

        jLabel6.setText("Filtro:");

        javax.swing.GroupLayout pnl_fornecedoresSelecionadosLayout = new javax.swing.GroupLayout(pnl_fornecedoresSelecionados);
        pnl_fornecedoresSelecionados.setLayout(pnl_fornecedoresSelecionadosLayout);
        pnl_fornecedoresSelecionadosLayout.setHorizontalGroup(
            pnl_fornecedoresSelecionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fornecedoresSelecionadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnl_fornecedoresSelecionadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_filtroFornecedoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_fornecedoresSelecionadosLayout.setVerticalGroup(
            pnl_fornecedoresSelecionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fornecedoresSelecionadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fornecedoresSelecionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_filtroFornecedoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnl_dadosCotacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Cotação"));

        btn_buscarCotacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_buscarCotacaoFocusLost(evt);
            }
        });
        btn_buscarCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarCotacaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Cotação *:");

        txt_codigoCotacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigoCotacao.setEnabled(false);
        txt_codigoCotacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoCotacaoFocusLost(evt);
            }
        });
        txt_codigoCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoCotacaoActionPerformed(evt);
            }
        });

        txt_observacaoCotacao.setEnabled(false);

        jLabel8.setText("Observação *:");

        javax.swing.GroupLayout pnl_dadosCotacaoLayout = new javax.swing.GroupLayout(pnl_dadosCotacao);
        pnl_dadosCotacao.setLayout(pnl_dadosCotacaoLayout);
        pnl_dadosCotacaoLayout.setHorizontalGroup(
            pnl_dadosCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dadosCotacaoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_codigoCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_buscarCotacao)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_observacaoCotacao)
                .addContainerGap())
        );
        pnl_dadosCotacaoLayout.setVerticalGroup(
            pnl_dadosCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dadosCotacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_dadosCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_dadosCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_observacaoCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_dadosCotacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_codigoCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_buscarCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_dadosLayout = new javax.swing.GroupLayout(pnl_dados);
        pnl_dados.setLayout(pnl_dadosLayout);
        pnl_dadosLayout.setHorizontalGroup(
            pnl_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_dadosCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_dadosLayout.createSequentialGroup()
                        .addComponent(pnl_listas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_remover, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(btn_inserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_fornecedoresSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_dadosLayout.setVerticalGroup(
            pnl_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_dadosCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnl_dadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_listas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_fornecedoresSelecionados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_dadosLayout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addComponent(btn_inserir)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remover)
                        .addGap(148, 148, 148)))
                .addContainerGap())
        );

        btn_exportar.setText("Exportar");

        btn_importar.setText("Importar");

        btn_configurar.setText("Configurar");
        btn_configurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_fundoLayout = new javax.swing.GroupLayout(pnl_fundo);
        pnl_fundo.setLayout(pnl_fundoLayout);
        pnl_fundoLayout.setHorizontalGroup(
            pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_fundoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btn_configurar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_importar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_exportar))
                    .addComponent(pnl_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_fundoLayout.setVerticalGroup(
            pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_dados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_importar)
                        .addComponent(btn_exportar)
                        .addComponent(btn_configurar))
                    .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoCotacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoCotacaoActionPerformed

    private void btn_configurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configurarActionPerformed
        con = new Frm_Conexao();
        con.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_configurarActionPerformed

    private void btn_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inserirActionPerformed
        if (tb_fornecedores.getSelectedRowCount() == 1) {
            String[] linha = new String[]{
                tb_fornecedores.getValueAt(tb_fornecedores.getSelectedRow(), 0).toString(),
                tb_fornecedores.getValueAt(tb_fornecedores.getSelectedRow(), 1).toString(),
                tb_fornecedores.getValueAt(tb_fornecedores.getSelectedRow(), 2).toString(),
                tb_fornecedores.getValueAt(tb_fornecedores.getSelectedRow(), 3).toString()
            };
            tm.getTableModel(tb_fornecedoresSelecionados).addRow(linha);
            tm.getTableModel(tb_fornecedores).removeRow(tb_fornecedores.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas um fornecedor de cada vez!");
        }
    }//GEN-LAST:event_btn_inserirActionPerformed

    private void txt_filtroFornecedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroFornecedoresKeyReleased
        tm.filtrar(tb_fornecedores, txt_filtroFornecedores);
    }//GEN-LAST:event_txt_filtroFornecedoresKeyReleased

    private void txt_filtroFornecedoresSelecionadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroFornecedoresSelecionadosKeyReleased
        tm.filtrar(tb_fornecedoresSelecionados, txt_filtroFornecedoresSelecionados);
    }//GEN-LAST:event_txt_filtroFornecedoresSelecionadosKeyReleased

    private void txt_codigoCotacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoCotacaoFocusLost
        
    }//GEN-LAST:event_txt_codigoCotacaoFocusLost

    private void btn_buscarCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarCotacaoActionPerformed
        Frm_ConsultaCotacoes f = new Frm_ConsultaCotacoes();
        f.setVisible(true);
    }//GEN-LAST:event_btn_buscarCotacaoActionPerformed

    private void btn_buscarCotacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_buscarCotacaoFocusLost
        setDadosCotacao();
    }//GEN-LAST:event_btn_buscarCotacaoFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btn_buscarCotacao;
    private javax.swing.JButton btn_configurar;
    private javax.swing.JButton btn_exportar;
    private javax.swing.JButton btn_importar;
    private javax.swing.JButton btn_inserir;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnl_dados;
    private javax.swing.JPanel pnl_dadosCotacao;
    private javax.swing.JPanel pnl_fornecedoresSelecionados;
    private javax.swing.JPanel pnl_fundo;
    private javax.swing.JPanel pnl_listas;
    private javax.swing.JTable tb_fornecedores;
    private javax.swing.JTable tb_fornecedoresSelecionados;
    private javax.swing.JTextField txt_codigoCotacao;
    private javax.swing.JTextField txt_filtroFornecedores;
    private javax.swing.JTextField txt_filtroFornecedoresSelecionados;
    private javax.swing.JTextField txt_observacaoCotacao;
    // End of variables declaration//GEN-END:variables
}
