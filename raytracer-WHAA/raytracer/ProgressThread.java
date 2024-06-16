package raytracer;

import static exercises.ExerciseAction.progressbar;
import gui.ViewCanvas;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressThread extends Thread {

    private final ViewCanvas canvas;
    private final Raytracer raytracer;
    
    private final int max = progressbar.getMaximum();
    private volatile int progress = 0;

    private long startTime;

    

    public ProgressThread(final ViewCanvas canvas, final Raytracer raytracer) {
        this.canvas = canvas;
        this.raytracer = raytracer;
    }


    public synchronized void increment() {
        progress++;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (progress < max) {
            calculateStuff();
        }
        calculateStuff();
    }

    private void calculateStuff() {
        double progressDone = ((double) progress / max);
        long currentTime = System.currentTimeMillis();
        long goneMillis = currentTime - startTime;
        long totalMillis = Math.round((double) goneMillis / progressDone);
        progressbar.setValue(progress);
        progressbar.setString(Math.round(progressDone * 100)
                + "% [" + goneMillis + "ms/" + totalMillis + "ms]");

        canvas.setImage(raytracer.generateImage(raytracer.colors));

        // die anderen Threads ihre arbeit machen lassen.
        try {
            sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressThread.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.canvas);
        hash = 73 * hash + Objects.hashCode(this.raytracer);
        return 73 * hash + this.max;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProgressThread other = (ProgressThread) obj;
        if (!Objects.equals(this.canvas, other.canvas)) {
            return false;
        }
        if (!Objects.equals(this.raytracer, other.raytracer)) {
            return false;
        }
        return this.max == other.max;
    }

    @Override
    public String toString() {
        return "ProgressThread{" + "canvas=" + canvas + ", raytracer=" + raytracer + ", max=" + max + ", progress=" + progress + ", startTime=" + startTime + '}';
    }
   
}