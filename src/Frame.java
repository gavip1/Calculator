import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JButton Equal;
    private JPanel mainPanel;
    private JButton One;
    private JButton Plus;
    private int currentNum = 0;
    private int nextNum = 0;

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
        setSize(500, 700);
        setVisible(true);
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
                    currentNum = 1; //Change this behavior to calculator 'append' format
                } else nextNum = 1; //This too
            }
        });
        Plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curState != State.NONE) {
                    currentNum = evaluate();
                }
                curState = State.PLUS;
            }
        });
    }

    public int evaluate() {
        if (curState == State.PLUS) {
            curState = State.NONE;
            return (currentNum + nextNum);
        } else if (curState == State.NONE) {
            return (currentNum);
        }
        return 0;
    }

    public static void main(String[] args){
        Frame mainFrame = new Frame();
    }
}
