package com.templates;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.partials.cColor;
import com.partials.cFonts;
import com.partials.cLinkKeluar;
import com.partials.cLinkLogout;

public abstract class cDashboardFrame extends JFrame {

    public JPanel sideBar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new JPanel();
    public JPanel line = new JPanel();
    public cLinkKeluar keluar = new cLinkKeluar(1020);
    public cLinkLogout logOut = new cLinkLogout(920);

    private JLabel titleApp = new JLabel("Groomskuy");
    public JLabel roleText = new JLabel("Administrator");
    public JLabel menuTitle = new JLabel("BERANDA");
    public JLabel kelompok = new JLabel("Copyright 2024. Anugraha & Irish");
    
    public cDashboardFrame(){

        super();
        setSize(1380, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        sideBar.setBackground(cColor.WHITE);
        sideBar.setBounds(0, 0, 272, 800);
        sideBar.setLayout(null);
        sideBar.setBorder(new javax.swing.border.LineBorder(cColor.ORANGE, 2));

        header.setBackground(cColor.ORANGE);
        header.setBounds(270, 0, 1110, 100);
        header.setLayout(null);
        line.setBounds(0, 98, 270, 2);
        line.setBackground(cColor.ORANGE);

        //700 x 1110
        main.setBackground(cColor.WHITE_GRAY);
        main.setBounds(270, 100, 1110, 700);
        main.setLayout(null);

        content.setBackground(cColor.WHITE);
        content.setBounds(65, 70, 980, 590);
        content.setLayout(null);

        titleApp.setFont(cFonts.APP_FONT);
        titleApp.setBounds(0, 0, 250, 90);
        titleApp.setHorizontalAlignment(JLabel.CENTER);
        titleApp.setVerticalAlignment(JLabel.CENTER);
        titleApp.setForeground(cColor.ORANGE);

        roleText.setFont(cFonts.ROLE_FONT);
        roleText.setBounds(0, 0, 220, 90);
        roleText.setHorizontalAlignment(JLabel.CENTER);
        roleText.setVerticalAlignment(JLabel.CENTER);
        roleText.setForeground(cColor.WHITE);

        menuTitle.setFont(cFonts.ROLE_FONT);
        menuTitle.setBounds(75, 0, 300, 70);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        menuTitle.setForeground(cColor.BLACK_GRAY_BANGET);

        kelompok.setFont(cFonts.KELOMPOK_FONT);
        kelompok.setBounds(445, 645, 400, 70);
        kelompok.setVerticalAlignment(JLabel.CENTER);
        kelompok.setForeground(cColor.BLACK_GRAY);

        // main.add(content);
        add(sideBar);
        add(main);
        add(header);
        sideBar.add(line);
        header.add(keluar);
        header.add(logOut);
        header.add(roleText);
        sideBar.add(titleApp);
        main.add(content);
        main.add(menuTitle);
        main.add(kelompok);
        
    }

    public cDashboardFrame(String title){
        this();
        roleText.setText(title);
    }

}
