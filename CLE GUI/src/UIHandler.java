import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.*;

public class UIHandler extends JFrame implements ActionListener, MouseListener {
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    ImageIcon homepageBg = new ImageIcon("CLE GUI\\HomepageBg.png");
    ImageIcon sctxt = new ImageIcon("CLE GUI\\sugarcaneFarmTxt.png");
    ImageIcon mstxt = new ImageIcon("CLE GUI\\mgmtSystemTxt.png");
    ImageIcon loginButton = new ImageIcon("CalcButton.png");
    ImageIcon sysLogo = new ImageIcon("CLE GUI\\logo1.png");
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
    JLabel lglabel = new JLabel();
    JLabel invalidMessage = new JLabel();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();


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
        loginButtonLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginButtonLabel.setForeground(Color.black);
        loginButtonLabel.setHorizontalTextPosition(JLabel.CENTER);
        

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

        loginPrompt();
        invalidMessage.setText("Invalid username or password. Please enter again.");
        invalidMessage.setFont(new Font("Calibri", Font.PLAIN, 15));
        invalidMessage.setForeground(Color.white);
        invalidMessage.setBounds(940, 280, 350, 50);
        invalidMessage.setVisible(false);
        this.add(invalidMessage);

        //username and password
        username.setBounds(1000, 400, 200, 30);
        username.setOpaque(false);
        username.setBackground(new Color(0, 0, 0, 150));
        username.setText("Enter Username");
        username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        username.setForeground(Color.white);
        this.add(username);
    
        username.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (username.getText().equals("Enter Username")) {
            username.setText("");
            username.setForeground(Color.white);
            }
        }

        @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().trim().isEmpty()) {
                    username.setText("Enter Username");
                    username.setForeground(Color.white); 
                }
            }
        });

        

      
        JPasswordField password = new JPasswordField();
        password.setBounds(1000, 500, 200, 30);
        password.setOpaque(false);
        password.setBackground(new Color(0, 0, 0, 150));
        password.setEchoChar((char)0);
        password.setText("Enter Password");
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        password.setForeground(Color.white);
        this.add(password);

        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(password.getPassword()).equals("Enter Password")) {
                    password.setText("");
                    password.setEchoChar('*'); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(password.getPassword()).trim().isEmpty()) {
                    password.setText("Enter Password");
                    password.setEchoChar((char) 0); 
                }
            }
        });


        loginButtonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the username and password inputs
                String enteredUsername = username.getText().trim();
                char[] enteredPasswordArray = password.getPassword();  
                String enteredPassword = String.valueOf(enteredPasswordArray).trim(); 

                
                if (enteredUsername.equals("admin123") && enteredPassword.equals("admin123")) {
                    dispose(); 
                    new Menu(); 
                } else {
                    lglabel.setVisible(false); 
                    invalidMessage.setVisible(true); 
                }
            }
        });

        this.add(loginButtonLabel);


        //added to homepage
        glassPanel.setOpaque(false);
        glassPanel.setBounds(850, 200, 500, 500);
        this.add(glassPanel);
        
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




   // =============================== METHODS ======================================================================

    public void loginPrompt() {
        lglabel.setText("Please Login To your Account.");
        lglabel.setFont(new Font("Calibri", Font.PLAIN, 15));
        lglabel.setBounds(1000, 280, 350, 50);
        lglabel.setForeground(Color.white);
        lglabel.setHorizontalTextPosition(JLabel.CENTER);
        this.add(lglabel);
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
        loginButtonLabel.setBounds(1030, 590, width, height);
    }

    public void hoverlogin() {
        image = loginButton.getImage();
        int width = 140;
        int height = (int)((double)image.getHeight(null)/image.getWidth(null)*width);
        image = image.getScaledInstance(width, height, image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        loginButtonLabel.setIcon(resizedIcon);
        loginButtonLabel.setBounds(1025, 590, width, height);

    }
    

    JPanel homepagePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

           
            int x = 0;
            int y = 0;
            int width = (int) (screensize.width * 0.85);
            int height = screensize.height;

            
            Color startColor = new Color(0, 0, 0, 255);
            Color endColor = new Color(0, 0, 0, 0);

            GradientPaint gradient = new GradientPaint(
                x,y, startColor, 
                x+width, y, endColor 
            );

          
            g2d.setPaint(gradient);
            
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


    JPanel glassPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
            int x = 10;  
            int y = 10;
            int width = getWidth() - 20;
            int height = getHeight() - 20;
            int arc = 30; 
    
           
            BufferedImage blurredBackground = createBlurredBackground(getWidth(), getHeight(), 15);
    
       
            BufferedImage maskedBackground = applyMask(blurredBackground, x, y, width, height, arc);
            g2d.drawImage(maskedBackground, 0, 0, null);
    
      
            Color glassColor = new Color(255, 255, 255, 80); // Semi-transparent white
            g2d.setColor(glassColor);
            g2d.fillRoundRect(x, y, width, height, arc, arc);
    
      
            Color borderColor = new Color(255, 255, 255, 150);
            g2d.setColor(borderColor);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRoundRect(x, y, width, height, arc, arc);
    
            g2d.dispose();
        }
    };

    private BufferedImage applyMask(BufferedImage source, int x, int y, int width, int height, int arc) {
        BufferedImage masked = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = masked.createGraphics();
    
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, masked.getWidth(), masked.getHeight());
    
    
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(Color.WHITE);
        g2d.fill(new RoundRectangle2D.Float(x, y, width, height, arc, arc));
    

        g2d.setComposite(AlphaComposite.SrcIn);
        g2d.drawImage(source, 0, 0, null);
    
        g2d.dispose();
        return masked;
    }
    

    private BufferedImage createBlurredBackground(int width, int height, int blurRadius) {
        BufferedImage tempImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g2d = tempImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
     
        GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 0, 0, 100), width, height, new Color(0, 0, 0, 50));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
    
        return applyGaussianBlur(tempImage, blurRadius);
    }
    

    private BufferedImage applyGaussianBlur(BufferedImage img, int radius) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage blurred = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = blurred.createGraphics();
        g2d.setComposite(AlphaComposite.Src);

        float[] matrix = new float[radius * radius];
        for (int i = 0; i < radius * radius; i++) {
            matrix[i] = 1.0f / (radius * radius);
        }

        //use convolveop to apply the blur
        ConvolveOp blurOp = new ConvolveOp(new Kernel(radius, radius, matrix), ConvolveOp.EDGE_NO_OP, null);
        blurOp.filter(img, blurred);
        g2d.dispose();
        return blurred;
    }





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

