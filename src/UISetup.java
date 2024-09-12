import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.String;

public class UISetup extends Calculator implements ActionListener, MouseListener {
    //Creating Textfields for Addition and Subtraction
    static JTextField hr1 = new JTextField("hrs"); //Addition/Subtraction first hours textfield
    static JTextField min1 = new JTextField("mins"); //Addition/Subtraction first minutes textfield
    static JTextField sec1 = new JTextField("secs"); //Addition/Subtraction first seconds textfield
    static JTextField dec1 = new JTextField("dec"); //Addition/Subtraction first decimals textfield
    static JTextField hr2 = new JTextField("hrs"); //Addition/Subtraction second hours textfield
    static JTextField min2 = new JTextField("mins"); //Addition/Subtraction second minutes textfield
    static JTextField sec2 = new JTextField("secs"); //Addition/Subtraction second seconds textfield
    static JTextField dec2 = new JTextField("dec"); //Addition/Subtraction second decimals textfield
    static JTextField totHrAS = new JTextField(); //Addition/Subtraction total hours text field
    static JTextField totMinAS = new JTextField(); //Addition/Subtraction total minutes text field
    static JTextField totSecAS = new JTextField(); //Addition/Subtraction total seconds text field
    static JTextField totDecAS = new JTextField(); //Addition/Subtraction total decimals text field

    static int h1;
    static int m1;
    static int s1;
    static int d1;
    static int h2;
    static int m2;
    static int s2;
    static int d2;
    static int h;
    static int m;
    static int s;
    static int d;
    static int t;



    //Creating Textfields for Multiplication and Division
    static JTextField totHrMD = new JTextField(); //Multiplication/Division total hours text field
    static JTextField totMinMD = new JTextField(); //Multiplication/Division total minutes text field
    static JTextField totSecMD = new JTextField(); //Multiplication/Division total seconds text field
    static JTextField totDecMD = new JTextField(); //Multiplication/Division total decimals text field
    static JTextField times = new JTextField(); //Multiplication/Division number to multiply/divide by text field
    static JTextField hr = new JTextField("hrs"); //Multiplication/Division input hours text field
    static JTextField min = new JTextField("mins"); //Multiplication/Division input minutes text field
    static JTextField sec = new JTextField("secs"); //Multiplication/Division input seconds text field
    static JTextField dec = new JTextField("dec"); //Multiplication/Division input decimals text field
    //End Creating Textfields
    static Button calcMD = new Button(); //Calculate Button for Multiplication and Division
    static Button resetMD = new Button(); //Reset Button for Multiplication and Division
    static Button calcAS = new Button(); // Calculate Button for Addition and subtraction
    static Button resetAS = new Button(); //Reset Button for addition and subtraction
    static Button asMenuButton = new Button(); //Button to get to the addition and subtraction menu
    static Button mdMenuButton = new Button(); // Button to get to the multiplication menu
    JButton b = new JButton("OK");
    static JMenuItem item;
    static String text = null;

    JFrame addSub = new JFrame();

    JFrame mulDiv = new JFrame();

    JFrame menu = new JFrame();

    static JFrame errorBox = new JFrame("Error");
    //solve s = new solve(); //hopefully isnt neccesary
    static boolean validation = false;



    UISetup() {
        //Creating the beginning menu frame

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(new Dimension(300,300));
        menu.setTitle("Running Calculator Menu");

        //Creating the addition and subtraction frame

        addSub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addSub.setSize(new Dimension(1000, 300));
        addSub.setTitle("Addition/Subtraction Menu");

        //Creating the multiplication and division frame
        mulDiv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mulDiv.setSize(new Dimension(1000,300));
        mulDiv.setTitle("Multiplication/Division Menu");


        //Creating a Menu Bar and Menu for addition and subtraction
        JMenuBar aSMB = new JMenuBar();
        JMenu x = new JMenu("+/-");
        JMenuItem m1 = new JMenuItem("+");
        JMenuItem m2 = new JMenuItem("-");

        x.add(m1);
        x.add(m2);

        aSMB.add(x);
        //end creating menu bar and menu

        //Creating a Menu Bar and Menu for addition and subtraction
        JMenuBar mDMB = new JMenuBar();
        JMenu y = new JMenu("x/÷");
        JMenuItem n1 = new JMenuItem("x");
        JMenuItem n2 = new JMenuItem("÷");
        y.add(n1);
        y.add(n2);
        mDMB.add(y);



        //Adding labels for the Calculate/Reset Buttons
        calcMD.setLabel("Calculate");
        resetMD.setLabel("Reset");
        calcAS.setLabel("Calculate");
        resetAS.setLabel("Reset");
        asMenuButton.setLabel("Addition/Subtraction");
        mdMenuButton.setLabel("Multiplication/Division");




        //Setting up the JPanel for the Main Menu
        JPanel mm = new JPanel();
        BoxLayout boxlayout = new BoxLayout(mm, BoxLayout.Y_AXIS);
        mm.setLayout(boxlayout);
        mm.setBorder(new EmptyBorder(new Insets(100,150,100,150)));
        mm.add(asMenuButton);
        mm.add(mdMenuButton);


        //Setting up the JPanel for the Addition and Subtraction UI
        JPanel aSP = new JPanel(new GridLayout(3, 3, 0, 10)); //3 rows, 4 columns, 0pixel horizontal gap, 10 pixel vertical gap
        aSP.add(new JLabel("Add/Sub"));
        aSP.add(aSMB);
        aSP.add(hr1);
        aSP.add(new JLabel(":"));
        aSP.add(min1);
        aSP.add(new JLabel(":"));
        aSP.add(sec1);
        aSP.add(new JLabel("."));
        aSP.add(dec1);

        aSP.add(resetAS);
        aSP.add(calcAS);

        aSP.add(hr2);
        aSP.add(new JLabel(":"));
        aSP.add(min2);
        aSP.add(new JLabel(":"));
        aSP.add(sec2);
        aSP.add(new JLabel("."));
        aSP.add(dec2);
        //textfields and labels for finalTime
        aSP.add(new JLabel("Hrs"));
        aSP.add(totHrAS);//Final time textfields and labels
        aSP.add(new JLabel(": Mins"));
        aSP.add(totMinAS);//Final time textfields and labels
        aSP.add(new JLabel(": Sec"));
        aSP.add(totSecAS);//Final time textfields and labels
        aSP.add(new JLabel(". Dec"));
        aSP.add(totDecAS);//Final time textfields and labels
        //End Add Sub Panel

        //Setting up the JPanel for the multiplication and Division UI
        JPanel mDP = new JPanel(new GridLayout(3,3,10,10));
        //Row 1
        mDP.add(hr);
        mDP.add(new JLabel(":"));
        mDP.add(min);
        mDP.add(new JLabel(":"));
        mDP.add(sec);
        mDP.add(new JLabel("."));
        mDP.add(dec);
        mDP.add(new JLabel("________________"));
        //Row 2
        mDP.add(new JLabel("Mul/Div"));
        mDP.add(mDMB); //Menubar

        mDP.add(new JLabel("Mul/Div by how many times"));
        mDP.add(times);//textfield for the times you're dividing or multiplying by
        mDP.add(resetMD);//reset button
        mDP.add(calcMD);//calculate button
        mDP.add(new JLabel("________________"));
        mDP.add(new JLabel("________________"));

        //Row 3
        mDP.add(new JLabel("Hrs"));
        mDP.add(totHrMD);//Final time textfields and labels
        mDP.add(new JLabel(": Mins"));
        mDP.add(totMinMD);//Final time textfields and labels
        mDP.add(new JLabel(": Sec"));
        mDP.add(totSecMD);//Final time textfields and labels
        mDP.add(new JLabel(". Dec"));
        mDP.add(totDecMD);//Final time textfields and labels

    //Creating Error Box
        JPanel p = new JPanel();
        p.add(new JLabel("Make sure you have valid number inputs"));
        b.addActionListener(this);
        p.add(b);
        errorBox.add(p);
        errorBox.setSize(250,150);



        //adding the JPanel to the frame
        addSub.add(aSP);
        mulDiv.add(mDP);
        menu.add(mm);
        menu.pack();


        asMenuButton.addActionListener(this);
        mdMenuButton.addActionListener(this);
        calcMD.addActionListener(this);
        calcAS.addActionListener(this);
        resetAS.addActionListener(this);
        resetMD.addActionListener(this);
        m1.addActionListener(this);
        m2.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);

        x.addMouseListener(this);

        //mulDiv.setVisible(true);
        menu.setVisible(true);
        //addSub.setVisible(true);
    }




    public void actionPerformed (ActionEvent e){

        if(e.getSource() == b)
        {
            errorBox.setVisible(false);
        }

        if(e.getSource() == resetAS || e.getSource() == resetMD){
            addSub.setVisible(false);
            mulDiv.setVisible(false);
            menu.setVisible(true);
        }

        if(e.getSource() == asMenuButton){
            menu.setVisible(false);
            addSub.setVisible(true);
        }
        else if(e.getSource() == mdMenuButton){
            menu.setVisible(false);
            mulDiv.setVisible(true);
        }

        if(e.getSource() instanceof JMenuItem) {
            item = (JMenuItem) e.getSource();
            text = item.getText();
            System.out.println(text);
        }


            if (e.getSource() == calcAS) {
                try {
                    h1 = Integer.parseInt(hr1.getText());
                    m1 = Integer.parseInt(min1.getText());
                    s1 = Integer.parseInt(sec1.getText());
                    h2 = Integer.parseInt(hr2.getText());
                    m2 = Integer.parseInt(min2.getText());
                    s2 = Integer.parseInt(sec2.getText());
                    d1 = Integer.parseInt(dec1.getText());
                    d2 = Integer.parseInt(dec2.getText());
                }
                catch(NumberFormatException a){
                    errorBox.setVisible((true));
                }
                /*
                    if((h1>=0)||(m1>=0)||(s1>=0)||(d1>=0)||(h2>=0)||(m2>=0)||(s2>=0)||(d2>=0)){
                        validation = true;

                      }

                 */

                Calculator t1 = new Calculator(h1, m1, s1, d1);
                Calculator t2 = new Calculator(h2, m2, s2, d2);
                System.out.println("two times are set up");

                //Sign validation

                if (text.equals("+")) {
                    Calculator ac = addition(t1, t2);
                    display(ac);

                    totHrAS.setText(String.valueOf(ac.getHours()));
                    totMinAS.setText(String.valueOf(ac.getMinutes()));
                    totSecAS.setText(String.valueOf(ac.getSeconds()));
                    totDecAS.setText(String.valueOf(ac.getDecimal()));
                }
                if(text.equals("-")){
                    Calculator sc = subtraction(t1,t2);
                    if(sc.getHours() ==-1 && sc.getMinutes() == -1 && sc.getSeconds() == -1 &&sc.getDecimal()==-1){
                        errorBox.setVisible(true);
                        return;
                    }
                    display(sc);

                    totHrAS.setText(String.valueOf(sc.getHours()));
                    totMinAS.setText(String.valueOf(sc.getMinutes()));
                    totSecAS.setText(String.valueOf(sc.getSeconds()));
                    totDecAS.setText(String.valueOf(sc.getDecimal()));
                }
            }

            if(e.getSource() == calcMD){
                try {
                    h = Integer.parseInt(hr.getText());
                    m = Integer.parseInt(min.getText());
                    s = Integer.parseInt(sec.getText());
                    d = Integer.parseInt(dec.getText());
                    t = Integer.parseInt(times.getText());
                }
                catch(NumberFormatException a){
                    errorBox.setVisible(true);

                }
                Calculator input = new Calculator(h,m,s,d);
                int x = t;

                //Sign validation

                if(text.equals("x")){
                    Calculator mc = multiplication(input,x);
                    display(mc);

                    totHrMD.setText(String.valueOf(mc.getHours()));
                    totMinMD.setText(String.valueOf(mc.getMinutes()));
                    totSecMD.setText(String.valueOf(mc.getSeconds()));
                    totDecMD.setText(String.valueOf(mc.getDecimal()));
                }
                if(text.equals("÷")){
                    Calculator dc = division(input,x);
                    display(dc);

                    totHrMD.setText(String.valueOf(dc.getHours()));
                    totMinMD.setText(String.valueOf(dc.getMinutes()));
                    totSecMD.setText(String.valueOf(dc.getSeconds()));
                    totDecMD.setText(String.valueOf(dc.getDecimal()));
                }
            }
            //System.out.println("We got to this point");

        }




    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof JMenuItem){
            //Set JMenuText to JMenuItem that was pressed
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
