package geometry;

import java.util.Objects;
import material.Material;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Ray;

/**
 * Diese Klasse repräsentiert einen Kreis.
 *
 * @author Arnold
 */
public class Disc extends Geometry {

    /**
     * Mittelpunkt des Kreises
     */
    public final Point3 p;

    /**
     * Normale auf der Kreisfläche
     */
    public final Normal3 n;

    /**
     * Radius des Kreises
     */
    public final double r;

    /**
     * Diese Konstrukter erstellt einen Einheitskreis mit der Normale 0 0 1 und
     * einem Radius von 1.
     *
     * @param material
     */
    public Disc(final Material material) {
        super(material);
        this.p = new Point3();
        this.n = new Normal3(0.0, 0.0, 1.0);
        this.r = 1.0;
    }

    /**
     * Dieser Konstrukter definiert einen Kreis
     *
     * @param p Mittelpunkt
     * @param n Normale
     * @param r Radius
     * @param material
     */
    public Disc(final Point3 p, final Normal3 n, final double r, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Disc übergebene Material darf nicht null sein");
        }
        if (p == null) {
            throw new IllegalArgumentException("Der der Disc übergebene Punkt darf nicht null sein");
        }
        if (n == null) {
            throw new IllegalArgumentException("Der der Disc übergebene Vector darf nicht null sein");
        }

        this.p = p;
        this.n = n;
        this.r = r;
    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        final double t = (double) n.dot(p.sub(r.o)) / (double) r.d.dot(n);
        if (r.d.dot(n) == 0) {
            return null;
        }
        final Vector3 tmpVec = p.sub(r.at(t));
        if (t < 0 || tmpVec.magnitude > this.r) {
            return null;
        } else {
            return new Hit(t, r, n, this);
        }
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + Objects.hashCode(this.p);
        hash = 97 * hash + Objects.hashCode(this.n);
        return 97 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
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
        final Disc other = (Disc) obj;
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        if (!Objects.equals(this.n, other.n)) {
            return false;
        }
        return Double.doubleToLongBits(this.r) == Double.doubleToLongBits(other.r);
    }

    @Override
    public String toString() {
        return "Disc{" + "p=" + p + ", n=" + n + ", r=" + r + '}';
    }

}
