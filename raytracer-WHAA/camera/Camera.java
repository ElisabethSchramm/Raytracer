package camera;

import java.util.Objects;
import raytracer.Ray;
import math.Point3;
import math.Vector3;

public abstract class Camera {
    
    /**
     * Position der Kamera (eyeposition)
     */
    public final Point3 e;
    /**
     * Blickrichtung der Kamera (gaze direction)
     */
    public final Vector3 g;
    /**
     * Oben (Up-Vector)
     */
    public final Vector3 t;
    /**
     * u Achsee im Koordinatensysthem der Kamera.
     */
    public final Vector3 u;
    /**
     * v Achse im Koordinatensysthem der Kamera.
     */
    public final Vector3 v;
    /**
     * w Achse im Koordinatensysthem der Kamera.
     */
    public final Vector3 w;

    /**
     * Repräsentiert die Grundeigenschaften einer Kamera. <br>
     * Im Konstruktor werden die Vektoren u v w berechnet, welche ebenfalls als
     * öffentliche Attribute zur Verfügung gestellt werden. <br>
     * e <b>Point3</b> Position der Kamera (eyposition) <br>
     * g <b>Vector3</b> Blickrichtung der Kamera (gaze direction) <br>
     * t <b>Vector3</b> Oben (Up-Vector) <br>
     * u <b>Vector3</b> u Axe im Koordinatensysthem der Kamera. <br>
     * v <b>Vector3</b> v Axe im Koordinatensysthem der Kamera. <br>
     * w <b>Vector3</b> w Axe im Koordinatensysthem der Kamera.<br>
     *
     * @param e Position der Kamera (eyposition)
     * @param g Blickrichtung (gaze direction)
     * @param t Oben (Up-Vektor)
     */
    public Camera(Point3 e, Vector3 g, Vector3 t) {
        if (e == null) {
            throw new IllegalArgumentException("Der der Camera übergebene Punkt e darf nicht null sein");
        }
        if (g == null) {
            throw new IllegalArgumentException("Der der Camera übergebene Vector g darf nicht null sein");
        }
        if (t == null) {
            throw new IllegalArgumentException("Der der Camera übergebene Vector t darf nicht null sein");
        }
        this.e = e;
        this.g = g;
        this.t = t;
        this.w = (g.normalized()).changeDirection();
        this.u = (t.x(w)).normalized();
        this.v = w.x(u);
    }
    
    /**
     * gibt für einen bestimmten Pixel den Strahl zurück. <br>
     * linke untere Ecke ist x=0 und y=0 <br>
     * rechte oebere Ecke ist x=w-1 und y=h-1
     *
     * @param w Breite des bildes
     * @param h Höhe des bildes
     * @param x Koordinate des Pixel, für den der Strahl generiert werden soll
     * @param y Koordinate des Pixel, für den der Strahl generiert werden soll
     * @return Strahl über den Pixel
     */
    public Ray rayFor(int w, int h, int x, int y){
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.e);
        hash = 47 * hash + Objects.hashCode(this.g);
        return  47 * hash + Objects.hashCode(this.t);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camera other = (Camera) obj;
        if (!Objects.equals(this.e, other.e)) {
            return false;
        }
        if (!Objects.equals(this.g, other.g)) {
            return false;
        }
        return Objects.equals(this.t, other.t);
    }

    @Override
    public String toString() {
        return "\n  e=" + e.toString() + "\n, g=" + g.toString() + "\n, t=" + t.toString() 
                + "\n, u=" + u.toString() + "\n, v=" + v.toString() + "\n, w=" + w.toString();
    }
}
