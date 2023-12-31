package code;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erlangga Lesmana P
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form loginFrame
     */
    public LoginFrame() {
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
        txt_user = new javax.swing.JTextField();
        pass_user = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        check_tampilsandi = new javax.swing.JCheckBox();
        combo_jenis = new javax.swing.JComboBox<>();
        minimize = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN PAGE");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setBackground(new java.awt.Color(204, 204, 204));
        txt_user.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_user.setNextFocusableComponent(pass_user);
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 190, 30));

        pass_user.setBackground(new java.awt.Color(204, 204, 204));
        pass_user.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pass_user.setNextFocusableComponent(btn_login);
        jPanel1.add(pass_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 190, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_login.setBackground(new java.awt.Color(255, 204, 0));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_login.setText("LOGIN");
        btn_login.setPreferredSize(new java.awt.Dimension(88, 27));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(255, 0, 0));
        btn_keluar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
        btn_keluar.setText("KELUAR");
        btn_keluar.setPreferredSize(new java.awt.Dimension(88, 27));
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_login, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 210, 260, 70));

        check_tampilsandi.setBackground(new java.awt.Color(255, 255, 255));
        check_tampilsandi.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        check_tampilsandi.setText("Tampilkan Password");
        check_tampilsandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_tampilsandiActionPerformed(evt);
            }
        });
        jPanel1.add(check_tampilsandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 190, 140, -1));

        combo_jenis.setBackground(new java.awt.Color(0, 102, 204));
        combo_jenis.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        combo_jenis.setForeground(new java.awt.Color(255, 255, 255));
        combo_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAHASISWA", "DOSEN", "ADMINISTRATOR" }));
        jPanel1.add(combo_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 290, -1));

        minimize.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-minimize.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, -10, -1, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/login.jpg"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        String[] opsi = {"YA" , "TIDAK"};
        int jawab = JOptionPane.showOptionDialog(this, 
                "Apakah anda yakin akan Keluar?" , 
                "Keluar Aplikasi", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);
        
        if (jawab == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void check_tampilsandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_tampilsandiActionPerformed
        // TODO add your handling code here:
        if(check_tampilsandi.isSelected()){
            pass_user.setEchoChar((char)0);
        } else {
            pass_user.setEchoChar('•');
        }
    }//GEN-LAST:event_check_tampilsandiActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            String jenisAkun = combo_jenis.getSelectedItem().toString();
            String pass_mahasiswa = PrivateData.get_pass_mahasiswa();
            if(txt_user.getText().equals("") || pass_user.getText().equals("") || combo_jenis.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus di isi!");
            }else{
                if(jenisAkun.equals("MAHASISWA")){
                    sql = "SELECT * FROM `mahasiswa` WHERE nim='"+txt_user.getText()+"' ";
                    java.sql.Connection con = (Connection)PrivateData.sambungDB();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    java.sql.ResultSet r = ps.executeQuery(sql);

                    String kolomPass = pass_user.getText().toString();

                    if(r.next() && kolomPass.equals(pass_mahasiswa)){
                        JOptionPane.showMessageDialog(this, 
                                "Login Berhasil! \nAKUN : MAHASISWA" , 
                                "Informasi Login" ,
                                JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        PrivateData.set_nama(r.getString("nama_mahasiswa").toUpperCase());
                        PrivateData.set_user_id(r.getString("nim"));
                        PrivateData.set_jenisAkun("MAHASISWA");
                        PrivateData.set_akunLogin(r.getString("prodi_mhs"));
                        new DashboardFrame_Mhs().setVisible(true);
                        System.out.println("ID = "+PrivateData.get_user_id().toString());
                        System.out.println("Nama = "+PrivateData.get_nama().toString());
                        //label_nama.setText(r.getString(4));
                    }else{
                        JOptionPane.showMessageDialog(this, 
                                "Maaf Login GAGAL \nPastikan Seluruh Kolom terisi dengan Benar" , 
                                "Informasi Login" , 
                                JOptionPane.INFORMATION_MESSAGE);

                        pass_user.setText("");
                    }

                }else if(jenisAkun.equals("DOSEN")){
                    sql = "SELECT * FROM `dosen` WHERE "
                            + "id_dosen='"+txt_user.getText()+"' "
                            + "and pass_dosen=MD5('"+pass_user.getText()+"')";
                    java.sql.Connection con = (Connection)PrivateData.sambungDB();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    java.sql.ResultSet r = ps.executeQuery(sql);

                    if(r.next()){
                        JOptionPane.showMessageDialog(this, 
                                "Login Berhasil! \nAKUN : DOSEN" , 
                                "Informasi Login" ,
                                JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        PrivateData.set_nama(r.getString("nama_dosen"));
                        PrivateData.set_user_id(r.getString("id_dosen"));
                        PrivateData.set_jenisAkun("DOSEN");
                        PrivateData.set_akunLogin(r.getString("dosen_prodi"));
                        new DashboardFrame_Dosen().setVisible(true);
                        System.out.println("ID = "+PrivateData.get_user_id().toString());
                        System.out.println("Nama = "+PrivateData.get_nama().toString());

                    }else{
                        JOptionPane.showMessageDialog(this, 
                                "Maaf Login GAGAL \nPastikan Seluruh Kolom terisi dengan Benar" , 
                                "Informasi Login" , 
                                JOptionPane.INFORMATION_MESSAGE);

                        pass_user.setText("");
                    }

                }else if(jenisAkun.equals("ADMINISTRATOR")){    
                    sql = "SELECT * FROM `admin` WHERE "
                            + "id_admin='"+txt_user.getText()+"' "
                            + "and pass_admin=MD5('"+pass_user.getText()+"')";
                    java.sql.Connection con = (Connection)PrivateData.sambungDB();
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);
                    java.sql.ResultSet r = ps.executeQuery(sql);

                    if(r.next()){
                        JOptionPane.showMessageDialog(this, 
                                "Login Berhasil! \nAKUN : ADMINISTRATOR" , 
                                "Informasi Login" ,
                                JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        PrivateData.set_nama(r.getString("nama_admin"));
                        PrivateData.set_user_id(r.getString("id_admin"));
                        PrivateData.set_jenisAkun("ADMINISTRATOR");
                        PrivateData.set_akunLogin("admin");
                        new DashboardFrame().setVisible(true);
                        System.out.println("ID = "+PrivateData.get_user_id().toString());
                        System.out.println("Nama = "+PrivateData.get_nama().toString());

                    }else{
                        JOptionPane.showMessageDialog(this, 
                                "Maaf Login GAGAL \nPastikan Seluruh Kolom terisi dengan Benar" , 
                                "Informasi Login" , 
                                JOptionPane.INFORMATION_MESSAGE);

                        pass_user.setText("");
                    }

                }else{
                    JOptionPane.showMessageDialog(this, 
                                "Maaf Login GAGAL \nPastikan Seluruh Kolom terisi dengan Benar" , 
                                "Informasi Login" , 
                                JOptionPane.INFORMATION_MESSAGE);
                }
            }
         }catch (SQLException e) {
            System.out.println("Kode Salah" + e);
        }    
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_login;
    private javax.swing.JCheckBox check_tampilsandi;
    private javax.swing.JComboBox<String> combo_jenis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel minimize;
    private javax.swing.JPasswordField pass_user;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
