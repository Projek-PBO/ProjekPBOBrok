package com.partials;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.program.Controler;

public class cLinkLogout extends JLabel{

    public cLinkLogout(int x){
        super();

        setBounds(x, 0, 82, 70);
        setText("Logout");
        setFont(cFonts.LINK_EXIT_FONT);
        setForeground(cColor.WHITE);
        addMouseListener(new java.awt.event.MouseAdapter(){

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
            public void mouseClicked(java.awt.event.MouseEvent e){
                Object[] options = { "IYA", "BATAL" };
                int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin Log out?", "Konfirmasi Logout", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if( konfirmasi == 0 ){
                  Controler.showLoginCustomer();
                }
            }
        });
    }
    
}