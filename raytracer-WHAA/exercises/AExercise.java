package exercises;

import camera.Camera;
import gui.ImageViewer;
import raytracer.Raytracer;
import raytracer.World;

public abstract class AExercise {

    protected final int rayWidth = 640;
    protected final int rayHeight = 480;
    protected Raytracer raytracer;
    protected World world;
    protected Camera camera;
    protected ImageViewer imageViewer;

    public AExercise(final ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
    } 

    public void setScene(String name) {

        if (name.equals("Scene1")) {
            setScene1();
        }
        if (name.equals("Scene2")) {
            setScene2();
        }
        if (name.equals("Scene3")) {
            setScene3();
        }
        if (name.equals("Scene4")) {
            setScene4();
        }
        if (name.equals("Scene5")) {
            setScene5();
        }
        if (name.equals("Scene6")) {
            setScene6();
        }
        if (name.equals("Scene7")) {
            setScene7();
        }
    }

    public void setScene1() {
    }

    public void setScene2() {
    }

    public void setScene3() {
    }

    public void setScene4() {
    }

    public void setScene5() {
    }

    public void setScene6() {
    }

    public void setScene7() {
    }

    public void setScene8() {
    }

    protected void updateGui() {

        imageViewer.getFrame().pack();
        System.out.println("\n" + raytracer.toString() + "\n");

    }
}
