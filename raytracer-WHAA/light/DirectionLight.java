package light;

import java.util.Objects;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Ray;
import raytracer.World;

/**
 * repräsentiert das Sonnenlicht, welches überall in der Szene aus der gleichen
 * Richtung kommt.
 */
public class DirectionLight extends Light {

    public final Vector3 direction;

    public DirectionLight(final Color color, final Vector3 direction, final boolean castsShadows) {
        super(color, castsShadows);
        if (direction == null) {
            throw new IllegalArgumentException("Der dem DirectionalLight übergebene Vektor direction darf nicht null sein");
        }
        this.direction = direction;
    }

    @Override
    public boolean illuminates(final Point3 point, final World world) {
        if (!castsShadows) {
            return true;
        }
        return (world.hit(new Ray(point, directionFrom(point)),0.000001)) == null;
    }
    
    @Override
    public Vector3 directionFrom(final Point3 point) {
        return direction.changeDirection().normalized();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return 79 * hash + Objects.hashCode(this.direction);
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
        final DirectionLight other = (DirectionLight) obj;
        return Objects.equals(this.direction, other.direction);
    }

    @Override
    public String toString() {
        return "DirectionLight{" + super.toString() + "\n, direction=" + direction.toString() + "}\n";
    }
    
    
    
}
