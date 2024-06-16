package raytracer;

import java.util.Objects;
import math.Point3;
import math.Vector3;

/**
 * Klasse, die einen Strahl repräsentiert
 *
 */
public class Ray {

    /**
     * Ursprung des Strahls
     */
    public final Point3 o;

    /**
     * Richtung des Strahls
     */
    public final Vector3 d;

    /**
     * Der Konstruktor dieser Klasse nimmt als Parameter den Ursprung und die
     * Richtung des Strahls entgegen.
     *
     * @param o Ursprung des Strahls
     * @param d Richtung des Strahls
     */
    public Ray(final Point3 o, final Vector3 d) {
        if (o == null) {
            throw new IllegalArgumentException("Der dem Ray übergeben Punkt darf nicht null sein");
        }
        if (d == null) {
            throw new IllegalArgumentException("Der dem Ray übergeben Vektor darf nicht null sein");
        }
        this.o = o;
        this.d = d;
    }

    /**
     * Verlängert den Strahl um einen Faktor <b>t</b>
     *
     * @param t Faktor um den verlängert wird.
     * @return Punkt
     */
    public Point3 at(final double t) {

        return (o.add(d.mul(t)));

    }

    /**
     * Die Metohde berechnet den Abstand von Punkt <b>p</b> vom Ursprung des
     * Strahls
     *
     * @param p Punkt p muss auf dem Strahl sein
     * @return Abstand zum Ursprung als double
     * @throws IllegalArgumentException wenn der Punkt nicht auf dem Strahl
     * liegt.
     * @throws NullPointerException wenn der Punkt <b>null</b> ist.
     */
    public double tOf(final Point3 p) {
        if (p == null) {
            throw new NullPointerException("Der übergebene Punkt p darf nicht null sein");
        }
        final double t = (p.x - o.x) / d.x;
        if (((p.y - o.y) / d.y) != t || ((p.z - o.z) / d.z) != t) {
            throw new IllegalArgumentException("Punkt " + p.toString() + " liegt nicht auf dem Strahl");
        }
        return t;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o);
        return 17 * hash + Objects.hashCode(this.d);    
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ray other = (Ray) obj;
        if (!Objects.equals(this.o, other.o)) {
            return false;
        }
        return Objects.equals(this.d, other.d);
    }

    @Override
    public String toString() {
        return "Ray{" + "o=" + o.toString() + ", d=" + d.toString() + '}';
    }
}
