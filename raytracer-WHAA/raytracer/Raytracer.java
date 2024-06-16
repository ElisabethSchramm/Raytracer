package raytracer;

import camera.Camera;
import gui.ViewCanvas;
import java.awt.image.BufferedImage;
import java.util.Objects;
import material.Tracer;

public class Raytracer {

    public final World world;
    public final Camera camera;
    public final int w;
    public final int h;

    public final Color[][] colors;
    public final BufferedImage bufferedImage;

    public Raytracer(final World world, final Camera camera, final int w, final int h) {
        if (world == null) {
            throw new IllegalArgumentException("Die dem Raytracer übergebene World darf nicht null sein");
        }
        if (camera == null) {
            throw new IllegalArgumentException("Die dem Raytracer übergebene Camera darf nicht null sein");
        }
        this.world = world;
        this.camera = camera;
        this.w = w;
        this.h = h;
        
        this.colors = new Color[this.h][this.w];
        this.bufferedImage = new BufferedImage(this.w, this.h, BufferedImage.TYPE_INT_ARGB);

    }

    public void SetRaster(final ViewCanvas canvas,final Tracer tracer) {

        final ProgressThread progressThread = new ProgressThread(canvas, this);
        progressThread.setName("ProgressThread");
        progressThread.start();

        final int processors = Runtime.getRuntime().availableProcessors();
        final int part = h / processors;
        
        int start = 0;
        int end = part;

        final RaytracerWorker[] worker = new RaytracerWorker[processors];
        for (int i = 0; i < worker.length; i++) {
            worker[i] = new RaytracerWorker(this, progressThread, tracer, start, end);
            worker[i].setName("RaytracerWorker" + i);
            worker[i].start();
            start = start + part;
            end = end + part;
        }
    }

    public BufferedImage generateImage(final Color[][] colors) {
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                if (colors[j][i] != null) {
                    bufferedImage.setRGB(i, bufferedImage.getHeight() - j - 1, colors[j][i].getRGB());
                }
            }
        }
        return bufferedImage;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.world);
        hash = 13 * hash + Objects.hashCode(this.camera);
        hash = 13 * hash + this.w;
        return 13 * hash + this.h;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Raytracer other = (Raytracer) obj;
        if (!Objects.equals(this.world, other.world)) {
            return false;
        }
        if (!Objects.equals(this.camera, other.camera)) {
            return false;
        }
        if (this.w != other.w) {
            return false;
        }
        return this.h == other.h;
    }

   
    

    @Override
    public String toString() {
        return "Raytracer{\n" + world.toString()
                + "\n\n" + camera.toString()
                + "\n\nimagewidth: " + w + ", imageheight: " + h + "\n}";
    }
}
