import javax.swing.*;

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
    private JLabel Result;
    private int currentNum = 0;
    private String numString = "0";
    private int counter = 0;

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
        Equal.addActionListener(e -> {
            evaluate();
            if(numString.equals("ERROR")) {
                Result.setText("Cannot divide by 0");
            }
            else
                Result.setText("= " + numString);
            numString = "0";
            updateLabelNum();
            curState = State.NONE;
        });
        One.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "1";
            }
            else numString += "1";
            updateLabelNum();
        });
        Two.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "2";
            }
            else numString += "2";
            updateLabelNum();
        });
        Three.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "3";
            }
            else numString += "3";
            updateLabelNum();
        });
        Four.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "4";
            }
            else numString += "4";
            updateLabelNum();
        });
        Five.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "5";
            }
            else numString += "5";
            updateLabelNum();
        });
        Six.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "6";
            }
            else numString += "6";
            updateLabelNum();
        });
        Seven.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "7";
            }
            else numString += "7";
            updateLabelNum();
        });
        Eight.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "8";
            }
            else numString += "8";
            updateLabelNum();
        });
        Nine.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "9";
            }
            else numString += "9";
            updateLabelNum();
        });
        Zero.addActionListener(e -> {
            if (numString.equals("0")) {
                numString = "0";
            }
            else numString += "0";
            updateLabelNum();
        });
        Plus.addActionListener(e -> {
            if(curState != State.NONE && !numString.equals("0")){
                evaluate();
            }
            else if (curState != State.PLUS && curState != State.NONE){
                Result.setText(currentNum + " + ");
                curState = State.PLUS;
                return;
            }
            else if (counter > 0) {
                return;
            }
            counter++;
            curState = State.PLUS;
            updateIntNum();
            Result.setText(currentNum + " + ");
            numString = "0";
            updateLabelNum();
        });

        Subtract.addActionListener(e -> {
            if(curState != State.NONE && !numString.equals("0")){
                evaluate();
            }
            else if (curState != State.MINUS && curState != State.NONE){
                Result.setText(currentNum + " - ");
                curState = State.MINUS;
                return;
            }
            else if (counter > 0) {
                return;
            }
            counter++;
            curState = State.MINUS;
            updateIntNum();
            Result.setText(currentNum + " - ");
            numString = "0";
            updateLabelNum();
        });
        Multiply.addActionListener(e -> {
            if(curState != State.NONE && !numString.equals("0")){
                evaluate();
            }
            else if (curState != State.MULTIPLY && curState != State.NONE){
                Result.setText(currentNum + " * ");
                curState = State.MULTIPLY;
                return;
            }
            else if (counter > 0) {
                return;
            }
            counter++;
            curState = State.MULTIPLY;
            updateIntNum();
            Result.setText(currentNum + " * ");
            numString = "0";
            updateLabelNum();
        });
        Divide.addActionListener(e -> {
            if(curState != State.NONE && !numString.equals("0")){
                evaluate();
            }
            else if (curState != State.DIVIDE && curState != State.NONE){
                Result.setText(currentNum + " / ");
                curState = State.DIVIDE;
                return;
            }
            else if (counter > 0) {
                return;
            }
            counter++;
            curState = State.DIVIDE;
            updateIntNum();
            Result.setText(currentNum + " / ");
            numString = "0";
            updateLabelNum();
        });

        Clear.addActionListener(e -> {
            curState = State.NONE;
            currentNum = 0;
            numString = "0";
            updateLabelNum();
            Result.setText("");
            counter = 0;
        });
    }

    public void evaluate() {
        if(curState == State.PLUS)
        {
            currentNum += Integer.parseInt(numString);
        }
        else if(curState == State.MINUS)
        {
            currentNum -= Integer.parseInt(numString);
        }
        else if(curState == State.MULTIPLY)
        {
            currentNum *= Integer.parseInt(numString);
        }
        else if(curState == State.DIVIDE)
        {
            if(numString.equals("0")) {
                currentNum = 0;
                numString = "ERROR";
                counter = 0;
                return;
            }
            currentNum /= Integer.parseInt(numString);
        }
        numString = String.valueOf(currentNum);
        updateLabelNum();
        counter = 0;
    }

    public void updateLabelNum() {
        NumberLabel.setText(numString);
    }

    public void updateIntNum() {
        currentNum = Integer.parseInt(numString);
    }

    public static void main(String[] args){
        Frame mainFrame = new Frame();
    }
}
