package com.partials;
import javax.swing.JTextArea;

public class cTextArea extends JTextArea{

    public cTextArea (int x, int y, int width, int height){
        super();
        setBounds(x, y, width, height);
        setFont(cFonts.FONT_RADIO);
        setBackground(cColor.WHITE);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBorder(new javax.swing.border.LineBorder(cColor.ORANGE, 1));
    }

}
