package math;

import java.util.Objects;

/**
 * Diese Klasse bildet einen Punkt in einem 3 dimensionalen kartesischen
 * Koordinatensystem ab.
 *
 * @author Arnold
 */
public class Point3 {

    /**
     * x-Koordinate des Punktes
     */
    public final double x;

    /**
     * y-Koordinate des Punktes
     */
    public final double y;

    /**
     * z-Koordinate des Punktes
     */
    public final double z;

    public Point3(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    /**
     * Dieser Konstrukter erstellt einen neuen Punkt
     *
     * @param x x-Koordinate des Punktes
     * @param y y-Koordinate des Punktes
     * @param z z-Koordinate des Punktes
     */
    public Point3(final Double x, final Double y, final Double z) {
        if (x == null || y == null || z == null) {
            throw new NullPointerException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Diese Methode Subtrahiert von diesem Punkt den übergebenen Punkt(poi) und
     * erstellt einen Vektor.
     *
     * @param poi Punkt der von diesem Punkt abgezogen werden soll
     * @return die Differenz der beiden Punkt als Vektor vom Type Vector3
     */
    public Vector3 sub(final Point3 poi) {
        if (poi == null) {
            throw new NullPointerException();
        }
        return new Vector3(x - poi.x, y - poi.y, z - poi.z);
    }

    /**
     * Diese Methode subtrahiert von diesem Punkt den übergebenen Vektor(vec).
     *
     * @param vec Vektor der von diesem Punkt abgezogen werden soll
     * @return Punkt auf dem abgebildet wird.
     */
    public Point3 sub(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Point3(x - vec.x, y - vec.y, z - vec.z);
    }

    /**
     * Diese Methode addiert zu diesem Punkt den übergebenen Vektor(vec).
     *
     * @param vec Vektor der zu diesem Punkt addiert werden soll
     * @return Punkt auf dem abgebildet wird.
     */
    public Point3 add(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Point3(x + vec.x, y + vec.y, z + vec.z);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return 17 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Point3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
