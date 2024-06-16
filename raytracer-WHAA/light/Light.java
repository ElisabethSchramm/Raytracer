package light;

import java.util.Objects;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.World;

/**
 * Basisklasse für Beleuchtung.
 */
public abstract class Light {

    /**
     * Farbe des Lichtes
     */
    public final Color color;
    
    /**
     * Gibt an ob dieses Licht Schatten wirft
     */
    public final boolean castsShadows; 

    public Light(final Color color, final boolean castsShadows) {
        if (color == null) {
            throw new IllegalArgumentException("Die dem Light übergebene Color darf nicht null sein");
        }
        this.color = color;
        this.castsShadows = castsShadows;
    }

    /**
     * Prüft ob der übergebene Punkt von diesem Licht angestrahlt wird
     *
     * @param point Punkt der geprüft wird.
     * @param world
     * @return wahr oder falsche.
     */
    public abstract boolean illuminates(final Point3 point, final World world);

    /**
     * Berechnet für einen gegebenen <b>Punkt3</b> die richtung zur Lichtquelle. 
     * @param point
     * @return Vector l, der zur Lichtquelle zeigt
     */
    public abstract Vector3 directionFrom(final Point3 point);

    @Override
    public int hashCode() {
        int hash = 5;
        return 97 * hash + Objects.hashCode(this.color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Light other = (Light) obj;
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return "Light{" + "color=" + color.toString();
    }  
}
