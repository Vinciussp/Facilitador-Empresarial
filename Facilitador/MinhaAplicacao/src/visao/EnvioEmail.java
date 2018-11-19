/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ConnectionConsulta;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;
import modelo.ModeloTabela;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.sql.PreparedStatement;

/**
 *
 * @author vinicius
 */
public class EnvioEmail extends javax.swing.JFrame {

    
    ConnectionConsulta conecta = new ConnectionConsulta();
    JTextArea texto;
    /**
     * Creates new form EnvioEmail
     */
    public EnvioEmail() {
        initComponents();
        conecta.conectaBanco();
        texto = new JTextArea();
        texto.setFont(new Font("Serif", Font.PLAIN, 26));
        JButton botao = new JButton("Abrir Arquivo");
        botao.setFont(new Font("Serif", Font.PLAIN, 26));
        
        
     
        conecta.conectaBanco();
        preenchertabela("select * from usuarios where recebimento in ('Não recebido') order by departamento;");
        ModeloTabela modelo = (ModeloTabela) jTableMsg.getModel();
        jTableMsg.setRowSorter(new TableRowSorter(modelo));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Attach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMsg = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("De:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 20, 20));

        jLabel2.setText("Para:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 20));

        jLabel3.setText("Assunto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jTextField1.setText("tecnologia@asscont.com.br");
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 180, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 180, -1));

        jTextField3.setText("Solicitação de baixa!");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 180, -1));

        JTextArea.setColumns(20);
        JTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        JTextArea.setRows(5);
        jScrollPane1.setViewportView(JTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 780, 113));

        jLabel4.setText("Enviar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 40, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/mail.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 80));

        jButton2.setText("Mostrar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        jButton3.setText("Leitura");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        Attach.setText("Anexar");
        Attach.setEnabled(false);
        Attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachActionPerformed(evt);
            }
        });
        getContentPane().add(Attach, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        jTableMsg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableMsg);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 281, 780, 230));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "acaxias@asscont.com.br", "adriana@asscont.com.br", "bruno.lopes@asscont.com.br", "declaracoes@asscont.com.br", "edilene@asscont.com.br", "gustavo@asscont.com.br", "rh@asscont.com.br", "janayna.dp@asscont.com.br", "katia@asscont.com.br", "natalia.dp@asscont.com.br", "Priscila@asscont.com.br", "vera@asscont.com.br" }));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 180, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/email_grande.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, 100));

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        jTextFieldUsuario.setEnabled(false);
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, 30));

        setSize(new java.awt.Dimension(814, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       try{
            SimpleEmail emailSimples = new SimpleEmail();
            emailSimples.setHostName("200.170.82.150");
            emailSimples.setSmtpPort(587);
            emailSimples.setFrom(jTextField1.getText(),jTextField1.getText());          
            emailSimples.addTo(jTextField2.getText());
            emailSimples.setSubject(jTextField3.getText());
            emailSimples.setMsg(JTextArea.getText());          
            emailSimples.setAuthentication("tecnologia@asscont.com.br","Asscont100");
            emailSimples.send();  
            JOptionPane.showMessageDialog(null, "Mensagem enviada");
        } catch (EmailException ex) {
            JOptionPane.showMessageDialog(null, "erro ao enviar"+ ex);
        }
    
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    
            jTextField1.setText("tecnologia@asscont.com.br");
            jTextField3.setText("Solicitação de baixa!");
         
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code her
        
        JFileChooser c = new JFileChooser();
        c.showOpenDialog(null);
        File file = c.getSelectedFile();
        String filename=file.getAbsolutePath();
        try{
            FileReader reader = new FileReader ( filename);
            BufferedReader br = new BufferedReader(reader);
            JTextArea.read( br, null);
            br.close();
            JTextArea.requestFocus();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this,"Erro ao processar");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void AttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachActionPerformed
        // TODO add your handling code here:
        JFileChooser c = new JFileChooser();
        c.showOpenDialog(null);
        File file = c.getSelectedFile();
        attachment_path=file.getAbsolutePath();
        
        
        
    }//GEN-LAST:event_AttachActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
         jTextField2.setText(jComboBox2.getSelectedItem().toString());
      
    
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    
     public void preenchertabela(String SQL){
        ArrayList dados = new ArrayList();
        
        
        String [] Colunas = new String[]{"ID","EMPRESA","DESCRICAO","DESTINATARIO"};
        conecta.conectaBanco();
        conecta.executaSQL(SQL);
        try {
           conecta.rs.first(); 
        do{
        dados.add(new Object[]{conecta.rs.getInt("id"),conecta.rs.getString("empresa"),conecta.rs.getString("descricao"),conecta.rs.getString("destinatario")}); 
        }while(conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList!\nErro" + ex);
        }
       
        
        
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableMsg.setModel(modelo);
        jTableMsg.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableMsg.getColumnModel().getColumn(0).setResizable(false);
        jTableMsg.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableMsg.getColumnModel().getColumn(1).setResizable(false);
        jTableMsg.getColumnModel().getColumn(2).setPreferredWidth(420);
        jTableMsg.getColumnModel().getColumn(2).setResizable(false);
        jTableMsg.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableMsg.getColumnModel().getColumn(3).setResizable(false);
        jTableMsg.getTableHeader().setReorderingAllowed(true);
        jTableMsg.setAutoResizeMode(jTableMsg.AUTO_RESIZE_OFF);
        //jTableMsg.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnvioEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnvioEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnvioEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnvioEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnvioEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attach;
    private javax.swing.JTextArea JTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMsg;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
String attachment_path;

 public void recebendo(String recebe){
        jTextFieldUsuario.setText(recebe);
    }
}
