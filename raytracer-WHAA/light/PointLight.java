package light;

import geometry.Hit;
import java.util.Objects;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Ray;
import raytracer.World;

/**
 * repräsentiert eine Punktlichtquelle, die gleichmäßig in alle Richtungen
 * strahlt.
 */
public class PointLight extends Light {

    public final Point3 position;

    public PointLight(final Color color, final Point3 position, final boolean castsShadows) {
        super(color, castsShadows);
        if (position == null) {
            throw new IllegalArgumentException("Der dem PointLight Punkt position darf nicht null sein");
        }
        this.position = position;
    }

    @Override
    public boolean illuminates(final Point3 point, final World world) {
        
        if (!castsShadows) {
            return true;
        }
        
        final Ray lightRay = new Ray(position, directionFrom(point).changeDirection());
        final Hit h = world.hit(lightRay, 0.000001);
        
        if (h == null) {
            return false;
        }
        
        final Point3 lightPoint = lightRay.at(h.t);
        final boolean checkForX = (point.x + 0.000001 > lightPoint.x && point.x - 0.000001 < lightPoint.x);
        final boolean checkForY = (point.y + 0.000001 > lightPoint.y && point.y - 0.000001 < lightPoint.y);
        final boolean checkForZ = (point.z + 0.000001 > lightPoint.z && point.z - 0.000001 < lightPoint.z);
        return checkForX && checkForY && checkForZ;
    }

    @Override
    public Vector3 directionFrom(final Point3 point) {
        return position.sub(point).normalized();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 97 * hash + Objects.hashCode(this.position);
        return hash;
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
        final PointLight other = (PointLight) obj;
        return Objects.equals(this.position, other.position);
    }

    @Override
    public String toString() {
        return "PointLight{" + super.toString() + "\n, position=" + position.toString() + "}\n";
    }

}
