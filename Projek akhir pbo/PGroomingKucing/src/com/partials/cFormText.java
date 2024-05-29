package com.partials;
import javax.swing.JTextField;

public class cFormText extends JTextField{

    public cFormText(int x, int y, int width, boolean centerAlignment){

        super();
        setBounds(x, y, width, 30);
        if(centerAlignment){
            setHorizontalAlignment(JTextField.CENTER);
        }
        setFont(cFonts.FORM_LABEL_FONT);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.ORANGE, 1));
    }
}
