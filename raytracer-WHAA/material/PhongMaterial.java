package material;

import geometry.Hit;
import java.util.Objects;
import light.Light;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.World;

public class PhongMaterial extends Material {

    public final Color difuse;
    public final Color spectacular;
    public final int exponent;

    public PhongMaterial(final Color difuse, final Color spectacular,final int exponent) {
        if (difuse == null) {
            throw new IllegalArgumentException("Die dem PhongMaterial übergebene Color difuse darf nicht null sein");
        }
        if (spectacular == null) {
            throw new IllegalArgumentException("Die dem PhongMaterial übergebene Color spectacular darf nicht null sein");
        }
        this.difuse = difuse;
        this.spectacular = spectacular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world, Tracer tracer) {

        Color withLightsColor = difuse.mul(world.ambientLightColor);
        final Point3 point = hit.ray.at(hit.t);
        final Normal3 n = hit.normal;
        final Vector3 e = hit.ray.d.changeDirection().normalized();

        for (Light light : world.lights) {
            if (light.illuminates(point,world)) {
                final Vector3 l = light.directionFrom(point);
                final Vector3 rl = l.reflectedOn(n);
                final double alpha = l.dot(n);
                final double betha = e.dot(rl);
                withLightsColor = withLightsColor.add(difuse.mul(light.color).mul(Double.max(0.0, alpha)));
                withLightsColor = withLightsColor.add(spectacular.mul(light.color).mul(Math.pow(Double.max(0.0, betha), exponent)));
            }
        }
        return withLightsColor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.difuse);
        hash = 37 * hash + Objects.hashCode(this.spectacular);
        return 37 * hash + this.exponent;
            }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhongMaterial other = (PhongMaterial) obj;
        if (!Objects.equals(this.difuse, other.difuse)) {
            return false;
        }
        if (!Objects.equals(this.spectacular, other.spectacular)) {
            return false;
        }
        return this.exponent == other.exponent;
    }

    @Override
    public String toString() {
        return "PhongMaterial{" + "difuse=" + difuse + ", spectacular=" + spectacular + ", exponent=" + exponent + '}';
    }
}
