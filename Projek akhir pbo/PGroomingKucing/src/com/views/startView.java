package com.views;
import com.templates.cStartFrame;

import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controler;
import com.program.Model;

public class startView extends cStartFrame{

    private cLabelStart labelUsernameLoginCustomer   = new cLabelStart("Username", 0, 114, 450, true);
    private cFormText txtUsernameLoginCustomer       = new cFormText(65, 149, 320, false);
    private cErrorLabel errorUsernameLoginCustomer   = new cErrorLabel("", 285, 179, 100, false);
    private cLabelStart labelPasswordLoginCustomer   = new cLabelStart("Password", 0, 194, 450, true);
    private cFormPassword txtPasswordLoginCustomer   = new cFormPassword(65, 229, 320, false);
    private cErrorLabel errorPasswordLoginCustomer   = new cErrorLabel("", 285, 258, 100, false);
    private cButton1 loginButtonLoginCustomer        = new cButton1("Login", 65, 289, 320, 50);
    private cGarisOr garis1LoginCustomer             = new cGarisOr(369, 65, 130);
    private cGarisOr garis2LoginCustomer             = new cGarisOr(369, 255, 130);
    private cLinkStart orLoginCustomer               = new cLinkStart("OR", 213, 359, false);
    private cLinkStart registerLoginCustomer         = new cLinkStart("Belum Punya Akun??", 0, 399, true);
    private cLinkAdmin loginAdminLoginCustomer       = new cLinkAdmin("Login Sebagai Admin??", 0, 429, true);

    private cLabelStart labelUsernameDaftarCustomer  = new cLabelStart("Username", 0, 104, 450, true);
    private cFormText txtUsernameDaftarCustomer      = new cFormText(65, 139, 320, false);
    private cErrorLabel errorUsernameDaftarCustomer  = new cErrorLabel("Username Kosong", 275, 169, 110, false);
    private cLabelStart labelNoHpDaftarCustomer      = new cLabelStart("No Handphone", 0, 184, 450, true);
    private cFormText txtNoHpDaftarCustomer          = new cFormText(65, 219, 320, false);
    private cErrorLabel errorNoHpDaftarCustomer      = new cErrorLabel("No Hp Kosong", 295, 249, 100, false);
    private cLabelStart labelPasswordDaftarCustomer  = new cLabelStart("Password", 0, 264, 450, true);
    private cFormPassword txtPasswordDaftarCustomer  = new cFormPassword(65, 299, 320, false);
    private cErrorLabel errorPasswordDaftarCustomer  = new cErrorLabel("Password Kosong", 275, 329, 110, false);
    private cButton1 daftarButtonDaftarCustomer      = new cButton1("Daftar", 65, 354, 320, 50);
    private cGarisOr garis1DaftarCustomer            = new cGarisOr(429, 65, 130);
    private cGarisOr garis2DaftarCustomer            = new cGarisOr(429, 255, 130);
    private cLinkStart orDaftarCustomer              = new cLinkStart("OR", 213, 419, false);
    private cLinkStart loginDaftarCustomer           = new cLinkStart("Sudah Punya Akun??", 0, 459, true);

    private cLabelStart labelUsernameLoginAdmin      = new cLabelStart("Username", 0, 114, 450, true);
    private cFormText txtUsernameLoginAdmin          = new cFormText(65, 149, 320, false);
    private cErrorLabel errorUsernameLoginAdmin      = new cErrorLabel("", 275, 179, 120, false);
    private cLabelStart labelPasswordLoginAdmin      = new cLabelStart("Password", 0, 194, 450, true);
    private cFormPassword txtPasswordLoginAdmin      = new cFormPassword(65, 229, 320, false);
    private cErrorLabel errorPasswordLoginAdmin      = new cErrorLabel("", 275, 258, 120, false);
    private cButton1 loginButtonLoginAdmin           = new cButton1("Login", 65, 289, 320, 50);
    private cGarisOr garis1LoginAdmin                = new cGarisOr(369, 65, 130);
    private cGarisOr garis2LoginAdmin                = new cGarisOr(369, 255, 130);
    private cLinkStart orLoginAdmin                  = new cLinkStart("OR", 213, 359, false);
    private cLinkStart loginCustomerLoginAdmin       = new cLinkStart("Login Sebagai Customer??", 0, 399, true);
    private cLinkStart registerCustomerLoginAdmin    = new cLinkStart("Daftar Sebagai Customer??", 0, 429, true);


    public startView() {
        super();
        //Login Customer
        registerLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Controler.showDaftarCustomer();
            }
        });
        loginAdminLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Controler.showLoginAdmin();
            }
        });

        //Daftar Customer
        loginDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Controler.showLoginCustomer();
            }
        });

        //Login Admin
        loginCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Controler.showLoginCustomer();
            }
        });
        registerCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me){
                Controler.showDaftarCustomer();
            }
        });
    }

    public void initsLoginCustomer(){
        cardStart.removeAll();
        titleStart.setText("Login Customer");
        cardStart.add(titleStart);

        loginButtonLoginCustomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){

                String tempusername = txtUsernameLoginCustomer.getText();
                String temppassword = String.valueOf(txtPasswordLoginCustomer.getPassword());
                if(txtUsernameLoginCustomer.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginCustomer.getPassword()).equalsIgnoreCase("")){

                    if (txtUsernameLoginCustomer.getText().equalsIgnoreCase("")) {
                        errorUsernameLoginCustomer.setText("Username Salah");;
                    }
                    
                    if (String.valueOf(txtPasswordLoginCustomer.getPassword()).equalsIgnoreCase("")) {
                        errorPasswordLoginCustomer.setText("Username Salah");
                    }

                } else if(Model.cekLogin(tempusername, temppassword)){
                    JOptionPane.showMessageDialog(startView.this, "Login Berhasil!", "Succses", JOptionPane.DEFAULT_OPTION);
                    startView.this.setVisible(false);
                    Controler.showDashboardCustomer(Model.ambilId(tempusername, temppassword));
                }
            }
        });

        cardStart.add(labelUsernameLoginCustomer);
        cardStart.add(txtUsernameLoginCustomer);
        cardStart.add(errorUsernameLoginCustomer);
        cardStart.add(labelPasswordLoginCustomer);
        cardStart.add(txtPasswordLoginCustomer);
        cardStart.add(errorPasswordLoginCustomer);
        cardStart.add(loginButtonLoginCustomer);
        cardStart.add(registerLoginCustomer);
        cardStart.add(garis1LoginCustomer);
        cardStart.add(garis2LoginCustomer);
        cardStart.add(orLoginCustomer);
        cardStart.add(loginAdminLoginCustomer);
    }
    
    public void initsDaftarCustomer(){
        cardStart.removeAll();
        titleStart.setText("Daftar Customer");
        cardStart.add(titleStart);

        daftarButtonDaftarCustomer.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                String tempUsername = txtUsernameDaftarCustomer.getText(); 
                String tempnoHp = txtNoHpDaftarCustomer.getText(); 
                String temppassword = String.valueOf(txtPasswordDaftarCustomer.getPassword());         
                
                if(tempUsername.equalsIgnoreCase("") || temppassword.equalsIgnoreCase("")){

                    if (tempUsername.equalsIgnoreCase("")) {
                        errorUsernameDaftarCustomer.setText("Username Kosong");;
                    }
                    
                    if (tempnoHp.equalsIgnoreCase("")) {
                        errorNoHpDaftarCustomer.setText("No HP Kosong");
                    }

                    if (temppassword.equalsIgnoreCase("")) {
                        errorPasswordDaftarCustomer.setText("Password Kosong");
                    }

                } else if(Model.register(tempUsername, tempnoHp, temppassword)){
                    JOptionPane.showMessageDialog(startView.this, "Registrasi Berhasil, Silahkan Login!", "Succses", JOptionPane.DEFAULT_OPTION);
                    startView.this.setVisible(false);
                    Controler.showLoginCustomer();
                }
            }
        });

        daftarButtonDaftarCustomer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){
                Controler.showDaftarCustomer();

                if(txtUsernameDaftarCustomer.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordDaftarCustomer.getPassword()).equalsIgnoreCase("") || txtNoHpDaftarCustomer.getText().equalsIgnoreCase("")){

                    if (txtUsernameDaftarCustomer.getText().equalsIgnoreCase("")) {
                        cardStart.add(errorUsernameDaftarCustomer);
                    }

                    if (txtNoHpDaftarCustomer.getText().equalsIgnoreCase("")) {
                        cardStart.add(errorNoHpDaftarCustomer);
                    }
                    
                    if (String.valueOf(txtPasswordDaftarCustomer.getPassword()).equalsIgnoreCase("")) {
                        cardStart.add(errorPasswordDaftarCustomer);
                    }

                }
            }
        });

        cardStart.add(labelUsernameDaftarCustomer);
        cardStart.add(txtUsernameDaftarCustomer);
        // cardStart.add(errorUsernameDaftarCustomer);
        cardStart.add(labelNoHpDaftarCustomer);
        cardStart.add(txtNoHpDaftarCustomer);
        // cardStart.add(errorNoHpDaftarCustomer);
        cardStart.add(labelPasswordDaftarCustomer);
        cardStart.add(txtPasswordDaftarCustomer);
        // cardStart.add(errorPasswordDaftarCustomer);
        cardStart.add(daftarButtonDaftarCustomer);
        cardStart.add(loginDaftarCustomer);
        cardStart.add(garis1DaftarCustomer);
        cardStart.add(garis2DaftarCustomer);
        cardStart.add(orDaftarCustomer);
    }

    public void initsLoginAdmin(){
        cardStart.removeAll();
        titleStart.setText("Login Admin");
        cardStart.add(titleStart);
        loginButtonLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae){

                if(txtUsernameLoginAdmin.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")){

                    if (txtUsernameLoginAdmin.getText().equalsIgnoreCase("")) {
                        errorUsernameLoginAdmin.setText("Username Kosong");
                    }
                    
                    if (String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("")) {
                        errorPasswordLoginAdmin.setText("Password Kosong");
                    }

                } else {

                    String tempUsername = txtUsernameLoginAdmin.getText();
                    String tempPassword = String.valueOf(txtPasswordLoginAdmin.getPassword());

                    if (Model.cekAdmin(tempUsername, tempPassword).equals("admin")){
                        if (Model.cekLoginAdmin(tempUsername, tempPassword)) {
                            Controler.showDashboardAdmin();
                            JOptionPane.showMessageDialog(startView.this, "Login Berhasil, Welcome " + tempUsername + "!", "Succses", JOptionPane.DEFAULT_OPTION);
                            startView.this.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(startView.this, "Login Gagal, Cek Username dan Password Anda", "Gagal", JOptionPane.DEFAULT_OPTION);
                        }
                    }
                }
            }
        });

        loginButtonLoginAdmin.addActionListener(new java.awt.event.ActionListener() {

            @Override

            public void actionPerformed(java.awt.event.ActionEvent ae){

                String username = txtUsernameLoginAdmin.getText();
                String password = String.valueOf(txtPasswordLoginAdmin.getPassword());
                
                if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
                    
                } else{
                    JOptionPane.showMessageDialog(startView.this, "Silahkan Perkiksa Username dan Password", "Gagal Login", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        cardStart.add(labelUsernameLoginAdmin);
        cardStart.add(txtUsernameLoginAdmin);
        cardStart.add(errorUsernameLoginAdmin);
        cardStart.add(labelPasswordLoginAdmin);
        cardStart.add(txtPasswordLoginAdmin);
        cardStart.add(errorPasswordLoginAdmin);
        cardStart.add(loginButtonLoginAdmin);
        cardStart.add(loginCustomerLoginAdmin);
        cardStart.add(garis1LoginAdmin);
        cardStart.add(garis2LoginAdmin);
        cardStart.add(orLoginAdmin);
        cardStart.add(registerCustomerLoginAdmin);
    }
}




/*
 *  PA   PB   PC   PD
 PA 0/0  0/0  0/0  0/0
 PB 0/0  0/0  0/0  0/0
 PC 0/0  0/0  0/0  0/0
 PD 0/0  0/0  0/0  0/0
 


 *  PA   PB   PC   PD
 PA 0/0  0/0  0/0  0/0
 PB 0/0  0/0  0/0  0/0
 PC 0/0  0/0  0/0  0/0
 PD 0/0  0/0  0/0  0/0

 *  PA   PB   PC   PD
 PA 0/0  0/0  2/1  0/0
 PB 0/0  0/0  0/0  0/0
 PC 1/2  0/0  0/0  0/0
 PD 0/0  0/0  0/0  0/0

 *  PA   PB   PC   PD
 PA 0/0  0/0  0/0  0/0
 PB 0/0  0/0  0/0  0/0
 PC 0/0  0/0  0/0  0/0
 PD 0/0  0/0  0/0  0/0

 *  PA   PB   PC   PD
 PA 0/0  0/0  0/0  0/0
 PB 0/0  0/0  0/0  0/0
 PC 0/0  0/0  0/0  0/0
 PD 0/0  0/0  0/0  0/0
 * 
 */