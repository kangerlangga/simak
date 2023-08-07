/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Erlangga Lesmana P
 */
class PrivateData {
    
    //private Connection con;
    
    //Kumpulan Variabel Private untuk menyimpan data tertentu
    private static String user_id;
    private static String nama;
    private static String jenisAkun;
    private static String pass_mahasiswa = "polijekampus4";
    private static String pass_dosen = "dosen@polije";
    private static String urlDB = "jdbc:mysql://localhost:3306/simak";
    private static String userDB = "root";
    private static String passDB = "";
    private static String akun_login;
    
    //Method khusus untuk MENGAMBIL data akun Login Database MYSQL(Offline)
    protected static String get_urlDB(){
        return urlDB;
    }
    protected static String get_userDB(){
        return userDB;
    }
    protected static String get_passDB(){
        return passDB;
    }
    
    //==========================================================================
    
    //Method khusus untuk mengambil data password pada login Aplikasi
    protected static String get_pass_mahasiswa(){
        return pass_mahasiswa;
    }
    
    protected static String get_pass_dosen(){
        return pass_dosen;
    }
    //==========================================================================
    
    //Method khusus untuk MENGAMBIL data user yang telah tersimpan
    //Untuk Kebutuhan di Frame lain dalam Package yang sama
    //Data user yang telah tersimpan pada variabel didalam class ini
    protected static String get_user_id(){
        return user_id;
    }
    
    protected static String get_nama(){
        return nama;
    }
    
    protected static String get_jenisAkun(){
        return jenisAkun;
    }
    
    protected static String get_akunLogin(){
        return akun_login;
    }
    //==========================================================================
    
    //Method khusus untuk MENYIMPAN data user yang telah berhasil login
    //Data user akan disimpan di variabel private didalam class ini
    protected static void set_user_id(String user_id1){
        PrivateData.user_id = user_id1;
    }
     
    protected static void set_nama(String nama1){
        PrivateData.nama = nama1;
    }
    
    protected static void set_jenisAkun(String jenisAkun1){
        PrivateData.jenisAkun = jenisAkun1;
    }
    
    protected static void set_akunLogin(String akun_login1){
        PrivateData.akun_login = akun_login1;
    }
    //==========================================================================
     
    //Sambung Database Lokal
    private static Connection MySQLConfig;
        protected static Connection sambungDB() throws SQLException{
            try{
                String url = urlDB; //URL letak Database
                String pengguna = userDB; //user untuk login Database
                String pass = passDB;
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                MySQLConfig = DriverManager.getConnection(url, pengguna, pass);
            }catch(SQLException e){
                System.err.println("Koneksi Gagal "+e.getMessage());
            }
            return MySQLConfig;
        }
}
