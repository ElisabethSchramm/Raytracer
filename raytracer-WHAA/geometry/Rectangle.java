package geometry;

import material.Material;
import math.Normal3;
import math.Point3;
import raytracer.Ray;

/**
 * Diese Klasse repräsentierd ein Rechteck
 *
 * @author Arnold
 */
public class Rectangle extends Geometry {

    /**
     * Breite
     */
    public final double w;

    /**
     * Höhe
     */
    public final double h;

    /**
     *
     * @param material
     */
    public Rectangle(final Material material) {
        super(material);
        this.w = 1.0;
        this.h = 1.0;
    }

    /**
     *
     * @param width
     * @param height
     * @param material
     */
    public Rectangle(final double width, final double height, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das dem Rectangle übergebene Material darf nicht null sein");
        }
        this.w = width;
        this.h = height;
    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        final Normal3 n = new Normal3(0.0, 1.0, 0.0);
        if (r.d.dot(n) == 0) {
            return null;
        }
        final Point3 p = new Point3();
        double t = (double) n.dot(p.sub(r.o)) / (double) r.d.dot(n);
        if (t < 0) {
            return null;
        } else {
            final Point3 hP = r.at(t);
            if (hP.x < 0 || hP.x > w || hP.z < 0 || hP.z > h) {
                return null;
            }
            return new Hit(t, r, n, this);
        }
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.w) ^ (Double.doubleToLongBits(this.w) >>> 32));
        return 29 * hash + (int) (Double.doubleToLongBits(this.h) ^ (Double.doubleToLongBits(this.h) >>> 32));
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
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.w) != Double.doubleToLongBits(other.w)) {
            return false;
        }
        return Double.doubleToLongBits(this.h) == Double.doubleToLongBits(other.h);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "w=" + w + ", h=" + h + '}';
    }

}
