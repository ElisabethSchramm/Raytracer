package exercises;

import camera.PerspectiveCamera;
import geometry.AxisAlignedBox;
import geometry.Cylinder;
import geometry.Disc;
import geometry.Geometry;
import geometry.Plane;
import geometry.Rectangle;
import geometry.Sphere;
import gui.ImageViewer;
import java.util.ArrayList;
import java.util.HashSet;
import light.Light;
import light.PointLight;
import material.LambertMaterial;
import material.Material;
import material.ReflectiveMaterial;
import material.Tracer;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Raytracer;
import raytracer.World;

public class Exercise4 extends AExercise {

    private final HashSet<Geometry> geometriesSet = new HashSet<>();
    private final Color black = new Color();
    private final Color red = new Color(1.0, 0.0, 0.0);
    private final Color white = new Color(1.0, 1.0, 1.0);
    private final Color green = new Color(0.0, 1.0, 0.0);
    private final Color blue = new Color(0.0, 0.0, 1.0);
    private final Color reflection = new Color(0.5, 0.5, 0.5);

    public Exercise4(ImageViewer imageViewer) {
        super(imageViewer);
    }

    @Override
    public void setScene1() {

        final Color difuse = new Color(0.1, 0.1, 0.1);
        final Material materialPlane = new ReflectiveMaterial(difuse, black, 64, reflection);
        final Plane plane = new Plane(new Point3(), new Normal3(0.0, 1.0, 0.0), materialPlane);

        final Material materialSphere = new ReflectiveMaterial(red, white, 64, reflection);
        final Sphere sphere = new Sphere(new Point3(-3.0, 1.0, 0.0), 1, materialSphere);

        final Material materialSphere2 = new ReflectiveMaterial(green, white, 64, reflection);
        final Sphere sphere2 = new Sphere(new Point3(0.0, 1.0, 0.0), 1, materialSphere2);

        final Material materialSphere3 = new ReflectiveMaterial(blue, white, 64, reflection);
        final Sphere sphere3 = new Sphere(new Point3(3.0, 1.0, 0.0), 1, materialSphere3);

        final ArrayList<Light> lights = new ArrayList<>();
        final Color ambient = new Color(0.25, 0.25, 0.25);

        final Light pointLight = new PointLight(white, new Point3(8.0, 8.0, 8.0), false);

        lights.add(pointLight);

        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(sphere);
        geometriesSet.add(sphere2);
        geometriesSet.add(sphere3);

        camera = new PerspectiveCamera(new Point3(8.0, 8.0, 8.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), new Tracer(world, 30));
        updateGui();
    }

    @Override
    public void setScene2() {

        final Color difuse = new Color(0.8, 0.8, 0.8);
        final Material materialPlane = new LambertMaterial(difuse);
        final Plane plane = new Plane(new Point3(), new Normal3(0.0, 1.0, 0.0), materialPlane);

        final Material materialBox = new LambertMaterial(red);//?
        final AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5, 0.0, -0.5), new Point3(0.5, 1.0, 0.5), materialBox);

        final ArrayList<Light> lights = new ArrayList<>();
        final Light pointLight = new PointLight(white, new Point3(8.0, 8.0, 0.0), true);
        lights.add(pointLight);

        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(box);

        camera = new PerspectiveCamera(new Point3(8.0, 8.0, 8.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);

        final Color ambient = new Color(0.25, 0.25, 0.25);//?
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), null);
        updateGui();

    }

    @Override
    public void setScene3() {
        final Color difuse = new Color(0.8, 0.8, 0.8);
        final Material materialPlane = new LambertMaterial(difuse);
        final Plane plane = new Plane(new Point3(0.0, -1.0, 0.0), new Normal3(0.0, 1.0, 0.0), materialPlane);

        final Material materialBox = new LambertMaterial(red);//?
        final Cylinder box = new Cylinder(materialBox);

        final Material materialRect = new LambertMaterial(blue);//?
        final Rectangle rect = new Rectangle(3.0, 5.0, materialRect);

        final Material materialDisc = new LambertMaterial(green);//?
        final Disc disc = new Disc(new Point3(0.0, 2.0, 0.0), new Normal3(0.0, 1.0, 0.0), 1.0, materialDisc);

        final ArrayList<Light> lights = new ArrayList<>();
        final Light pointLight = new PointLight(white, new Point3(8.0, 8.0, 8.0), true);
        lights.add(pointLight);

        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(box);
        geometriesSet.add(rect);
        geometriesSet.add(disc);

        camera = new PerspectiveCamera(new Point3(8.0, 8.0, 8.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);

        final Color ambient = new Color(0.25, 0.25, 0.25);//?
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), null);
        updateGui();
    }

}
