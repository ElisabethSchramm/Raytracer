package geometry;

import java.util.Objects;
import material.Material;
import raytracer.Ray;
import math.Normal3;
import math.Point3;

/**
 * Diese Klasse repräsentiert eine Ebene.
 *
 * @author Arnold
 */
public class Plane extends Geometry {

    /**
     * Mittelpunkt der Ebene
     */
    public final Point3 a;

    /**
     * Normale der Ebene
     */
    public final Normal3 n;

    /**
     *
     * @param a Punkt der Ebene
     * @param n Normale der Ebene
     * @param material
     */
    public Plane(final Point3 a, final Normal3 n, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Plane übergebene Material darf nicht null sein");
        }
        if (a == null) {
            throw new IllegalArgumentException("Der der Plane übergebe Punkt darf nicht null sein");
        }
        if (n == null) {
            throw new IllegalArgumentException("Der der Plane übergebe Vektor darf nicht null sein");
        }

        this.a = a;
        this.n = n;
    }

    /**
     * Dieser Konstrukter erstellt eine Einheitsebene am Punkt 0 0 0 und der
     * Normalen 0 1 0
     *
     * @param material
     */
    public Plane(final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Plane übergebene Material darf nicht null sein");
        }
        this.a = new Point3();
        this.n = new Normal3(0.0, 1.0, 0.0);
    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        if (r.d.dot(n) == 0) {
            return null;
        }
        final double t = (double) n.dot(a.sub(r.o)) / (double) r.d.dot(n);
        if (t < 0) {
            return null;
        } else {
            return new Hit(t, r, n, this);
        }
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.a);
        return 71 * hash + Objects.hashCode(this.n);
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plane other = (Plane) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        return Objects.equals(this.n, other.n);
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString() + "\n, a=" + a.toString() + "\n, n=" + n.toString() + "}\n";
    }
}
