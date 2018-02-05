import java.awt.*;
import java.applet.*;  
public  class Tiles
{
//	CREATE A PAINT METHOD FOR TILES CLASS WITH ARG GRAPHICS G
//	INSERT INSTANCE IMAGE TO CLASS TILE
//	GUIdemo will call method paint of class tiles and depending on the 
//	current position of the tile then draw the image on the field
	int row;
	int column;
	int HP;
	int range;
	String name;
	int player;
	public Tiles(int row, int column, int HP, int range, String name, int player)
	{
		this.row = row;
		this.column = column;
		this.HP = HP;
		this.range = range;
		this.name = name;
		this.player = player;
	}

	public void changePosition(int x, int y )
	{
	
//		game.field[xPos][yPos] = null;
		row +=x;
		column  +=y;
//		game.field[xPos][yPos] = this;
		

	}
	
	 public boolean equals(Object other){
//		 Code goes here to compare OBJECTS
//		 ...
//		 ...
		 
		 
     	return true;
     }

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}