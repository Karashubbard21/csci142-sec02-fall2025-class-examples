package shapes;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		Square square1 = new Square();
		Square square2 = new Square(15.0, Color.RED);
		//Shape shape = new Shape(Color.BLACK);
		
		System.out.println(square1);
		System.out.println(square2);
		
	}

}
