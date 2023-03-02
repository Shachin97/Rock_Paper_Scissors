import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    JButton rockBtn, scissorBtn, paperBtn, quitBtn;
    ImageIcon rockIcon, scissorIcon, paperIcon;
    JPanel statsPnl, mainPnl, showPnl, buttonPnl;
    JTextArea results;
    JScrollPane pane;
    JLabel playerWinLabel, compWinLabel, tiesLabel;
    JTextField playerCount, compCount, tiesCount;

    int computerWins = 0;
    int playersWins = 0;
    int timeTies = 0;

    int playerRock = 0;
    int playerPaper = 0;
    int playerScissors = 0;

    int compRock = 0;
    int compPaper = 0;
    int compScissors = 0;



    public RockPaperScissorsFrame()
    {
        super("Rock Paper Scissors Game");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);


        createButtonPanel();
        mainPnl.add(buttonPnl, BorderLayout.NORTH);

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.SOUTH);

        createTextPanel();
        mainPnl.add(showPnl, BorderLayout.CENTER);


        setVisible(true);



    }

    private void createButtonPanel()
    {
        buttonPnl= new JPanel();
        buttonPnl.setLayout(new GridLayout(1,4));



        rockBtn = new JButton("ROCK", new ImageIcon("Rock.png"));
        rockBtn.addActionListener((ActionEvent ae) ->
        {
            results.append("You play Rock \t");
            compPlays(0);

        });

        scissorBtn = new JButton("SCISSORS", new ImageIcon("Scissors.png"));
        scissorBtn.addActionListener((ActionEvent ae) ->
        {
            results.append("You play Scissors ");
            compPlays(2);

        });

        paperBtn = new JButton("PAPER", new ImageIcon("Paper.png"));
        paperBtn.addActionListener((ActionEvent ae) ->
        {
            results.append("You play Paper ");
            compPlays(1);

        });



        quitBtn = new JButton("QUIT", new ImageIcon("Quit.png"));

        // when pressed quit, it will close the application
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPnl.add(rockBtn);
        buttonPnl.add(scissorBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(quitBtn);






    }

    private void createTextPanel()
    {
        showPnl = new JPanel();
        results = new JTextArea(15,30);
        pane = new JScrollPane(results);
        showPnl.add(pane);

    }

    private void createStatsPanel()

    {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3,2));

        playerWinLabel = new JLabel("Player Wins : ");
        compWinLabel = new JLabel("Computer Wins : ");
        tiesLabel = new JLabel("Ties : ");

        playerCount = new JTextField(1);
        compCount = new JTextField(1);
        tiesCount = new JTextField(1);

        statsPnl.add(playerWinLabel);
        statsPnl.add(playerCount);

        statsPnl.add(compWinLabel);
        statsPnl.add(compCount);

        statsPnl.add(tiesLabel);
        statsPnl.add(tiesCount);



    }
    private void compPlays(int playerMove)
            // computer moves
            // computer has 3 total moves and its random
            // move 0 will be rock, 1 = paper 2 = scissors
            // It will then get appened to the text area called results
    {
        Random rand = new Random();
        int compMove = rand.nextInt(3);

        if (compMove == playerMove){
            if (compMove == 0){
                results.append("Computer plays: Rock\n It's a tie!\n");
            }
            else if (compMove == 1){
                results.append("Computer plays: Paper\n It's a tie!\n");
            }
            else{
                results.append("Computer plays: Scissors\n It's a tie!\n");
            }
            timeTies++;
            // increase the value by 1 each time the game is tied
            // and prints the number in tiesLabel

        }
        else if (compMove == 0 && playerMove == 1){
            results.append("Computer plays: Rock\nYou win!\n");
            playersWins++;
        }
        else if (compMove == 0 && playerMove == 2){
            results.append("Computer plays: Rock\nYou lose!\n");
            computerWins++;
        }
        else if (compMove == 1 && playerMove == 0){
            results.append("Computer plays: Paper\nYou lose!\n");
            computerWins++;
        }
        else if (compMove == 1 && playerMove == 2){
            results.append("Computer plays: Paper\nYou win!\n");
            playersWins++;
        }
        else if (compMove == 2 && playerMove == 0){
            results.append("Computer plays: Scissors\nYou win!\n");
            playersWins++;
        }
        else if (compMove == 2 && playerMove == 1){
            results.append("Computer plays: Scissors\nYou lose!\n");
            computerWins++;
        }
        tiesLabel.setText("Ties: " + timeTies);
        playerWinLabel.setText("Player wins: " + playersWins);
        compWinLabel.setText("Computer wins: " + computerWins);
    }
}

