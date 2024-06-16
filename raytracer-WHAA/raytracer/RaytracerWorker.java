package raytracer;

import material.Tracer;
import geometry.Hit;
import java.util.Objects;

public class RaytracerWorker extends Thread {

    private final Raytracer raytracer;
    private final ProgressThread progressThread;
    private final Tracer tracer;
    private final int start;
    private final int end;

    public RaytracerWorker(final Raytracer raytracer, final ProgressThread progressThread, final Tracer tracer, final int start, final int end) {
        this.raytracer = raytracer;
        this.progressThread = progressThread;
        if (tracer != null) {
            this.tracer = tracer;
        } else {
            this.tracer = new Tracer(raytracer.world, 0);
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int x = start; x < end; x++) {
            for (int y = 0; y < raytracer.w; y++) {
                Ray camRay = raytracer.camera.rayFor(raytracer.w, raytracer.h, y, x);
                if (camRay == null) {
                    raytracer.colors[x][y] = new Color();
                } else {
                    if (raytracer.world.hit(camRay, 0.0) == null) {
                        raytracer.colors[x][y] = raytracer.world.backgroundColor;
                    } else {
                        
                        Hit hit = raytracer.world.hit(camRay, 0.0);
                        raytracer.colors[x][y] = hit.geo.material.colorFor(hit, raytracer.world, new Tracer(tracer.world, tracer.reflection));
                    }
                }
                progressThread.increment();
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.raytracer);
        hash = 17 * hash + Objects.hashCode(this.progressThread);
        hash = 17 * hash + Objects.hashCode(this.tracer);
        hash = 17 * hash + this.start;
        return 17 * hash + this.end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RaytracerWorker other = (RaytracerWorker) obj;
        if (!Objects.equals(this.raytracer, other.raytracer)) {
            return false;
        }
        if (!Objects.equals(this.progressThread, other.progressThread)) {
            return false;
        }
        if (!Objects.equals(this.tracer, other.tracer)) {
            return false;
        }
        if (this.start != other.start) {
            return false;
        }
        return this.end == other.end;
    }

    @Override
    public String toString() {
        return "RaytracerWorker{" + "raytracer=" + raytracer + ", progressThread=" + progressThread + ", tracer=" + tracer + ", start=" + start + ", end=" + end + '}';
    }
}
