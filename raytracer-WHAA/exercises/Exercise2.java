package exercises;

import camera.OrthographicCamera;
import camera.PerspectiveCamera;
import geometry.AxisAlignedBox;
import geometry.Geometry;
import geometry.Node;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import gui.ImageViewer;
import java.util.ArrayList;
import java.util.HashSet;
import light.DirectionLight;
import light.Light;
import material.SingleColorMaterial;
import math.Normal3;
import math.Point3;
import math.Transform;
import math.Vector3;
import raytracer.Color;
import raytracer.Raytracer;
import raytracer.World;

public class Exercise2 extends AExercise {
 

    private final Light light = new DirectionLight(new Color(1.0, 1.0, 1.0), new Vector3(0.0, 0.0, 0.0), false);
    private final ArrayList<Light> lights = new ArrayList<>();
    private final Color ambientLightColor = new Color(1.0, 0.0, 0.0);
    private final HashSet<Geometry> geometriesSet = new HashSet<>();
    private Color backgroundColor;

    public Exercise2(ImageViewer imageViewer) {
        super(imageViewer);
    }

    @Override
    public void setScene1() {
        
        final SingleColorMaterial material = new SingleColorMaterial(new Color(0.0, 1.0, 0.0));
//        final Plane plane = new Plane(new Point3(0.0, -1.0, 0.0), new Normal3(0.0, 1.0, 0.0), material);
        
        Transform transform = new Transform();
        transform = transform.translate(new Vector3(0.0, -0.1, 0.0));
        ArrayList<Geometry> geometries = new ArrayList<>();
        geometries.add(new Plane(material));
        
        final Node planeNode = new Node(geometries, transform);

        geometriesSet.clear();
        geometriesSet.add(planeNode);
        //geometriesSet.add(plane);
        
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        camera = new PerspectiveCamera(new Point3(0.0, 0.0, 0.0), new Vector3(0.0, 0.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
//        ImageSizeModel imageSizeModel = new ImageSizeModel();
//        PerspectiveCameraModel model = new PerspectiveCameraModel();
//        model.setE(new Point3Model());
//        model.setG(new Vector3Model(0.0, 0.0,-1.0));
//        model.setG(new Vector3Model(0.0, 1.0, 0.0));
//        model.setAngle((Math.PI) / 4);
        
    }

    @Override
    public void setScene2() {
        final SingleColorMaterial material = new SingleColorMaterial(new Color(1.0, 0.0, 0.0));
        final Sphere sphere = new Sphere(new Point3(0.0, 0.0, -3.0), 0.5, material);
        
        Transform transform = new Transform();
        transform = transform.scale(new Vector3(0.5,0.5,0.5));
        transform = transform.translate(new Vector3(0.0, 0.0, -3.0));
        
        ArrayList<Geometry> geometries = new ArrayList<>();
        geometries.add(new Sphere(material));
        
        final Node sphereNode = new Node(geometries, transform);
        
        
        geometriesSet.clear();
        geometriesSet.add(sphereNode); 
        //geometriesSet.add(sphere);
        
        camera = new PerspectiveCamera(new Point3(), new Vector3(0.0, 0.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();

    }

    @Override
    public void setScene3() {
        final SingleColorMaterial material = new SingleColorMaterial(new Color(0.0, 0.0, 1.0));
        final AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5, 0.0, -0.5), new Point3(0.5, 1.0, 0.5), material);
        camera = new PerspectiveCamera(new Point3(3.0, 3.0, 3.0), new Vector3(-3.0, -3.0, -3.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        geometriesSet.clear();
        geometriesSet.add(box);
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();

    }

    @Override
    public void setScene4() {
        final SingleColorMaterial material = new SingleColorMaterial(new Color(1.0, 0.0, 1.0));
        final Point3 a = new Point3(-0.5, 0.5, -3.0);
        final Point3 b = new Point3(0.5, 0.5, -3.0);
        final Point3 c = new Point3(0.5, -0.5, -3.0);
        final Normal3 aNormal = new Normal3();
        final Normal3 bNormal = new Normal3();
        final Normal3 cNormal = new Normal3();
        final Triangle triangle = new Triangle(a, aNormal, b, bNormal, c, cNormal, material);
        camera = new PerspectiveCamera(new Point3(), new Vector3(0.0, 0.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        geometriesSet.clear();
        geometriesSet.add(triangle);
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();

    }

    @Override
    public void setScene5() {
        final SingleColorMaterial material = new SingleColorMaterial(new Color(1.0, 0.0, 0.0));
        final Sphere sphere = new Sphere(new Point3(-1.0, 0.0, -3.0), 0.5, material);
        final Sphere sphere2 = new Sphere(new Point3(1.0, 0.0, -6.0), 0.5, material);
        camera = new PerspectiveCamera(new Point3(), new Vector3(0.0, 0.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        geometriesSet.clear();
        geometriesSet.add(sphere);
        geometriesSet.add(sphere2);
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();

    }

    @Override
    public void setScene6() {
        final SingleColorMaterial material = new SingleColorMaterial(new Color(1.0, 0.0, 0.0));
        final Sphere sphere = new Sphere(new Point3(-1.0, 0.0, -3.0), 0.5, material);
        final Sphere sphere2 = new Sphere(new Point3(1.0, 0.0, -6.0), 0.5, material);
        camera = new OrthographicCamera(new Point3(), new Vector3(0.0, 0.0, -1.0), new Vector3(0.0, 1.0, 0.0), 3);
        geometriesSet.clear();
        geometriesSet.add(sphere);
        geometriesSet.add(sphere2);
        backgroundColor = new Color();
        lights.clear();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }
}
