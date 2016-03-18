package cbrick.ownstory.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import cbrick.ownstory.main.Main;
import cbrick.ownstory.main.Node;
import cbrick.ownstory.utils.Coordinate;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class Screen extends JPanel{
	
	public List<Button> buttonList;
	List<Button> hoverButtons;
	List<Button> activeButtons;
	
	public Node activeNode;
	
	public Screen(){
		super();
		this.buttonList = new ArrayList<Button>();
		this.hoverButtons = new ArrayList<Button>();
		this.activeButtons = new ArrayList<Button>();
		MouseAdapter mouseListener =
		new MouseAdapter(){
			
			@Override
			public void mousePressed(MouseEvent e){
				for(int i = 0; i < buttonList.size(); i++){
					if(Coordinate.coordinateIsInRegion(buttonList.get(i).getMin(), buttonList.get(i).getMax(), new Coordinate(e.getX(), e.getY()))){
						buttonList.get(i).onClick(true);
						activeButtons.add(buttonList.get(i));
						repaint();
					}
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e){
				for(int i = 0; i < buttonList.size(); i++){
					if(Coordinate.coordinateIsInRegion(buttonList.get(i).getMin(), buttonList.get(i).getMax(), new Coordinate(e.getX(), e.getY()))){
						buttonList.get(i).onClick(false);
						repaint();
					}else{
						if(activeButtons.contains(buttonList.get(i))){
							activeButtons.remove(buttonList.get(i));
							buttonList.get(i).onClick(false);
							repaint();
						}
					}
				}
			}
			
			@Override
			public void mouseMoved(MouseEvent e){
				for(int i = 0; i < buttonList.size(); i++){
					if(Coordinate.coordinateIsInRegion(buttonList.get(i).getMin(), buttonList.get(i).getMax(), new Coordinate(e.getX(), e.getY()))){
						if(!hoverButtons.contains(buttonList.get(i))){
							hoverButtons.add(buttonList.get(i));
							buttonList.get(i).onHover(true);
							repaint();
						}
					}else{
						if(hoverButtons.contains(buttonList.get(i))){
							hoverButtons.remove(buttonList.get(i));
							buttonList.get(i).onHover(false);
							repaint();
						}
					}
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e){
				for(int i = 0; i < buttonList.size(); i++){
					if(Coordinate.coordinateIsInRegion(buttonList.get(i).getMin(), buttonList.get(i).getMax(), new Coordinate(e.getX(), e.getY()))){
						if(!hoverButtons.contains(buttonList.get(i))){
							hoverButtons.add(buttonList.get(i));
							buttonList.get(i).onHover(true);
							repaint();
						}
					}else{
						if(hoverButtons.contains(buttonList.get(i))){
							hoverButtons.remove(buttonList.get(i));
							buttonList.get(i).onHover(false);
							repaint();
						}
					}
				}
			}
			
		};
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		init();
	}
	
	public void addButton(Button b){
		this.buttonList.add(b);
		calculateButtonPosition();
	}
	
	public void init(){
		
	}
	
	protected void paintComponent(Graphics g){

		super.paintComponent(g);
		
		this.setBackground(Color.white);
		
		for(int i = 0; i < buttonList.size(); i++){
			Button b = buttonList.get(i);
			g.setColor(b.FILL_COLOR);
			g.fillRect(b.x, b.y, b.getWidth(), b.getHeight());
			g.setColor(Color.BLACK);
			g.drawRect(b.x, b.y, b.getWidth(), b.getHeight());
			int textWidth = 0;
			textWidth = g.getFontMetrics(this.getFont()).stringWidth(b.getText());
			int textHeight = g.getFontMetrics().getHeight();
			g.drawString(b.getText(), b.x + ((b.getWidth() - textWidth)/2), b.y + ((b.getHeight() - textHeight)/2));
		}
		
	}
	
	public void calculateButtonPosition(){
		int space = 10;
		int y = 400;
		int maxHeight = 0;
		double lastX = (Main.f.getWidth()*0.02);
		for(int i = 0; i < buttonList.size(); i++)
			if(maxHeight < buttonList.get(i).getHeight()) maxHeight = buttonList.get(i).getHeight();
		for(int i = 0; i < buttonList.size(); i++){
			if(lastX + space + buttonList.get(i).getWidth() < Main.f.getWidth()){
				double calculatedSpace = lastX + space;
				buttonList.get(i).x = (int)calculatedSpace;
				buttonList.get(i).y = y + (maxHeight - buttonList.get(i).getHeight());
				lastX += space + buttonList.get(i).getWidth();
			}else{
				y += maxHeight + 10;
				lastX = (Main.f.getWidth()*0.02);
				double calculatedSpace = lastX + space;
				buttonList.get(i).x = (int)calculatedSpace;
				buttonList.get(i).y = y + (maxHeight - buttonList.get(i).getHeight());
				lastX += space + buttonList.get(i).getWidth();
			}
		}
	}
	
	public void actionPerformed(){
		
	}

}
