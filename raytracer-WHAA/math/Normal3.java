package math;

/**
 * Diese Klasse bildet eine Normale in einem 3 dimensionalen kartesischen
 * Koordinatensystem ab.
 *
 * @author Arnold
 */
public class Normal3 {

    /**
     * x-Richtung der Normalen
     */
    public final double x;

    /**
     * y-Richtung der Normalen
     */
    public final double y;

    /**
     * z-Richtung der Normalen
     */
    public final double z;

    public Normal3(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    /**
     * Diser Konstrukter erstellt einen neue Normale.
     *
     * @param x x-Richtung der Normalen
     * @param y y-Richtung der Normalen
     * @param z z-Richtung der Normalen
     */
    public Normal3(final Double x, final Double y, final Double z) {
        if (x == null || y == null || z == null) {
            throw new NullPointerException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Diese Methode multipliziert die Normale mit dem übergenen Fakto(c).
     *
     * @param c Faktor mit dem die Normale multipliziert werden soll
     * @return Normale mit der c-fachen länge
     */
    public Normal3 mul(final Double c) {
        if (c == null) {
            throw new NullPointerException();
        }
        return new Normal3(x * c, y * c, z * c);
    }

    /**
     * Diese Methode addiert zu dieser Normalen die übergebene Normale(norm).
     *
     * @param norm Normale die zu dieser Addiert werden soll
     * @return Summennormale der beiden Normalen vom Type Normal3
     */
    public Normal3 add(final Normal3 norm) {
        if (norm == null) {
            throw new NullPointerException();
        }
        return new Normal3(x + norm.x, y + norm.y, z + norm.z);
    }

    /**
     * Skalarprodukt dieser Normalen mit dem übergebenen Vektor(vec)
     *
     * @param vec Vektor mit dem das Skalarprodukt gebildet werden soll
     * @return Skalarprodukt als double
     */
    public double dot(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return ((x * vec.x) + (y * vec.y) + (z * vec.z));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return 53 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Normal3 other = (Normal3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }

    @Override
    public String toString() {
        return "Normal3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
