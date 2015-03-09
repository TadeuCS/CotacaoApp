/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tadeu
 */
public class Manager {

    private Connection con=null;
    private Statement st=null;
    private ResultSet rs=null;
    private PreparedStatement ps=null;

    public Connection getConexao(String diretorio, String usuario, String senha) {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con = DriverManager.getConnection(diretorio, usuario, senha);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return con;
    }

    public ResultSet consulta(String query) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta!");
        }
        return rs;
    }

    public String insere(String query) {
        String resultado = null;
        try {
            ps = con.prepareStatement(query);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro.\n" + "Valor já existe no Banco de Dados!");
            System.out.println(e);

        }
        return resultado;
    }
}
