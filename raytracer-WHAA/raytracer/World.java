package raytracer;

import geometry.Geometry;
import geometry.Hit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import light.Light;

public class World {

    public final Color backgroundColor;
    public final HashSet<Geometry> geometries;
    public final ArrayList<Light> lights;
    public final Color ambientLightColor;

    public World(final ArrayList<Light> lights, final Color ambientLightColor, final Color backgroundColor, final HashSet<Geometry> geometries) {
        if (lights == null) {
            throw new IllegalArgumentException("Die der World übergebene ArrayList lights darf nicht null sein");
        }
        if (lights == null) {
            throw new IllegalArgumentException("Die der World übergebene Color ambientLightColor darf nicht null sein");
        }
        if (lights == null) {
            throw new IllegalArgumentException("Die der World übergebene Color backgroundColor darf nicht null sein");
        }
        if (lights == null) {
            throw new IllegalArgumentException("Das der World übergebene HashSet<Geometry> geometries darf nicht null sein");
        }
        this.backgroundColor = backgroundColor;
        this.geometries = geometries;
        this.lights = lights;
        this.ambientLightColor = ambientLightColor;
    }

    public Hit hit(final Ray r, final double epsilon) {
        if (r == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        if (geometries == null) {
            return null;
        }
        Hit geoHit = null;
        double t = -1;

        for (Geometry geo : geometries) {
            Hit tmpGeoHit = geo.hit(r);
            if (tmpGeoHit != null) {
                //kleinster positiver Schnittpunkt mit einer Geometrie in der Szene
                if ((tmpGeoHit.t >= 0) && ((tmpGeoHit.t < t) || t == -1)) {
                    t = tmpGeoHit.t + epsilon;
                    geoHit = tmpGeoHit;
                }
            }
        }
        return geoHit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.backgroundColor);
        hash = 89 * hash + Objects.hashCode(this.geometries);
        hash = 89 * hash + Objects.hashCode(this.lights);
        return 89 * hash + Objects.hashCode(this.ambientLightColor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final World other = (World) obj;
        if (!Objects.equals(this.backgroundColor, other.backgroundColor)) {
            return false;
        }
        if (!Objects.equals(this.geometries, other.geometries)) {
            return false;
        }
        if (!Objects.equals(this.lights, other.lights)) {
            return false;
        }
        return Objects.equals(this.ambientLightColor, other.ambientLightColor);
    }

    @Override
    public String toString() {
        return "World{\nbackgroundColor=" + backgroundColor.toString()
                + "\ngeometries=" + geometries.toString()
                + "\nlights=" + lights.toString()
                + "\nambientLightColor=" + ambientLightColor.toString() + "\n}";
    }
}
