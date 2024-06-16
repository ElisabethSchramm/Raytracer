package geometry;

import java.util.Objects;
import material.Material;
import raytracer.Ray;

/**
 *
 * @author Elli
 */
public abstract class Geometry {

    /**
     * Material der Geometry
     */
    public final Material material;

    /**
     *
     * @param material
     */
    public Geometry(final Material material) {
        this.material = material;
    }

    /**
     * Schnittberechnung. Eine Implementierung gibt bei mehreren Schnittpunkten
     * immer den mit dem kleinsten positiven t zurück. Wird kein Schnittpunkt
     * gefunden, wird null zurückgegeben. Ein Schnittpunkt wird mit einem Objekt
     * der Klasse Hit ausgedrückt.
     *
     * @param r
     * @return
     */
    public abstract Hit hit(Ray r);

    @Override
    public int hashCode() {
        int hash = 3;
        return 43 * hash + Objects.hashCode(this.material);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Geometry other = (Geometry) obj;
        return Objects.equals(this.material, other.material);
    }

    @Override
    public String toString() {
        return "Geometry{" + "material=" + material.toString();
    }
}
