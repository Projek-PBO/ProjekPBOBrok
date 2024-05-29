package com.views;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Model;

import com.templates.cDashboardFrame;

public class dashboardCustomerView extends cDashboardFrame{

    private int angkaBeranda = 0;
    private int angkaPemesanan = 1;
    private int angkaJadwal = 1;

    private String umur = "";

    //sidebar menu
    private cSidebarMenu sidebarBeranda = new cSidebarMenu("Beranda", 100);    
    private cSidebarMenu sideBarPemesanan = new cSidebarMenu("Pemesanan", 150);    
    private cSidebarMenu sideBarJadwal = new cSidebarMenu("Jadwal", 200);  
    
    //sidebarBeranda

    //isi beranda


    //isi Pesanan
    private cLabelPesanan namaKucingPesanan = new cLabelPesanan("Nama Kucing", 20, 20, 200, false);
    private cFormText txtNamaKucingPesanan = new cFormText(20, 60, 380, false);
    private cLabelPesanan umurKucingPesanan = new cLabelPesanan("Umur Kucing", 20, 120, 200, false);
    private cRadioButton rdUmur16 = new cRadioButton("1-6 Bulan", "1-6", 20, 160, 120);
    private cRadioButton rdUmur612 = new cRadioButton("6-12 Bulan", "6-12", 140, 160, 120);
    private cRadioButton rdUmurTh = new cRadioButton("> 1 Tahun", "> 1 Tahun", 260, 160, 120);
    private cLabelPesanan pilihPaketPesanan = new cLabelPesanan("Paket", 20, 200, 200, false);
    private cTable paketGroomingPesanan;
    private cScrollPane spPaketGroomingPesanan;
    private cButton1 pilihPaketButtonPesanan = new cButton1("Pilih", 20, 410, 80, 30);
    private cTextArea deskripsiPaketTextAreaPesanan = new cTextArea(20, 450, 380, 100);
    private cLabelPesanan pilihJadwalPesanan = new cLabelPesanan("Jadwal", 500, 20, 100, false);
    private cFormText searchTextField = new cFormText(630, 20, 230, false);
    private cButton1 searchButtonPesanan = new cButton1("Search", 870, 20, 80, 30);
    private cTable jadwalGroomingPesanan;
    private cScrollPane spJadwalGroomingPesanan;
    private cLabelPesanan deskripsiLabelPesanan = new cLabelPesanan("Catatan", 500, 250, 200, false);
    private cTextArea deskripsiCatatanTextAreaPesanan = new cTextArea(500, 290, 450, 200);
    private cButton1 submitPesanan = new cButton1("PESAN!", 840, 500, 100, 50);

    private cTable riwayatPesanan;
    private cScrollPane spRiwayatPesanan;

    public dashboardCustomerView(String id){
        
        super("Customer");

        resetSideBar();
        refreshContent();
        initsBeranda(id);

        sidebarBeranda.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaBeranda == 1) {
                    refreshContent();
                    initsBeranda(id);
                }
            }
        });

        sideBarPemesanan.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaPemesanan == 1) {
                    refreshContent();
                    initsPemesanan(id);
                }
            }
        });

        sideBarJadwal.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaJadwal == 1) {
                    refreshContent();
                    initsJadwal(id);
                }
            }
        });

        sideBar.add(sidebarBeranda);
        sideBar.add(sideBarPemesanan);
        sideBar.add(sideBarJadwal);
    }

    private void resetSideBar(){
        setVisible(false);

        sidebarBeranda.setForeground(cColor.GRAY);
        sidebarBeranda.setBackground(cColor.WHITE);
        sidebarBeranda.setSidebarNonAktif();

        sideBarPemesanan.setForeground(cColor.GRAY);
        sideBarPemesanan.setBackground(cColor.WHITE);
        sideBarPemesanan.setSidebarNonAktif();

        sideBarJadwal.setForeground(cColor.GRAY);
        sideBarJadwal.setBackground(cColor.WHITE);
        sideBarJadwal.setSidebarNonAktif();
    }

    private void refreshContent(){
        content.removeAll();
    }


    
    public void initsBeranda(String id){
        resetSideBar();
        angkaBeranda = 0;
        angkaPemesanan = 1;
        angkaJadwal = 1;
        sidebarBeranda.setSidebarAktif();

        menuTitle.setText("Beranda");

        setVisible(true);
    }
    
    public void initsPemesanan(String id){
        resetSideBar();
        angkaBeranda = 1;
        angkaPemesanan = 0;
        angkaJadwal = 1;
        sideBarPemesanan.setSidebarAktif();

        menuTitle.setText("Pemesanan");
        
        paketGroomingPesanan = new cTable(Model.getAllDataMenuGrooming());

        paketGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
        paketGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(100);
        paketGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(100);

        spPaketGroomingPesanan = new cScrollPane(paketGroomingPesanan, 20, 230, 380, 170);
        
        jadwalGroomingPesanan = new cTable(Model.getAllJadwal());

        jadwalGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
        jadwalGroomingPesanan.getColumnModel().getColumn(1).setMinWidth(75);
        jadwalGroomingPesanan.getColumnModel().getColumn(1).setMaxWidth(75);
        jadwalGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(95);
        jadwalGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(95);
        jadwalGroomingPesanan.getColumnModel().getColumn(3).setMinWidth(70);
        jadwalGroomingPesanan.getColumnModel().getColumn(3).setMaxWidth(70);
        jadwalGroomingPesanan.getColumnModel().getColumn(4).setMinWidth(60);
        jadwalGroomingPesanan.getColumnModel().getColumn(4).setMaxWidth(60);

        spJadwalGroomingPesanan = new cScrollPane(jadwalGroomingPesanan, 500, 60, 450, 170);

        content.add(namaKucingPesanan);
        content.add(txtNamaKucingPesanan);
        content.add(umurKucingPesanan);
        ButtonGroup groupUmur = new ButtonGroup();
        groupUmur.add(rdUmur16);
        groupUmur.add(rdUmur612);
        groupUmur.add(rdUmurTh);
        content.add(rdUmur16);
        content.add(rdUmur612);
        content.add(rdUmurTh);
        content.add(pilihPaketPesanan);
        content.add(spPaketGroomingPesanan);
        content.add(pilihPaketButtonPesanan);
        content.add(deskripsiPaketTextAreaPesanan);
        content.add(pilihJadwalPesanan);
        content.add(searchTextField);
        content.add(searchButtonPesanan);
        content.add(spJadwalGroomingPesanan);
        content.add(deskripsiLabelPesanan);
        content.add(deskripsiCatatanTextAreaPesanan);
        content.add(submitPesanan);



        rdUmur16.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

                umur = "1-6 Bulan";
                
            }
        });
        
        rdUmur612.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

                umur = "6-12 Bulan";
                
            }
        });

        rdUmurTh.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

                umur = "> 1 tahun";
                
            }
        });

        pilihPaketButtonPesanan.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

                int tempSelectPaket = paketGroomingPesanan.getSelectedRow();
                
                if (tempSelectPaket != -1) {
                    String idPaket = paketGroomingPesanan.getValueAt(tempSelectPaket, 0).toString();

                    String deskripsi = Model.ambilDeskripsiPaket(idPaket);

                    deskripsiPaketTextAreaPesanan.setText(deskripsi);

                } else {
                        
                }

            }
        });

        searchButtonPesanan.addActionListener(new java.awt.event.ActionListener(){
            @Override

            public void actionPerformed(java.awt.event.ActionEvent ae){
                String tempSearch = searchTextField.getText();

                jadwalGroomingPesanan.setModel(Model.searchJadwal(tempSearch));
                jadwalGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMinWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMaxWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMinWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMaxWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMinWidth(60);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMaxWidth(60);
            }
        });

        searchTextField.addActionListener(new java.awt.event.ActionListener(){
            @Override

            public void actionPerformed(java.awt.event.ActionEvent ae){
                String tempSearch = searchTextField.getText();

                jadwalGroomingPesanan.setModel(Model.searchJadwal(tempSearch));
                jadwalGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMinWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMaxWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMinWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMaxWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMinWidth(60);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMaxWidth(60);
            }
        });

        submitPesanan.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {

            Object[] options = { "IYA", "Cek Ulang" };
            int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin Data Sudah Benar?", "Konfirmasi Submit", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if( konfirmasi == 0 ){
                String namaKucing = txtNamaKucingPesanan.getText();
    
                int tempSelectPaket = paketGroomingPesanan.getSelectedRow();
                String namaPaket = paketGroomingPesanan.getValueAt(tempSelectPaket, 1).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Tanggal = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 0).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Hari = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 1).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Bulan = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 2).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Tahun = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 3).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Jam = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 4).toString().replace(" ", "");
                tempSelectPaket = jadwalGroomingPesanan.getSelectedRow();
                String Status = jadwalGroomingPesanan.getValueAt(tempSelectPaket, 5).toString().replace(" ", "");
                String Catatan = deskripsiCatatanTextAreaPesanan.getText();
    
                Model.pesanGrooming(namaKucing, umur, namaPaket, Tanggal, Hari, Bulan, Tahun, Jam, Status, Catatan, id);
                
                content.add(rdUmur16);
                content.add(rdUmur612);
                content.add(rdUmurTh);
                remove(spPaketGroomingPesanan);
                paketGroomingPesanan = new cTable(Model.getAllDataMenuGrooming());
                paketGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
                paketGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(100);
                paketGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(100);
                spPaketGroomingPesanan = new cScrollPane(paketGroomingPesanan, 20, 230, 380, 170);
                content.add(spPaketGroomingPesanan);


                searchTextField.setText("");
                
                remove(spJadwalGroomingPesanan);
                jadwalGroomingPesanan = new cTable(Model.getAllJadwal());
                jadwalGroomingPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMinWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(1).setMaxWidth(75);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMinWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(2).setMaxWidth(95);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMinWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(3).setMaxWidth(70);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMinWidth(60);
                jadwalGroomingPesanan.getColumnModel().getColumn(4).setMaxWidth(60);
                spJadwalGroomingPesanan = new cScrollPane(jadwalGroomingPesanan, 500, 60, 450, 170);
                content.add(spJadwalGroomingPesanan);

                deskripsiCatatanTextAreaPesanan.setText("");
                deskripsiPaketTextAreaPesanan.setText("");
            }

            }
        });

        setVisible(true);
    }

    public void initsJadwal(String id){
        resetSideBar();
        angkaBeranda = 1;
        angkaPemesanan = 1;
        angkaJadwal = 0;
        sideBarJadwal.setSidebarAktif();

        menuTitle.setText("Jadwal");

        riwayatPesanan = new cTable(Model.getRiwayatUser(id));

        riwayatPesanan.getColumnModel().getColumn(0).setMaxWidth(50);
        riwayatPesanan.getColumnModel().getColumn(0).setMinWidth(50);
        riwayatPesanan.getColumnModel().getColumn(1).setMinWidth(150);
        riwayatPesanan.getColumnModel().getColumn(1).setMaxWidth(150);
        riwayatPesanan.getColumnModel().getColumn(2).setMinWidth(120);
        riwayatPesanan.getColumnModel().getColumn(2).setMaxWidth(120);
        riwayatPesanan.getColumnModel().getColumn(3).setMinWidth(170);
        riwayatPesanan.getColumnModel().getColumn(3).setMaxWidth(170);
        riwayatPesanan.getColumnModel().getColumn(4).setMinWidth(60);
        riwayatPesanan.getColumnModel().getColumn(4).setMaxWidth(60);
        riwayatPesanan.getColumnModel().getColumn(5).setMinWidth(85);
        riwayatPesanan.getColumnModel().getColumn(5).setMaxWidth(85);

        spRiwayatPesanan = new cScrollPane(riwayatPesanan, 152, 70, 635, 400);

        content.add(spRiwayatPesanan);

        setVisible(true);
    }

}
