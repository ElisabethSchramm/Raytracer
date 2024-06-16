package material;

import geometry.Hit;
import java.util.Objects;
import raytracer.Color;
import raytracer.World;

public class SingleColorMaterial extends Material {

    public final Color color;

    /**
     * Ein Material, welches unabhängig durch jegliche Beeinflussung durch Licht
     * und Blickwinkel den Farbwert zurückgibt.
     * @param color
     */
    public SingleColorMaterial(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Die dem SingleColorMaterial übergebene Color darf nicht null sein");
        }
        this.color = color;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, final Tracer tracer) {
        return this.color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return 89 * hash + Objects.hashCode(this.color);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SingleColorMaterial other = (SingleColorMaterial) obj;
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return "SingleColorMaterial{" +  color.toString() + '}';
    }

}
