package material;

import geometry.Hit;
import java.util.Objects;
import raytracer.Color;
import raytracer.Ray;
import raytracer.World;

public class Tracer {

    final public World world;
    public int reflection;

    public Tracer(final World world, final int reflection) {
        if (world == null) {
            throw new IllegalArgumentException("Die dem Tracer übergebene Welt darf nicht null sein");
        }
        this.world = world;
        this.reflection = reflection;
    }

    /**
     * @param ray
     * @return Color
     */
    public Color getColor(final Ray ray) {
        if (ray == null) {
            throw new IllegalArgumentException("Der übergebene Ray darf nicht null sein");
        }
        final Hit h = world.hit(ray, 0.00001);
        if (h == null) {
            return new Color();
        } else {
            reflection--;
            if (reflection >= 0) {
                return h.geo.material.colorFor(h, world, this);
            }
            else{
                return new Color();
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.world);
        return 71 * hash + this.reflection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tracer other = (Tracer) obj;
        if (!Objects.equals(this.world, other.world)) {
            return false;
        }
        return this.reflection == other.reflection;
    }


    

    @Override
    public String toString() {
        return "Tracer{" + "world=" + world + ", reflection=" + reflection + '}';
    }

}
