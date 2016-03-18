package cbrick.ownstory.main;

import javax.swing.JFrame;

import cbrick.ownstory.gui.Button;
import cbrick.ownstory.gui.Screen;


public class Main {
	
	public static JFrame f;
	public static Screen s;
	
	public static void main(String[] args){
		f = new JFrame("Make your own story");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s = new Screen();
		f.add(s);
		
		f.setSize(600, 600);
		Node c1 = new Node(1, "leedleed", "Node 1");
		Node c2 = new Node(2, "leedleed", "Node 2");
		Node c3 = new Node(3, "leedleed", "Node 3");
		Node n = new Node(0, "You find yourself in a field. To the west of you is a large, towering penis.", "", c1, c2, c3);
		f.setVisible(true);
		s.repaint();
	}

}
