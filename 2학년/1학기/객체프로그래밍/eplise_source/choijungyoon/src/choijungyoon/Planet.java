package choijungyoon;

public enum Planet {

	MERCURY	(3.303e+23, 2.4397e6 ),
	VENUS	(4.869e+24, 6.0518e6 ),
	EARTH	(5.976e+24, 6.37814e6 ),
	MARS	(6.421e+23, 3.397e6 ),
	JUPITER	(1.9e+27, 7.1492e7 ),
	SATURN	(5.688e+26, 6.0268e7 ),
	URANUS	(8.686e+25, 2.5559e7 ),
	NEPTUNE	(1.024e+26, 2.4746e7 );
	
	private final double mass;
	private final double radius;
	
	// enum 생성자(자동으로 실행)
	Planet (double mass, double radius){
		this.mass = mass;
		this.radius = radius;
	}
	private double mass() {return mass;}
	private double radius() {return radius;}
	
	//중력 상수
	public static final double G = 6.67300E-11;
	//지표면 중력
	double surfaceGravity() {
		return G * mass / (radius * radius);
	}
	//지표면 무게
	double surfaceWeight(double otherMass) {
		return otherMass * surfaceGravity();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.err.println("Usage: java Planner <earth_weight>");
			System.exit(-1);
		}
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight/EARTH.surfaceGravity();
		for(Planet p : Planet.values())
			System.out.printf("Your weight on %s is %f\n", p, p.surfaceWeight(mass));
	}

}
