package com.templates;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.partials.cLinkKeluar;
import com.partials.cColor;
import com.partials.cFonts;


public abstract class cStartFrame extends JFrame {

    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("../../gambar/ayam geprek pas.png");
    JLabel foto = new JLabel(icon);

    public JPanel bg = new JPanel();
    public JPanel cardStart = new JPanel();
    public JPanel cardShadow = new JPanel();
    public cLinkKeluar linkKeluar = new cLinkKeluar(1268);
    public JLabel titleStart = new JLabel("Selamat Datang Grooming");

    
    public cStartFrame(){
        super();
        setSize(1380, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(cStartFrame.EXIT_ON_CLOSE);
        
        bg.setBackground(cColor.ORANGE);
        bg.setBounds(0 ,0, 1380, 800);
        bg.setLayout(null);
        
        cardStart.setBackground(cColor.WHITE90);
        cardStart.setBounds(465, 150, 450, 500);
        cardStart.setLayout(null);

        titleStart.setFont(cFonts.TITLE_START_FONT);
        titleStart.setForeground(cColor.BLACK);
        titleStart.setBounds(0, 45, 450, 40);
        titleStart.setHorizontalAlignment(JLabel.CENTER);
        titleStart.setVerticalAlignment(JLabel.CENTER);

        cardStart.add(titleStart);
        bg.add(linkKeluar);
        add(foto);
        add(cardStart);
        add(cardShadow);
        add(bg);

    }

    public cStartFrame(String title){
        this();
        setTitle(title);
    }

}
