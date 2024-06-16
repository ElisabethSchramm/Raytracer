package camera;

import raytracer.Ray;
import math.Point3;
import math.Vector3;

public class OrthographicCamera extends Camera {

    /**
     * Skalierungfaktor der Bildebene.
     */
    public final double s;

    /**
     * Repräsentiert eine Ortographische Kamera die Parallelprojektionen
     * erzeugt.
     *
     * @param e Position der Kamera (eyeposition)
     * @param g Blickrichtung der Kamera (gaze direction)
     * @param t Oben aus Kamarasicht (Up-Vector)
     * @param s Skalierugnsfaktor der Bildebene
     *
     */
    public OrthographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s) {
        super(e, g, t);
        this.s = s;
    }

    @Override
    public Ray rayFor(int w, int h, int x, int y) {
        if (w == 1 || h == 1 || h == 0) {
            throw new IllegalArgumentException();
        }
        final double a = ((double) w) / ((double) h);
        final double denominatorU = ((double) (w - 1));
        final double numeratorU = x - denominatorU / 2.0;
        final double productU = numeratorU / denominatorU;

        final double denominatorV = ((double) (h - 1));
        final double numeratorV = y - denominatorV / 2.0;
        final double productV = numeratorV / denominatorV;

        final double skalarForU = this.s * a * productU;
        final double skalarForV = this.s * productV;
        final Vector3 vecW = this.u.mul(skalarForU);
        final Vector3 vecH = this.v.mul(skalarForV);

        return new Ray(this.e.add(vecW.add(vecH)), this.w.changeDirection());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.s) ^ (Double.doubleToLongBits(this.s) >>> 32));
        return hash;
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
        final OrthographicCamera other = (OrthographicCamera) obj;
        return Double.doubleToLongBits(this.s) == Double.doubleToLongBits(other.s);
    }

    @Override
    public String toString() {
        return "OrthographicCamerea{" + super.toString() + "\n, s=" + s + "\n}";
    }
}
