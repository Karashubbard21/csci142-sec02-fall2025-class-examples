package shapes;

import java.awt.Color;

public class Square extends Shape {
	private double sideLength;
	
	public Square() {
		this(1.0, Color.WHITE);
	}
	
	public Square(double sideLength, Color color) {
		super(color);
	    if (!Double.isFinite(sideLength) || sideLength < 0.0) {
	        throw new IllegalArgumentException("sideLength must be finite and >= 0");
	    }
	    this.sideLength = sideLength;
	}
	
	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}

	public double area() {
		return this.sideLength * this.sideLength;
	}
	
	@Override
	public String toString() {
		return "Square: sideLength = " + sideLength + " area = " + area()
				+ " " + super.toString();
	}

}
