import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JButton Equal;
    private JPanel mainPanel;
    private JButton One;
    private JButton Plus;
    private JButton Two;
    private JButton Three;
    private JButton Four;
    private JButton Five;
    private JButton Six;
    private JButton Seven;
    private JButton Eight;
    private JButton Nine;
    private JButton Zero;
    private JButton Subtract;
    private JButton Multiply;
    private JButton Divide;
    private JButton Clear;
    private JLabel NumberLabel;
    private int currentNum = 0;
    private String numString = "0";

    private enum State {
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        NONE
    }

    State curState = State.NONE;

    public Frame() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
        NumberLabel.setText(String.valueOf(currentNum));
        Equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(evaluate());
            }
        });
        One.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curState == State.NONE) {
                    if (numString.equals("0")) {
                        numString = "1";
                    }
                    else numString += "1";
                }
                else {
                    currentNum = Integer.parseInt(numString);
                    numString = "1";
                    curState = State.NONE;
                }
                updateNum();
            }
        });
        Plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curState != State.NONE) {
                    currentNum = evaluate();
                }
                curState = State.PLUS;
                updateNum();
            }
        });
    }

    public int evaluate() {
        if(curState == State.PLUS)
        {
            currentNum += Integer.parseInt(numString);
            numString = String.valueOf(currentNum);
        }
        updateNum();
        curState = State.NONE;
        return (currentNum);
    }

    public void updateNum() {
        NumberLabel.setText(numString);
    }

    public static void main(String[] args){
        Frame mainFrame = new Frame();
    }
}
