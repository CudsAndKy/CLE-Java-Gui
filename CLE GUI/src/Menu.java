import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener, MouseListener{
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon menuBg = new ImageIcon("CLE GUI\\MenuBg.png");
    Image logo = Toolkit.getDefaultToolkit().getImage("logo1.png");
    ImageIcon sysLogo = new ImageIcon("CLE GUI\\logo1.png");
    Image image;
    JLabel menuBgLabel = new JLabel();
    JLabel sysLogoLabel = new JLabel();
    JLabel About = new JLabel();
    JLabel Contributors = new JLabel();
    JLabel faq = new JLabel();

    Menu() {
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(screensize.width, screensize.height);
        this.setIconImage(logo);

        //About
        About.setText("ABOUT");
        About.setFont(new Font("Calibri", Font.PLAIN, 15));
        About.setBounds(180, 50, 150, 50);
        About.setForeground(Color.white);
        About.addMouseListener(this);
        this.add(About) ;

        //Contributors 
        Contributors.setText("CONTRIBUTORS");
        Contributors.setFont(new Font("Calibri", Font.PLAIN, 15));
        Contributors.setBounds(575, 50, 150, 50);
        Contributors.setForeground(Color.white);
        Contributors.addMouseListener(this);
        this.add(Contributors);
 

        //FAQs
        faq.setText("FAQs");
        faq.setFont(new Font("Calibri", Font.PLAIN, 15));
        faq.setBounds(screensize.width-500, 50, 150, 50);
        faq.setForeground(Color.white);
        faq.addMouseListener(this);
        this.add(faq);



        resizeSysLogo();
        this.add(sysLogoLabel);

        resizeMenuBg();
        this.add(menuBgLabel);
        this.setVisible(true);

    }

    public void resizeMenuBg() {
        image = menuBg.getImage();
        int width = screensize.width;
        int height = screensize.height;
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        menuBgLabel.setIcon(resizedIcon);
        menuBgLabel.setBounds(0, 0, width, height);
    }

    public void resizeSysLogo() {
        image = sysLogo.getImage();
        int width = 100;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        sysLogoLabel.setIcon(resizedIcon);
        sysLogoLabel.setBounds(70, 30, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
