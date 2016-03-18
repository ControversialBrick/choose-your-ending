package cbrick.ownstory.main;

import java.util.ArrayList;
import java.util.List;

import cbrick.ownstory.gui.Button;


public class Node {
	
	List<Node> choices;
	Node parent;
	
	private int id;
	
	private String text;
	private String buttonText;
	
	public Node(int id, String text, String buttonText, Node... nodes){
		this.id = id;
		this.text = text;
		this.buttonText = buttonText;
		choices = new ArrayList<Node>();
		Main.s.buttonList.clear();
		for(Node n : nodes){
			choices.add(n);
		}
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getText(){
		return this.text;
	}
	
	public String getButtonText(){
		return this.buttonText;
	}
	
	public void display(){
		Main.s.activeNode = this;
	}
	
	public boolean addChoice(Node n){
		return choices.add(n);
	}
	
	public boolean removeChoice(int index){return choices.remove(index) != null;}
	public boolean removeChoice(Node n){return choices.remove(n);}

}
