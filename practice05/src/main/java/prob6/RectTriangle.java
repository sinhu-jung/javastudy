package prob6;

public class RectTriangle extends Shape{
	private double width;
	private double height;
	
	public RectTriangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return (width + height) * 2;	
	}
	
	public double getPerimeter() {
		return (width + height) + Math.sqrt(height * height + width * width);
	}
}
