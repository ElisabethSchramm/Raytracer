package camera;

import raytracer.Ray;
import math.Point3;
import math.Vector3;

public class PerspectiveCamera extends Camera {

    /**
     * Öffnungswinkel in Grad
     */
    public final double angle;

    /**
     * Repräsentiert eine Perspektivische Kamera. Die Perspektivische
     * Projektionen erzeugt.
     *
     * @param e Position der Kamera (eyposition)
     * @param g Blickrichtung der Kamera (gaze direction)
     * @param t Oben aus Kamarasicht (Up-Vector)
     * @param angle Öffnungswinkel in Grad.
     *
     */
    public PerspectiveCamera(final Point3 e, final Vector3 g, final Vector3 t, final double angle) {
        super(e, g, t);
        this.angle = angle / 2.0;
    }

    @Override
    public Ray rayFor(final int w, final int h, final int x, final int y) {
        final Vector3 vecW = this.u.mul((double) (x - (w - 1) / 2));
        final Vector3 vecH = this.v.mul((double) (y - (h - 1) / 2));
        if (Math.tan(angle) == 0) {
            throw new IllegalArgumentException();
        }
        final Vector3 r = super.w.changeDirection().mul((h / 2) / Math.tan(angle)).add(vecW).add(vecH);

        return new Ray(this.e, r.normalized());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.angle) ^ (Double.doubleToLongBits(this.angle) >>> 32));
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
        final PerspectiveCamera other = (PerspectiveCamera) obj;
        return Double.doubleToLongBits(this.angle) == Double.doubleToLongBits(other.angle);
    }

    @Override
    public String toString() {
        return "perspectiveCamera{" + super.toString() + "\n, angle=" + angle + " \n}";
    }
}
