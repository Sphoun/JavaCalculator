import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Created by scott on 2016-07-28.
 */

public class Calculator extends JFrame implements ActionListener
{
    JPanel row[]           = new JPanel[5];
    JButton button[]       = new JButton[19];
    String buttonStrings[] = {"7", "8", "9","+", "C",
                              "4", "5", "6","-", "M",
                              "3", "2", "1","*", "+/-",
                              "0", ".", "/", "="};

    int [] dimenW               = {285, 45, 100, 90};
    int [] dimenH               = {35, 40};
    Dimension screenDimension   = new Dimension(dimenW[0], dimenH[0]);
    Dimension regDimension      = new Dimension(dimenW[1], dimenH[1]);
    Dimension rColDimension     = new Dimension(dimenW[2], dimenH[1]);
    Dimension zeroDimension     = new Dimension(dimenW[3], dimenH[1]);

    boolean [] func = new boolean[4];
    float [] inputVals = new float[20]; // 20 max digs

    Font font           = new Font("Times new Roman", Font.BOLD, 14);
    JTextArea display   = new JTextArea(1,20);
    GridLayout grid     = new GridLayout(5,5);
    FlowLayout f1       = new FlowLayout(FlowLayout.CENTER);
    FlowLayout f2       = new FlowLayout(FlowLayout.CENTER, 1, 1);


    public Calculator()
    {
        super("Java Calculator");

        init();

        // Functions
        for(int i = 0; i < 4; i++) func[i] = false;

        // Layout
        for(int i = 0; i < 5; i++)
        {
            row[i] = new JPanel();
            if(i != 0) row[i].setLayout(f2);
        }
        row[0].setLayout(f1);
        row[0].add(display);

        // Buttons
        for(int i = 0; i < 19; i++)
        {
            button[i] = new JButton();
            button[i].setText(buttonStrings[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

        // Button sizes
        for(int i = 0; i < 15; i++) button[i].setPreferredSize(regDimension);
        button[15].setPreferredSize(zeroDimension);
        for(int i = 16; i < 19; i++) button[i].setPreferredSize(regDimension);
        button[4].setPreferredSize(rColDimension);
        button[9].setPreferredSize(rColDimension);
        button[14].setPreferredSize(rColDimension);
        button[18].setPreferredSize(rColDimension);
        display.setPreferredSize(screenDimension);

        // Row assignments
        for(int i = 0; i < 5; i++) row[1].add(button[i]);
        for(int i = 5; i < 10; i++) row[2].add(button[i]);
        for(int i = 10; i < 15; i++) row[3].add(button[i]);
        for(int i = 15; i < 19; i++) row[4].add(button[i]);

        for(int i = 0; i < 5; i++) add(row[i]);
    }

    public final void init()
    {
        setLayout(grid);
        setVisible(true);
        setResizable(false);
        setSize(320,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public void actionPerformed(ActionEvent ae)
    {

    }
}
