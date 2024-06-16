package geometry;

import java.util.Objects;
import material.Material;
import raytracer.Ray;
import math.Point3;
import math.Mat3x3;
import math.Normal3;
import math.Vector3;

/**
 * Diese Klasse repräsentierd ein Dreieck
 *
 * @author User
 */
public class Triangle extends Geometry {

    /**
     * Punkt a des Dreiecks
     */
    public final Point3 a;

    /**
     * Normale am Punkt a des Dreiecks
     */
    public final Normal3 aNormal;

    /**
     * Punkt b des Dreiecks
     */
    public final Point3 b;

    /**
     * Normale am Punkt b des Dreiecks
     */
    public final Normal3 bNormal;

    /**
     * Punkt c des Dreiecks
     */
    public final Point3 c;

    /**
     * Normale am Punkt c des Dreiecks
     */
    public final Normal3 cNormal;

    /**
     *
     * @param a
     * @param aNormal
     * @param b
     * @param bNormal
     * @param c
     * @param cNormal
     * @param material
     */
    public Triangle(final Point3 a, final Normal3 aNormal, final Point3 b, final Normal3 bNormal, final Point3 c, final Normal3 cNormal, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das dem Dreieck übergebene Material darf nicht null sein");
        }
        if (a == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Punkt a darf nicht null sein");
        }
        if (b == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Punkt b darf nicht null sein");
        }
        if (c == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Punkt c darf nicht null sein");
        }
        if (aNormal == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Vektor a darf nicht null sein");
        }
        if (bNormal == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Vektor b darf nicht null sein");
        }
        if (cNormal == null) {
            throw new IllegalArgumentException("Der dem Dreieck übergebene Vektor c darf nicht null sein");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.aNormal = aNormal;
        this.bNormal = bNormal;
        this.cNormal = cNormal;
    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }

        final Vector3 ergVec = a.sub(r.o);
        final Mat3x3 matA = new Mat3x3(
                a.x - b.x, a.x - c.x, r.d.x,
                a.y - b.y, a.y - c.y, r.d.y,
                a.z - b.z, a.z - c.z, r.d.z);
        final double beta = (matA.changeCol1(ergVec).determinant) / matA.determinant;
        if (beta < 0 || beta > 1) {
            return null;
        }
        final double gamma = (matA.changeCol2(ergVec).determinant) / matA.determinant;
        if (gamma < 0 || gamma > 1) {
            return null;
        }
        if (beta + gamma < 0 || beta + gamma > 1) {
            return null;
        }
        final double t = (matA.changeCol3(ergVec).determinant) / matA.determinant;
        final Normal3 hitPointNormal = aNormal.mul(1 - (beta + gamma)).add(bNormal.mul(beta)).add(cNormal.mul(gamma));
        return new Hit(t, r, hitPointNormal, this);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 59 * hash + Objects.hashCode(this.a);
        hash = 59 * hash + Objects.hashCode(this.aNormal);
        hash = 59 * hash + Objects.hashCode(this.b);
        hash = 59 * hash + Objects.hashCode(this.bNormal);
        hash = 59 * hash + Objects.hashCode(this.c);
        return 59 * hash + Objects.hashCode(this.cNormal);
    }

    @Override
    public boolean equals(Object obj) {
        super.hashCode();
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.aNormal, other.aNormal)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.bNormal, other.bNormal)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        return Objects.equals(this.cNormal, other.cNormal);
    }

    @Override
    public String toString() {
        return "Triangle{" + super.toString() + "\n, a=" + a + ", aNormal=" + aNormal
                + "\n, b=" + b + ", bNormal=" + bNormal
                + "\n, c=" + c + ", cNormal=" + cNormal + "}\n";
    }

}
