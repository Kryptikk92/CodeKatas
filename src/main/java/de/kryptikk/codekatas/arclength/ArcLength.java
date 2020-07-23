package de.kryptikk.codekatas.arclength;

public class ArcLength {
	
	private MathFunction f;

	public ArcLength(MathFunction f) {
		this.f = f;
	}
	
	/**
	 * Funktion zum errechnen der Bogenlänge einer beliebigen 2-dimensionalen Funktion
	 * im Bereich x=[x0, x1], indem die angenäherte Bogenlänge in n Abschnitten 
	 * aufsummiert wird.
	 * @param n zu errechnende Abschnitte, je mehr n, desto genauere Berechnung
	 * @param x0 linker Rand
	 * @param x1 rechter Rand
	 * @return
	 */
	public double lenCurve(int n, double x0, double x1) {
		double segmentStep = (x1-x0)/(double)n;
		double totalLen = 0.0d;
		double curX = x0;
		double lastX = curX;
		double lastY = this.f.calc(curX);
		double curY;
		for (int i = 0; i < n; i++) {
			curX += segmentStep;
			curY = this.f.calc(curX);
			totalLen += Math.sqrt(Math.pow(curX-lastX, 2) + Math.pow(curY-lastY, 2));
			lastX = curX;
			lastY = curY;
		}
		
		return totalLen;
	}

	/**
	 * DEPRECATED, TESTET NUR x^2
	 * 
	 * Funktion zum errechnen der Bogenlänge von x^2 im Bereich x=[0, 1]
	 * indem die angenäherte Bogenlänge in n Abschnitten aufsummiert wird.
	 * @param n zu errechnende Abschnitte, je mehr n, desto genauere Berechnung
	 * @return Bogenlänge
	 * @deprecated
	 */
	@Deprecated
	public static double lenCurve(int n) {
		double totalLen = 0.0d;
		double curX = 0.0d;
		double lastX = 0.0d;
		double lastY = 0.0d;
		double curY;
		for (int i = 0; i < n; i++) {
			curX += 1.0d/(double)n;
			curY = curX*curX;
			totalLen += Math.sqrt(Math.pow(curX-lastX, 2) + Math.pow(curY-lastY, 2));
			lastY = curY;
			lastX = curX;
		}
		return totalLen;
	}
}
