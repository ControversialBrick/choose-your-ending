package cbrick.ownstory.gui;

import java.awt.Color;

import cbrick.ownstory.main.Main;
import cbrick.ownstory.utils.Coordinate;


public class Button {
	
	private String name;
	private String text;

	private int id;
	private int width;
	private int height;
	
	public int x;
	public int y;
	
	protected Color FILL_COLOR = Color.RED;
	
	public Button(int id, int width, int height, String name, String text){
		this.id = id;
		/*this.x = x;
		this.y = y;*/
		this.width = width;
		this.height = height;
		this.name = name;
		this.text = text;
	}
	
	public int getId(){
		return id;
	}
	
	public Coordinate getMin(){
		return new Coordinate(this.x, this.y);
	}
	
	/*public int getX(){
		return this.x;
	}*/
	
	/*public int getY(){
		return this.y;
	}*/
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getXMax(){
		return x + width;
	}
	
	public int getYMax(){
		return y + height;
	}
	
	public Coordinate getMax(){
		return new Coordinate(this.getXMax(), this.getYMax());
	}
	
	public String getName(){
		return name;
	}
	
	public String getText(){
		return text;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void onClick(boolean on){
		if(on){
			FILL_COLOR = Color.GREEN;
		}else{
			if(Main.s.hoverButtons.contains(this))FILL_COLOR = Color.BLUE;
			else FILL_COLOR = Color.red;
		}
	}
	
	public void onHover(boolean on){
		if(on){
			FILL_COLOR = Color.BLUE;
		}else{
			FILL_COLOR = Color.RED;
		}
	}

}
