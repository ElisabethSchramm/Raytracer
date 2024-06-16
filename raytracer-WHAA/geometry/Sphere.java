package geometry;

import java.util.Objects;
import material.Material;
import raytracer.Ray;
import math.Point3;

/**
 * Diese Klasse repräsentierd eine Kugel
 *
 * @author User
 */
public class Sphere extends Geometry {

    /**
     * Mittelpunkt der Kugel
     */
    public final Point3 c;

    /**
     * Radius der Kugel
     */
    public final double r;

    /**
     * Konstrukter für Benutzerdefinierten Kugel
     *
     * @param c
     * @param r
     * @param material
     */
    public Sphere(final Point3 c, final double r, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Sphere übergebene Material darf nicht null sein");
        }
        if (c == null) {
            throw new IllegalArgumentException("Der der Sphere übergebene Punkt darf nicht null sein");
        }
        if (r == 0.0) {
            throw new IllegalArgumentException("Der der Sphere übergebene Punkt darf nicht null sein");
        }
        this.c = c;
        this.r = r;
    }

    /**
     * Konstruktur für Einheitskugel um den Punkt 0 0 0 und Radius 1
     *
     * @param material
     */
    public Sphere(final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Sphere übergebene Material darf nicht null sein");
        }
        this.c = new Point3(0.0, 0.0, 0.0);
        this.r = 1.0;
    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        final double a = r.d.dot(r.d);
        if (a == 0) {
            return null;
        }
        double b = r.d.dot((r.o.sub(c)).mul(2.0));
        double c = (r.o.sub(this.c)).dot(r.o.sub(this.c)) - Math.pow(this.r, 2);
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            return null;
        } else if (d == 0) {
            final double t = (-b) / (2 * a);
            if (t >= 0) {
                final Point3 hitPoint = r.at(t);
                return new Hit(t, r, hitPoint.sub(this.c).asNormal(), this);
            } else {
                return null;
            }
        } else {
            final double sqrt = Math.sqrt(d);
            final Double t1 = ((-b) + sqrt) / (2.0 * a);
            final Double t2 = ((-b) - sqrt) / (2.0 * a);
            if (t1 < t2 && t1 >= 0) {
                final Point3 hitPoint = r.at(t1);
                return new Hit(t1, r, hitPoint.sub(this.c).asNormal(), this);
            } else {
                if (t2 >= 0) {
                    final Point3 hitPoint = r.at(t2);
                    return new Hit(t2, r, hitPoint.sub(this.c).asNormal(), this);
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 53 * hash + Objects.hashCode(this.c);
        return 53 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
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
        final Sphere other = (Sphere) obj;
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return Double.doubleToLongBits(this.r) == Double.doubleToLongBits(other.r);
    }

    @Override
    public String toString() {
        return "Sphere{" + super.toString() + "\n, c=" + c.toString() + ", r=" + r + "}\n";
    }
}
