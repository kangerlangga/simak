/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kevin
 */
public class MahasiswaFrame_Mhs extends javax.swing.JFrame {
private Statement st;
private Connection con;
private ResultSet rs;
String ambil_id, sql, matkul, idMatkul, idPtm;
    /**
     * Creates new form abscience
     */
    public MahasiswaFrame_Mhs() {
        initComponents();
        data_Matkul();
        kosong();
        dataLoginMHS();
        TampilData();
        cekProdiLoginMHS();
        combo_ptm.setEnabled(false);
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
    
    private void data_ptm(){
        try{
            sql = "SELECT * FROM `ptm_matkul` WHERE nama_matkul='"+matkul+"' AND status='BUKA';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
                while(r.next()){
                    combo_ptm.addItem(r.getString("judul_ptm"));
                    combo_ptm.setEnabled(true);
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void kosong(){
        try{
            sql = "SELECT * FROM `ptm_matkul` WHERE nama_matkul='"+matkul+"' AND status='BUKA';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                combo_ptm.setEnabled(false);
                combo_ptm.setSelectedIndex(0);
                combo_matkul.setSelectedIndex(0);
                combo_ptm.removeItem(r.getString("judul_ptm"));
                matkul = "";
                ambil_id = "";
                idMatkul = "";
                idPtm = "";
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cekKehadiran(){
        try{
            sql = "SELECT * FROM `absen_mhs` WHERE nim='"+txt_nim.getText()+"' AND nama_matkul='"+combo_matkul.getSelectedItem()+"' AND judul_ptm='"+combo_ptm.getSelectedItem()+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery(sql);
            if(r.next()){
                JOptionPane.showMessageDialog(this, "Anda Sudah Absen!");
            }else{
                String sql1 = "SELECT * FROM `ptm_matkul` WHERE judul_ptm='"+combo_ptm.getSelectedItem()+"' AND nama_matkul='"+combo_matkul.getSelectedItem()+"';";
                java.sql.Connection con1 = (Connection)PrivateData.sambungDB();
                java.sql.PreparedStatement ps1 = con.prepareStatement(sql1);
                java.sql.ResultSet r1 = ps1.executeQuery(sql1);
                if(r1.next()){
                    idMatkul = r1.getString("id_matkul");
                    idPtm = r1.getString("id_ptm");
                    String[] opsi = {"YA" , "TIDAK"};
                    int jawab = JOptionPane.showOptionDialog(this,
                        "Apakah Data Sudah Benar?" ,
                        "Submit Attendance",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);

                    if (jawab == JOptionPane.YES_OPTION){
                        tambahKehadiran();
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void tambahKehadiran(){
        try{
            String nim = PrivateData.get_user_id();
            String idAbsensi = nim + idMatkul + idPtm;
            sql = "INSERT INTO `absen_mhs` (`id_absen_mhs`, `nim`, `nama_mhs`, `id_matkul`, `nama_matkul`, "
                + "`id_ptm`, `judul_ptm`, `waktu_absen`, `keterangan`) VALUES "
                + "('"+idAbsensi+"', "
                + "'"+txt_nim.getText()+"', "
                + "'"+txt_nama.getText()+"', "
                + "'"+idMatkul+"', "
                + "'"+combo_matkul.getSelectedItem()+"', "
                + "'"+idPtm+"', "
                + "'"+combo_ptm.getSelectedItem()+"', "
                + "current_timestamp(), 'HADIR');";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(this, "Kehadiran Berhasil Dikirim");
            kosong();
            TampilData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Dikirim "+e);
        }
    }
    
    private void TampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Mata Kuliah");
        model.addColumn("Judul Pertemuan");
        model.addColumn("Waktu");
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);
        try{
            String sqlTampilData = "SELECT * FROM `absen_mhs` WHERE nim='"+PrivateData.get_user_id()+"'";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sqlTampilData);
            while(rs.next()){
                model.addRow(
                new Object[] {
                    rs.getString("nama_mhs"), rs.getString("nama_matkul"),
                    rs.getString("judul_ptm"), rs.getString("waktu_absen")
                }
                );
            }
            tabel_absen.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void dataLoginMHS(){
        try{
            sql = "SELECT * FROM `mahasiswa` WHERE nim='"+PrivateData.get_user_id()+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                txt_nim.setText(rs.getString("nim"));
                txt_nama.setText(rs.getString("nama_mahasiswa"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void cekProdiLoginMHS(){
        try{
            sql = "SELECT * FROM `mahasiswa` WHERE nim='"+PrivateData.get_user_id()+"';";
            java.sql.Connection con = (Connection)PrivateData.sambungDB();
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                String prodiLogin = rs.getString("prodi_mhs");
                if(prodiLogin.equals("TIF_SDA")){
                    lbl_absen.setText("ABSENSI MAHASISWA TEKNIK INFORMATIKA");
                }else if(prodiLogin.equals("MID_SDA")){
                    lbl_absen.setText("ABSENSI MAHASISWA MANAJEMEN AGROINDUSTRI");
                }else{
                    JOptionPane.showMessageDialog(null, "Prodi Tidak Ditemukan");
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
        minimize = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_absen = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jLabel5 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        lbl_absen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combo_matkul = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        combo_ptm = new javax.swing.JComboBox<>();
        btn_Submit = new javax.swing.JButton();
        btn_cekDataPTM = new javax.swing.JButton();
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

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icon-minimize.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 30, 30));

        tabel_absen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Mahasiswa", "Mata Kuliah", "Judul Pertemuan", "Waktu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_absen);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 457, 960, 230));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REKAP RIWAYAT KEHADIRAN MAHASISWA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 960, 30));

        txt_nim.setEditable(false);
        txt_nim.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 350, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Lengkap");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 120, 30));

        txt_nama.setEditable(false);
        txt_nama.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 350, 30));

        lbl_absen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_absen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_absen.setText("ABSENSI MAHASISWA MANAJEMEN AGROINDUSTRI");
        jPanel1.add(lbl_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 152, 630, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mata Kuliah");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 220, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nomor Induk Mahasiswa");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 220, 30));

        combo_matkul.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combo_matkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        jPanel1.add(combo_matkul, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 350, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pertemuan");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 220, 30));

        combo_ptm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combo_ptm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        jPanel1.add(combo_ptm, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 350, 30));

        btn_Submit.setBackground(new java.awt.Color(0, 51, 0));
        btn_Submit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_Submit.setText("SUBMIT ATTENDANCE");
        btn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 350, 30));

        btn_cekDataPTM.setBackground(new java.awt.Color(102, 0, 102));
        btn_cekDataPTM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cekDataPTM.setForeground(new java.awt.Color(255, 255, 255));
        btn_cekDataPTM.setText("CEK DATA PERTEMUAN");
        btn_cekDataPTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekDataPTMActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cekDataPTM, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 210, 30));

        btn_batal.setBackground(new java.awt.Color(0, 0, 102));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 120, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Mahasiswa_Desain.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here
        this.setVisible(false);
        new DashboardFrame_Mhs().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void btn_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitActionPerformed
        // TODO add your handling code here:
        if(combo_matkul.getSelectedItem().equals("PILIH") || combo_ptm.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(this, "Pastikan Seluruh Kolom sudah Terisi!");
        }else{
            cekKehadiran();
        }
    }//GEN-LAST:event_btn_SubmitActionPerformed

    private void btn_cekDataPTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekDataPTMActionPerformed
        // TODO add your handling code here:
        if(combo_matkul.getSelectedItem().equals("PILIH")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Mata Kuliah Terlebih Dahulu!");
        }else{
            matkul = combo_matkul.getSelectedItem().toString();
            data_ptm();
        }
    }//GEN-LAST:event_btn_cekDataPTMActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame_Mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame_Mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_Submit;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_cekDataPTM;
    private javax.swing.JButton btn_kembali;
    private javax.swing.JComboBox<String> combo_matkul;
    private javax.swing.JComboBox<String> combo_ptm;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_absen;
    private javax.swing.JLabel minimize;
    private javax.swing.JTable tabel_absen;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
}
