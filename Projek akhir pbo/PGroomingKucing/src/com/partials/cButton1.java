package com.partials;
import javax.swing.JButton;

public class cButton1 extends JButton {

    public cButton1 (String text, int x, int y, int width, int height){
        super();
        setText(text);
        setBounds(x, y, width, height);
        setFont(cFonts.FORM_LABEL_FONT);
        setBackground(cColor.ORANGE);
        setForeground(cColor.WHITE);
        setBorder(null);

    }

}
