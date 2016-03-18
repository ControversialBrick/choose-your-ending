package cbrick.ownstory.utils;

public class Coordinate{
	
	public int x;
	public int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static boolean coordinateIsInRegion(Coordinate regMin, Coordinate regMax, Coordinate point){
		int x1, x2, x3;
		int y1, y2, y3;
		
		x1 = regMin.x;
		x2 = regMax.x;
		x3 = point.x;
		y1 = regMin.y;
		y2 = regMax.y;
		y3 = point.y;
		
		return ((x3 >= x1 && x3 <= x2) && (y3 >= y1 && y3 <= y2));
	}
	
}