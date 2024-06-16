package geometry;

import java.util.Objects;
import math.Normal3;
import raytracer.Ray;

/**
 *
 * Ein Schnittpunkt wird mit einem Objekt der Klasse Hit ausgedrückt. Dieser
 * verweist auf den Strahl, die Geometrie und beinhaltet das an dem dieser
 * Strahl und diese Geometrie sich schneiden
 */
public class Hit {
    public final double t;
    public final Ray ray;
    public final Normal3 normal;
    public final Geometry geo;

    public Hit(double t, Ray ray, Normal3 hitPointNormal, Geometry geo) {
//        if(ray == null) throw new IllegalArgumentException("Das übergebe t darf nicht null sein");
//        if(n == null) throw new IllegalArgumentException("Der übergebe Vektor darf nicht null sein");
        this.t = t;
        this.ray = ray;
        this.normal = hitPointNormal;
        this.geo = geo;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.t) ^ (Double.doubleToLongBits(this.t) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.ray);
        hash = 29 * hash + Objects.hashCode(this.normal);
        hash = 29 * hash + Objects.hashCode(this.geo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hit other = (Hit) obj;
        if (Double.doubleToLongBits(this.t) != Double.doubleToLongBits(other.t)) {
            return false;
        }
        if (!Objects.equals(this.ray, other.ray)) {
            return false;
        }
        if (!Objects.equals(this.normal, other.normal)) {
            return false;
        }
        if (!Objects.equals(this.geo, other.geo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hit{" + "t=" + t + ", ray=" + ray + ", normal=" + normal + ", geo=" + geo + '}';
    } 
}
