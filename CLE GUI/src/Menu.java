import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    JLabel menuBgLabel = new JLabel();
    ImageIcon menuBg = new ImageIcon("CLE GUI\\MenuBg.jpg");
    Image logo = Toolkit.getDefaultToolkit().getImage("logo1.png");
    Image image;

    Menu() {
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(screensize.width, screensize.height);
        this.setIconImage(logo);


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

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
