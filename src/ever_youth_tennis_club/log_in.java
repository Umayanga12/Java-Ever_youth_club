/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ever_youth_tennis_club;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class log_in extends javax.swing.JFrame {

    /**
     * Creates new form log_in
     */
    public log_in() {
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
        jLabel2 = new javax.swing.JLabel();
        u_name = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));
        jPanel1.add(u_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 347, -1));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 347, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("F:\\first year - semester 1\\Assignment\\New\\programming\\Ever_youth_tennis_club\\ball1.jpg")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 690, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-23, -3, 830, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // get the user inputs
            String user_name = u_name.getText();
            String pw = password.getText();

            // variable decleration 
            String db_user_name = "";
            String db_password = "";
            String statement = "";

            //database searching 
            Statement s = db_connection.DB_conneConnection().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM user WHERE user_name='" + user_name + "' && password='" + pw + "' ");

            while (rs.next()) {
                db_user_name = rs.getString("user_name");
                db_password = rs.getString("password");
                statement = rs.getString("states");
                log_user_id = rs.getInt("iduser");

            }
            // get the log user name as public variable
            log_user = user_name;

            // System.out.println(log_user_id);

            if (user_name.equals("") || pw.equals("")) {

                JOptionPane.showMessageDialog(rootPane, "Please Enter the Log in Detail", "Log in Error", JOptionPane.ERROR_MESSAGE);

            } else {

                if (user_name.equals(db_user_name) && pw.equals(db_password)) {

                    if (statement.equals("admin")) {

                        admin_pannel admin = new admin_pannel();
                        admin.setVisible(true);
                        this.dispose();
                        System.gc();

                    }

                    if (statement.equals("user")) {

                        home h = new home();
                        h.setVisible(true);
                        this.dispose();
                        System.gc();

                    }

                } else {

                    JOptionPane.showMessageDialog(rootPane, "User name or Password is Worng", "Log in Error", JOptionPane.ERROR_MESSAGE);

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public static String log_user = "";
    public static int log_user_id = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new log_in().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField u_name;
    // End of variables declaration//GEN-END:variables
}
