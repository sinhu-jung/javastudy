package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;
	
	Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override
	public double getPerimeter() {
		return (width + height)*2;
	}
	
	public void resize (double size) {
		this.width *= size;
		this.height *= size;
	}
}
