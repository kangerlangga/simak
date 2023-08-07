/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
       
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class MahasiswaFrame_Admin extends javax.swing.JFrame {
    String ambil_id, sql;
    /**
     * Creates new form MahasiswaFrame_Dosen
     */
    public MahasiswaFrame_Admin() {   
        initComponents();
        kosong();
        TampilData();
    }
    
    private void kosong(){
        txt_nim.setEditable(true);
        txt_nim.setText("");
        txt_nama.setText("");
        txt_telpon.setText("");
        txt_alamat.setText("");
        combo_prodi.setSelectedIndex(0);
        ambil_id = "";
    }
    
    private void pilihData(){
        try{
            sql = "SELECT * FROM `mahasiswa` WHERE nim='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                txt_nim.setEditable(false);
                txt_nim.setText(r.getString("nim"));
                txt_nama.setText(r.getString("nama_mahasiswa"));
                txt_telpon.setText(r.getString("nomor_telp"));
                txt_alamat.setText(r.getString("alamat"));
                combo_prodi.setSelectedItem(r.getString("prodi_mhs"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void TampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Program Studi");
        model.addColumn("Alamat");
        model.addColumn("Telepon");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);
        try{
            String sqlTampilData = "SELECT * FROM `mahasiswa`";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlTampilData);
            while(rs.next()){
                model.addRow(
                new Object[] {
                    rs.getString("nim"), rs.getString("nama_mahasiswa"),
                    rs.getString("prodi_mhs"), rs.getString("alamat"), 
                    rs.getString("nomor_telp")
                }
                );
            }
            tabel_mhs.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void tambahData(){
        try{
            sql = "INSERT INTO `mahasiswa` "
                + "(`prodi_mhs`, `nim`, `nama_mahasiswa`, `alamat`, `nomor_telp`) VALUES "
                + "('"+combo_prodi.getSelectedItem()+"', "
                + "'"+txt_nim.getText()+"', "
                + "'"+txt_nama.getText()+"', "
                + "'"+txt_alamat.getText()+"', "
                + "'"+txt_telpon.getText()+"');";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil Ditambahkan");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Ditambahkan "+e);
        }
    }
    
    private void hapusData(){
        try{
            sql = "DELETE FROM `mahasiswa` WHERE `nim`='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil Dihapus");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dihapus "+e);
        }
    }
    
    private void editData(){
        try{
            sql = "UPDATE `mahasiswa` SET "
                + "`prodi_mhs` = '"+combo_prodi.getSelectedItem()+"', "
                + "`nama_mahasiswa` = '"+txt_nama.getText()+"', "
                + "`alamat` = '"+txt_alamat.getText()+"', "
                + "`nomor_telp` = '"+txt_telpon.getText()+"' "
                + "WHERE `mahasiswa`.`nim` = '"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Data Mahasiswa Berhasil Diperbarui");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Diperbarui "+e);
        }
    }
    
    private void cekDataMHS(){
        try{
            sql = "SELECT * FROM `mahasiswa` WHERE nim='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                JOptionPane.showMessageDialog(this, "Data Sudah Ada!");
            }else{
                String[] opsi = {"YA" , "TIDAK"};
                int jawab = JOptionPane.showOptionDialog(this,
                    "Apakah Data Sudah Benar?" ,
                    "Tambah Data",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);

                if (jawab == JOptionPane.YES_OPTION){
                    tambahData();
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        btn_kembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_mhs = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        minimize = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        txt_telpon = new javax.swing.JTextField();
        combo_prodi = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        lbl_absen = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        btn_rekap = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_kembali.setBackground(new java.awt.Color(255, 51, 51));
        btn_kembali.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_kembali.setForeground(new java.awt.Color(255, 255, 255));
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        tabel_mhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama Mahasiswa", "Program Studi", "Alamat", "Telepon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_mhs);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 457, 960, 230));

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-minimize.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIM");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Lengkap");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Program Studi");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alamat");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nomor Telepon");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 110, 30));

        txt_nim.setEditable(false);
        txt_nim.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 290, 30));

        txt_telpon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_telpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 280, 30));

        combo_prodi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combo_prodi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "TIF_SDA", "MID_SDA" }));
        jPanel1.add(combo_prodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 180, 30));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 0));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 120, 30));

        btn_perbarui.setBackground(new java.awt.Color(0, 255, 0));
        btn_perbarui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_perbarui, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 30));

        btn_hapus.setBackground(new java.awt.Color(255, 0, 0));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 120, 30));

        btn_batal.setBackground(new java.awt.Color(0, 0, 102));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 120, 30));

        lbl_absen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_absen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_absen.setText("DATA MAHASISWA POLIJE KAMPUS 4");
        jPanel1.add(lbl_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 152, 630, 60));

        txt_nama.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 290, 30));

        txt_alamat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 280, 30));

        btn_rekap.setBackground(new java.awt.Color(0, 51, 0));
        btn_rekap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_rekap.setForeground(new java.awt.Color(255, 255, 255));
        btn_rekap.setText("REKAP ABSENSI");
        btn_rekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rekapActionPerformed(evt);
            }
        });
        jPanel1.add(btn_rekap, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 200, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Mahasiswa_Desain.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here
        this.setVisible(false);
        new DashboardFrame().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if(txt_nim.getText().equals("") || txt_nama.getText().equals("") || txt_alamat.getText().equals("") || txt_telpon.getText().equals("") || combo_prodi.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(this, "Seluruh kolom harus di isi!");
        }else{
            ambil_id = txt_nim.getText();
            cekDataMHS();
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:
        if(ambil_id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data yang akan Diperbarui");
        }else{
            if(txt_nim.getText().equals("") || txt_nama.getText().equals("") || txt_alamat.getText().equals("") || txt_telpon.getText().equals("") || combo_prodi.getSelectedItem().equals("PILIH")){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus di isi!");
            }else{
                String[] opsi = {"YA" , "TIDAK"};
                int jawab = JOptionPane.showOptionDialog(this,
                    "Data Ini Akan Diperbarui?" ,
                    "Perbarui Data",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);

                if (jawab == JOptionPane.YES_OPTION){
                    editData();
                }
            }
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        if(ambil_id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data yang akan Dihapus");
        }else{
            String[] opsi = {"YA" , "TIDAK"};
            int jawab = JOptionPane.showOptionDialog(this,
                "Data Akan Dihapus?" ,
                "Hapus Data",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, opsi, opsi[1]);

            if (jawab == JOptionPane.YES_OPTION){
                hapusData();
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void tabel_mhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mhsMouseClicked
        // TODO add your handling code here:
        ambil_id = tabel_mhs.getValueAt(tabel_mhs.getSelectedRow(), 0).toString();
        pilihData();
    }//GEN-LAST:event_tabel_mhsMouseClicked

    private void btn_rekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rekapActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MahasiswaFrame_Rekap().setVisible(true);
    }//GEN-LAST:event_btn_rekapActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_rekap;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> combo_prodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_absen;
    private javax.swing.JLabel minimize;
    private javax.swing.JTable tabel_mhs;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_telpon;
    // End of variables declaration//GEN-END:variables
}
