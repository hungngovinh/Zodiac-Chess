//PROBLEM CURRENTLY JANUARY 2: IT DOES NOT ALLOW PLAYER 2 TO GO, SKIP TO PLAYER 1 ON ROUND 3


/**
 * demonstrating a GUI program
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class GUIdemo extends JPanel
{
	class Panel2 extends JPanel {
		

        Panel2() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(800, 800));
        }

        @Override
        public void paintComponent(Graphics g) {
        	
            super.paintComponent(g);
            Image orgImage = null; // Image not resized yet
            Image image = null;
            try {
                File pathToFile = new File("chess.jpg");
                orgImage = ImageIO.read(pathToFile);
                image = orgImage.getScaledInstance(60, 45, Image.SCALE_DEFAULT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            
            g.setColor(Color.GREEN);
            g.fillRect(210, 0, 600, 800 );
            
            g.setColor(Color.BLACK);
            
//            Each Tile is Length 60 and Width 60 pixels
            for ( int i = 0; i < 11; i++){
            	g.drawLine(210 + i * 60, 0, 210 + i * 60, 0 + 600);
            	g.drawLine(210, i * 42, 210 + 600, i * 42);
            }
//            Draw Chess for player1
            for ( int i = 2; i < 8; i++){
            g.drawImage(image, 210 + i * 60, 0, this);
            g.drawImage(image, 210 + i * 60, 45, this);
            g.drawImage(image, 210 + i * 60, 336, this);
            g.drawImage(image, 210 + i * 60, 378, this);
            
            }
            
           
            
            
        }
        
       
    }
	
	
	
	
	Game zodiac = new Game();
	// ***Variables are created ***
	//*** GUIs are made up of JPanels.  Panels are created
	//*** here and named appropriately to describe what will
	//*** be placed in each of them.
	
	JPanel titlePanel = new JPanel();
	
	JPanel turnPanel = new JPanel();
	JPanel fieldPanel = new JPanel();
	JPanel animalPanel = new JPanel();
	JPanel HPPanel = new JPanel();
	JPanel movesPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	
	
	//*** a JLabel is a text string that is given a String value
	//*** and is placed in its corresponding JPanel or JButton
	
	JLabel animalLabel = new JLabel();
	JLabel HPLabel = new JLabel();
	JLabel moveLabel = new JLabel();
	JLabel titleLabel = new JLabel();
	

	
	//*** three JButtons are created.  When pushed, each button calls
	//*** its corresponding actionPerformed() method from the class created
	//*** for each button. This method executes the method code, performing
	//*** what the button is to do.
	
	JButton finishButton = new JButton();
	JButton animalSelectButton = new JButton();
	
	
	//*** a JTextField creates a location where the client can place
	//*** text
	JTextArea outputAnimalTextArea = new JTextArea(10, 10);
	JTextArea outputHPTextArea = new JTextArea(1, 1);
	JTextArea outputMoveTextArea = new JTextArea(10, 10);
	JTextArea outputTurnTextArea = new JTextArea(5,5);
	
	JTextField inputAnimalTextField = new JTextField(15);
	JTextField inputMoveTextField = new JTextField(15);
	

	
	 //*** constructor
	 //*** Variables are given initial values
	
	public GUIdemo()
	{
		//*** set panel layouts
		//*** panels could be LEFT, or RIGHT justified.
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		turnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		animalPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		HPPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		movesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		

		//*** set Label fonts.  You can use other numbers besides 30,20
		//*** or 15 for the font size.  There are other fonts.
		Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
		Font quizSmallFont = new Font("Helvetica Bold", Font.BOLD, 15);
		titleLabel.setFont(quizBigFont);
		turnPanel.setFont(quizBigFont);
		fieldPanel.setFont(quizMidFont);
		animalPanel.setFont(quizSmallFont);
		HPPanel.setFont(quizSmallFont);
		movesPanel.setFont(quizSmallFont);
		buttonPanel.setFont(quizSmallFont);
		
		inputAnimalTextField.setFont(quizMidFont);
		inputMoveTextField.setFont(quizMidFont);
		
		outputAnimalTextArea.setFont(quizMidFont);
		outputHPTextArea.setFont(quizMidFont);
		outputMoveTextArea.setFont(quizMidFont);
		outputTurnTextArea.setFont(quizMidFont);
		
		
		
		
		
		//*** labels are given string values
		
		
		titleLabel.setText("ZODIAC GAMEPLAY");
		animalLabel.setText("Available Animals");
		HPLabel.setText("HP");
		moveLabel.setText("Moves");
		
		
		
	
		//*** the 3 buttons are connected to their classes
		animalSelectButton.setSize(10, 10);
		animalSelectButton.setText("SELECT");
		
		finishButton.setSize(10, 10);
		finishButton.setText("FINISH TURN");
		finishButton.addActionListener(new finishButton());
		animalSelectButton.addActionListener(new animalSelectButton());
		
		
		
	
		//*** Labels, buttons and textFields are added to their
		//*** panels
		titlePanel.add(titleLabel);
		
		turnPanel.add(outputTurnTextArea);
		animalPanel.add(animalLabel);
		HPPanel.add(HPLabel);
		HPPanel.add(outputHPTextArea);
		
		movesPanel.add(moveLabel);
		
		animalPanel.add(outputAnimalTextArea);
		animalPanel.add(inputAnimalTextField);
		
		movesPanel.add(outputMoveTextArea);
		movesPanel.add(inputMoveTextField);
		
		buttonPanel.add(animalSelectButton);
		buttonPanel.add(finishButton);
		
		
		
		
		//*** submitPanel has two items added
		
		//*** The panels are added in the order that they should appear.
		//*** Throughout the declarations and initializations variables were
		//*** kept in this order to aid in keeping them straight
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Panel2 fieldPanel = new Panel2();
		fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(fieldPanel);
		
		add(titlePanel);
		add(turnPanel);
		add(animalPanel);
		add(HPPanel);
		add(movesPanel);
		add(buttonPanel);
		
	}
	 //*** display() is called from main to get things going
	 
	public void display()
	{	//*** A JFrame is where the components of the screen
		//*** will be put.
		
		
		JFrame theFrame = new JFrame("ZODIAC");
		
		//*** When the frame is closed it will exit to the
		//*** previous window that called it.
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//*** puts the panels in the JFrame
		theFrame.setContentPane(this);
		//*** sets the dimensions in pixels
		theFrame.setPreferredSize(new Dimension(1200, 1200));
		theFrame.pack();
		//*** make the window visible
		theFrame.setVisible(true);
	}
	
	 //*** method doSomething is called from an actionPerformend method
	 //*** demonstrating calling methods that can do work for you.
	 
	private void runGame()
	{
		zodiac.initializePlayer1();
		zodiac.initializePlayer2();
		
		
		
			
//			askUserToMove(p1Pieces);
//			displayBoard();
//			turn++;
//			if(gameOver())
//				break;
//
//			askUserToMove(p2Pieces);
//			displayBoard();
//			turn++;
			
//			Player 1
//			zodiac.displayBoard();
			
			outputTurnTextArea.setText(zodiac.day_night_turn_display());
			outputAnimalTextArea.setText(zodiac.displayPossibleTile(zodiac.getP1Pieces()));
			
		
	}
	
	class animalSelectButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Animal Select Button Clicked");
			int number = 1;
			try{
			 number = Integer.parseInt(inputAnimalTextField.getText());
			}
			catch( NumberFormatException exception){
				System.out.println("ERROR INPUTING NUMBER");
			}
			
			System.out.println("Animal Number Chosen Is: " + number);
			if (zodiac.turn % 2 == 1){
				ArrayList<Integer> possibleMoves1 = zodiac.displayPossibleMoveOfTile(zodiac.getP1Pieces(), number);
				ArrayList<Integer> possibleAttacks1 = zodiac.displayPossibleAttackOfTile(zodiac.getP1Pieces(), number);
				String possibleMoves1Output = zodiac.interpret_possible_moves(zodiac.getP1Pieces(), number, possibleMoves1, possibleAttacks1).toString();
				outputMoveTextArea.setText(possibleMoves1Output);
				outputHPTextArea.setText(new Integer(displayHP(zodiac.getP1Pieces(), number)).toString());
			}
			
			if (zodiac.turn % 2 == 0){
				ArrayList<Integer> possibleMoves2 = zodiac.displayPossibleMoveOfTile(zodiac.getP2Pieces(), number);
				ArrayList<Integer> possibleAttacks2 = zodiac.displayPossibleAttackOfTile(zodiac.getP2Pieces(), number);
				String possibleMoves2Output = zodiac.interpret_possible_moves(zodiac.getP2Pieces(), number, possibleMoves2, possibleAttacks2).toString();
				outputMoveTextArea.setText(possibleMoves2Output);
				outputHPTextArea.setText(new Integer(displayHP(zodiac.getP2Pieces(), number)).toString());
				
			}
		}
		
		public int displayHP(Tiles[] playerPieces, int tilePosition){
			return playerPieces[tilePosition].HP; 
		}
	}
	
	class finishButton implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			System.out.println("Finish Button Clicked");
			int moveNumber = 1;
			int animalNumber = 1;
			try{
				 moveNumber = Integer.parseInt(inputMoveTextField.getText());
				 animalNumber = Integer.parseInt(inputAnimalTextField.getText());
			}
			
			catch ( NumberFormatException exception){
				System.out.println("Error inputing number");
			}
			System.out.println("Move Chosen Number is: " + moveNumber);
			System.out.println("TURN" + zodiac.turn);
			
			if (zodiac.turn % 2 == 1){
				zodiac.move(animalNumber, moveNumber, zodiac.getP1Pieces());
				outputAnimalTextArea.setText(" ");
				outputMoveTextArea.setText(" ");
				outputHPTextArea.setText(" ");
				inputAnimalTextField.setText(" ");
				inputMoveTextField.setText(" ");
				zodiac.turn++;
				
				outputTurnTextArea.setText(zodiac.day_night_turn_display());
				outputAnimalTextArea.setText(zodiac.displayPossibleTile(zodiac.getP2Pieces()));
				
			}
			
			if (zodiac.turn % 2 == 0){
				zodiac.move(animalNumber, moveNumber, zodiac.getP2Pieces());
				outputAnimalTextArea.setText(" ");
				outputMoveTextArea.setText(" ");
				outputHPTextArea.setText(" ");
				inputAnimalTextField.setText(" ");
				inputMoveTextField.setText(" ");
				zodiac.turn++;
				
				outputTurnTextArea.setText(zodiac.day_night_turn_display());
				outputAnimalTextArea.setText(zodiac.displayPossibleTile(zodiac.getP1Pieces()));
				
			}
		}
	}

	
	//*** This class has one method that is called when the add5Button
	//*** is pushed.  It retrieves the string from the JTextField
	//*** inputTextField, converts it to an integer and manipulates the
	//*** number.
	//*** NOTE: a string of integers can be formed by creating a string
	//*** with one of the numbers and then concatenating the other integers
	//*** to form the string.
	
	
	 
	
	
	//*** this method resets the values of inputTextField and answerLable
	 
	
	public static void main(String[] args) throws IOException
	  {
		GUIdemo gameGUI = new GUIdemo();
		System.out.println("we can print to the console");
	    gameGUI.display();
	    gameGUI.runGame();

	  }
}