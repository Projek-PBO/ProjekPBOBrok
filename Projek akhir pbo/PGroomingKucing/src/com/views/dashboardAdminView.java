package com.views;

import com.partials.*;
import com.program.Model;
import com.templates.cDashboardFrame;

public class dashboardAdminView extends cDashboardFrame{
    private int angkaGroomingToday = 0;
    private int angkaProses = 1;
    private int angkaRiwayatPesanan = 1;

    private cSidebarMenu sidebarGroomingToday = new cSidebarMenu("Grooming Today", 100);    
    private cSidebarMenu sidebarProsesPesanan = new cSidebarMenu("Proses Pesanan", 150);  
    private cSidebarMenu sidebarRiwayatPesanan = new cSidebarMenu("Riwayat Pesanan", 200);  
    private cLabelAntrian labelAntrian = new cLabelAntrian("Antrian", 370, 20, 200, true);
    private cTable antrianTabel;
    private cScrollPane spAntrianTabel;
    private cButton1 prossesButton = new cButton1("Proses", 365, 500, 100, 50);
    private cButton1 cancelButton = new cButton1("Cancel", 515, 500, 100, 50);
    private cLabelAntrian labelProses = new cLabelAntrian("Proses", 370, 20, 200, true);
    private cTable prosesTabel;
    private cScrollPane spProsesTabel;
    private cButton1 selesaiButton = new cButton1("Selesai", 365, 500, 100, 50);
    private cButton1 tolakButton = new cButton1("Tolak", 515, 500, 100, 50);
    private cLabelAntrian labelSelesai = new cLabelAntrian("Riwayat", 370, 20, 200, true);
    private cTable SelesaiTabel;
    private cScrollPane spSelesaiTabel;
  

    public dashboardAdminView(){
        super("Admin");

        resetSideBar();
        refreshContent();
        initsGroomingToday();

        sidebarGroomingToday.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaGroomingToday == 1) {
                    refreshContent();
                    initsGroomingToday();
                }
            }
        });

        sidebarProsesPesanan.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaProses == 1) {
                    refreshContent();
                    initsProses();
                }
            }
        });

        sidebarRiwayatPesanan.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                if (angkaRiwayatPesanan == 1) {
                    refreshContent();
                    initsRiwayat();
                }
            }
        });

        sideBar.add(sidebarGroomingToday);
        sideBar.add(sidebarProsesPesanan);
        sideBar.add(sidebarRiwayatPesanan);

    }

    private void resetSideBar(){
        setVisible(false);

        sidebarGroomingToday.setForeground(cColor.GRAY);
        sidebarGroomingToday.setBackground(cColor.WHITE);
        sidebarGroomingToday.setSidebarNonAktif();

        sidebarProsesPesanan.setForeground(cColor.GRAY);
        sidebarProsesPesanan.setBackground(cColor.WHITE);
        sidebarProsesPesanan.setSidebarNonAktif();

        sidebarRiwayatPesanan.setForeground(cColor.GRAY);
        sidebarRiwayatPesanan.setBackground(cColor.WHITE);
        sidebarRiwayatPesanan.setSidebarNonAktif();


    }

    private void refreshContent(){
        content.removeAll();
    }

    public void initsGroomingToday(){
        resetSideBar();

        angkaGroomingToday = 0;
        angkaProses = 1;
        angkaRiwayatPesanan = 1;

        sidebarGroomingToday.setSidebarAktif();    

        menuTitle.setText("Grooming Today");

        antrianTabel = new cTable(Model.getPesananJadwal());

        antrianTabel.getColumnModel().getColumn(0).setMaxWidth(50);
        antrianTabel.getColumnModel().getColumn(0).setMinWidth(50);
        antrianTabel.getColumnModel().getColumn(1).setMinWidth(150);
        antrianTabel.getColumnModel().getColumn(1).setMaxWidth(150);
        antrianTabel.getColumnModel().getColumn(2).setMinWidth(120);
        antrianTabel.getColumnModel().getColumn(2).setMaxWidth(120);
        antrianTabel.getColumnModel().getColumn(3).setMinWidth(170);
        antrianTabel.getColumnModel().getColumn(3).setMaxWidth(170);
        antrianTabel.getColumnModel().getColumn(4).setMinWidth(60);
        antrianTabel.getColumnModel().getColumn(4).setMaxWidth(60);
        antrianTabel.getColumnModel().getColumn(5).setMinWidth(85);
        antrianTabel.getColumnModel().getColumn(5).setMaxWidth(85);

        spAntrianTabel = new cScrollPane(antrianTabel, 152, 70, 635, 400);

        content.add(spAntrianTabel);
        content.add(labelAntrian);
        content.add(prossesButton);
        content.add(cancelButton);

        prossesButton.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {

                int tempId = antrianTabel.getSelectedRow();

                if (tempId != -1) {
                    String idPaket = antrianTabel.getValueAt(tempId, 6).toString();

                    Model.prosesGrooming(idPaket);

                    refreshContent();
                    antrianTabel = new cTable(Model.getPesananJadwal());
                    antrianTabel.getColumnModel().getColumn(0).setMaxWidth(50);
                    antrianTabel.getColumnModel().getColumn(0).setMinWidth(50);
                    antrianTabel.getColumnModel().getColumn(1).setMinWidth(150);
                    antrianTabel.getColumnModel().getColumn(1).setMaxWidth(150);
                    antrianTabel.getColumnModel().getColumn(2).setMinWidth(120);
                    antrianTabel.getColumnModel().getColumn(2).setMaxWidth(120);
                    antrianTabel.getColumnModel().getColumn(3).setMinWidth(170);
                    antrianTabel.getColumnModel().getColumn(3).setMaxWidth(170);
                    antrianTabel.getColumnModel().getColumn(4).setMinWidth(60);
                    antrianTabel.getColumnModel().getColumn(4).setMaxWidth(60);
                    antrianTabel.getColumnModel().getColumn(5).setMinWidth(85);
                    antrianTabel.getColumnModel().getColumn(5).setMaxWidth(85);
                    spAntrianTabel = new cScrollPane(antrianTabel, 152, 70, 635, 400);
                    content.add(spAntrianTabel);
                    content.add(prossesButton);
                }
            }
        });

        cancelButton.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {

                int tempId = antrianTabel.getSelectedRow();

                if (tempId != -1) {
                    String idPaket = antrianTabel.getValueAt(tempId, 6).toString();

                    Model.cancelGrooming(idPaket);

                    refreshContent();
                    antrianTabel = new cTable(Model.getPesananJadwal());
                    antrianTabel.getColumnModel().getColumn(0).setMaxWidth(50);
                    antrianTabel.getColumnModel().getColumn(0).setMinWidth(50);
                    antrianTabel.getColumnModel().getColumn(1).setMinWidth(150);
                    antrianTabel.getColumnModel().getColumn(1).setMaxWidth(150);
                    antrianTabel.getColumnModel().getColumn(2).setMinWidth(120);
                    antrianTabel.getColumnModel().getColumn(2).setMaxWidth(120);
                    antrianTabel.getColumnModel().getColumn(3).setMinWidth(170);
                    antrianTabel.getColumnModel().getColumn(3).setMaxWidth(170);
                    antrianTabel.getColumnModel().getColumn(4).setMinWidth(60);
                    antrianTabel.getColumnModel().getColumn(4).setMaxWidth(60);
                    antrianTabel.getColumnModel().getColumn(5).setMinWidth(85);
                    antrianTabel.getColumnModel().getColumn(5).setMaxWidth(85);
                    spAntrianTabel = new cScrollPane(antrianTabel, 152, 70, 635, 400);
                    content.add(spAntrianTabel);
                    content.add(cancelButton);
                }
            }
        });

        setVisible(true);
    }
    
    public void initsProses(){
        resetSideBar();
        
        angkaGroomingToday = 1;
        angkaProses = 0;
        angkaRiwayatPesanan = 1;

        sidebarProsesPesanan.setSidebarAktif();        

        menuTitle.setText("Proses Pesanan");

        prosesTabel = new cTable(Model.getProsesJadwal());

        prosesTabel.getColumnModel().getColumn(0).setMaxWidth(50);
        prosesTabel.getColumnModel().getColumn(0).setMinWidth(50);
        prosesTabel.getColumnModel().getColumn(1).setMinWidth(150);
        prosesTabel.getColumnModel().getColumn(1).setMaxWidth(150);
        prosesTabel.getColumnModel().getColumn(2).setMinWidth(120);
        prosesTabel.getColumnModel().getColumn(2).setMaxWidth(120);
        prosesTabel.getColumnModel().getColumn(3).setMinWidth(170);
        prosesTabel.getColumnModel().getColumn(3).setMaxWidth(170);
        prosesTabel.getColumnModel().getColumn(4).setMinWidth(60);
        prosesTabel.getColumnModel().getColumn(4).setMaxWidth(60);
        prosesTabel.getColumnModel().getColumn(5).setMinWidth(85);
        prosesTabel.getColumnModel().getColumn(5).setMaxWidth(85);

        spProsesTabel = new cScrollPane(prosesTabel, 152, 70, 635, 400);

        content.add(spProsesTabel);
        content.add(labelProses);
        content.add(tolakButton);
        content.add(selesaiButton);

        selesaiButton.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {

                int tempId = prosesTabel.getSelectedRow();

                if (tempId != -1) {
                    String idPaket = prosesTabel.getValueAt(tempId, 6).toString();

                    Model.selesaiGrooming(idPaket);

                    refreshContent();
                    prosesTabel = new cTable(Model.getPesananJadwal());
                    prosesTabel.getColumnModel().getColumn(0).setMaxWidth(50);
                    prosesTabel.getColumnModel().getColumn(0).setMinWidth(50);
                    prosesTabel.getColumnModel().getColumn(1).setMinWidth(150);
                    prosesTabel.getColumnModel().getColumn(1).setMaxWidth(150);
                    prosesTabel.getColumnModel().getColumn(2).setMinWidth(120);
                    prosesTabel.getColumnModel().getColumn(2).setMaxWidth(120);
                    prosesTabel.getColumnModel().getColumn(3).setMinWidth(170);
                    prosesTabel.getColumnModel().getColumn(3).setMaxWidth(170);
                    prosesTabel.getColumnModel().getColumn(4).setMinWidth(60);
                    prosesTabel.getColumnModel().getColumn(4).setMaxWidth(60);
                    prosesTabel.getColumnModel().getColumn(5).setMinWidth(85);
                    prosesTabel.getColumnModel().getColumn(5).setMaxWidth(85);
                    spProsesTabel = new cScrollPane(prosesTabel, 152, 70, 635, 400);
                    content.add(spProsesTabel);
                    content.add(selesaiButton);
                    

                }
            }
        });

        tolakButton.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {

                int tempId = prosesTabel.getSelectedRow();

                if (tempId != -1) {
                    String idPaket = prosesTabel.getValueAt(tempId, 6).toString();

                    Model.tolakGrooming(idPaket);

                    refreshContent();
                    prosesTabel = new cTable(Model.getPesananJadwal());
                    prosesTabel.getColumnModel().getColumn(0).setMaxWidth(50);
                    prosesTabel.getColumnModel().getColumn(0).setMinWidth(50);
                    prosesTabel.getColumnModel().getColumn(1).setMinWidth(150);
                    prosesTabel.getColumnModel().getColumn(1).setMaxWidth(150);
                    prosesTabel.getColumnModel().getColumn(2).setMinWidth(120);
                    prosesTabel.getColumnModel().getColumn(2).setMaxWidth(120);
                    prosesTabel.getColumnModel().getColumn(3).setMinWidth(170);
                    prosesTabel.getColumnModel().getColumn(3).setMaxWidth(170);
                    prosesTabel.getColumnModel().getColumn(4).setMinWidth(60);
                    prosesTabel.getColumnModel().getColumn(4).setMaxWidth(60);
                    prosesTabel.getColumnModel().getColumn(5).setMinWidth(85);
                    prosesTabel.getColumnModel().getColumn(5).setMaxWidth(85);
                    spProsesTabel = new cScrollPane(prosesTabel, 152, 70, 635, 400);
                    content.add(spProsesTabel);
                    content.add(tolakButton);

                }
            }
        });

        setVisible(true);
    }

    public void initsRiwayat(){
        resetSideBar();
        
        angkaGroomingToday = 1;
        angkaProses = 1;
        angkaRiwayatPesanan = 0;

        sidebarRiwayatPesanan.setSidebarAktif();        

        menuTitle.setText("Riwayat Pesanan");

        SelesaiTabel = new cTable(Model.getRiwayatJadwal());

        SelesaiTabel.getColumnModel().getColumn(0).setMaxWidth(50);
        SelesaiTabel.getColumnModel().getColumn(0).setMinWidth(50);
        SelesaiTabel.getColumnModel().getColumn(1).setMinWidth(150);
        SelesaiTabel.getColumnModel().getColumn(1).setMaxWidth(150);
        SelesaiTabel.getColumnModel().getColumn(2).setMinWidth(120);
        SelesaiTabel.getColumnModel().getColumn(2).setMaxWidth(120);
        SelesaiTabel.getColumnModel().getColumn(3).setMinWidth(170);
        SelesaiTabel.getColumnModel().getColumn(3).setMaxWidth(170);
        SelesaiTabel.getColumnModel().getColumn(4).setMinWidth(60);
        SelesaiTabel.getColumnModel().getColumn(4).setMaxWidth(60);
        SelesaiTabel.getColumnModel().getColumn(5).setMinWidth(85);
        SelesaiTabel.getColumnModel().getColumn(5).setMaxWidth(85);

        spSelesaiTabel = new cScrollPane(SelesaiTabel, 152, 70, 635, 400);

        content.add(spSelesaiTabel);
        content.add(labelSelesai);

        setVisible(true);
    }
}
