package exercises;

import camera.PerspectiveCamera;
import geometry.AxisAlignedBox;
import geometry.Geometry;
import geometry.Plane;
import geometry.Sphere;
import geometry.Triangle;
import gui.ImageViewer;
import java.util.ArrayList;
import java.util.HashSet;
import light.DirectionLight;
import light.Light;
import light.PointLight;
import light.SpotLight;
import material.LambertMaterial;
import material.Material;
import material.PhongMaterial;
import material.SingleColorMaterial;
import math.Normal3;
import math.Point3;
import math.Vector3;
import raytracer.Color;
import raytracer.Raytracer;
import raytracer.World;

public class Exercise3 extends AExercise {

    private final HashSet<Geometry> geometriesSet = new HashSet<>();
    private final Color colorPlane = new Color(1.0, 0.0, 0.0);
    private final Color colorSphere = new Color(0.0, 1.0, 0.0);
    private final Color colorBox = new Color(0.0, 0.0, 1.0);
    private final Color colorTriangle = new Color(1.0, 1.0, 0.0);
    private final Color ambientLightColor = new Color(0.0, 0.0, 0.0);
    private final Color white = new Color(1.0, 1.0, 1.0);
    private Color backgroundColor;

    Material materialPlane;
    Material materialSphere;
    Material materialBox;
    Material materialTriangle;

    public Exercise3(ImageViewer imageViewer) {
        super(imageViewer);
    }

    @Override
    public void setScene1() {
        final DirectionLight light = new DirectionLight(new Color(1.0, 1.0, 1.0), new Vector3(0.0, 0.0, 0.0), false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new SingleColorMaterial(colorPlane);
        materialSphere = new SingleColorMaterial(colorSphere);
        materialBox = new SingleColorMaterial(colorBox);
        materialTriangle = new SingleColorMaterial(colorTriangle);
        setElements();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    @Override
    public void setScene2() {

        final PointLight light = new PointLight(new Color(1.0, 1.0, 1.0), new Point3(3.0, 3.0, 3.0), false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new LambertMaterial(colorPlane);
        materialSphere = new LambertMaterial(colorSphere);
        materialBox = new LambertMaterial(colorBox);
        materialTriangle = new LambertMaterial(colorTriangle);
        setElements();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    @Override
    public void setScene3() {
        final PointLight light = new PointLight(white, new Point3(3.0, 3.0, 3.0), false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new PhongMaterial(colorPlane, white, 64);
        materialSphere = new PhongMaterial(colorSphere, white, 64);
        materialBox = new PhongMaterial(colorBox, white, 64);
        materialTriangle = new PhongMaterial(colorTriangle, white, 64);
        setElements();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    @Override
    public void setScene4() {
        final DirectionLight light = new DirectionLight(white, new Vector3(-1.0, -1.0, -1.0), false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new PhongMaterial(colorPlane, white, 64);
        materialSphere = new PhongMaterial(colorSphere, white, 64);
        materialBox = new PhongMaterial(colorBox, white, 64);
        materialTriangle = new PhongMaterial(colorTriangle, white, 64);
        setElements();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    @Override
    public void setScene5() {

        final SpotLight light = new SpotLight(white, new Point3(4.0, 4.0, 4.0), new Vector3(-1.0, -1.0, -1.0), (Math.PI) / 14, false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new PhongMaterial(colorPlane, white, 64);
        materialSphere = new PhongMaterial(colorSphere, white, 64);
        materialBox = new PhongMaterial(colorBox, white, 64);
        materialTriangle = new PhongMaterial(colorTriangle, white, 64);
        setElements();
        lights.add(light);
        world = new World(lights, ambientLightColor, backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    @Override
    public void setScene6() {
        final SpotLight light = new SpotLight(white, new Point3(4.0, 4.0, 4.0), new Vector3(-1.0, -1.0, -1.0), (Math.PI) / 14, false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new PhongMaterial(colorPlane, white, 64);
        materialSphere = new PhongMaterial(colorSphere, white, 64);
        materialBox = new PhongMaterial(colorBox, white, 64);
        materialTriangle = new PhongMaterial(colorTriangle, white, 64);
        setElements();
        lights.add(light);
        world = new World(lights, new Color(0.25, 0.25, 0.25), backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();

    }

    @Override
    public void setScene7() {
        final PointLight light = new PointLight(white, new Point3(0.0, 1.0, 0.0), false);
        final ArrayList<Light> lights = new ArrayList<>();
        materialPlane = new PhongMaterial(colorPlane, white, 64);
        materialSphere = new PhongMaterial(colorSphere, white, 64);
        materialBox = new PhongMaterial(colorBox, white, 64);
        materialTriangle = new PhongMaterial(colorTriangle, white, 64);
        setElementsOwnScene();
        lights.add(light);
        world = new World(lights, new Color(0.25, 0.25, 0.25), backgroundColor, geometriesSet);
        raytracer = new Raytracer(world, camera, rayWidth, rayHeight);
        raytracer.SetRaster(imageViewer.getContent().getCanvas(),null);
        updateGui();
    }

    private void setElements() {

        final Plane plane = new Plane(new Point3(), new Normal3(0.0, 1.0, 0.0), materialPlane);
        final Sphere sphere = new Sphere(new Point3(1.0, 1.0, 1.0), 0.5, materialSphere);
        final AxisAlignedBox box = new AxisAlignedBox(new Point3(-1.5, 0.5, 0.5), new Point3(-0.5, 1.5, 1.5), materialBox);
        final Point3 a = new Point3(0.0, 0.0, -1.0);
        final Point3 b = new Point3(1.0, 0.0, -1.0);
        final Point3 c = new Point3(1.0, 1.0, -1.0);
        final Normal3 aNormal = new Normal3(0.0, 0.0, 1.0);
        final Normal3 bNormal = new Normal3(0.0, 0.0, 1.0);
        final Normal3 cNormal = new Normal3(0.0, 0.0, 1.0);
        final Triangle triangle = new Triangle(a, aNormal, b, bNormal, c, cNormal, materialTriangle);

        camera = new PerspectiveCamera(new Point3(4.0, 4.0, 4.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(sphere);
        geometriesSet.add(box);
        geometriesSet.add(triangle);
        backgroundColor = new Color(0.0, 0.0, 0.0);
    }

    private void setElementsOwnScene() {

        final Plane plane = new Plane(new Point3(), new Normal3(0.0, 1.0, 0.0), materialPlane);
        final Sphere sphere = new Sphere(new Point3(0.0, 1.0, 0.0), 0.5, materialSphere);

        final Point3 a = new Point3(0.0, 0.0, -1.0);
        final Point3 b = new Point3(10.0, 0.0, -1.0);
        final Point3 c = new Point3(10.0, 1.0, -1.0);
        final Normal3 aNormal = new Normal3(0.0, 0.0, 1.0);
        final Normal3 bNormal = new Normal3(0.0, 0.0, 1.0);
        final Normal3 cNormal = new Normal3(0.0, 0.0, 1.0);
        final Triangle triangle = new Triangle(a, aNormal, b, bNormal, c, cNormal, materialTriangle);

        camera = new PerspectiveCamera(new Point3(4.0, 4.0, 4.0), new Vector3(-1.0, -1.0, -1.0), new Vector3(0.0, 1.0, 0.0), (Math.PI) / 4);
        geometriesSet.clear();
        geometriesSet.add(plane);
        geometriesSet.add(sphere);
        geometriesSet.add(triangle);

        backgroundColor = new Color(0.0, 0.0, 0.0);
    }
}
