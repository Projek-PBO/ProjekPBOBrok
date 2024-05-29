package com.partials;   
import javax.swing.JLabel;

public class cLabelPesanan extends JLabel{

    public cLabelPesanan(String text, int x, int y, int width, boolean centerAlignment){

        super();
        setText(text);
        setBounds(x, y, width, 30);
        if(centerAlignment){
            setHorizontalAlignment(JLabel.CENTER);
        }
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.LABEL_PESANAN);
        setForeground(cColor.BLACK);
    }

}