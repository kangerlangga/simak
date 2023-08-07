/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package code;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class PenelitianFrame extends javax.swing.JFrame {

       public Statement st;
       public ResultSet rs;
       public PreparedStatement ps;
       String ambil_id = "";
       private Connection con;
       String jenisAkun = PrivateData.get_jenisAkun();
    
    public PenelitianFrame(){
        initComponents();
        sambungDB();
        TampilData ();
    }
    
    //Sambung Database Lokal
     private void sambungDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Menentukan Driver untuk tersambung ke Database
            String url = PrivateData.get_urlDB(); //URL letak Database
            String pengguna = PrivateData.get_userDB(); //user untuk login Database
            String pass = PrivateData.get_passDB();
            
            con = DriverManager.getConnection(url, pengguna, pass); //Untuk menyambungkan Driver ke Database
            
        } catch (Exception e) {
            System.out.println("Database GAGAL Tersambung " + e.getMessage()); //Menampilkan pesan gagal
        }
    }
    
    private void TampilData(){
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM penelitian ");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Penelitian");
            model.addColumn("Kategori Penelitian");
            model.addColumn("Nama Penelitian");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object [] data = {
                   rs.getString("id_penelitian"),rs.getString("kategori_penelitian"),rs.getString("nama_penelitian")};
                model.addRow(data);
                tblData.setModel(model);
                        }
                
            
            
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Nama = new javax.swing.JTextField();
        btn_ubah = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Kategori = new javax.swing.JTextField();
        minimize = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        btn_batal = new javax.swing.JButton();
        txt_idPenelitian = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 823, 1000, 700));
        getContentPane().add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 310, 40));

        btn_ubah.setBackground(new java.awt.Color(204, 0, 204));
        btn_ubah.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("PERBARUI");
        btn_ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 120, 40));

        btn_tambah.setBackground(new java.awt.Color(204, 0, 204));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 120, 40));

        btn_delete.setBackground(new java.awt.Color(204, 0, 204));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("HAPUS");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 200, 120, 40));

        tblData.setBackground(new java.awt.Color(204, 161, 234));
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Kategori", "Nama"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 930, 280));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Kategori");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 70, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 50, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ID Penelitian");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 140, 30));
        getContentPane().add(Kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 310, 40));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-minimize.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 30, 30));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-home.png"))); // NOI18N
        back.setText("jLabel2");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 6, 60, 60));

        btn_batal.setBackground(new java.awt.Color(204, 0, 204));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 120, 40));
        getContentPane().add(txt_idPenelitian, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 310, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Penelitian_Desain.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     
    
 
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        try{
            st = con.createStatement();
                    if(ambil_id.equals("")){
                        JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Akan Diperbarui");
                    }else{
                        st.executeUpdate("UPDATE `penelitian` SET "
                                + "`kategori_penelitian` = '"+Kategori.getText()+ "', "
                                + "`nama_penelitian` = '"+Nama.getText()+"' "
                                + "WHERE `penelitian`.`id_penelitian` = '"+ambil_id+"';");     
                        JOptionPane.showMessageDialog(null, " Data Berhasil Diperbarui");
                        Nama.setText("");
                        Kategori.setText("");
                        txt_idPenelitian.setText("");
                        txt_idPenelitian.setEditable(true);
                        ambil_id = "";
                        TampilData();
                    }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
            if ( ambil_id.equals("")){
                JOptionPane.showMessageDialog(this, "silahkan pilih data yang akan dihapus");
            }else{
                String[] opsi = {"YA" , "TIDAK"};
                int jawab = JOptionPane.showOptionDialog(null, 
                        "Apakah Anda Yakin Akan \nMenghapus Data Ini? \nID="+ambil_id, 
                        "Konfirmasi" ,
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);
                if ( jawab == JOptionPane.YES_OPTION ) {
                    try {
                        st =con.createStatement();
                        String sql = "DELETE FROM penelitian WHERE id_penelitian = '" + ambil_id +"';";
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                        st.close();
                        Nama.setText("");
                        Kategori.setText("");
                        txt_idPenelitian.setText("");
                        txt_idPenelitian.setEditable(true);
                        ambil_id = "";
                        TampilData ();  
                    }catch ( SQLException e){
                        JOptionPane.showMessageDialog(null, e);

                    }   
                }
            }           
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
         try {
            st = con.createStatement();
            if(txt_idPenelitian.getText().equals("") || Nama.getText().equals("") || Kategori.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus di terpenuhi!");
            }else{
                String sql1 = "SELECT * FROM `penelitian` WHERE `id_penelitian`='"+txt_idPenelitian.getText()+"';";
                java.sql.Connection con = (Connection)PrivateData.sambungDB();
                java.sql.PreparedStatement ps = con.prepareStatement(sql1);
                java.sql.ResultSet r = ps.executeQuery(sql1);
                if(r.next()){
                    JOptionPane.showMessageDialog(this, "Data Sudah Ada!");
                }else{
                    String sql = "INSERT INTO `penelitian` (`id_penelitian`, `kategori_penelitian`, `nama_penelitian`) VALUES ('"+txt_idPenelitian.getText()+"', '"+Kategori.getText()+"', '"+Nama.getText()+"');";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    Nama.setText("");
                    Kategori.setText("");
                    txt_idPenelitian.setText("");
                    txt_idPenelitian.setEditable(true);
                    ambil_id = "";
                    TampilData ();
                }
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, e);
     }
        
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:     
        Kategori.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        Nama.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        ambil_id = tblData.getValueAt(tblData.getSelectedRow(), 0).toString();
        txt_idPenelitian.setText(ambil_id);
        txt_idPenelitian.setEditable(false);
        
    }//GEN-LAST:event_tblDataMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        if(jenisAkun.equalsIgnoreCase("Administrator")){
            this.setVisible(false);
            new DashboardFrame().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Dosen")){
            this.setVisible(false);
            new DashboardFrame_Dosen().setVisible(true);
        }
    }//GEN-LAST:event_backMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        Nama.setText("");
        Kategori.setText("");
        ambil_id = "";
        txt_idPenelitian.setText("");
        txt_idPenelitian.setEditable(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(PenelitianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenelitianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenelitianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenelitianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenelitianFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Kategori;
    private javax.swing.JTextField Nama;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimize;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txt_idPenelitian;
    // End of variables declaration//GEN-END:variables
   
}
