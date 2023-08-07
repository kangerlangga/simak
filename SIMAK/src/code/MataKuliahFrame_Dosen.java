/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kevin
 */
public class MataKuliahFrame_Dosen extends javax.swing.JFrame {
String ambil_id = "", sql, programStudi;
String jenisAkun = PrivateData.get_jenisAkun();
    /**
     * Creates new form tabel_matkulz
     */
    public MataKuliahFrame_Dosen() {
        initComponents();
        kosong();
        cekDataLogin();
    }
    
    private void cekDataLogin(){
        String prodi = "";
        prodi = PrivateData.get_akunLogin();
        if(prodi.equalsIgnoreCase("TIF_SDA")){
            lbl_matkul.setText("MATA KULIAH TEKNIK INFORMATIKA");
            combo_prodi.setSelectedItem("TIF_SDA");
            combo_prodi.setEnabled(false);
            Tampildata_TIFSDA();
        }else if(prodi.equalsIgnoreCase("MID_SDA")){
            lbl_matkul.setText("MATA KULIAH MANAJEMEN AGROINDUSTRI");
            combo_prodi.setSelectedItem("MID_SDA");
            combo_prodi.setEnabled(false);
            Tampildata_MIDSDA();
        }else if(prodi.equalsIgnoreCase("admin")){
            lbl_matkul.setText("DAFTAR MATA KULIAH POLIJE KAMPUS 4");
            Tampildata();
        }else{
            JOptionPane.showMessageDialog(null, "Akun Tidak Ditemukan");
        }
    }
    
    private void Tampildata() {
        try {
            String sqlTIFSDA = "SELECT * FROM `mata_kuliah`";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlTIFSDA);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Matkul");
            model.addColumn("Nama Matkul");
            model.addColumn("Ruang Matkul");
            model.addColumn("Durasi Matkul");
           
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()){
                Object [] data = {
                    rs.getString("id_matkul"),rs.getString("nama_matkul"),rs.getString("ruang_matkul"),rs.getString("durasi_matkul")};
                model.addRow(data);
                tabel_matkul.setModel(model);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void Tampildata_TIFSDA() {
        try {
            String sqlTIFSDA = "SELECT * FROM `mata_kuliah` WHERE `matkul_prodi`='TIF_SDA';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlTIFSDA);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Matkul");
            model.addColumn("Nama Matkul");
            model.addColumn("Ruang Matkul");
            model.addColumn("Durasi Matkul");
           
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()){
                Object [] data = {
                    rs.getString("id_matkul"),rs.getString("nama_matkul"),rs.getString("ruang_matkul"),rs.getString("durasi_matkul")};
                model.addRow(data);
                tabel_matkul.setModel(model);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void Tampildata_MIDSDA() {
        try {
            String sqlMIDSDA="SELECT * FROM `mata_kuliah` WHERE `matkul_prodi`='MID_SDA';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlMIDSDA);
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Matkul");
            model.addColumn("Nama Matkul");
            model.addColumn("Ruang Matkul");
            model.addColumn("Durasi Matkul");
           
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()){
                Object [] data = {
                    rs.getString("id_matkul"),rs.getString("nama_matkul"),rs.getString("ruang_matkul"),rs.getString("durasi_matkul")};
                model.addRow(data);
                tabel_matkul.setModel(model);
           
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
     
    private void kosong(){
        txt_idMatkul.setEditable(true);
        txt_idMatkul.setText("");
        txt_namaMatkul.setText("");
        txt_ruangMatkul.setText("");
        txt_durasiMatkul.setText("");
        combo_prodi.setSelectedIndex(0);
        ambil_id = "";
    }
    
    private void pilihData(){
        try{
            sql = "SELECT * FROM `mata_kuliah` WHERE id_matkul='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                txt_idMatkul.setEditable(false);
                txt_idMatkul.setText(r.getString("id_matkul"));
                txt_namaMatkul.setText(r.getString("nama_matkul"));
                txt_ruangMatkul.setText(r.getString("ruang_matkul"));
                txt_durasiMatkul.setText(r.getString("durasi_matkul"));
                combo_prodi.setSelectedItem(r.getString("matkul_prodi"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void tambahData(){
        try{
            sql = "INSERT INTO `mata_kuliah` "
                + "(`id_matkul`, `matkul_prodi`, `nama_matkul`, `ruang_matkul`, `durasi_matkul`) VALUES "
                + "('"+txt_idMatkul.getText()+"', "
                + "'"+combo_prodi.getSelectedItem()+"', "
                + "'"+txt_namaMatkul.getText()+"', "
                + "'"+txt_ruangMatkul.getText()+"', "
                + "'"+txt_durasiMatkul.getText()+"');";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Mata Kuliah Berhasil Ditambahkan");
            kosong();
            Tampildata();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Ditambahkan "+e);
        }
    }
    
    private void hapusData(){
        try{
            sql = "DELETE FROM `mata_kuliah` WHERE `id_matkul`='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Mata Kuliah Berhasil Dihapus");
            kosong();
            Tampildata();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dihapus "+e);
        }
    }
    
    private void editData(){
        try{
            sql = "UPDATE `mata_kuliah` SET "
                + "`matkul_prodi` = '"+combo_prodi.getSelectedItem()+"', "
                + "`nama_matkul` = '"+txt_namaMatkul.getText()+"', "
                + "`ruang_matkul` = '"+txt_ruangMatkul.getText()+"', "
                + "`durasi_matkul` = '"+txt_durasiMatkul.getText()+"' "
                + "WHERE `mata_kuliah`.`id_matkul` = '"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Mata Kuliah Berhasil Diperbarui");
            kosong();
            Tampildata();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Diperbarui "+e);
        }
    }
    
     private void cekDataMatkul(){
        try{
            sql = "SELECT * FROM `mata_kuliah` WHERE id_matkul='"+ambil_id+"';";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_matkul = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        btn_kembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_idMatkul = new javax.swing.JTextField();
        txt_namaMatkul = new javax.swing.JTextField();
        txt_ruangMatkul = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_durasiMatkul = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_prodi = new javax.swing.JComboBox<>();
        lbl_matkul = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_matkul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Matkul", "Ruang Matkul", "Durasi Matkul"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_matkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_matkulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_matkul);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 960, 250));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prodi Mata Kuliah");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 160, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nama Mata Kuliah");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ruang Mata Kuliah");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 150, 30));

        txt_idMatkul.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(txt_idMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 310, 30));

        txt_namaMatkul.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(txt_namaMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 310, 30));

        txt_ruangMatkul.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(txt_ruangMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 310, 30));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 0));
        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, 120, 30));

        btn_perbarui.setBackground(new java.awt.Color(0, 255, 0));
        btn_perbarui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_perbarui, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 120, 30));

        btn_hapus.setBackground(new java.awt.Color(255, 0, 0));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 120, 30));

        btn_batal.setBackground(new java.awt.Color(0, 0, 102));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 120, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Durasi Mata Kuliah");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 150, 30));

        txt_durasiMatkul.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jPanel1.add(txt_durasiMatkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 310, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Mata Kuliah");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 150, 30));

        combo_prodi.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        combo_prodi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "TIF_SDA", "MID_SDA" }));
        jPanel1.add(combo_prodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 140, 30));

        lbl_matkul.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbl_matkul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_matkul.setText("DAFTAR MATA KULIAH POLIJE KAMPUS 4");
        jPanel1.add(lbl_matkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 630, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/MataKuliah_Desain_Dosen.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here
        if(jenisAkun.equalsIgnoreCase("Administrator")){
            this.setVisible(false);
            new DashboardFrame().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Dosen")){
            this.setVisible(false);
            new DashboardFrame_Dosen().setVisible(true);
        }
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if(txt_idMatkul.getText().equals("") || txt_namaMatkul.getText().equals("") || txt_ruangMatkul.getText().equals("") || txt_durasiMatkul.getText().equals("") || combo_prodi.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(this, "Seluruh kolom harus di isi!");
        }else{
            ambil_id = txt_idMatkul.getText();
            cekDataMatkul();
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:
        if(ambil_id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data yang akan Diperbarui");
        }else{
            if(txt_idMatkul.getText().equals("") || txt_namaMatkul.getText().equals("") || txt_ruangMatkul.getText().equals("") || txt_durasiMatkul.getText().equals("") || combo_prodi.getSelectedItem().equals("PILIH")){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus di terisi!");
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

    private void tabel_matkulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_matkulMouseClicked
        // TODO add your handling code here:
        ambil_id = tabel_matkul.getValueAt(tabel_matkul.getSelectedRow(), 0).toString();
        pilihData();
    }//GEN-LAST:event_tabel_matkulMouseClicked

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
            java.util.logging.Logger.getLogger(MataKuliahFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MataKuliahFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MataKuliahFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MataKuliahFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MataKuliahFrame_Dosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> combo_prodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_matkul;
    private javax.swing.JTable tabel_matkul;
    private javax.swing.JTextField txt_durasiMatkul;
    private javax.swing.JTextField txt_idMatkul;
    private javax.swing.JTextField txt_namaMatkul;
    private javax.swing.JTextField txt_ruangMatkul;
    // End of variables declaration//GEN-END:variables
}
