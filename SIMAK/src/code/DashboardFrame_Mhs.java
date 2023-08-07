/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package code;

/**
 *
 * @author Lenovo
 */
public class DashboardFrame_Mhs extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public DashboardFrame_Mhs() {
        initComponents();
        
        txt_userlogin.setText("INFORMASI LOGIN : "
                +PrivateData.get_nama()
                +"("+PrivateData.get_jenisAkun()+")");
    }
    
    String jenisAkun = PrivateData.get_jenisAkun();
    String akunLogin = PrivateData.get_akunLogin();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        lomba = new javax.swing.JLabel();
        matakuliah = new javax.swing.JLabel();
        mahasiswa = new javax.swing.JLabel();
        txt_userlogin = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 70, 70));

        lomba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lombaMouseClicked(evt);
            }
        });
        jPanel1.add(lomba, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 140, 220));

        matakuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matakuliahMouseClicked(evt);
            }
        });
        jPanel1.add(matakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 150, 220));

        mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mahasiswaMouseClicked(evt);
            }
        });
        jPanel1.add(mahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 140, 220));

        txt_userlogin.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txt_userlogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_userlogin.setText("INFORMASI LOGIN : ");
        jPanel1.add(txt_userlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 49, 890, 30));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-minimize.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, -1, 30));

        jPanel2.setBackground(new java.awt.Color(0, 240, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEM INFORMASI AKADEMIK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 15, 890, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 850, 50));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dashboard_mhs.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mahasiswaMouseClicked
        // TODO add your handling code here:
            this.setVisible(false);
            new MahasiswaFrame_Mhs().setVisible(true);
    }//GEN-LAST:event_mahasiswaMouseClicked

    private void matakuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matakuliahMouseClicked
        // TODO add your handling code here:
        if(jenisAkun.equalsIgnoreCase("MAHASISWA") && akunLogin.equalsIgnoreCase("TIF_SDA")){
            this.setVisible(false);
            new MataKuliahFrame_TIF22().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("MAHASISWA") && akunLogin.equalsIgnoreCase("MID_SDA")){
            this.setVisible(false);
            new MataKuliahFrame_MID22().setVisible(true);
        }
    }//GEN-LAST:event_matakuliahMouseClicked

    private void lombaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lombaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new LombaFrame().setVisible(true);
        
    }//GEN-LAST:event_lombaMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        PrivateData.set_nama("");
        PrivateData.set_user_id("");
        PrivateData.set_jenisAkun("");
        new LoginFrame().setVisible(true);
        System.out.println("ID = "+PrivateData.get_user_id().toString());
        System.out.println("Nama = "+PrivateData.get_nama().toString());
    }//GEN-LAST:event_exitMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame_Mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lomba;
    private javax.swing.JLabel mahasiswa;
    private javax.swing.JLabel matakuliah;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel txt_userlogin;
    // End of variables declaration//GEN-END:variables
}
