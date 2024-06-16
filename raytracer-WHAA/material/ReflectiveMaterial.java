package material;

import geometry.Hit;
import java.util.Objects;
import light.Light;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Ray;
import raytracer.World;

public class ReflectiveMaterial extends Material {

    public final Color difuse;
    public final Color spectacular;
    public final int exponent;
    public final Color reflection;

    public ReflectiveMaterial(final Color difuse, final Color spectacular, final int exponent, final Color reflection) {
        if (difuse == null) {
            throw new IllegalArgumentException("Die dem ReflectiveMaterial übergebene Color difuse darf nicht null sein");
        }
        if (spectacular == null) {
            throw new IllegalArgumentException("Die dem ReflectiveMaterial übergebene Color spectacular darf nicht null sein");
        }
        if (reflection == null) {
            throw new IllegalArgumentException("Die dem ReflectiveMaterial übergebene Color reflection darf nicht null sein");
        }
        this.difuse = difuse;
        this.spectacular = spectacular;
        this.exponent = exponent;
        this.reflection = reflection;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, final Tracer tracer) {
        Color withLightsColor = difuse.mul(world.ambientLightColor);
        final Point3 point = hit.ray.at(hit.t);
        final Normal3 n = hit.normal;
        final Vector3 e = hit.ray.d.changeDirection().normalized();

        for (Light light : world.lights) {
            if (light.illuminates(point, world)) {
                final Vector3 l = light.directionFrom(point);
                final Vector3 rl = l.reflectedOn(n);
                final double alpha = l.dot(n);
                final double betha = e.dot(rl);
                withLightsColor = withLightsColor.add(difuse.mul(light.color).mul(Double.max(0.0, alpha)));
                withLightsColor = withLightsColor.add(spectacular.mul(light.color).mul(Math.pow(Double.max(0.0, betha), exponent)));
                final Ray ray = new Ray(hit.ray.at(hit.t - 0.000000001), hit.ray.d.reflectedOn(n).changeDirection());
                withLightsColor = withLightsColor.add(reflection.mul(tracer.getColor(ray)));
            }
        }
        return withLightsColor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.difuse);
        hash = 97 * hash + Objects.hashCode(this.spectacular);
        hash = 97 * hash + this.exponent;
        return  97 * hash + Objects.hashCode(this.reflection);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReflectiveMaterial other = (ReflectiveMaterial) obj;
        if (!Objects.equals(this.difuse, other.difuse)) {
            return false;
        }
        if (!Objects.equals(this.spectacular, other.spectacular)) {
            return false;
        }
        if (this.exponent != other.exponent) {
            return false;
        }
        return Objects.equals(this.reflection, other.reflection);
    }

    @Override
    public String toString() {
        return "ReflectiveMaterial{" + "difuse=" + difuse + ", spectacular=" + spectacular + ", exponent=" + exponent + ", reflection=" + reflection + '}';
    }

    
}
