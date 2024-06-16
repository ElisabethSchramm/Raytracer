/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

import material.Material;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Ray;

/**
 *
 * @author User
 */
public class Cylinder extends Geometry {

    public Cylinder(Material material) {
        super(material);
    }

    @Override
    public Hit hit(Ray ray) {
        if (ray == null) {
            throw new NullPointerException("Der übergebene Ray ist null");
        }
        Point3 hitPoi;
        Point3 hitPoi1;
        Point3 hitPoi2;
        Hit hit;
        Point3 co = new Point3();
        Ray r = new Ray(new Point3(ray.o.x, 0.0, ray.o.z), new Vector3(ray.d.x, 0.0, ray.d.z));
        final double a = r.d.dot(r.d);
        if (a == 0) {
            return null;
        }
        double b = r.d.dot((r.o.sub(co)).mul(2.0));
        double c = (r.o.sub(co)).dot(r.o.sub(co)) - 1;
        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            return null;
        } else if (d == 0) {
            final double t = (-b) / (2 * a);
            if (t >= 0) {
                hitPoi = ray.at(t);
                hit = new Hit(t, ray, new Normal3(hitPoi.x, 0.0, hitPoi.z), this);
            } else {
                return null;
            }
        } else {
            final double sqrt = Math.sqrt(d);
            final Double t1 = ((-b) + sqrt) / (2.0 * a);
            final Double t2 = ((-b) - sqrt) / (2.0 * a);
            hitPoi1 = ray.at(t1);
            hitPoi2 = ray.at(t2);

            if (t2 >= 0 && (hitPoi2.y >= -0.5 && hitPoi2.y <= 0.5)) {
                hit = new Hit(t2, ray, new Normal3(hitPoi2.x, 0.0, hitPoi2.z), this);
            } else {
                if (t1 >= 0 && (hitPoi1.y >= -0.5 && hitPoi1.y <= 0.5)) {
                    hit = new Hit(t1, ray, new Normal3(hitPoi1.x, 0.0, hitPoi1.z), this);
                } else {
                    return null;
                }
            }
        }
        return hit;
    }
}
