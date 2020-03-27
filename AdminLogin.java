/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojrct;

import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class AdminLogin extends javax.swing.JFrame {

    public AdminLogin() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\User-blue-icon.png")); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 70, 64, 64);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\secrecy-icon (3).png")); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 140, 48, 48);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 110, 69, 17);

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(270, 110, 200, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 150, 67, 50);

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(270, 160, 200, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\symbol-check-icon.png")); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 300, 120, 25);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\Go-back-icon.png")); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 300, 110, 25);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\App-logout-icon.png")); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 300, 130, 25);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mbali\\Desktop\\Project - Copy\\IMG-20191102-WA0000.jpg")); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 10, 880, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
     //Now display response result
     
     if(response ==JOptionPane.YES_OPTION){
         this.hide();
         jButton3.setVisible(true);
        
    }else  if(response == JOptionPane.NO_OPTION){
      AdminLogin frm = new AdminLogin ();
        frm.setVisible(true);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{

            //con = DriverManager.getConnection("jdbc:apache:commons:dbcp:root");

            Class.forName("com.mysql.jdbc.Driver");
            //get connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement_db","root","");
            //create statement
            Statement st = con.createStatement();

            String sql= "select * from adminlogin_db where Username = '"+username.getText()+"' and Password='"+password.getText()+"'";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){

                JOptionPane.showMessageDialog(null, "username and password matched");

                RegistrationForms Info = new RegistrationForms();
                Info.setVisible(true);
                dispose();

            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login details","Login Error",JOptionPane.ERROR_MESSAGE);
                //JOptionPane.showMessageDialog(null, "username or password is not correct");

            }

            con.close();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.hide();
        LoginForms frm = new LoginForms ();
        frm.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

          private void systemExit() {
           WindowEvent winCloseing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    }
}
