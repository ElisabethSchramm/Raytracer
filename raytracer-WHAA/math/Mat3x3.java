package math;

/**
 * Diese Klasse bildet eine 3x3 Matrix ab.
 *
 * @author Arnold
 */
public class Mat3x3 {

    /**
     * Element der 1. Zeile und 1. Spalte.
     */
    public final double m11;

    /**
     * Element der 1. Zeile und 2. Spalte.
     */
    public final double m12;

    /**
     * Element der 1. Zeile und 3. Spalte.
     */
    public final double m13;

    /**
     * Element der 2. Zeile und 1. Spalte.
     */
    public final double m21;

    /**
     * Element der 2. Zeile und 2. Spalte.
     */
    public final double m22;

    /**
     * Element der 2. Zeile und 3. Spalte.
     */
    public final double m23;

    /**
     * Element der 3. Zeile und 1. Spalte.
     */
    public final double m31;

    /**
     * Element der 3. Zeile und 3. Spalte.
     */
    public final double m32;

    /**
     * Element der 3. Zeile und 3. Spalte.
     */
    public final double m33;

    /**
     * Determinante der Matrix.
     */
    public final double determinant;

    /**
     * Diser Konstrukter erstellt eine neue 3x3 Matrix.
     *
     * @param m11 Element der 1. Zeile und 1. Spalte.
     * @param m12 Element der 1. Zeile und 2. Spalte.
     * @param m13 Element der 1. Zeile und 3. Spalte.
     * @param m21 Element der 2. Zeile und 1. Spalte.
     * @param m22 Element der 2. Zeile und 2. Spalte.
     * @param m23 Element der 2. Zeile und 3. Spalte.
     * @param m31 Element der 3. Zeile und 1. Spalte.
     * @param m32 Element der 3. Zeile und 2. Spalte.
     * @param m33 Element der 3. Zeile und 3. Spalte.
     */
    public Mat3x3(
            final Double m11, final Double m12, final Double m13,
            final Double m21, final Double m22, final Double m23,
            final Double m31, final Double m32, final Double m33) {
        if (m11 == null || m12 == null || m13 == null || m21 == null || m22 == null || m23 == null || m31 == null || m32 == null || m33 == null) {
            throw new NullPointerException();
        }
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.determinant = determinant();

    }

    /**
     * Diese Methode multipliziert diese Matrix mit der übergebenen Matrix(mat).
     *
     * @param mat Matrix vom Type Mat3x3 die mit der Matrix multipliziert wird.
     * @return Produktmatrix vom Type Mat3x3
     */
    public Mat3x3 mul(final Mat3x3 mat) {
        if (mat == null) {
            throw new NullPointerException();
        }
        return new Mat3x3(
                (this.m11 * mat.m11) + (this.m12 * mat.m21) + (this.m13 * mat.m31),
                (this.m11 * mat.m12) + (this.m12 * mat.m22) + (this.m13 * mat.m32),
                (this.m11 * mat.m13) + (this.m12 * mat.m23) + (this.m13 * mat.m33),
                (this.m21 * mat.m11) + (this.m22 * mat.m21) + (this.m23 * mat.m31),
                (this.m21 * mat.m12) + (this.m22 * mat.m22) + (this.m23 * mat.m32),
                (this.m21 * mat.m13) + (this.m22 * mat.m23) + (this.m23 * mat.m33),
                (this.m31 * mat.m11) + (this.m32 * mat.m21) + (this.m33 * mat.m31),
                (this.m31 * mat.m12) + (this.m32 * mat.m22) + (this.m33 * mat.m32),
                (this.m31 * mat.m13) + (this.m32 * mat.m23) + (this.m33 * mat.m33));
    }

    /**
     * Diese Methode multipliziert diese Matrix mit dem Vektor(vec).
     *
     * @param vec Vektor vom Type Vector3 der mit der Matrix multipliziert wird.
     * @return Produktvektor vom Type Vector3.
     */
    public Vector3 mul(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Vector3(
                (this.m11 * vec.x) + (this.m12 * vec.y) + (this.m13 * vec.z),
                (this.m21 * vec.x) + (this.m22 * vec.y) + (this.m23 * vec.z),
                (this.m31 * vec.x) + (this.m32 * vec.y) + (this.m33 * vec.z));
    }

    /**
     * Diese Methode multipliziert diese Matrix mit dem Punkt(poi).
     *
     * @param poi Punkt vom Type Point3 der mit der Matrix multipliziert wird.
     * @return Produktpunkt vom Type Point3.
     */
    public Point3 mul(final Point3 poi) {
        if (poi == null) {
            throw new NullPointerException();
        }
        return new Point3(
                (this.m11 * poi.x) + (this.m12 * poi.y) + (this.m13 * poi.z),
                (this.m21 * poi.x) + (this.m22 * poi.y) + (this.m23 * poi.z),
                (this.m31 * poi.x) + (this.m32 * poi.y) + (this.m33 * poi.z));
    }

    /**
     * Diese Methode ersetzt die 1. Spalte dieser Matrix durch den übergebenen
     * Vektor(vec).
     *
     * @param vec Vektor der die 1. Spalte ersetzen soll.
     * @return Matrix vom Type Mat3x3 mit der ersetzten 1. Spalte.
     */
    public Mat3x3 changeCol1(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Mat3x3(vec.x, m12, m13, vec.y, m22, m23, vec.z, m32, m33);
    }

    /**
     * Diese Methode ersetzt die 2. Spalte dieser Matrix durch den übergebenen
     * Vektor(vec).
     *
     * @param vec Vektor der die 2. Spalte ersetzen soll.
     * @return Matrix vom Type Mat3x3 mit der ersetzten 2. Spalte.
     */
    public Mat3x3 changeCol2(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Mat3x3(m11, vec.x, m13, m21, vec.y, m23, m31, vec.z, m33);
    }

    /**
     * Diese Methode ersetzt die 3. Spalte dieser Matrix durch den übergebenen
     * Vektor(vec).
     *
     * @param vec Vektor der die 3. Spalte ersetzen soll.
     * @return Matrix vom Type Mat3x3 mit der ersetzten 3. Spalte.
     */
    public Mat3x3 changeCol3(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Mat3x3(m11, m12, vec.x, m21, m22, vec.y, m31, m32, vec.z);
    }
    
     /**
     * Diese Methode berechnet die Determinante der 3x3 Matrix nach der Regel
     * von Sarrus.
     *
     * @return Die Determinante der 3x3 Matrix als double.
     */
    private double determinant() {
        return (m11 * m22 * m33) + (m12 * m23 * m31) + (m13 * m21 * m32)
                - (m31 * m22 * m13) - (m32 * m23 * m11) - (m33 * m21 * m12);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m13) ^ (Double.doubleToLongBits(this.m13) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m23) ^ (Double.doubleToLongBits(this.m23) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m31) ^ (Double.doubleToLongBits(this.m31) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.m32) ^ (Double.doubleToLongBits(this.m32) >>> 32));
        return 17 * hash + (int) (Double.doubleToLongBits(this.m33) ^ (Double.doubleToLongBits(this.m33) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mat3x3 other = (Mat3x3) obj;
        if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m12) != Double.doubleToLongBits(other.m12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m13) != Double.doubleToLongBits(other.m13)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m21) != Double.doubleToLongBits(other.m21)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m22) != Double.doubleToLongBits(other.m22)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m23) != Double.doubleToLongBits(other.m23)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m31) != Double.doubleToLongBits(other.m31)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m32) != Double.doubleToLongBits(other.m32)) {
            return false;
        }
        return Double.doubleToLongBits(this.m33) == Double.doubleToLongBits(other.m33);
    }

    @Override
    public String toString() {
        return "Mat3x3{" + "m11=" + m11 + ", m12=" + m12 + ", m13=" + m13 + ", m21=" + m21 + ", m22=" + m22 + ", m23=" + m23 + ", m31=" + m31 + ", m32=" + m32 + ", m33=" + m33 + ", determinant=" + determinant + '}';
    }
    
    
}
