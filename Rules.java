import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
public class Rules extends JFrame implements ActionListener, ItemListener {
    private JLabel header;
    private JLabel goalHeader;
    private JLabel goal;
    private JLabel rules;
    private JLabel r1;
    private JLabel r2;
    private JLabel r3;
    private JLabel r4;
    private JLabel r5;
    private JCheckBox understood;
    private JButton done;
    private String sr1;
    private String sr2;
    private String sr3;
    private String sr4;
    private String sr5;
    public BackEnd game;

    Rules(BackEnd newBackEnd){
        game = newBackEnd;
        //Declaration of Strings
        sr1 = "1. When a 6 is rolled, you have to move a figure out of base!";
        sr2 = "2. you have to keep your start-field free, as long as there are figures in your Base";
        sr3 = "3. If possible, you must kick another person! If you didn't your figure, that was able to kick someone, will get moved to your Base.";
        sr4 = "4. In order to get into your house you have to get the exact number, you can't go in with a number, that is to high.";
        sr5 = "5. You cannot jump over your figures in your House.";


        //declaration of the JLabels & the JCheckBox
        header = new JLabel("Info");
        goalHeader = new JLabel("Goal of the Game:");
        goal = new JLabel("The Goal is to get all of your 4 figures into your House. \nIn order to get there you have to kick your opponents figures.");
        rules = new JLabel("Rules: ");
        r1 = new JLabel(sr1);
        r2 = new JLabel(sr2);
        r3 = new JLabel(sr3);
        r4 = new JLabel(sr4);
        r5 = new JLabel(sr5);

        understood = new JCheckBox("I read and understood the rules of the game", false);
        done = new JButton("done");

        //settings of headers
        Font fontHeading = new Font(header.getFont().getName(), Font.PLAIN, 40);
        header.setFont(fontHeading);
        header.setBounds(13, 5, 150, 70);
        Font fontGoalheading = new Font(goalHeader.getFont().getName(), Font.PLAIN, 20);
        goalHeader.setFont(fontGoalheading);
        goalHeader.setBounds(40, 80, 300, 50);
        Font fontRules = new Font(rules.getFont().getName(), Font.PLAIN, 20);
        rules.setFont(fontRules);
        rules.setBounds(40, 170, 300, 50);

        //position of all j-components
        goal.setBounds(40, 130, 600, 32);
        r1.setBounds(40, 200, 600, 32);
        r2.setBounds(40, 230, 600, 32);
        r3.setBounds(40, 260, 600, 32);
        r4.setBounds(40, 290, 600, 32);
        r5.setBounds(40, 320, 600, 32);

        understood.setBounds(40, 500, 600, 32);
        understood.addItemListener(this);

        done.setBounds(40, 580, 80, 32);
        done.addActionListener(this);
        done.setBackground(Color.green);

        //Add all the j-components to the content Panel
        add(header);
        add(goalHeader);
        add(goal);
        add(rules);
        add(r1);
        add(r2);
        add(r3);
        add(r4);
        add(r5);
        add(understood);

        //apply all needed values for the JFrame
        adjustJFrameSetting();
    }

    public boolean getCheckboxSetting(){
        return understood.isSelected();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(getCheckboxSetting()){
            add(done);
        } else {
            remove(done);
        }
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        game.gui.setVisible(true);
    }


    private void adjustJFrameSetting(){
        setTitle("Overview Rules");
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Color.BLACK);
        setResizable(true);
        setVisible(true);
    }
}
