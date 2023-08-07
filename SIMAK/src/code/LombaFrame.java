/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package code;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author Lenovo
 */
public class LombaFrame extends javax.swing.JFrame {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    String ambil_id = "";
    String jenisAkun = PrivateData.get_jenisAkun();
    
    /**
     * Creates new form NewJFrame
     */
    public LombaFrame() {
        initComponents();
        sambungDB();
        TampilData();
    }
   
    //Sambung Database Lokal
     private void sambungDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Menentukan Driver untuk tersambung ke Database
            String url = PrivateData.get_urlDB(); //URL letak Database
            String pengguna = PrivateData.get_userDB(); //user untuk login Database
            String pass = PrivateData.get_passDB();
            
            con = DriverManager.getConnection(url, pengguna, pass); //Untuk menyambungkan Driver ke Database
            System.out.println("Aplikasi Berhasil Tersambung ke Database Lokal"); //Menampilkan pesan berhasil
        } catch (Exception e) {
            System.out.println("Database GAGAL Tersambung " + e.getMessage()); //Menampilkan pesan gagal
        }
    }
    private void TampilData(){
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `lomba`");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID LOMBA");
            model.addColumn("KATEGORI LOMBA");
            model.addColumn("NAMA LOMBA");
            model.addColumn("TANGGAL");
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            
            while (rs.next()) {
                    Object[] data = {
                        rs.getString("id_lomba"),rs.getString("kategori_lomba"),rs.getString("nama_lomba"),rs.getString("tanggal")};
                    model.addRow(data);
                    tabel_lomba.setModel(model);
            
                
            }
            
        }catch (Exception e){
            
            
        }
    }
    
    private void kosong(){
        id_lomba.setText("");
        kategori_lomba.setText("");
        nama_lomba.setText("");
        date_tgl.setDate(null);
        id_lomba.setEditable(true);
        ambil_id = "";
        tanggal_pertemuan = "";
    }
    
    String formatTGL = "yyyy-MM-dd";
    SimpleDateFormat fm = new SimpleDateFormat(formatTGL);
    String tanggal_pertemuan;
    
    public static java.util.Date getTanggal(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        java.util.Date tgl = null;
        try{
            tgl = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }catch(Exception e){
            System.out.println("Error GetTanggal "+e);
        }
        return tgl;
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
        Beranda2 = new javax.swing.JLabel();
        BERANDA1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabel_lomba = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        btn_batal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        nama_lomba = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        kategori_lomba = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        id_lomba = new javax.swing.JTextArea();
        date_tgl = new com.toedter.calendar.JDateChooser();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Beranda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Beranda2MouseClicked(evt);
            }
        });
        jPanel1.add(Beranda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 30, 30));

        BERANDA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BERANDA1MouseClicked(evt);
            }
        });
        jPanel1.add(BERANDA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 140, 40));

        tabel_lomba.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID_LOMBA", "KATEGORI_LOMBA", "NAMA_LOMBA", "TANGGAL"
            }
        ));
        tabel_lomba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_lombaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabel_lomba);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 510, 970, 180));

        btn_batal.setBackground(new java.awt.Color(102, 0, 255));
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 110, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 50));

        btn_tambah.setBackground(new java.awt.Color(102, 0, 255));
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 40));

        btn_perbarui.setBackground(new java.awt.Color(102, 0, 255));
        btn_perbarui.setForeground(new java.awt.Color(255, 255, 255));
        btn_perbarui.setText("PERBARUI");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_perbarui, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 40));

        btn_hapus.setBackground(new java.awt.Color(102, 0, 255));
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 40));

        nama_lomba.setColumns(20);
        nama_lomba.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nama_lomba.setRows(5);
        jScrollPane3.setViewportView(nama_lomba);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, 150));

        kategori_lomba.setColumns(20);
        kategori_lomba.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        kategori_lomba.setRows(5);
        jScrollPane2.setViewportView(kategori_lomba);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 170, 150));

        id_lomba.setColumns(20);
        id_lomba.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id_lomba.setRows(5);
        jScrollPane1.setViewportView(id_lomba);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 180, 150));

        date_tgl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(date_tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 170, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Lomba_Desain.png"))); // NOI18N
        bg.setText("jLabel1");
        bg.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1250, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        try {
            tanggal_pertemuan = String.valueOf(fm.format(date_tgl.getDate()));
            st = con.createStatement();
            if(id_lomba.getText().equals("") || nama_lomba.getText().equals("") || kategori_lomba.getText().equals("") || date_tgl.getDate()==null){
                JOptionPane.showMessageDialog(this, "Seluruh kolom harus di terpenuhi!");
            }else{
                String sql1 = "SELECT * FROM `lomba` WHERE `id_lomba`='"+id_lomba.getText()+"';";
                java.sql.Connection con = (Connection)PrivateData.sambungDB();
                java.sql.PreparedStatement ps = con.prepareStatement(sql1);
                java.sql.ResultSet r = ps.executeQuery(sql1);
                if(r.next()){
                    JOptionPane.showMessageDialog(this, "Data Sudah Ada!");
                }else{
                    String sql = "INSERT INTO `lomba` "
                            + "(`id_lomba`, `kategori_lomba`, `nama_lomba`, `tanggal`) VALUES "
                            + "('"+id_lomba.getText()+"', "
                            + "'"+kategori_lomba.getText()+"', "
                            + "'"+nama_lomba.getText()+"', "
                            + "'"+tanggal_pertemuan+"');";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    kosong();
                    TampilData ();
                }        
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, e);
     }
        
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:
        try{
            tanggal_pertemuan = String.valueOf(fm.format(date_tgl.getDate()));
            st = con.createStatement();
                    if(ambil_id.equals("")){
                        JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Akan Diperbarui");
                    }else{
                        st.executeUpdate("UPDATE `lomba` SET "
                                + "`kategori_lomba` = '"+kategori_lomba.getText()+ "', "
                                + "`tanggal` = '"+tanggal_pertemuan+ "', "
                                + "`nama_lomba` = '"+nama_lomba.getText()+"' "
                                + "WHERE `lomba`.`id_lomba` = '"+ambil_id+"';");     
                        JOptionPane.showMessageDialog(null, " Data Berhasil Diperbarui");
                        kosong();
                        TampilData();
                    }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
            if ( ambil_id.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Yang Akan Dihapus");
            }else{
                String[] opsi = {"YA" , "TIDAK"};
                int jawab = JOptionPane.showOptionDialog(null, 
                        "Apakah Anda Yakin Akan \nMenghapus Data Ini?", 
                        "Konfirmasi" ,
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, opsi, opsi[1]);
                if ( jawab == JOptionPane.YES_OPTION ) {
                    try {
                        st =con.createStatement();
                        st.executeUpdate("DELETE FROM `lomba` WHERE `id_lomba`='"+ambil_id+"';");
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                        st.close();
                        kosong();
                        TampilData();

                    }catch ( SQLException e){
                        JOptionPane.showMessageDialog(null, e);

                    }   
                }
            }     
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void BERANDA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BERANDA1MouseClicked
        // TODO add your handling code here:
        if(jenisAkun.equalsIgnoreCase("Administrator")){
            this.setVisible(false);
            new DashboardFrame().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Dosen")){
            this.setVisible(false);
            new DashboardFrame_Dosen().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Mahasiswa")){
            this.setVisible(false);
            new DashboardFrame_Mhs().setVisible(true);
        }
    }//GEN-LAST:event_BERANDA1MouseClicked

    private void Beranda2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Beranda2MouseClicked
        // TODO add your handling code here:
        if(jenisAkun.equalsIgnoreCase("Administrator")){
            this.setVisible(false);
            new DashboardFrame().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Dosen")){
            this.setVisible(false);
            new DashboardFrame_Dosen().setVisible(true);
        }else if(jenisAkun.equalsIgnoreCase("Mahasiswa")){
            this.setVisible(false);
            new DashboardFrame_Mhs().setVisible(true);
        }
    }//GEN-LAST:event_Beranda2MouseClicked

    private void tabel_lombaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_lombaMouseClicked
        // TODO add your handling code here:
        ambil_id= tabel_lomba.getValueAt(tabel_lomba.getSelectedRow(), 0).toString();
        id_lomba.setText(ambil_id);
        id_lomba.setEditable(false);
        kategori_lomba.setText(tabel_lomba.getValueAt(tabel_lomba.getSelectedRow(), 1).toString());
        nama_lomba.setText(tabel_lomba.getValueAt(tabel_lomba.getSelectedRow(), 2).toString());
        date_tgl.setDate(getTanggal(tabel_lomba, 3));
    }//GEN-LAST:event_tabel_lombaMouseClicked

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
            java.util.logging.Logger.getLogger(LombaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LombaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LombaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LombaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LombaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BERANDA1;
    private javax.swing.JLabel Beranda2;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private com.toedter.calendar.JDateChooser date_tgl;
    private javax.swing.JTextArea id_lomba;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea kategori_lomba;
    private javax.swing.JTextArea nama_lomba;
    private javax.swing.JTable tabel_lomba;
    // End of variables declaration//GEN-END:variables
}