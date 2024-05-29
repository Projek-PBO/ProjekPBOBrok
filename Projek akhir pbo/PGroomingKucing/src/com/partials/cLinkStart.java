package com.partials;
import javax.swing.JLabel;

public class cLinkStart extends JLabel {

    public cLinkStart(String text, int x, int y, boolean alignment){
    super();
    setText(text);
    setBounds(x, y, 450, 20);
    if(alignment){
        setHorizontalAlignment(JLabel.CENTER);
    }
    setVerticalAlignment(JLabel.CENTER);
    setFont(cFonts.LINK_FONT);
    setForeground(cColor.ORANGE);
    addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseEntered(java.awt.event.MouseEvent e)
      {
        setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      }
      public void mouseExited(java.awt.event.MouseEvent e)
      {
        setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
      }
    });
  }

}
