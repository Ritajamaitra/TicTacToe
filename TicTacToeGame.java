import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class TicTacToeGame implements ActionListener{
    JFrame frame = new JFrame();
     JButton[] buttons =  new JButton[9];
     JPanel panel = new JPanel();
     JPanel p = new JPanel();
     JLabel text = new JLabel();
     int flag =0;
     Random random = new Random();
     boolean chance;
     
     TicTacToeGame() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(250, 184, 97));
        frame.setTitle("Tic Tac Toe Game ");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground(new Color(0,0,0));
        text.setForeground(new Color(255,0,0));
        text.setFont(new Font("Helvetica", Font.BOLD, 75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Toe Game in Swing");
        text.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 800, 100);

        p.setLayout(new GridLayout(3, 3));
        p.setBackground(new Color(0, 0, 0));
        for (int i = 0; i < 9; i++) 
        {
            buttons[i] = new JButton();
            p.add(buttons[i]);
            buttons[i].setFont(new Font("Serif", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.cyan);
        }
        
        panel.add(text);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(p);

        startGame();
    }

    public void startGame() {
        try 
        {
            text.setText("Loading....");
            Thread.sleep(4000);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        int chances=random.nextInt(100);

        if (chances%2 == 0) 
        {
            chance = true;
            text.setText("Player X turn");
        } 
        else 
        {
            chance = false;
            text.setText("Player O turn");
        }

    }

    public void gameOver(String s)
    {
        flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if(n==0)
        {
            frame.dispose();
            new TicTacToeGame();
        }
        else
        {
            frame.dispose();
        }
    
    }

    public void matchCheck() 
    {
        if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) 
        {
            xWins(0, 1, 2);
        }
        else if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) 
        {
            xWins(0, 4, 8);
        }
        else if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) 
        {
            xWins(0, 3, 6);
        }
        else if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) 
        {
            xWins(1, 4, 7);
        }
        else if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) 
        {
            xWins(2, 4, 6);
        }
        else if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) 
        {
            xWins(2, 5, 8);
        }
       else if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) 
       {
            xWins(3, 4, 5);
        }
       else if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) 
       {
            xWins(6, 7, 8);
        }
      
        else if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) 
        {
            oWins(0, 1, 2);
        }
        else if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O"))         {
            oWins(0, 3, 6);
        }
        else if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) 
        {
            oWins(0, 4, 8);
        }
        else if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) 
        {
            oWins(1, 4, 7);
        }
        else if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) 
        {
            oWins(2, 4, 6);
        }
        else if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) 
        {
            oWins(2, 5, 8);
        }
        else if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) 
        {
            oWins(3, 4, 5);
        } else if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) 
        {
            oWins(6, 7, 8);
        }
        else if(flag==9) 
        {
            text.setText("Game Draw!!");
             gameOver("Game Draw!!");
        }
    }

    

    // Method to print that Player X wins
    public void xWins(int x1, int x2, int x3) 
    {
        buttons[x1].setBackground(Color.YELLOW);
        buttons[x2].setBackground(Color.YELLOW);
        buttons[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++) 
        {
            buttons[i].setEnabled(false);
        }
        text.setText("Player X wins");
        gameOver("Player X Wins");
    }

    // Method to print that Player O wins
    public void oWins(int x1, int x2, int x3) 
    {
        buttons[x1].setBackground(Color.YELLOW);
        buttons[x2].setBackground(Color.YELLOW);
        buttons[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++) 
        {
            buttons[i].setEnabled(false);
        }
        text.setText("Player O Wins");
        gameOver("Player O Wins");
    }
    
    // Method for performing action after every turn
    


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 9; i++) 
        {
            if (e.getSource() == buttons[i]) 
            {
                if (chance) 
                {
                    if (buttons[i].getText() == "") 
                    {
                        buttons[i].setForeground(new Color(0, 188, 255));
                        buttons[i].setText("X");
                        chance = false;
                        text.setText("O turn");
                        flag++;
                        matchCheck();
                    }
                } 
                else 
                {
                    if (buttons[i].getText() == "") 
                    {
                        buttons[i].setForeground(new Color(0, 255, 9));
                        buttons[i].setText("O");
                       chance = true;
                        text.setText("X turn");
                        flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
new TicTacToeGame();        
    }
}

    
