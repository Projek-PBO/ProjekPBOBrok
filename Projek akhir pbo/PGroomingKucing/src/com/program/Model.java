package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;

public class Model {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbgroomingkucing";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connect;
    private static Statement statement;

    private static void connection(){

        try {

            connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean cekLogin(String username, String password){

        connection();
        
        boolean cekLog = false;

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM akun WHERE username = '" + username + "' AND password = '" + password + "'";

            ResultSet resultdata = statement.executeQuery(query);

            resultdata.next();
            if(resultdata.getString("username").equals(username) && resultdata.getString("password").equals(password)){
                cekLog = true;
            }
            
            connect.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return cekLog;
    }

    public static String ambilId(String username, String password){

        connection();
        
        String idid = "";

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM akun WHERE username = '" + username + "' AND password = '" + password + "'";

            ResultSet resultdata = statement.executeQuery(query);

            resultdata.next();
            if(resultdata.getString("username").equals(username) && resultdata.getString("password").equals(password)){
                idid = resultdata.getString("id");
            }
            
            connect.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return idid;
    }

    public static boolean cekLoginAdmin(String username, String password){

        connection();
        
        boolean cekLog = false;

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM akun WHERE username = '" + username + "' AND password = '" + password + "'";

            ResultSet resultdata = statement.executeQuery(query);

            resultdata.next();
            if(resultdata.getString("username").equals(username) && resultdata.getString("password").equals(password)){
                cekLog = true;
            }
            
            connect.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return cekLog;
    }

    public static String cekAdmin(String username, String password){

        connection();
        
        String cekAdmin = "";
        int tempAdmin = 0;

        try {

            statement = connect.createStatement();

            String query = "SELECT * FROM akun WHERE username = '" +  username + "' AND password = '" + password + "'";

            ResultSet resultdata = statement.executeQuery(query);

            resultdata.next();
            tempAdmin = resultdata.getInt("admin");

            if (tempAdmin == 0) {
                cekAdmin = "customer";
            } else if (tempAdmin == 1) {
                cekAdmin = "admin";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cekAdmin;
    }

    public static DefaultTableModel getAllDataMenuGrooming(){

        String[] dataHeader = {"No", "Paket", "Harga"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);


        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM paket_grooming";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("id"), "  " + resultData.getString("Nama Paket"), "  " + resultData.getInt("Harga")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getAllJadwal(){

        String[] dataHeader = {"Tgl", "Hari", "Bulan", "Tahun", "Jam", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM Jadwal_Grooming";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), " " + resultData.getString("Hari"), " " + resultData.getString("Bulan"), "   " + resultData.getInt("Tahun"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getPesananJadwal(){

        String[] dataHeader = {"Tgl", "Nama Kucing", "Umur Kucing", "Paket Grooming", "Jam", "Status", "Id"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM pesanan WHERE Status = 'Antrian'";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), "  " + resultData.getString("Nama_Kucing"), "  " + resultData.getString("Umur_Kucing"), "  " + resultData.getString("Paket_Grooming"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status"), resultData.getInt("Id")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getRiwayatUser(String id){

        String[] dataHeader = {"Tgl", "Nama Kucing", "Umur Kucing", "Paket Grooming", "Jam", "Status", "Id"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM pesanan WHERE idUser = " + id + "";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), "  " + resultData.getString("Nama_Kucing"), "  " + resultData.getString("Umur_Kucing"), "  " + resultData.getString("Paket_Grooming"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status"), resultData.getInt("Id")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getRiwayatJadwal(){

        String[] dataHeader = {"Tgl", "Nama Kucing", "Umur Kucing", "Paket Grooming", "Jam", "Status", "Id"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM pesanan WHERE Status = 'Selesai' OR Status = 'Ditolak' OR Status = 'Batal'";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), "  " + resultData.getString("Nama_Kucing"), "  " + resultData.getString("Umur_Kucing"), "  " + resultData.getString("Paket_Grooming"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status"), resultData.getInt("Id")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static DefaultTableModel getProsesJadwal(){

        String[] dataHeader = {"Tgl", "Nama Kucing", "Umur Kucing", "Paket Grooming", "Jam", "Status", "Id"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "SELECT * FROM pesanan WHERE Status = 'Proses'";

            ResultSet resultData = statement.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), "  " + resultData.getString("Nama_Kucing"), "  " + resultData.getString("Umur_Kucing"), "  " + resultData.getString("Paket_Grooming"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status"), resultData.getInt("Id")};
                tm.addRow(rowData);
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static void prosesGrooming(String id){

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "UPDATE `pesanan` SET `Status` = 'Proses' WHERE `pesanan`.`Id` = " + id;

            statement.executeUpdate(query);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void cancelGrooming(String id){

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "UPDATE `pesanan` SET `Status` = 'Batal' WHERE `pesanan`.`Id` = " + id;

            statement.executeUpdate(query);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void tolakGrooming(String id){

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "UPDATE `pesanan` SET `Status` = 'Ditolak' WHERE `pesanan`.`Id` = " + id;

            statement.executeUpdate(query);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void selesaiGrooming(String id){

        try {

            connection();
            
            statement = connect.createStatement();

            String query = "UPDATE `pesanan` SET `Status` = 'Selesai' WHERE `pesanan`.`Id` = " + id;

            statement.executeUpdate(query);

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static String ambilDeskripsiPaket(String id){
        
        String desc = "";
        
        try {
            
            connection();
            
            statement = connect.createStatement();
            
            String query = "SELECT * FROM paket_grooming WHERE id = " + id;
            
            ResultSet resultData = statement.executeQuery(query);
            
            while (resultData.next()) {
                desc = resultData.getString("Deskripsi");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return desc;
    }
    
    public static DefaultTableModel searchJadwal(String search){
    
        String[] dataHeader = {"Tgl", "Hari", "Bulan", "Tahun", "Jam", "Status"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
    
        try {
    
            connection();
            
            statement = connect.createStatement();
    
            String query = "SELECT * FROM Jadwal_Grooming WHERE Tanggal = '" + search + "' OR Hari = '" + search + "' OR Bulan = '" + search + "' OR Tahun = '" + search + "' OR Jam = '" + search + "'";
    
            ResultSet resultData = statement.executeQuery(query);
    
            while (resultData.next()) {
                Object[] rowData = { "   " + resultData.getInt("Tanggal"), " " + resultData.getString("Hari"), " " + resultData.getString("Bulan"), "   " + resultData.getInt("Tahun"), " " + resultData.getString("Jam"), "   " + resultData.getString("Status")};
                tm.addRow(rowData);
            }
    
            statement.close();
            connect.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return tm;
    }

    public static boolean register(String username, String noHp, String password){

        connection();
        
        boolean cekReg = false;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO `akun` (`id`, `username`, `password`, `noHp`, `admin`) VALUES (NULL, '" + username + "', '" + password + "', '" + noHp + "', '0');";

            statement.executeUpdate(query);

            cekReg = true;
            
            connect.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return cekReg;
    }

    public static void pesanGrooming(String namaKucing, String umur, String namaPaket, String Tanggal, String Hari, String Bulan, String Tahun, String Jam, String Status, String Catatan, String id){

        connection();

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO `pesanan`(`Id`, `Nama_Kucing`, `Umur_Kucing`, `Paket_Grooming`, `Catatan`, `Status`, `Jam`, `Tanggal`, `Hari`, `Bulan`, `Tahun`, `idUser`) VALUES (NULL,'"+ namaKucing +"','"+ umur +"','"+ namaPaket +"','"+ Catatan +"','Antrian','"+ Jam +"','"+ Tanggal +"','"+ Hari +"','"+ Bulan +"','"+ Tahun +"','"+ id +"')";

            statement.executeUpdate(query);
            
            connect.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
