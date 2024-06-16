package geometry;

import java.util.Objects;
import material.Material;
import math.Normal3;
import raytracer.Ray;
import math.Point3;

/**
 *
 * @author Arnold
 */
public class AxisAlignedBox extends Geometry {

    /**
     * Entfernter Punkt
     */
    public final Point3 ibf;

    /**
     * Naher Punkt
     */
    public final Point3 run;

    /**
     * Dieser Konstrukter erstellt eine Einheitsbox der Größe 1 um den KO.
     *
     * @param material
     */
    public AxisAlignedBox(final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Box übergebene Material darf nicht null sein");
        }
        this.ibf = new Point3(-0.5, -0.5, -0.5);
        this.run = new Point3(0.5, 0.5, 0.5);
    }

    /**
     * Dieser Konstrukter erstellt eine Box von dem Punkt ibf bis zum Punkt run.
     *
     * @param ibf
     * @param run
     * @param material
     */
    public AxisAlignedBox(final Point3 ibf, final Point3 run, final Material material) {
        super(material);
        if (material == null) {
            throw new IllegalArgumentException("Das der Box übergebene Material darf nicht null sein");
        }
        if (ibf == null) {
            throw new IllegalArgumentException("Das der Box übergebene Punkt ibf darf nicht null sein");
        }
        if (run == null) {
            throw new IllegalArgumentException("Das der Box übergebene Punkt run darf nicht null sein");
        }

        this.ibf = ibf;
        this.run = run;

    }

    @Override
    public Hit hit(final Ray r) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }

        final Normal3 runx = new Normal3(1.0, 0.0, 0.0);
        final Normal3 runy = new Normal3(0.0, 1.0, 0.0);
        final Normal3 runz = new Normal3(0.0, 0.0, 1.0);
        final Normal3 ibfx = new Normal3(-1.0, 0.0, 0.0);
        final Normal3 ibfy = new Normal3(0.0, -1.0, 0.0);
        final Normal3 ibfz = new Normal3(0.0, 0.0, -1.0);

        final Normal3[] normalsibf = new Normal3[]{ibfx, ibfy, ibfz};
        final Normal3[] normalsrun = new Normal3[]{runx, runy, runz};

        double max = -1;

        Normal3 hitPointNormal = null;

        for (Normal3 normal : normalsibf) {
            if (r.o.sub(ibf).dot(normal) > 0) {
                final double t = normal.dot(ibf.sub(r.o)) / r.d.dot(normal);
                if (t > max) {
                    max = t;
                    hitPointNormal = normal;
                }
            }
        }
        for (Normal3 normal : normalsrun) {
            if (r.o.sub(run).dot(normal) > 0) {
                final double t = normal.dot(run.sub(r.o)) / r.d.dot(normal);
                if (t > max) {
                    max = t;
                    hitPointNormal = normal;
                }
            }
        }
        if (Double.compare(max, 0) >= 0) {
            final Point3 hitPoi = r.at(max + 0.000000001);
            if (Double.compare(run.x, hitPoi.x) < 0
                    || Double.compare(ibf.x, hitPoi.x) > 0
                    || Double.compare(run.y, hitPoi.y) < 0
                    || Double.compare(ibf.y, hitPoi.y) > 0
                    || Double.compare(run.z, hitPoi.z) < 0
                    || Double.compare(ibf.z, hitPoi.z) > 0) {
                return null;
            }
            return new Hit(max, r, hitPointNormal, this);
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + Objects.hashCode(this.ibf);
        return 97 * hash + Objects.hashCode(this.run);
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
        final AxisAlignedBox other = (AxisAlignedBox) obj;
        if (!Objects.equals(this.ibf, other.ibf)) {
            return false;
        }
        return Objects.equals(this.run, other.run);
    }

    @Override
    public String toString() {
        return "AxisAlignedBox{" + super.toString() + "\n, ibf=" + ibf
                + ", run=" + run + "}\n";
    }

}
