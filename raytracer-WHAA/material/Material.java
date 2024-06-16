package material;

import geometry.Hit;
import raytracer.Color;
import raytracer.World;

public abstract class Material {
    
    public abstract Color colorFor(final Hit hit, final World world, final Tracer tracer);

    
}
