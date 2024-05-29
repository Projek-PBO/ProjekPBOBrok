package com.partials;
import javax.swing.JPasswordField;

public class cFormPassword extends JPasswordField{

    public cFormPassword(int x, int y, int width, boolean centerAlignment){
        super();
        setBounds(x, y, width, 30);
        if(centerAlignment){
            setHorizontalAlignment(JPasswordField.CENTER);
        }
        setFont(cFonts.FORM_LABEL_FONT);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.ORANGE, 1));
    }

}
