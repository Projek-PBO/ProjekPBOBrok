package com.program;

import com.views.dashboardAdminView;
import com.views.dashboardCustomerView;
import com.views.startView;

public class Controler {

    private static startView frameLoginAndRegister = new startView();

    public static void showLoginCustomer(){

        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginCustomer();
        frameLoginAndRegister.setVisible(true);
        
    }
    
    public static void showDaftarCustomer(){

        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsDaftarCustomer();
        frameLoginAndRegister.setVisible(true);
        
    }
    
    public static void showLoginAdmin(){
        
        frameLoginAndRegister.setVisible(false);
        frameLoginAndRegister.initsLoginAdmin();
        frameLoginAndRegister.setVisible(true);

    }

    public static void showDashboardCustomer(String id){
        dashboardCustomerView dashboardCustomer = new dashboardCustomerView(id);
        dashboardCustomer.setVisible(true);
    }

    public static void showDashboardAdmin(){
        dashboardAdminView dashboardAdmin = new dashboardAdminView();
        dashboardAdmin.setVisible(true);
    }


}
