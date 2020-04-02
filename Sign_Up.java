

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Sign_Up extends javax.swing.JFrame {

    /**
     * Creates new form Sign_Up
     */
    public Sign_Up() {
        setSize(624,499);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(624, 499));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(625, 0, 0, 499);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Sign Up");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 160, 60);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setText("Enter Name:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 80, 200, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(230, 90, 160, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel4.setText("Enter Username:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 140, 170, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(230, 150, 160, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setText("Enter Password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 200, 170, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(230, 200, 160, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setText("Confirm Password:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 250, 200, 30);

        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(230, 250, 160, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel7.setText("Enter email Address:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 300, 220, 40);

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 390, 140, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 390, 120, 40);

        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(230, 310, 160, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 625, 499);

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(230, 300, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name=jTextField1.getText();
        System.out.println(name);
        String username=jTextField2.getText();
        System.out.println(username);
        String password=jPasswordField1.getText();
        System.out.println(password);
        String email;
        email = jTextField4.getText();
        System.out.println(email);
        
        Date date=new Date();
        String dd=date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900);
        String time=date.getHours()+":"+date.getMinutes();
        
        try
        {
           Connection con=Dbconnection.dbconnect();
           PreparedStatement ps=con.prepareStatement("insert into sign_up(username,password,time,date,name,email) values (?,?,?,?,?,?)");
            ps.setString(1,username);
             ps.setString(2,password);
              ps.setString(3,time);
               ps.setString(4,dd);
                ps.setString(5,name);
                 ps.setString(6,email);
                   int i=ps.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null, "Successfully Registered");
                    new Login_Window().setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Registration Unsuccessful");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField4.setText("");
                }
        }catch(SQLException | HeadlessException e)
        {
            System.out.println("Exception in signup"+e);
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        if(!(jPasswordField1.getText().equals(jPasswordField2.getText())))
        {
            JOptionPane.showMessageDialog(null, "Password sholud be same");
            jPasswordField1.setText("");
            jPasswordField2.setText("");
        }
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
new Login_Window().setVisible(true);
dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        String email=jTextField4.getText().trim();
        int atpos=email.indexOf("@");
        int dotpos=email.lastIndexOf(".");
        if(atpos<1||dotpos<atpos+2||dotpos+2>=email.length())
        {
            JOptionPane.showMessageDialog(null, "Invalid Email Address");
            jTextField4.setText("");
        }
    }//GEN-LAST:event_jTextField4FocusLost

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sign_Up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
