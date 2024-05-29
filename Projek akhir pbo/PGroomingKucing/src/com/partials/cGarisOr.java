package com.partials;
import javax.swing.JButton;

public class cGarisOr extends JButton {

    public cGarisOr(int y, int x, int width){

        super();
        setBounds(x, y, width, 2);
        setFont(cFonts.FORM_LABEL_FONT);
        setBackground(cColor.ORANGE);
        setBorder(null);


    }

}
