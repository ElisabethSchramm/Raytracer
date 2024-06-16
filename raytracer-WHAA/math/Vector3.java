package math;

/**
 * Diese Klasse bildet einen 3 dimensionalen Vektor in einem 3 dimensionalen
 * kartesischen Koordinatensystem ab.
 *
 * @author Arnold
 */
public class Vector3 {

    /**
     * x-Richtung des Vektors
     */
    public final double x;

    /**
     * y-Richtung des Vektors
     */
    public final double y;

    /**
     * z-Richtung des Vektors
     */
    public final double z;

    /**
     * Länge des Vektors
     */
    public final double magnitude;

    
    /**
     * Diser Konstrukter erstellt einen neuen Vektor.
     *
     * @param x x-Richtung des Vektors
     * @param y y-Richtung des Vektors
     * @param z z-Richtung des Vektors
     */
    public Vector3(final Double x, final Double y, final Double z) {
        if (x == null || y == null || z == null) {
            throw new NullPointerException();
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = magnitude();
    }
    
    public Vector3() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.magnitude = 0.0;
    }

    /**
     * Diese Methode berechnet die Länge dieses Vektors.
     *
     * @return Länge als double
     */
    private double magnitude() {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0));
    }

    /**
     * Diese Methode addiert diesen Vektor mit dem übergebenen Vektors(vec).
     *
     * @param vec Vektor der dazu addiert wird
     * @return Summenvektor vom Type Vector3
     */
    public Vector3 add(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Vector3(x + vec.x, y + vec.y, z + vec.z);
    }

    /**
     * Diese Methode addiert den übergebenen Normalenvektor(norm) zu diesem
     * Vektor.
     *
     * @param norm Normalenvektor der dazu addiert wird
     * @return Summenvektor vom Type Vector3
     */
    public Vector3 add(final Normal3 norm) {
        if (norm == null) {
            throw new NullPointerException();
        }
        return new Vector3(x + norm.x, y + norm.y, z + norm.z);
    }

    /**
     * Diese Methode subtrahiert den übergebenen Normalenvektor(norm) von
     * diesem.
     *
     * @param norm Normalenvektor(Subtrahend) wird vom Vektor subtrahiert
     * @return Differenzvektor vom Type Vector3
     */
    public Vector3 sub(final Normal3 norm) {
        if (norm == null) {
            throw new NullPointerException();
        }
        return new Vector3(x - norm.x, y - norm.y, z - norm.z);
    }

    /**
     * Diese Methode multipliziert diesen Vector mit dem übergebenen Faktor(c).
     *
     * @param c Faktor mit dem der Vektor multipliziert wird
     * @return Vektor mit c-fachen länge von Type Vector3
     */
    public Vector3 mul(final Double c) {
        if (c == null) {
            throw new NullPointerException();
        }
        return new Vector3(x * c, y * c, z * c);
    }

    /**
     * Diese Methode berechnet das Skalarprodukt von diesem Vektor und dem
     * Übergebenen.
     *
     * @param vec Vektor mit dem das Skalarprodukt gebildet werden soll
     * @return Skalraprodukt als double
     */
    public double dot(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return ((x * vec.x) + (y * vec.y) + (z * vec.z));
    }

    /**
     * Diese Methode berechnet das Skalarprodukt von diesem Vektor und der
     * übergebenen Normalen.
     *
     * @param norm Normale mit der das Skalarprodukt gebildet werden soll
     * @return Skalraprodukt als double
     */
    public double dot(final Normal3 norm) {
        if (norm == null) {
            throw new NullPointerException();
        }
        return ((x * norm.x) + (y * norm.y) + (z * norm.z));
    }

    /**
     * Diese Methode normalisiert den Vektor auf die länge 1.
     *
     * @return Normalisierter Vektor vom Type Vector3
     */
    public Vector3 normalized() {
        if (magnitude != 0) {
            return new Vector3(x / magnitude, y / magnitude, z / magnitude);
        } else {
            return new Vector3(x, y, z);
        }
    }

    /**
     * Diese Methode normalisiert den Vektor auf die länge 1 und gibt eine
     * Normale zurück.
     *
     * @return Normale des Vektors
     */
    public Normal3 asNormal() {
        final Vector3 normalizedVector = normalized();
        return new Normal3(normalizedVector.x, normalizedVector.y, normalizedVector.z);
    }

    /**
     * Diese Methode reflekiert diesen Vektor an einer Normalen(norm).
     *
     * @param norm Normale an der reflekiert werden soll
     * @return Reflektionsvektor vom Type Vector3
     */
    public Vector3 reflectedOn(final Normal3 norm) {
        if (norm == null) {
            throw new NullPointerException();
        }
        /**
         * (2*Skalar(Einfalssvektor,Noramle))*Normale-Einfallsvektor
         */
        return subForRefl(norm.mul(2.0 * dot(norm)));
    }

    /**
     * Diese Methode subtrahiert von der Übergebenen Normalen diesen Vector.
     *
     * @param norm Normale von der Subtrahiert wird
     * @return Differnez als Vector3
     */
    private Vector3 subForRefl(final Normal3 norm) {
        return new Vector3(norm.x - x, norm.y - y, norm.z - z);
    }
    
    /**
     * Diese methode kehrt die Richtung des Vektors um.
     * 
     * @return Vektor in Gegenichtung
     */
    public Vector3 changeDirection() {
        return new Vector3(-x, -y, -z);
    }

    /**
     * Diese Methode berechnet das Kreuzprodukt aus diesem Vektor und dem
     * Übergebenen
     *
     * @param vec Vektor mit dem das Kreuzprodukt berechnet werden soll
     * @return Kreuzprodukt vom Type Vector3
     */
    public Vector3 x(final Vector3 vec) {
        if (vec == null) {
            throw new NullPointerException();
        }
        return new Vector3(y * vec.z - z * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return 67 * hash + (int) (Double.doubleToLongBits(this.magnitude) ^ (Double.doubleToLongBits(this.magnitude) >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector3 other = (Vector3) obj;
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
        return "Vector3{" + "x=" + x + ", y=" + y + ", z=" + z + ", magnitude=" + magnitude + '}';
    }
}
