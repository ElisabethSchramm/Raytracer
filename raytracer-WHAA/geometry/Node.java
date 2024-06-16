package geometry;

import java.util.ArrayList;
import java.util.Objects;
import math.Transform;
import raytracer.Ray;

/**
 *
 * @author Arnold
 */
public class Node extends Geometry {

    /**
     * Liste von Geometry die transformiert werden sollen
     */
    public final ArrayList<Geometry> geometries;

    /**
     * Transform beinhaltet die Transfomierung
     */
    public final Transform transform;

    /**
     * Der Konstrukter übernimmt eine Liste von Geometry und eine Transformation
     * zur Trnasformation der Geometrien
     *
     * @param geometries
     * @param transform
     */
    public Node(final ArrayList<Geometry> geometries, final Transform transform) {
        super(null);
        if (geometries == null) {
            throw new IllegalArgumentException("Die der Node übergebene Arraylist darf nicht null sein");
        }
        if (transform == null) {
            throw new IllegalArgumentException("Das der Node übergebene Transform darf nicht null sein");
        }
        this.geometries = geometries;
        this.transform = transform;
    }

    @Override
    public Hit hit(final Ray r) {

        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        if (geometries == null) {
            return null;
        }
        Ray transRay = this.transform.mul(r);
        double tmpT = -1;
        Hit hit = null;
        for (Geometry geo : geometries) {
            Hit tmpHit = geo.hit(transRay);
            if (tmpHit != null) {
                if (tmpHit.t >= 0 && (tmpHit.t < tmpT || tmpT == -1)) {
                    hit = new Hit(tmpHit.t, r, this.transform.mul(tmpHit.normal), tmpHit.geo);
                    tmpT = hit.t;
                }
            }
        }
        return hit;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 37 * hash + Objects.hashCode(this.geometries);
        return 37 * hash + Objects.hashCode(this.transform);
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
        final Node other = (Node) obj;
        if (!Objects.equals(this.geometries, other.geometries)) {
            return false;
        }
        return Objects.equals(this.transform, other.transform);
    }

    @Override
    public String toString() {
        
        return  "Node{" + "geometries=" + geometries + ", transform=" + transform + '}';
    }
}
