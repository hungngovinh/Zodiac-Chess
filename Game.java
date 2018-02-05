import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Scanner;
public class Game 
{	
	public static final int BOARD_SIZE = 10;
	public static Tiles [][] field = new Tiles[BOARD_SIZE][BOARD_SIZE];
    private static  Tiles [] p1Pieces = new Tiles [12];
	public static Tiles[][] getField() {
		return field;
	}

	public static void setField(Tiles[][] field) {
		Game.field = field;
	}

	public static Tiles[] getP1Pieces() {
		return p1Pieces;
	}

	public static void setP1Pieces(Tiles[] p1Pieces) {
		Game.p1Pieces = p1Pieces;
	}

	public static Tiles[] getP2Pieces() {
		return p2Pieces;
	}

	public static void setP2Pieces(Tiles[] p2Pieces) {
		Game.p2Pieces = p2Pieces;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public int getNightCount() {
		return nightCount;
	}

	public void setNightCount(int nightCount) {
		this.nightCount = nightCount;
	}

	public int getDay_night_status() {
		return day_night_status;
	}

	public void setDay_night_status(int day_night_status) {
		this.day_night_status = day_night_status;
	}

	public static int getBoardSize() {
		return BOARD_SIZE;
	}




	private static Tiles [] p2Pieces = new Tiles [12];
	int turn = 1;
//	Number of rounds for Day Mode: 5 rounds
//	Number of Rounds for Night Mode: 3 rounds
	int dayCount = 0;
	int nightCount = 0;
	int day_night_status = 1;
//	status 1 for Day and status 0 for night

//	p1Pieces[0].moveForward(5,0);
	
	public String day_night_turn_display(){
		String turnDisplay = " ";
		if ((turn % 8 > 0)  && (turn % 8 < 6)){
//			DAY MODE
			day_night_status = 1;
			nightCount = 0;
			dayCount = turn % 8;
			
		}
		
		else{
//			NIGHT MODE
			nightCount = turn % 8 - 5;
			if (nightCount < 0){
//				When turn is divisible by 8
				nightCount = 3;
			}
			dayCount = 0;
			day_night_status = 0;
		}
		
		System.out.println("Turn: " + turn);
		switch (day_night_status){
		case 1:
//			DAY MODE
			System.out.println("DAY: " + dayCount);
			System.out.println((6 - dayCount) + " rounds until night");
			
			if ( turn % 2 == 1){
			turnDisplay = "PLAYER 1 :	DAY: " + dayCount + "\n" + 
							(6 - dayCount) + " rounds until night";
			}
			
			else{
				turnDisplay = "PLAYER 2 :	DAY: " + dayCount + "\n" + 
						(6 - dayCount) + " rounds until night";
			}
			break;
		case 0: 
//			NIGHT MODE
			System.out.println("NIGHT: " + nightCount);
			System.out.println((4 - nightCount) + " rounds until day");
			
			if ( turn % 2 == 1){
			turnDisplay = "PLAYER 1: 		NIGHT: " + nightCount + "\n" +
					(4 - nightCount) + " rounds until day";
			
			}
			
			else{
				turnDisplay = "PLAYER 2: 		NIGHT: " + nightCount + "\n" +
						(4 - nightCount) + " rounds until day";
				
				}
			break;
		}
		
		return turnDisplay;
		
		
	}
	
	public void playGame ()
	{
		
//		initializePlayer1 (p1Pieces);
//		initializePlayer2 (p2Pieces);

		while(!gameOver())
		{
			
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
			
			
			day_night_turn_display();
			System.out.println("PLAYER 1");
			displayBoard();
			displayPossibleTile(p1Pieces);
			int tilePosition1 = askForTileInput(p1Pieces);
			ArrayList<Integer> possibleMoves1 = displayPossibleMoveOfTile(p1Pieces, tilePosition1);
			ArrayList<Integer> possibleAttacks1 = displayPossibleAttackOfTile(p1Pieces, tilePosition1);
			int tileMove1 = askForTileMove(possibleMoves1, possibleAttacks1);
			System.out.println("You chose Move Option " + tileMove1);
			move(tilePosition1, tileMove1, p1Pieces);
			turn++;
			
//			Player2
			day_night_turn_display();
			System.out.println("PLAYER 2");
			displayBoard();
			displayPossibleTile(p2Pieces);
			int tilePosition2 = askForTileInput(p2Pieces);
			ArrayList<Integer> possibleMoves2 = displayPossibleMoveOfTile(p2Pieces, tilePosition2);
			ArrayList<Integer> possibleAttacks2 = displayPossibleAttackOfTile(p2Pieces, tilePosition2);
			int tileMove2 = askForTileMove(possibleMoves2, possibleAttacks2);
			move(tilePosition2, tileMove2, p2Pieces);
			displayBoard();
			turn++;
		}
	}
	
	public void initializePlayer1(){
		int count = 0;
		for ( int i = 2; i < 8; i++){
			
			field[0][i] = new Tiles(0, i, 1, 1, "M1",1);
			p1Pieces[count] = field[0][i];
			count++;
			field[1][i] = new Tiles(1, i, 1, 1, "M1",1);
			p1Pieces[count] = field[1][i];
			count++;
		}
		
		
	}
	
	public void initializePlayer2(){
		int count = 0;
		for (int i = 2; i < 8; i++){
			field[8][i] = new Tiles(8, i, 1, 1, "M2",2);
			p2Pieces[count] = field[8][i];
			count++;
			field[9][i] = new Tiles(9, i, 1, 1, "M2", 2);
			p2Pieces[count] = field[9][i];
			count++;
		}
	}
//	TestMethod
	public void testMethod(){
////		Player 1
//		displayBoard();
//		displayPossibleTile(p1Pieces);
//		int tilePosition1 = askForTileInput(p1Pieces);
//		ArrayList<Integer> possibleMoves1 = displayPossibleMoveOfTile(p1Pieces, tilePosition1);
//		int tileMove1 = askForTileMove(possibleMoves1,possibleAttacks1);
//		System.out.println("You chose Move Option " + tileMove1);
//		move(tilePosition1, tileMove1, p1Pieces);
//		turn++;
//		
////		Player2
//		displayBoard();
//		displayPossibleTile(p2Pieces);
//		int tilePosition2 = askForTileInput(p2Pieces);
//		ArrayList<Integer> possibleMoves2 = displayPossibleMoveOfTile(p2Pieces, tilePosition2);
//		int tileMove2 = askForTileMove(possibleMoves2);
//		move(tilePosition2, tileMove2, p2Pieces);
//		displayBoard();
//		turn++;
	}
	
	public boolean canAttackOpponent (Tiles opponent, int playerNumber)
	{
		if (opponent.player == playerNumber){
			return false;
		}
		else{
		if (opponent.HP - 1 >= 0){
			return true;
		}
		}
		return false;
	}
	
	public int[] convertToGrid(int moveOption)
	{
		int [] grid = new int [2];
		switch (moveOption)
		{
			case 1:
			{
				grid [0] = -1;
				grid [1] = -1;
				break;
			} 
			case 2:
			{
				grid [0] = -1;
				grid [1] = 0;
				break;
			} 
			case 3:
			{
				grid [0] = -1;
				grid [1] = 1;
				break;
			} 
			case 4:
			{
				grid [0] = 0;
				grid [1] = -1;
				break;
			} 
			case 5:
			{
				grid [0] = 0;
				grid [1] = 1;
				break;
			} 
			case 6:
			{
				grid [0] = 1;
				grid [1] = -1;
				break;
			} 
			case 7:
			{
				grid [0] = 1;
				grid [1] = 0;
				break;
			} 
			case 8:
			{
				grid [0] = 1;
				grid [1] = 1;
				break;
			} 
		
		}
		return grid;
	}
	
	
	
	public void move(int tilePosition,  int tileMove, Tiles[] playerPieces)
	{
			int rowMoveFromGrid = convertToGrid(tileMove)[0];
			int columnMoveFromGrid = convertToGrid(tileMove)[1];
			int nextRowMove = playerPieces[tilePosition].getRow() + rowMoveFromGrid;
			int nextColumnMove = playerPieces[tilePosition].getColumn() + columnMoveFromGrid;
			if ((field[nextRowMove][nextColumnMove] == null)){
//				If nothing is there in the way of the Tile or there is an opponent that would die
				playerPieces[tilePosition].setRow(nextRowMove);
				playerPieces[tilePosition].setColumn(nextColumnMove);
				field[playerPieces[tilePosition].getRow()][playerPieces[tilePosition].getColumn()] = playerPieces[tilePosition];
				field[playerPieces[tilePosition].getRow()- rowMoveFromGrid][playerPieces[tilePosition].getColumn()-columnMoveFromGrid] = null;
			}
			else if (field[nextRowMove][nextColumnMove].HP - 1 == 0){
				field[nextRowMove][nextColumnMove].HP = 0;
				field[nextRowMove][nextColumnMove] = null;
				playerPieces[tilePosition].setRow(nextRowMove);
				playerPieces[tilePosition].setColumn(nextColumnMove);
				field[playerPieces[tilePosition].getRow()][playerPieces[tilePosition].getColumn()] = playerPieces[tilePosition];
				field[playerPieces[tilePosition].getRow()- rowMoveFromGrid][playerPieces[tilePosition].getColumn()-columnMoveFromGrid] = null;
			}
			
			else if (field[nextRowMove][nextColumnMove].HP - 1 > 0){
//				-It hits the opponent but the opponent does not die, its HP decreases
//				-The player tile will be placed next to the opponent depending on the direction
//				that the player comes from
//				1st: Decrease the HP of the opponent
//				2nd: Move the player tile to the position next to it by flipping the sign of
//					 the direction that it moves
				field[nextRowMove][nextColumnMove].HP -= 1;
				playerPieces[tilePosition].setRow(nextRowMove + (rowMoveFromGrid * (-1/ rowMoveFromGrid)));
				playerPieces[tilePosition].setColumn(nextColumnMove + (columnMoveFromGrid * (-1/ columnMoveFromGrid)));
				field[playerPieces[tilePosition].getRow()][playerPieces[tilePosition].getColumn()] = playerPieces[tilePosition];
				field[playerPieces[tilePosition].getRow()- rowMoveFromGrid][playerPieces[tilePosition].getColumn()-columnMoveFromGrid] = null;
			}
			
		
	}
	
	public void askUserToMove(Tiles[] playerPieces){
//		1st: Display all the tiles possible to move at that turn
//		2nd: Ask user to choose which tile they want to move
//		Ex: Possible Tiles: [0] M1, [1] M1 or [5] Dragon;
//		3rd: After the tiles is chosen, record the tile var,list out the possible moves
//		Ex: Chose [6] M1 ---> Possible moves: left 1, down left 1, down 1
//		4th: Ask the user to input the possible move( switch statement)
//		5th: tiles.changePosition() and change the position of that tile in the field
		displayPossibleTile(playerPieces);
		
	}

	
	public String displayPossibleTile (Tiles[] playerPieces){
//		Check 8 surroundings of any possible tiles
//		1 2 3
//		4 T 5
//		6 7 8
		String output = " ";
		
		System.out.println("Possible Tiles Can Move: ");
		int numberInPieces = 0;
		for (numberInPieces = 0; numberInPieces < 12; numberInPieces++){
			if (playerPieces[numberInPieces].HP == 0){
				
			}
		
			else{
				int row = playerPieces[numberInPieces].row;
//				Display current Piece chosen row and Column
//				System.out.println(numberInPieces + " " + row);
				int column = playerPieces[numberInPieces].column;
//				System.out.println(numberInPieces + " " + column);
				boolean canMove = false;
				
				
				boolean canMoveUp = ( row - 1 >= 0);
				boolean canMoveDown = ( row + 1 <= BOARD_SIZE - 1);
				boolean canMoveLeft = ( column - 1 >= 0);
				boolean canMoveRight = ( column + 1 <= BOARD_SIZE + 1);
				
				
//				Normal Case when Tile is not on the border of the field
				if ((canMoveUp) && (canMoveDown) && (canMoveLeft) && (canMoveRight)) {
					if ( field[row-1][column-1] == null){
						canMove = true;
					}
					
					if ( field[row -1 ][column] == null){
						canMove = true;
						
					}
					
					if ( field[row - 1][column + 1] == null){
						canMove = true;
						
					}
					if ( field[row][column-1] == null){
						canMove = true;
						
					}
					
					if ( field[row][column + 1] == null){
						canMove = true;
					}
					if ( field[row + 1][column-1] == null){
						canMove = true;
					}
					
					if ( field[row + 1][column] == null){
						canMove = true;
					}
					
					if ( field[row + 1][column + 1] == null){
						canMove = true;
					}
				}
				
				else{
					if (!canMoveUp){
//						Upper Right Corner position of the Field
						if (!canMoveRight){
							if ( field[row + 1][column] == null){
								canMove = true;
							}
							if ( field[row + 1][column-1] == null){
								canMove = true;
							}
							if ( field[row][column-1] == null){
								canMove = true;
								
							}
							
						}
						
//						Upper Left corner position of the Field
						if (!canMoveLeft){
							if ( field[row + 1][column + 1] == null){
								canMove = true;
							}
							if ( field[row + 1][column] == null){
								canMove = true;
							}
							if ( field[row][column + 1] == null){
								canMove = true;
							}

						}
//						Anywhere on the first row ( up border of the field)
						else{
							if ( field[row][column-1] == null){
								canMove = true;
								
							}
							
							if ( field[row][column + 1] == null){
								canMove = true;
							}
							
							if ( field[row + 1][column-1] == null){
								canMove = true;
							}
							
							if ( field[row + 1][column] == null){
								canMove = true;
							}
							
							if ( field[row + 1][column + 1] == null){
								canMove = true;
							}
						}
					}
//					Last Row of the field
					if (!canMoveDown){
//						Corner down left of the field
						if (!canMoveLeft){
							if ( field[row][column + 1] == null){
								canMove = true;
							}
							if ( field[row -1 ][column] == null){
								canMove = true;
								
							}
							
							if ( field[row - 1][column + 1] == null){
								canMove = true;
								
							}
						}
//						Corner Down right of the field
						if (!canMoveRight){
							if ( field[row-1][column-1] == null){
								canMove = true;
							}
							
							if ( field[row -1 ][column] == null){
								canMove = true;
								
							}
							if ( field[row][column-1] == null){
								canMove = true;
								
							}
						}
//						Every position in the final row ( 9th row) of the field
						else{
							if ( field[row][column-1] == null){
								canMove = true;
								
							}
							if ( field[row][column + 1] == null){
								canMove = true;
							}
							if ( field[row-1][column-1] == null){
								canMove = true;
							}
							
							if ( field[row -1 ][column] == null){
								canMove = true;
								
							}
							if ( field[row - 1][column + 1] == null){
								canMove = true;
								
							}
						}
						
					}
					
					if (!canMoveLeft){
//						The left border position of the field
//						Do not have to check the 2 corners because already checked
						if ( field[row -1 ][column] == null){
							canMove = true;
							
						}
						if ( field[row + 1][column] == null){
							canMove = true;
						}
						if ( field[row - 1][column + 1] == null){
							canMove = true;
							
						}
						if ( field[row][column + 1] == null){
							canMove = true;
						}
						
						if ( field[row + 1][column + 1] == null){
							canMove = true;
						}
						
					}
					
					if (!canMoveRight){
//						The right border position of the field
//						Do not have to check the 2 corners because already checked
						if ( field[row -1 ][column] == null){
							canMove = true;
							
						}
						if ( field[row + 1][column] == null){
							canMove = true;
						}
						if ( field[row][column-1] == null){
							canMove = true;
							
						}
						
						if ( field[row-1][column-1] == null){
							canMove = true;
						}
						
						if ( field[row + 1][column-1] == null){
							canMove = true;
						}
						
					}
					
					if (playerPieces[numberInPieces].HP == 0){
						canMove = false;
					}
				}
				if ((canMove)){
					System.out.println("Tile No." + numberInPieces + " " + playerPieces[numberInPieces].name + " at row " +
										row + " column " + column);
					output = output + "Tile No." + numberInPieces + " " + playerPieces[numberInPieces].name + " at row " +
							row + " column " + column + "\n";
				}
				

	//			numberInPieces++;
			}
		}
		
		return output;
	}
	
	public int askForTileInput(Tiles[] playerPieces){
//		Gets the choice of tile the player want to move after  
//		displaying all possible tiles
		System.out.println("Enter the number of Tile you want to move: ");
		Scanner keyboard = new Scanner(System.in);
		int tilePosition = 0;
		tilePosition = keyboard.nextInt();
		
		
		while (playerPieces[tilePosition] == null){
			System.out.println("Invalid Choice. Enter the tile you want to move: ");
			tilePosition = keyboard.nextInt();
		}
		
		return tilePosition;
		
	}
	
	public int askForTileMove(ArrayList<Integer> possibleMoves, ArrayList<Integer> possibleAttacks){
		int tileMove = 0;
		boolean isGoodMove = false;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the move from list you want to move the tile");
		tileMove = keyboard.nextInt();
		while (!isGoodMove){
			for (int possibleMove : possibleMoves){
				if ( tileMove == possibleMove){
					isGoodMove = true;
					break;
				}
				
			}
			
			for (int possibleAttack : possibleAttacks){
				if ( tileMove == possibleAttack){
					isGoodMove = true;
					break;
				}
				
			}
			if (isGoodMove){
				break;
			}
			else{
				System.out.println("Not a legit move. Enter move from list.");
				tileMove = keyboard.nextInt();
			}
		}
		
		return tileMove;
	}
	
	
	public ArrayList<Integer> displayPossibleAttackOfTile(Tiles[] playerPieces, int tilePosition){
		int row = playerPieces[tilePosition].row;
		ArrayList<Integer> possibleAttacks = new ArrayList<Integer>();
//		Display current Piece chosen row and Column
//		System.out.println(numberInPieces + " " + row);
		int column = playerPieces[tilePosition].column;
		System.out.println("Possible Attacks of " + playerPieces[tilePosition].name
							+ " at row " + row + " column " + column  );
//		System.out.println(numberInPieces + " " + column);
		boolean canMoveUp = ( row - 1 >= 0);
		boolean canMoveDown = ( row + 1 <= BOARD_SIZE - 1);
		boolean canMoveLeft = ( column - 1 >= 0);
		boolean canMoveRight = ( column + 1 <= BOARD_SIZE + 1);
		
		int currentPlayerNumber = playerPieces[tilePosition].player;
		
		
//		Normal Case when Tile is not on the border of the field

		if ((canMoveUp) && (canMoveDown) && (canMoveLeft) && (canMoveRight)) {
			if ( field[row-1][column-1] != null){
				
				boolean canAttack = canAttackOpponent(field[row-1][column-1], currentPlayerNumber);
				if (canAttack){
					System.out.println("1. Attack " + field[row-1][column-1].name + "at Row " + (row - 1) + " Column " + (column - 1));
					possibleAttacks.add(1);
				}
			}
			
			
			if ( field[row -1 ][column] != null){
				
				boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
				if (canAttack){
					System.out.println("2. Attack " + field[row-1][column].name + "at Row " + (row - 1) + " Column " + (column));
					possibleAttacks.add(2);
				}
				
			}
			
			if ( field[row - 1][column + 1] != null){
			
				
				
				boolean canAttack = canAttackOpponent(field[row-1][column + 1], currentPlayerNumber);
				if (canAttack){
					System.out.println("3. Attack " + field[row-1][column+1].name + "at Row " + (row - 1) + " Column " + (column + 1));
					possibleAttacks.add(3);
				}
				
			}
			if ( field[row][column-1] != null){
				
				
				boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
				if (canAttack){
					System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row ) + " Column " + (column - 1));
					possibleAttacks.add(4);
				}
				
			}
			
			if ( field[row][column + 1] != null){
				
				
				boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
				if (canAttack){
					System.out.println("5. Attack " + field[row][column+1].name + "at Row " + (row) + " Column " + (column + 1));
					possibleAttacks.add(5);
				}
			}
			if ( field[row + 1][column-1] != null){
				
				
				boolean canAttack = canAttackOpponent(field[row+1][column - 1], currentPlayerNumber);
				if (canAttack){
					System.out.println("6. Attack " + field[row+1][column-1].name + "at Row " + (row + 1) + " Column " + (column - 1));
					possibleAttacks.add(6);
				}
			}
			
			if ( field[row + 1][column] != null){
				
				
				boolean canAttack = canAttackOpponent(field[row + 1][column], currentPlayerNumber);
				if (canAttack){
					System.out.println("7. Attack " + field[row + 1][column].name + "at Row " + (row + 1) + " Column " + (column));
					possibleAttacks.add(7);
				}
			}
			
			if ( field[row + 1][column + 1] != null){
				
				
				boolean canAttack = canAttackOpponent(field[row+1][column + 1], currentPlayerNumber);
				if (canAttack){
					System.out.println("8. Attack " + field[row+1][column+1].name + "at Row " + (row + 1) + " Column " + (column + 1));
					possibleAttacks.add(8);
				}
			}
		}

		else{
			if (!canMoveUp){
//				Upper Right Corner position of the Field
				if (!canMoveRight){
					if ( field[row + 1][column] != null){
					
						
						
						boolean canAttack = canAttackOpponent(field[row+1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("7. Attack " + field[row + 1][column].name + "at Row " + (row + 1) + " Column " + (column));
							possibleAttacks.add(7);
						}
					}
					if ( field[row + 1][column-1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row+1][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("6. Attack " + field[row + 1][column - 1].name + "at Row " + (row + 1) + " Column " + (column - 1));
							possibleAttacks.add(6);
						}
					}
					if ( field[row][column-1] != null){
						
						
						boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row) + " Column " + (column - 1));
							possibleAttacks.add(4);
						}
					}
					
				}
				
//				Upper Left corner position of the Field
				if (!canMoveLeft){
					if ( field[row + 1][column + 1] != null){
						
						
						boolean canAttack = canAttackOpponent(field[row+1][column + 1], currentPlayerNumber);
						possibleAttacks.add(8);
						if (canAttack){
							System.out.println("8. Attack " + field[row+1][column+1].name + "at Row " + (row + 1) + " Column " + (column + 1));
							possibleAttacks.add(8);
						}
					}
					if ( field[row + 1][column] != null){
				
						
						boolean canAttack = canAttackOpponent(field[row+1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("7. Attack " + field[row+1][column].name + "at Row " + (row + 1) + " Column " + (column));
							possibleAttacks.add(7);
						}
					}
					if ( field[row][column + 1] != null){
		
						
						boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("5. Attack " + field[row][column+1].name + "at Row " + (row) + " Column " + (column + 1));
							possibleAttacks.add(5);
						}
					}

				}
//				Anywhere on the first row ( up border of the field)
				else{
					if ( field[row][column-1] != null){
						
						
						boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row) + " Column " + (column - 1));
							possibleAttacks.add(4);
						}
						
					}
					
					if ( field[row][column + 1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("5. Attack " + field[row-1][column+1].name + "at Row " + (row) + " Column " + (column + 1));
							possibleAttacks.add(5);
						}
					}
					
					if ( field[row + 1][column-1] != null){
					
						
						boolean canAttack = canAttackOpponent(field[row+1][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("6. Attack " + field[row+1][column-1].name + "at Row " + (row + 1) + " Column " + (column - 1));
							possibleAttacks.add(6);
						}
					}
					
					if ( field[row + 1][column] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row+1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("7. Attack " + field[row+1][column].name + "at Row " + (row + 1) + " Column " + (column));
							possibleAttacks.add(7);
						}
					}
					
					if ( field[row + 1][column + 1] != null){
						
						
						boolean canAttack = canAttackOpponent(field[row+1][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("8. Attack " + field[row + 1][column+1].name + "at Row " + (row + 1) + " Column " + (column + 1));
							possibleAttacks.add(8);
						}
					}
				}
			}
//			Last Row of the field
			if (!canMoveDown){
//				Corner down left of the field
				if (!canMoveLeft){
					if ( field[row][column + 1] != null){
					
						
					
						boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("5. Attack " + field[row][column+1].name + "at Row " + (row) + " Column " + (column + 1));
							possibleAttacks.add(5);
						}
					}
					if ( field[row -1 ][column] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("2. Attack " + field[row - 1][column].name + "at Row " + (row - 1) + " Column " + (column));
							possibleAttacks.add(2);
						}
					}
					
					if ( field[row - 1][column + 1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("3. Attack " + field[row - 1][column-1].name + "at Row " + (row - 1) + " Column " + (column - 1));
							possibleAttacks.add(3);
						}
						
					}
				}
//				Corner Down right of the field
				if (!canMoveRight){
					if ( field[row-1][column-1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("1. Attack " + field[row - 1][column-1].name + "at Row " + (row - 1) + " Column " + (column - 1));
							possibleAttacks.add(1);
						}
					}
					
					if ( field[row -1 ][column] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("2. Attack " + field[row - 1][column].name + "at Row " + (row - 1) + " Column " + (column));
							possibleAttacks.add(2);
						}
						
					}
					if ( field[row][column-1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row) + " Column " + (column - 1));
							possibleAttacks.add(4);
						}
						
					}
				}
//				Every position in the final row ( 9th row) of the field
				else{
					if ( field[row][column-1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row) + " Column " + (column - 1));
							possibleAttacks.add(4);
						}
						
					}
					if ( field[row][column + 1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("5. Attack " + field[row][column+1].name + "at Row " + (row) + " Column " + (column + 1));
							possibleAttacks.add(5);
						}
						
					}
					if ( field[row-1][column-1] != null){
						
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column - 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("1. Attack " + field[row - 1][column-1].name + "at Row " + (row + 1) + " Column " + (column - 1));
							possibleAttacks.add(1);
						}
					}
					
					if ( field[row -1 ][column] != null){
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
						if (canAttack){
							System.out.println("2. Attack " + field[row - 1][column].name + "at Row " + (row - 1) + " Column " + (column));
							possibleAttacks.add(2);
						}
						
					}
					if ( field[row - 1][column + 1] != null){
					
						
						
						boolean canAttack = canAttackOpponent(field[row-1][column + 1], currentPlayerNumber);
						if (canAttack){
							System.out.println("3. Attack " + field[row - 1][column+1].name + "at Row " + (row - 1) + " Column " + (column + 1));
							possibleAttacks.add(3);
						}
						
					}
				}
				
			}
			
			if (!canMoveLeft){
//				The left border position of the field
//				Do not have to check the 2 corners because already checked
				if ( field[row -1 ][column] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
					if (canAttack){
						System.out.println("2. Attack " + field[row - 1][column].name + "at Row " + (row - 1) + " Column " + (column));
						possibleAttacks.add(2);
					}
					
				}
				if ( field[row + 1][column] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row+1][column], currentPlayerNumber);
					if (canAttack){
						System.out.println("7. Attack " + field[row + 1][column].name + "at Row " + (row + 1) + " Column " + (column));
						possibleAttacks.add(7);
					}
				}
				if ( field[row - 1][column + 1] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row-1][column + 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("1. Attack " + field[row - 1][column+1].name + "at Row " + (row - 1) + " Column " + (column + 1));
						possibleAttacks.add(1);
					}
					
				}
				if ( field[row][column + 1] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row][column + 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("5. Attack " + field[row + 1][column+1].name + "at Row " + (row) + " Column " + (column + 1));
						possibleAttacks.add(5);
					}
				}
				
				if ( field[row + 1][column + 1] != null){
					
					
					boolean canAttack = canAttackOpponent(field[row+1][column + 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("8. Attack " + field[row + 1][column+1].name + "at Row " + (row + 1) + " Column " + (column + 1));
						possibleAttacks.add(8);
					}
				}
				
			}
			
			if (!canMoveRight){
//				The right border position of the field
//				Do not have to check the 2 corners because already checked
				if ( field[row -1 ][column] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row-1][column], currentPlayerNumber);
					if (canAttack){
						System.out.println("2. Attack " + field[row - 1][column].name + "at Row " + (row - 1) + " Column " + (column));
						possibleAttacks.add(2);
					}
					
				}
				if ( field[row + 1][column] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row+1][column], currentPlayerNumber);
					if (canAttack){
						System.out.println("7. Attack " + field[row + 1][column].name + "at Row " + (row + 1) + " Column " + (column));
						possibleAttacks.add(7);
					}
				}
				if ( field[row][column-1] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row][column - 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("4. Attack " + field[row][column-1].name + "at Row " + (row) + " Column " + (column - 1));
						possibleAttacks.add(4);
					}
					
				}
				
				if ( field[row-1][column-1] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row-1][column - 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("1. Attack " + field[row - 1][column-1].name + "at Row " + (row - 1) + " Column " + (column - 1));
						possibleAttacks.add(1);
					}
				}
				
				if ( field[row + 1][column-1] != null){
					
					
					
					boolean canAttack = canAttackOpponent(field[row+1][column - 1], currentPlayerNumber);
					if (canAttack){
						System.out.println("6. Attack " + field[row + 1][column-1].name + "at Row " + (row + 1) + " Column " + (column - 1));
						possibleAttacks.add(6);
					}
				}
				
			}
		}
		return possibleAttacks;
	}
	
	public StringBuilder interpret_possible_moves(Tiles[] playerPieces, int tilePosition, ArrayList<Integer> possibleMoves, ArrayList<Integer> possibleAttacks){
		int row = playerPieces[tilePosition].row;
		int column = playerPieces[tilePosition].column;
		StringBuilder answer = new StringBuilder();
		for (int move: possibleMoves){
			switch (move){
				case 1:
					answer.append("1. Move Upper Left To Row " + (row - 1) +
										" Column " + (column - 1) +"\n");
					break;
				case 2:
					answer.append("2. Move Up To Row " + (row - 1) +
							" Column " + (column) +"\n");
					break;
				case 3:
					answer.append("3. Move Upper Right To Row " + (row - 1) +
							" Column " + (column + 1) +"\n");
					break;
				case 4:
					answer.append("4. Move Left To Row " + (row) +
							" Column " + (column - 1) +"\n");
					break;
				case 5:
					answer.append("5. Move Right To Row " + (row) +
							" Column " + (column + 1) +"\n");
					break;
				case 6:
					answer.append("6. Move Down Left To Row " + (row + 1) +
							" Column " + (column - 1) +"\n");
					break;
				case 7:
					answer.append("7. Move Down To Row " + (row + 1) +
							" Column " + (column) +"\n");
					break;
				case 8:
					answer.append("8. Move Down Right To Row " + (row + 1) +
							" Column " + (column + 1) +"\n");
					break;
					
			}
			
		}
		answer.append("Possible Attacks: \n");
		for (int move: possibleAttacks){
			switch (move){
				case 1:
					answer.append("1. Attack " + field[row-1][column-1].name + "at Row " + (row - 1) + " Column " + (column - 1) +"\n");
					break;
				case 2:
					answer.append("2. Attack " + field[row-1][column].name + "at Row " + (row - 1) + " Column " + (column) +"\n");
					break;
				case 3:
					answer.append("3. Attack " + field[row-1][column+1].name + "at Row " + (row - 1) + " Column " + (column + 1) +"\n");
					break;
				case 4:
					answer.append("4. Attack " + field[row][column-1].name + "at Row " + (row ) + " Column " + (column - 1) +"\n");
					break;
				case 5:
					answer.append("5. Attack " + field[row][column+1].name + "at Row " + (row) + " Column " + (column + 1) +"\n");
					break;
				case 6:
					answer.append("6. Attack " + field[row+1][column-1].name + "at Row " + (row + 1) + " Column " + (column - 1) +"\n");
					break;
				case 7:
					answer.append("7. Attack " + field[row + 1][column].name + "at Row " + (row + 1) + " Column " + (column) +"\n");
					break;
				case 8:
					answer.append("8. Attack " + field[row+1][column+1].name + "at Row " + (row + 1) + " Column " + (column + 1) +"\n");
					break;
					
			}
		}
		return answer;
	}
	
	public ArrayList<Integer> displayPossibleMoveOfTile(Tiles[] playerPieces, int tilePosition){
		int row = playerPieces[tilePosition].row;
		ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
//		Display current Piece chosen row and Column
//		System.out.println(numberInPieces + " " + row);
		int column = playerPieces[tilePosition].column;
		System.out.println("Possible Moves of " + playerPieces[tilePosition].name
							+ " at row " + row + " column " + column  );
//		System.out.println(numberInPieces + " " + column);
		boolean canMoveUp = ( row - 1 >= 0);
		boolean canMoveDown = ( row + 1 <= BOARD_SIZE - 1);
		boolean canMoveLeft = ( column - 1 >= 0);
		boolean canMoveRight = ( column + 1 <= BOARD_SIZE + 1);
		
		
//		Normal Case when Tile is not on the border of the field
		if ((canMoveUp) && (canMoveDown) && (canMoveLeft) && (canMoveRight)) {
			if ( field[row-1][column-1] == null){
				System.out.println("1. Move Upper Left To Row " + (row - 1) +
									" Column " + (column - 1));
				possibleMoves.add(1);
			}
			else if ( field[row-1][column-1] == null){
//				boolean canAttack = canAttackOpponent(field[row-1][column-1]);
//				if (canAttack){
//					possibleAttacks.add(1);
//				}
			}
			
			if ( field[row -1 ][column] == null){
				System.out.println("2. Move Up To Row " + (row - 1) +
						" Column " + (column));
				possibleMoves.add(2);
				
			}
			
			if ( field[row - 1][column + 1] == null){
				System.out.println("3. Move Upper Right To Row " + (row - 1) +
						" Column " + (column + 1));
				possibleMoves.add(3);
				
			}
			if ( field[row][column-1] == null){
				System.out.println("4. Move Left To Row " + (row) +
						" Column " + (column - 1));
				possibleMoves.add(4);
				
			}
			
			if ( field[row][column + 1] == null){
				System.out.println("5. Move Right To Row " + (row) +
						" Column " + (column + 1));
				possibleMoves.add(5);
			}
			if ( field[row + 1][column-1] == null){
				System.out.println("6. Move Down Left To Row " + (row + 1) +
						" Column " + (column - 1));
				possibleMoves.add(6);
			}
			
			if ( field[row + 1][column] == null){
				System.out.println("7. Move Down To Row " + (row + 1) +
						" Column " + (column));
				possibleMoves.add(7);
			}
			
			if ( field[row + 1][column + 1] == null){
				System.out.println("8. Move Down Right To Row " + (row + 1) +
						" Column " + (column + 1));
				possibleMoves.add(8);
			}
		}
		
		else{
			if (!canMoveUp){
//				Upper Right Corner position of the Field
				if (!canMoveRight){
					if ( field[row + 1][column] == null){
						System.out.println("7. Move Down To Row " + (row + 1) +
								" Column " + (column));
						possibleMoves.add(7);
					}
					if ( field[row + 1][column-1] == null){
						System.out.println("6. Move Down Left To Row " + (row + 1) +
								" Column " + (column - 1));
						possibleMoves.add(6);
					}
					if ( field[row][column-1] == null){
						System.out.println("4. Move Left To Row " + (row) +
								" Column " + (column - 1));
						possibleMoves.add(4);
						
					}
					
				}
				
//				Upper Left corner position of the Field
				if (!canMoveLeft){
					if ( field[row + 1][column + 1] == null){
						System.out.println("8. Move Down Right To Row " + (row + 1) +
								" Column " + (column + 1));
						possibleMoves.add(8);
					}
					if ( field[row + 1][column] == null){
						System.out.println("7. Move Down To Row " + (row + 1) +
								" Column " + (column));
						possibleMoves.add(7);
					}
					if ( field[row][column + 1] == null){
						System.out.println("5. Move Right To Row " + (row) +
								" Column " + (column + 1));
						possibleMoves.add(5);
					}

				}
//				Anywhere on the first row ( up border of the field)
				else{
					if ( field[row][column-1] == null){
						System.out.println("4. Move Left To Row " + (row) +
								" Column " + (column - 1));
						possibleMoves.add(4);
						
					}
					
					if ( field[row][column + 1] == null){
						System.out.println("5. Move Right To Row " + (row) +
								" Column " + (column + 1));
						possibleMoves.add(5);
					}
					
					if ( field[row + 1][column-1] == null){
						System.out.println("6. Move Down Left To Row " + (row + 1) +
								" Column " + (column - 1));
						possibleMoves.add(6);
					}
					
					if ( field[row + 1][column] == null){
						System.out.println("7. Move Down To Row " + (row + 1) +
								" Column " + (column));
						possibleMoves.add(7);
					}
					
					if ( field[row + 1][column + 1] == null){
						System.out.println("8. Move Down Right To Row " + (row + 1) +
								" Column " + (column + 1));
						possibleMoves.add(8);
					}
				}
			}
//			Last Row of the field
			if (!canMoveDown){
//				Corner down left of the field
				if (!canMoveLeft){
					if ( field[row][column + 1] == null){
						System.out.println("5. Move Right To Row " + (row) +
								" Column " + (column + 1));
						possibleMoves.add(5);
					}
					if ( field[row -1 ][column] == null){
						System.out.println("2. Move Up To Row " + (row - 1) +
								" Column " + (column));
						possibleMoves.add(2);
						
					}
					
					if ( field[row - 1][column + 1] == null){
						System.out.println("3. Move Upper Right To Row " + (row - 1) +
								" Column " + (column + 1));
						possibleMoves.add(3);
						
					}
				}
//				Corner Down right of the field
				if (!canMoveRight){
					if ( field[row-1][column-1] == null){
						System.out.println("1. Move Upper Left To Row " + (row - 1) +
											" Column " + (column - 1));
						possibleMoves.add(1);
					}
					
					if ( field[row -1 ][column] == null){
						System.out.println("2. Move Up To Row " + (row - 1) +
								" Column " + (column));
						possibleMoves.add(2);
						
					}
					if ( field[row][column-1] == null){
						System.out.println("4. Move Left To Row " + (row) +
								" Column " + (column - 1));
						possibleMoves.add(4);
						
					}
				}
//				Every position in the final row ( 9th row) of the field
				else{
					if ( field[row][column-1] == null){
						System.out.println("4. Move Left To Row " + (row) +
								" Column " + (column - 1));
						possibleMoves.add(4);
						
					}
					if ( field[row][column + 1] == null){
						System.out.println("5. Move Right To Row " + (row) +
								" Column " + (column + 1));
						possibleMoves.add(5);
					}
					if ( field[row-1][column-1] == null){
						System.out.println("1. Move Upper Left To Row " + (row - 1) +
											" Column " + (column - 1));
						possibleMoves.add(1);
					}
					
					if ( field[row -1 ][column] == null){
						System.out.println("2. Move Up To Row " + (row - 1) +
								" Column " + (column));
						possibleMoves.add(2);
						
					}
					if ( field[row - 1][column + 1] == null){
						System.out.println("3. Move Upper Right To Row " + (row - 1) +
								" Column " + (column + 1));
						possibleMoves.add(3);
						
					}
				}
				
			}
			
			if (!canMoveLeft){
//				The left border position of the field
//				Do not have to check the 2 corners because already checked
				if ( field[row -1 ][column] == null){
					System.out.println("2. Move Up To Row " + (row - 1) +
							" Column " + (column));
					possibleMoves.add(2);
					
				}
				if ( field[row + 1][column] == null){
					System.out.println("7. Move Down To Row " + (row + 1) +
							" Column " + (column));
					possibleMoves.add(7);
				}
				if ( field[row - 1][column + 1] == null){
					System.out.println("1. Move Upper Right To Row " + (row - 1) +
							" Column " + (column + 1));
					possibleMoves.add(1);
					
				}
				if ( field[row][column + 1] == null){
					System.out.println("5. Move Right To Row " + (row) +
							" Column " + (column + 1));
					possibleMoves.add(5);
				}
				
				if ( field[row + 1][column + 1] == null){
					System.out.println("8. Move Down Right To Row " + (row + 1) +
							" Column " + (column + 1));
					possibleMoves.add(8);
				}
				
			}
			
			if (!canMoveRight){
//				The right border position of the field
//				Do not have to check the 2 corners because already checked
				if ( field[row -1 ][column] == null){
					System.out.println("2. Move Up To Row " + (row - 1) +
							" Column " + (column));
					possibleMoves.add(2);
					
				}
				if ( field[row + 1][column] == null){
					System.out.println("7. Move Down To Row " + (row + 1) +
							" Column " + (column));
					possibleMoves.add(7);
				}
				if ( field[row][column-1] == null){
					System.out.println("4. Move Left To Row " + (row) +
							" Column " + (column - 1));
					possibleMoves.add(4);
					
				}
				
				if ( field[row-1][column-1] == null){
					System.out.println("1. Move Upper Left To Row " + (row - 1) +
										" Column " + (column - 1));
					possibleMoves.add(1);
				}
				
				if ( field[row + 1][column-1] == null){
					System.out.println("6. Move Down Left To Row " + (row + 1) +
							" Column " + (column - 1));
					possibleMoves.add(6);
				}
				
			}
		}
	
		return possibleMoves;


		
	}
	public boolean gameOver () 
	{
		if (p1Pieces[4].HP== 0|| p2Pieces[4].HP == 0)
			return true;
		return false;
	}




	public void displayBoard()
	{
		for (int i = 0; i < BOARD_SIZE; i ++)
		{

			for (int j = 0; j < BOARD_SIZE; j ++)
			{
				if (field [i][j] != null)
					System.out.print(field[i][j].name + " ");
				else
					System.out.print("-1 ");
			} 
			System.out.print("\n");
		}
		
	}

}

