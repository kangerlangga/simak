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
public class MahasiswaFrame_Dosen extends javax.swing.JFrame {
    String ambil_id, id_matkul, sql, prodi;
    /**
     * Creates new form MahasiswaFrame_Dosen
     */
    public MahasiswaFrame_Dosen() {   
        initComponents();
        kosong();
        data_Matkul();
        TampilData();
        cekDataLogin();
    }
    
    String formatTGL = "yyyy-MM-dd";
    SimpleDateFormat fm = new SimpleDateFormat(formatTGL);
    String tanggal_pertemuan;
    
    public static Date getTanggal(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tgl = null;
        try{
            tgl = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(Exception e){
            System.out.println("Error GetTanggal "+e);
        }
        return tgl;
    }
    
    private void cekDataLogin(){
        String prodi = "";
        prodi = PrivateData.get_akunLogin();
        if(prodi.equalsIgnoreCase("TIF_SDA")){
            lbl_absen.setText("ABSENSI MAHASISWA TEKNIK INFORMATIKA");
        }else if(prodi.equalsIgnoreCase("MID_SDA")){
            lbl_absen.setText("ABSENSI MAHASISWA MANAJEMEN AGROINDUSTRI");
        }else if(prodi.equalsIgnoreCase("admin")){
            lbl_absen.setText("DATA PERTEMUAN MAHASISWA");
        }else{
            JOptionPane.showMessageDialog(null, "Akun Tidak Ditemukan");
        }
    }
    
    private void kosong(){
        combo_matkul.setEnabled(true);
        btn_buatID.setEnabled(true);
        txt_idPertemuan.setText("");
        txt_judulptm.setText("");
        combo_status.setSelectedIndex(0);
        combo_matkul.setSelectedIndex(0);
        spin_ptmke.setValue(0);
        date_tgl.setDate(null);
        tanggal_pertemuan = "";
        ambil_id = "";
        id_matkul = "";
    }
    
    private void data_Matkul(){
        try{
            sql = "SELECT * FROM `mata_kuliah` WHERE matkul_prodi='"+PrivateData.get_akunLogin()+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            while(r.next()){
                combo_matkul.addItem(r.getString("nama_matkul"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void generate_id(){
        try{
            sql = "SELECT * FROM `mata_kuliah` WHERE nama_matkul='"+combo_matkul.getSelectedItem()+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                id_matkul = r.getString("id_matkul");
                txt_idPertemuan.setText(id_matkul+"_PTM"+spin_ptmke.getValue());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void pilihData(){
        try{
            sql = "SELECT * FROM `ptm_matkul` WHERE id_ptm='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                combo_matkul.setEnabled(false);
                txt_idPertemuan.setText(r.getString("id_ptm"));
                txt_judulptm.setText(r.getString("judul_ptm"));
                date_tgl.setDate(getTanggal(tabel_pertemuan, 4));
                combo_matkul.setSelectedItem(r.getString("nama_matkul"));
                int ptmke = Integer.parseInt(r.getString("ptm_ke"));
                spin_ptmke.setValue(ptmke);
                combo_status.setSelectedItem(r.getString("status"));
                btn_buatID.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void TampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pertemuan");
        model.addColumn("Judul Pertemuan");
        model.addColumn("Mata Kuliah");
        model.addColumn("Pertemuan ke");
        model.addColumn("Tanggal");
        model.addColumn("Status Absensi");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);
        try{
            String sqlTampilData = "SELECT * FROM `ptm_matkul`";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlTampilData);
            while(rs.next()){
                model.addRow(
                new Object[] {
                    rs.getString("id_ptm"), rs.getString("judul_ptm"), rs.getString("nama_matkul"),
                    rs.getString("ptm_ke"), rs.getString("tgl_ptm"), 
                    rs.getString("status")
                }
                );
            }
            tabel_pertemuan.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void tambahData(){
        try{
            tanggal_pertemuan = String.valueOf(fm.format(date_tgl.getDate()));
            sql = "INSERT INTO `ptm_matkul` "
                + "(`id_ptm`, `judul_ptm`, `id_matkul`, `nama_matkul`, `id_dosen`, "
                + "`nama_dosen`, `ptm_ke`, `tgl_ptm`, `status`) VALUES "
                + "('"+txt_idPertemuan.getText()+"', "
                + "'"+txt_judulptm.getText()+"', "
                + "'"+id_matkul+"', "
                + "'"+combo_matkul.getSelectedItem()+"', "
                + "'"+PrivateData.get_user_id()+"', "
                + "'"+PrivateData.get_nama()+"', "
                + "'"+spin_ptmke.getValue()+"', "
                + "'"+tanggal_pertemuan+"', "
                + "'"+combo_status.getSelectedItem()+"');";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Absensi Berhasil Ditambahkan");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Ditambahkan "+e);
        }
    }
    
    private void hapusData(){
        try{
            sql = "DELETE FROM `ptm_matkul` WHERE `id_ptm`='"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Absensi Berhasil Dihapus");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dihapus "+e);
        }
    }
    
    private void editData(){
        try{
            tanggal_pertemuan = String.valueOf(fm.format(date_tgl.getDate()));
            sql = "UPDATE `ptm_matkul` SET "
                + "`judul_ptm` = '"+txt_judulptm.getText()+"', "
                + "`ptm_ke` = '"+spin_ptmke.getValue()+"', "
                + "`tgl_ptm` = '"+tanggal_pertemuan+"', "
                + "`status` = '"+combo_status.getSelectedItem()+"' "
                + "WHERE `ptm_matkul`.`id_ptm` = '"+ambil_id+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Absensi Berhasil Diperbarui");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Diperbarui "+e);
        }
    }
    
    private void cekDataPTM(){
        try{
            sql = "SELECT * FROM `ptm_matkul` WHERE id_ptm='"+ambil_id+"';";
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
        tabel_pertemuan = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        minimize = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_idPertemuan = new javax.swing.JTextField();
        txt_judulptm = new javax.swing.JTextField();
        combo_status = new javax.swing.JComboBox<>();
        date_tgl = new com.toedter.calendar.JDateChooser();
        spin_ptmke = new javax.swing.JSpinner();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_buatID = new javax.swing.JButton();
        btn_rekap = new javax.swing.JButton();
        combo_matkul = new javax.swing.JComboBox<>();
        lbl_absen = new javax.swing.JLabel();
        btn_batal = new javax.swing.JButton();
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

        tabel_pertemuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pertemuan", "Judul Pertemuan", "Mata Kuliah", "Pertemuan ke", "Tanggal", "Status Absensi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_pertemuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pertemuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pertemuan);

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
        jLabel5.setText("ID Pertemuan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 120, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Judul Pertemuan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 120, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mata Kuliah");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 120, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status Absensi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pertemuan ke");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 110, 30));

        txt_idPertemuan.setEditable(false);
        txt_idPertemuan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_idPertemuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 210, 30));

        txt_judulptm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_judulptm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 350, 30));

        combo_status.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH", "BUKA", "TUTUP" }));
        jPanel1.add(combo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 180, 30));

        date_tgl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(date_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 180, 30));

        spin_ptmke.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        spin_ptmke.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        jPanel1.add(spin_ptmke, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, 27));

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

        btn_buatID.setBackground(new java.awt.Color(102, 0, 102));
        btn_buatID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_buatID.setForeground(new java.awt.Color(255, 255, 255));
        btn_buatID.setText("BUAT ID");
        btn_buatID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buatIDActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buatID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 120, 30));

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

        combo_matkul.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combo_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        jPanel1.add(combo_matkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 350, 30));

        lbl_absen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_absen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_absen.setText("ABSENSI MAHASISWA MANAJEMEN AGROINDUSTRI");
        jPanel1.add(lbl_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 152, 630, 60));

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
        new DashboardFrame_Dosen().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        if(txt_idPertemuan.getText().equals("") || txt_judulptm.getText().equals("") || combo_matkul.getSelectedItem().equals("PILIH") || spin_ptmke.getValue().equals(0) || date_tgl.getDate()==null || combo_status.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(this, "Seluruh kolom harus di isi!");
        }else{
            ambil_id = txt_idPertemuan.getText();
            cekDataPTM();
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:
        if(ambil_id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data yang akan Diperbarui");
        }else{
            if(txt_idPertemuan.getText().equals("") || txt_judulptm.getText().equals("") || combo_matkul.getSelectedItem().equals("PILIH") || spin_ptmke.getValue().equals(0) || date_tgl.getDate()==null || combo_status.getSelectedItem().equals("PILIH")){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus terisi!");
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

    private void btn_buatIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buatIDActionPerformed
        // TODO add your handling code here:
        if(combo_matkul.getSelectedItem().equals("PILIH") || spin_ptmke.getValue().equals(0)){
            JOptionPane.showMessageDialog(this, "Kolom Mata Kuliah dan Pertemuan Harus di isi!");
        }else{
            generate_id();
        }
    }//GEN-LAST:event_btn_buatIDActionPerformed

    private void btn_rekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rekapActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MahasiswaFrame_Rekap().setVisible(true);
    }//GEN-LAST:event_btn_rekapActionPerformed

    private void tabel_pertemuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pertemuanMouseClicked
        // TODO add your handling code here:
        ambil_id = tabel_pertemuan.getValueAt(tabel_pertemuan.getSelectedRow(), 0).toString();
        pilihData();
    }//GEN-LAST:event_tabel_pertemuanMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_batalActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Dosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MahasiswaFrame_Dosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_buatID;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_rekap;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> combo_matkul;
    private javax.swing.JComboBox<String> combo_status;
    private com.toedter.calendar.JDateChooser date_tgl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_absen;
    private javax.swing.JLabel minimize;
    private javax.swing.JSpinner spin_ptmke;
    private javax.swing.JTable tabel_pertemuan;
    private javax.swing.JTextField txt_idPertemuan;
    private javax.swing.JTextField txt_judulptm;
    // End of variables declaration//GEN-END:variables
}
