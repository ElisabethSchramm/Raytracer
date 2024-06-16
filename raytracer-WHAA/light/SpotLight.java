package light;

import geometry.Hit;
import java.util.Objects;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Ray;
import raytracer.World;

/**
 * Lichtquelle die von einem bestimmten Punkt aus in eine gegebene Richtung
 * innerhalb eines festgelegten Winkels abstrahlt
 */
public class SpotLight extends Light {

    public final Point3 position;
    public final Vector3 direction;
    public final double halfAngle;

    public SpotLight(final Color color, final Point3 position, final Vector3 direction, final double halfAngle, final boolean castsShadows) {
        super(color, castsShadows);
        if (position == null) {
            throw new IllegalArgumentException("Der dem SpotLight übergebene Punkt postion darf nicht null sein");
        }
        if (direction == null) {
            throw new IllegalArgumentException("Der dem SpotLight übergebene Vector direction darf nicht null sein");
        }
        this.position = position;
        this.direction = direction;
        this.halfAngle = halfAngle;
    }

    @Override
    public boolean illuminates(final Point3 point, final World world) {
        if (!castsShadows) {
            return true;
        }
        final Vector3 directionFromPoint = directionFrom(point);
        final double angle = direction.dot(directionFromPoint) / (direction.magnitude * directionFromPoint.magnitude);
        if (Math.acos(angle) >= halfAngle) {
            return false;
        }
        final Hit h = world.hit(new Ray(point, directionFromPoint), 0.000001);
        final double t = directionFromPoint.magnitude / 1;
        return !(h != null && h.t < t);
    }

    @Override
    public Vector3 directionFrom(final Point3 point) {
        return position.sub(point).normalized();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 11 * hash + Objects.hashCode(this.position);
        hash = 11 * hash + Objects.hashCode(this.direction);
        return 11 * hash + (int) (Double.doubleToLongBits(this.halfAngle) ^ 
                (Double.doubleToLongBits(this.halfAngle) >>> 32));
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
        final SpotLight other = (SpotLight) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.direction, other.direction)) {
            return false;
        }
        return Double.doubleToLongBits(this.halfAngle) == Double.doubleToLongBits(other.halfAngle);
    }

    @Override
    public String toString() {
        return "SpotLight{" + super.toString() + "\n, position=" + position.toString()
                + ", direction=" + direction.toString()
                + ", halfAngle=" + halfAngle + "}\n";
    }
}
