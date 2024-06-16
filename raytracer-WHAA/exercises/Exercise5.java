package exercises;

import camera.FisheyeCamera;
import camera.PerspectiveCamera;
import geometry.AxisAlignedBox;
import geometry.Geometry;
import geometry.Node;
import geometry.Plane;
import geometry.Sphere;
import gui.ImageViewer;
import java.util.ArrayList;
import java.util.HashSet;
import light.Light;
import light.PointLight;
import material.Material;
import material.ReflectiveMaterial;
import material.Tracer;
import math.Normal3;
import math.Point3;
import math.Transform;
import math.Vector3;
import raytracer.Color;
import raytracer.Raytracer;
import raytracer.World;

public class Exercise5 extends AExercise {

    private final HashSet<Geometry> geometriesSet = new HashSet<>();
    private final Color black = new Color();
    private final Color red = new Color(1.0, 0.0, 0.0);
    private final Color white = new Color(1.0, 1.0, 1.0);
    private final Color green = new Color(0.0, 1.0, 0.0);
    private final Color blue = new Color(0.0, 0.0, 1.0);
    private final Color yellow = new Color(0.8, 1.0, 0.1);
    private final Color reflection = new Color(0.5, 0.5, 0.5);

    public Exercise5(ImageViewer imageViewer) {
        super(imageViewer);
    }

    @Override
    public void setScene1() {

        final ArrayList<Light> lights = new ArrayList<>();
        final Color ambient = new Color(0.25, 0.25, 0.25);

        final Light pointLight = new PointLight(white, new Point3(8.0, 8.0, 0.0), false);

        lights.add(pointLight);

        Transform transform = new Transform();
        transform = transform.scale(new Vector3(4.0, 0.5, 2.0));

        ArrayList<Geometry> geometries = new ArrayList<>();
        final Material materialSphere = new ReflectiveMaterial(red, white, 64, reflection);
        geometries.add(new Sphere(materialSphere));

        final Node sphereNode = new Node(geometries, transform);

        geometriesSet.clear();
        geometriesSet.add(sphereNode);
       //geometriesSet.add(new Plane(new ReflectiveMaterial(black, white, 64, reflection)));

        camera = new PerspectiveCamera(new Point3(8.0, 8.0, 8.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), new Tracer(world, 30));
        updateGui();
    }

    @Override
    public void setScene2() {

        final ArrayList<Light> lights = new ArrayList<>();
        final Light pointLight = new PointLight(white, new Point3(8.0, 8.0, 0.0), false);
        lights.add(pointLight);

        Transform transform = new Transform();
        transform = transform.scale(new Vector3(4.0, 0.5, 10.0)).rotateZ(-Math.PI/4.0);
        
        ArrayList<Geometry> geometries = new ArrayList<>();
        final Material materialBox = new ReflectiveMaterial(yellow, white, 256, reflection);
        geometries.add(new AxisAlignedBox(materialBox));

        final Node boxNode = new Node(geometries, transform);

        geometriesSet.clear();
        geometriesSet.add(boxNode);
        //geometriesSet.add(new Plane(new ReflectiveMaterial(black, white, 64, reflection)));

        camera = new PerspectiveCamera(new Point3(8.0, 8.0, 8.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);

        final Color ambient = new Color(0.25, 0.25, 0.25);
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), null);
        updateGui();

    }

    @Override
    public void setScene3() {
        final ArrayList<Light> lights = new ArrayList<>();
        final Light pointLight = new PointLight(white, new Point3(1.0, 1.0, 1.0), true);
        lights.add(pointLight);
        
        final Color difuse = new Color(0.1, 0.1, 0.1);
        final Material materialPlane = new ReflectiveMaterial(difuse, black, 64, reflection);
        final Plane plane = new Plane(new Point3(), new Normal3(0.0, 1.0, 0.0), materialPlane);

        final Material materialSphere = new ReflectiveMaterial(red, white, 64, reflection);
        final Sphere sphere = new Sphere(new Point3(2.0, 1.0, 2.0), 1, materialSphere);

        final Material materialSphere2 = new ReflectiveMaterial(green, white, 64, reflection);
        final Sphere sphere2 = new Sphere(new Point3(-2.0, 1.0, 2.0), 1, materialSphere2);

        final Material materialSphere3 = new ReflectiveMaterial(blue, white, 64, reflection);
        final Sphere sphere3 = new Sphere(new Point3(2.0, 1.0, -2.0), 1, materialSphere3);
        
        final Material materialSphere4 = new ReflectiveMaterial(yellow, white, 64, reflection);
        final Sphere sphere4 = new Sphere(new Point3(-2.0, 1.0, -2.0), 1, materialSphere4);

        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(sphere);
        geometriesSet.add(sphere2);
        geometriesSet.add(sphere3);
        geometriesSet.add(sphere4);

        camera = new FisheyeCamera(new Point3(0.0, 1.0, 0.0), new Vector3(-1.0, 0.4, 0.2), new Vector3(0.0, 1.0, 0.0), 4 * Math.PI);

        final Color ambient = new Color(0.25, 0.25, 0.25);
        world = new World(lights, ambient, black, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(), null);
        updateGui();

    }

}
