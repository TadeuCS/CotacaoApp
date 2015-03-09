/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Util.Manager;
import java.awt.Color;
import javax.swing.JOptionPane;
import Util.PropertiesManager;
import javax.swing.JFileChooser;

/**
 *
 * @author Tadeu
 */
public class Frm_Conexao extends javax.swing.JFrame {

    Manager em = new Manager();
    PropertiesManager prop = new PropertiesManager();

    public Frm_Conexao() {
        initComponents();
        validaIP();
        getConfiguracoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbx_tipo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_diretorio = new javax.swing.JTextField();
        btn_buscarDiretorio = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btn_gravar = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        btn_testar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Configuração da Conexão");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tipo:");

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Remoto" }));
        cbx_tipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbx_tipoFocusLost(evt);
            }
        });

        jLabel2.setText("IP/Host *:");

        jLabel3.setText("Diretório *:");

        btn_buscarDiretorio.setText("...");
        btn_buscarDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarDiretorioActionPerformed(evt);
            }
        });

        jLabel4.setText("Usuário *:");

        jLabel5.setText("Senha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txt_senha))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_diretorio)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscarDiretorio)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_diretorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarDiretorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_gravar.setText("Gravar");
        btn_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gravarActionPerformed(evt);
            }
        });

        msg.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_testar.setText("Testar");
        btn_testar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_testarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_testar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_gravar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_gravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_testar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_tipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbx_tipoFocusLost
        validaIP();
    }//GEN-LAST:event_cbx_tipoFocusLost

    private void btn_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gravarActionPerformed
       setConfiguracoes();
    }//GEN-LAST:event_btn_gravarActionPerformed

    private void btn_buscarDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarDiretorioActionPerformed
        buscaDiretorio();
    }//GEN-LAST:event_btn_buscarDiretorioActionPerformed

    private void btn_testarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_testarActionPerformed
        try {
            txt_diretorio.setText(txt_diretorio.getText().replace("\\", "/"));
            validaCampos(cbx_tipo.getSelectedItem().toString(), txt_ip.getText(), txt_diretorio.getText(), txt_usuario.getText(), txt_senha.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_testarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Conexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Conexao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarDiretorio;
    private javax.swing.JButton btn_gravar;
    private javax.swing.JButton btn_testar;
    private javax.swing.JComboBox cbx_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField txt_diretorio;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    public void buscaDiretorio() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
        } else {
            String file = fileChooser.getSelectedFile().getPath();
            txt_diretorio.setText(file);
        }
    }

    private void validaCampos(String tipo, String ip, String diretorio, String usuario, String senha) {
        if (tipo.equals("Remoto") == true && (ip.isEmpty())) {
            JOptionPane.showMessageDialog(null, "IP inválido!");
            txt_ip.requestFocus();
        } else {
            if (diretorio.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Diretório inválido!");
                txt_diretorio.requestFocus();
            } else {
                if (usuario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuário inválido!");
                    txt_usuario.requestFocus();
                } else {
                    if (senha.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Senha inválida!");
                        txt_senha.requestFocus();
                    } else {
                        testaConexao(ip, diretorio, usuario, senha);
                    }
                }
            }
        }
    }

    public void setEnableIP(boolean tipo) {
        txt_ip.setText(null);
        txt_ip.setEnabled(tipo);
    }

    public static String getDiretorioConexao(String ip, String diretorio) {
        return "jdbc:firebirdsql://" + ip + ":3050/" + diretorio;
    }

    private void testaConexao(String ip, String diretorio, String usuario, String senha) {
        Thread acao = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (em.getConexao(getDiretorioConexao(ip, diretorio), usuario, senha) == null) {
                        msg.setText("Falha ao conectar ao banco de dados!");
                        msg.setForeground(Color.red);
                        Thread.sleep(3000);
                        msg.setText(null);
                    } else {
                        msg.setText("Conexão bem sucedida!");
                        msg.setForeground(Color.blue);
                        Thread.sleep(3000);
                        msg.setText(null);
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        });
        acao.start();
    }

    private void validaIP(){
        if (cbx_tipo.getSelectedIndex() == 0) {
            setEnableIP(false);
            txt_ip.setText("localhost");
            txt_diretorio.requestFocus();
        } else {
            setEnableIP(true);
            txt_ip.requestFocus();
        }
    }
    private void getConfiguracoes() {
        if(prop.get("ip").equals("localhost")!=true){
        txt_ip.setText(prop.get("ip"));
        cbx_tipo.setSelectedIndex(1);
        txt_ip.setEnabled(true);
        }        
        txt_diretorio.setText(prop.get("diretorio"));
        txt_usuario.setText(prop.get("usuario"));
        txt_senha.setText(prop.get("senha"));
    }

    private void setConfiguracoes() {
         try {
            prop.set("ip", txt_ip.getText());
            prop.set("diretorio", txt_diretorio.getText());
            prop.set("usuario", txt_usuario.getText());
            prop.set("senha", txt_senha.getText());
            Frm_Principal f = new Frm_Principal();
            f.setVisible(true);
            dispose();
        }catch(Exception e){
        }
    }
}
