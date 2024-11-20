import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UIHandler extends JFrame implements ActionListener, MouseListener {
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon homepageBg = new ImageIcon("HomepageBg.png");
    ImageIcon sctxt = new ImageIcon("sugarcaneFarmTxt.png");
    ImageIcon mstxt = new ImageIcon("mgmtSystemTxt.png");
    ImageIcon loginButton = new ImageIcon("loginButton.png");
    ImageIcon sysLogo = new ImageIcon("logo1.png");
    Image image;
    Image logo = Toolkit.getDefaultToolkit().getImage("logo1.png");
    JLabel homepageLabel = new JLabel(homepageBg);
    JLabel sctxtlabel = new JLabel();  
    JLabel mstxtlabel = new JLabel();
    JLabel homeDesc = new JLabel();
    JLabel loginButtonLabel = new JLabel();
    JLabel About = new JLabel();
    JLabel Contributors = new JLabel();
    JLabel faq = new JLabel();
    JLabel sysLogoLabel = new JLabel();


    UIHandler() {
        
        this.setTitle("Sugarcane Farm Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(screensize.width, screensize.height);
        this.setIconImage(logo);

        resizeLogo();
        this.add(sysLogoLabel);

        //SUGARCANE FARM TITLE
        resizeSugarcaneTitle();
        this.add(sctxtlabel);

        //MANAGEMENT SYSTEM TITLE
        resizeMgmtSystemTitle();
        this.add(mstxtlabel);

        resizeLoginButton();
        loginButtonLabel.setText("LOG IN");
        loginButtonLabel.setFont(new Font("Calibri", Font.BOLD, 15));
        loginButtonLabel.setForeground(Color.white);
        loginButtonLabel.setHorizontalTextPosition(JLabel.CENTER);
        loginButtonLabel.addMouseListener(this);
        this.add(loginButtonLabel);

        //Description
        homeDesc.setBounds(110, 230, 570, 500);
        homeDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
        homeDesc.setHorizontalTextPosition(JLabel.CENTER);
        homeDesc.setText("<html>The Sugarcane Field Management System is an OOP-based solution designed to streamline farm operations by automating task recording seasonal tracking, and report generation. It simplifies the management of activities with centralized data storage, intuitive user interfaces, and customizable reports.</html>");
        homeDesc.setForeground(Color.white);
        this.add(homeDesc);

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

        
        
        
        homepagePanel.setOpaque(false);
        homepagePanel.setBounds(0, 0, (int)(screensize.width * 0.85), screensize.height);        
        this.add(homepagePanel);
        upHomepagePanel.setOpaque(false);
        upHomepagePanel.setBounds(0, 0, screensize.width, screensize.height/2 );
        this.add(upHomepagePanel);

        //Homepage Background
        setHomepageBg(); 
        this.add(homepageLabel);
        this.setVisible(true);
    }


    public void setHomepageBg() {
        image = homepageBg.getImage();
        int width = screensize.width;
        int height = screensize.height;
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        homepageLabel.setIcon(resizedIcon);
        homepageLabel.setBounds(0,0, width, height);
    }

    public void resizeLogo() {
        image = sysLogo.getImage();
        int width = 100;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        sysLogoLabel.setIcon(resizedIcon);
        sysLogoLabel.setBounds(screensize.width-230, 40, width, height);
    }

    public void resizeSugarcaneTitle() {
        image = sctxt.getImage();
        int width = 600;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        sctxtlabel.setIcon(resizedIcon);
        sctxtlabel.setBounds(100, 300, width, height);
    }

    public void resizeMgmtSystemTitle() {
        image = mstxt.getImage();
        int width = 400;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        mstxtlabel.setIcon(resizedIcon);
        mstxtlabel.setBounds(180, 380, width, height);
    }

    public void resizeLoginButton() {
        image = loginButton.getImage();
        int width = 130;
        int height = (int) ((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        loginButtonLabel.setIcon(resizedIcon);
        loginButtonLabel.setBounds(280, 550, width, height);
    }

    public void hoverlogin() {
        image = loginButton.getImage();
        int width = 140;
        int height = (int)((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        loginButtonLabel.setIcon(resizedIcon);
        loginButtonLabel.setBounds(275, 560, width, height);

    }

    JPanel homepagePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //for smooth edges
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            //Rectangle's position and size
            int x = 0;
            int y = 0;
            int width = (int) (screensize.width * 0.85);
            int height = screensize.height;

            //Gradient Color with transparency
            Color startColor = new Color(0, 0, 0, 255);
            Color endColor = new Color(0, 0, 0, 0);

            GradientPaint gradient = new GradientPaint(
                x,y, startColor, //Start point (left)
                x+width, y, endColor //End point (right)
            );

            //Apply the gradient paint
            g2d.setPaint(gradient);
            //Fill the rectangle with the gradient
            g2d.fillRect(x, y, width, height);
        }
    };

    JPanel upHomepagePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int x = 0;
            int y = 0;
            int width = screensize.width;
            int height = screensize.height/2;
            Color startColor = new Color(0,0,0,255);
            Color endColor = new Color(0,0,0,0);
            GradientPaint gradient = new GradientPaint(
                x, y, startColor,
                x, y+height, endColor
            );

            g2d.setPaint(gradient);
            g2d.fillRect(x, y, width, height);

        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==loginButtonLabel) {
            hoverlogin();
            loginButtonLabel.revalidate();
            loginButtonLabel.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==loginButtonLabel) {
            resizeLoginButton();
            loginButtonLabel.revalidate();
            loginButtonLabel.repaint();
        }
    }

}
