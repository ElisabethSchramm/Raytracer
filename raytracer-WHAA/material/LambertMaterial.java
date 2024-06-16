package material;

import geometry.Hit;
import java.util.Objects;
import light.Light;
import math.Point3;
import raytracer.Color;
import raytracer.World;

public class LambertMaterial extends Material {

    public final Color color;

    public LambertMaterial(final Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Die dem LambertMaterial übergebene Color darf nicht null sein");
        }
        this.color = color;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {

        Color withLightsColor = color.mul(world.ambientLightColor);
        Point3 point = hit.ray.at(hit.t);
        for (Light light : world.lights) {
            if (light.illuminates(point, world)) {
                double intensive = Double.max(0.0, hit.normal.dot(light.directionFrom(point)));
                Color tmpColor = color.mul(light.color).mul(intensive);
                withLightsColor = withLightsColor.add(tmpColor);
            }
        }
        return withLightsColor;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return 73 * hash + Objects.hashCode(this.color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LambertMaterial other = (LambertMaterial) obj;
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        return "LambertMaterial{" + "color=" + color + '}';
    }
}
