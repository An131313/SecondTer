package generics;

public class Circle extends GeometricObject {
	private double radius;

	int x;
	public Circle( int x) {
		this.x = x;
	}
	
	 public String toString() {
		 return "Radius is " + x;
	 }
	 
	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}
//
//	/** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}


	 public void printCircle() {
		 System.out.println("The circle is created" + getDateCreated() +  " and the radius is: " + getRadius());
	 }
	 
//	// Override the toString method defined in the superclass
//	 public String toString() {
//		 return super.toString() + "\nradius is " + radius;
//	 }

	@Override
	public double getArea1() {
		// TODO Auto-generated method stub
		return radius*radius*3.14;
	}
}
	