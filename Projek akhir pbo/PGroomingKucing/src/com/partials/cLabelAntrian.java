package com.partials;   
import javax.swing.JLabel;

public class cLabelAntrian extends JLabel{

    public cLabelAntrian(String text, int x, int y, int width, boolean centerAlignment){

        super();
        setText(text);
        setBounds(x, y, width, 30);
        if(centerAlignment){
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_ANTRIAN);
        setForeground(cColor.BLACK);
    }

}