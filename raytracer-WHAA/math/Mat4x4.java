package math;

public class Mat4x4 {

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
     * Element der 1. Zeile und 4. Spalte.
     */
    public final double m14;

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
     * Element der 2. Zeile und 4. Spalte.
     */
    public final double m24;

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
     * Element der 3. Zeile und 4. Spalte.
     */
    public final double m34;

    /**
     * Element der 4. Zeile und 1. Spalte.
     */
    public final double m41;

    /**
     * Element der 4. Zeile und 3. Spalte.
     */
    public final double m42;

    /**
     * Element der 4. Zeile und 3. Spalte.
     */
    public final double m43;

    /**
     * Element der 4. Zeile und 4. Spalte.
     */
    public final double m44;

    /**
     * Diser Konstrukter erstellt eine neue 3x3 Matrix.
     *
     * @param m11 Element der 1. Zeile und 1. Spalte.
     * @param m12 Element der 1. Zeile und 2. Spalte.
     * @param m13 Element der 1. Zeile und 3. Spalte.
     * @param m14 Element der 1. Zeile und 4. Spalte.
     * @param m21 Element der 2. Zeile und 1. Spalte.
     * @param m22 Element der 2. Zeile und 2. Spalte.
     * @param m23 Element der 2. Zeile und 3. Spalte.
     * @param m24 Element der 2. Zeile und 4. Spalte.
     * @param m31 Element der 3. Zeile und 1. Spalte.
     * @param m32 Element der 3. Zeile und 2. Spalte.
     * @param m33 Element der 3. Zeile und 3. Spalte.
     * @param m34 Element der 3. Zeile und 4. Spalte.
     * @param m41 Element der 4. Zeile und 1. Spalte.
     * @param m42 Element der 4. Zeile und 2. Spalte.
     * @param m43 Element der 4. Zeile und 3. Spalte.
     * @param m44 Element der 4. Zeile und 4. Spalte.
     */
    public Mat4x4(
            final Double m11, final Double m12, final Double m13, final Double m14,
            final Double m21, final Double m22, final Double m23, final Double m24,
            final Double m31, final Double m32, final Double m33, final Double m34,
            final Double m41, final Double m42, final Double m43, final Double m44) {
        if (m11 == null || m12 == null || m13 == null || m14 == null
                || m21 == null || m22 == null || m23 == null || m24 == null
                || m31 == null || m32 == null || m33 == null || m34 == null
                || m41 == null || m42 == null || m43 == null || m44 == null) {
            throw new NullPointerException();
        }
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;

    }

    /**
     * Diese Methode multipliziert diese Matrix mit der übergebenen Matrix(mat).
     *
     * @param mat Matrix vom Type Mat4x4 die mit der Matrix multipliziert wird.
     * @return Produktmatrix vom Type Mat4x4
     */
    public Mat4x4 mul(final Mat4x4 mat) {
        if (mat == null) {
            throw new NullPointerException();
        }
        return new Mat4x4(
                (this.m11 * mat.m11) + (this.m12 * mat.m21) + (this.m13 * mat.m31) + (this.m14 * mat.m41),
                (this.m11 * mat.m12) + (this.m12 * mat.m22) + (this.m13 * mat.m32) + (this.m14 * mat.m42),
                (this.m11 * mat.m13) + (this.m12 * mat.m23) + (this.m13 * mat.m33) + (this.m14 * mat.m43),
                (this.m11 * mat.m14) + (this.m12 * mat.m24) + (this.m13 * mat.m34) + (this.m14 * mat.m44),
                
                (this.m21 * mat.m11) + (this.m22 * mat.m21) + (this.m23 * mat.m31) + (this.m24 * mat.m41),
                (this.m21 * mat.m12) + (this.m22 * mat.m22) + (this.m23 * mat.m32) + (this.m24 * mat.m42),
                (this.m21 * mat.m13) + (this.m22 * mat.m23) + (this.m23 * mat.m33) + (this.m24 * mat.m43),
                (this.m21 * mat.m14) + (this.m22 * mat.m24) + (this.m23 * mat.m34) + (this.m24 * mat.m44),
                
                (this.m31 * mat.m11) + (this.m32 * mat.m21) + (this.m33 * mat.m31) + (this.m34 * mat.m41),
                (this.m31 * mat.m12) + (this.m32 * mat.m22) + (this.m33 * mat.m32) + (this.m34 * mat.m42),
                (this.m31 * mat.m13) + (this.m32 * mat.m23) + (this.m33 * mat.m33) + (this.m34 * mat.m43),
                (this.m31 * mat.m14) + (this.m32 * mat.m24) + (this.m33 * mat.m34) + (this.m34 * mat.m44),
                
                (this.m41 * mat.m11) + (this.m42 * mat.m21) + (this.m43 * mat.m31) + (this.m44 * mat.m41),
                (this.m41 * mat.m12) + (this.m42 * mat.m22) + (this.m43 * mat.m32) + (this.m44 * mat.m42),
                (this.m41 * mat.m13) + (this.m42 * mat.m23) + (this.m43 * mat.m33) + (this.m44 * mat.m43),
                (this.m41 * mat.m14) + (this.m42 * mat.m24) + (this.m43 * mat.m34) + (this.m44 * mat.m44));

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
                (this.m11 * poi.x) + (this.m12 * poi.y) + (this.m13 * poi.z) + this.m14,
                (this.m21 * poi.x) + (this.m22 * poi.y) + (this.m23 * poi.z) + this.m24,
                (this.m31 * poi.x) + (this.m32 * poi.y) + (this.m33 * poi.z) + this.m34);
    }

    public Mat4x4 transpose() {
        return new Mat4x4(
                this.m11, this.m21, this.m31, this.m41,
                this.m12, this.m22, this.m32, this.m42,
                this.m13, this.m23, this.m33, this.m43,
                this.m14, this.m24, this.m34, this.m44);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m11) ^ (Double.doubleToLongBits(this.m11) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m12) ^ (Double.doubleToLongBits(this.m12) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m13) ^ (Double.doubleToLongBits(this.m13) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m14) ^ (Double.doubleToLongBits(this.m14) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m21) ^ (Double.doubleToLongBits(this.m21) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m22) ^ (Double.doubleToLongBits(this.m22) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m23) ^ (Double.doubleToLongBits(this.m23) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m24) ^ (Double.doubleToLongBits(this.m24) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m31) ^ (Double.doubleToLongBits(this.m31) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m32) ^ (Double.doubleToLongBits(this.m32) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m33) ^ (Double.doubleToLongBits(this.m33) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m34) ^ (Double.doubleToLongBits(this.m34) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m41) ^ (Double.doubleToLongBits(this.m41) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m42) ^ (Double.doubleToLongBits(this.m42) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.m43) ^ (Double.doubleToLongBits(this.m43) >>> 32));
        return 83 * hash + (int) (Double.doubleToLongBits(this.m44) ^ (Double.doubleToLongBits(this.m44) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mat4x4 other = (Mat4x4) obj;
        if (Double.doubleToLongBits(this.m11) != Double.doubleToLongBits(other.m11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m12) != Double.doubleToLongBits(other.m12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m13) != Double.doubleToLongBits(other.m13)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m14) != Double.doubleToLongBits(other.m14)) {
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
        if (Double.doubleToLongBits(this.m24) != Double.doubleToLongBits(other.m24)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m31) != Double.doubleToLongBits(other.m31)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m32) != Double.doubleToLongBits(other.m32)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m33) != Double.doubleToLongBits(other.m33)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m34) != Double.doubleToLongBits(other.m34)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m41) != Double.doubleToLongBits(other.m41)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m42) != Double.doubleToLongBits(other.m42)) {
            return false;
        }
        if (Double.doubleToLongBits(this.m43) != Double.doubleToLongBits(other.m43)) {
            return false;
        }
        return Double.doubleToLongBits(this.m44) == Double.doubleToLongBits(other.m44);
    }

    @Override
    public String toString() {
        return "Mat4x4{" + "m11=" + m11 + ", m12=" + m12 + ", m13=" + m13 + ", m14=" + m14 + ", m21=" + m21 + ", m22=" + m22 + ", m23=" + m23 + ", m24=" + m24 + ", m31=" + m31 + ", m32=" + m32 + ", m33=" + m33 + ", m34=" + m34 + ", m41=" + m41 + ", m42=" + m42 + ", m43=" + m43 + ", m44=" + m44 + '}';
    }
    
}
