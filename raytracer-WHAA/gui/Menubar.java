package gui;
import exercises.ExerciseAction;
import gui.ImageViewer.ImageExit;
import exercises.Exercise2;
import exercises.Exercise3;
import exercises.Exercise4;
import exercises.Exercise5;
import gui.dialog.NewRaytracerDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Diese Klasse erzeugt die Menubar für das MainFrame(ImageViewer)
 */
public class Menubar extends JMenuBar {

    private final JMenu file;
    /**
     * JMenu für die Aufgaben ohne Licht
     */
    private final JMenu raytracerWOL;
    /**
     * JMenu für die Aufgaben mit Licht
     */
    private final JMenu raytracerWL;
    /**
     * JMenu für die Aufgaben mit Schatten
     */
    private final JMenu raytracerWS;
    /**
     * JMenu für die Aufgaben mit Node
     */
    private final JMenu raytracerWN;
    private final Exercise2 exercise2;
    private final Exercise3 exersice3;
    private final Exercise4 exercise4;
    private final Exercise5 exercise5;

    public Menubar(ImageViewer imageViewer) {

        file = new JMenu("File");
        raytracerWOL = new JMenu("Exersice2");
        raytracerWL = new JMenu("Exersice3");
        raytracerWS = new JMenu("Exersice4");
        raytracerWN = new JMenu("Exersice5");
        
        exercise2 = new Exercise2(imageViewer);
        exersice3 = new Exercise3(imageViewer);
        exercise4 = new Exercise4(imageViewer);
        exercise5 = new Exercise5(imageViewer);

        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        file.add(new JMenuItem(new ImageOpener(imageViewer)));
        file.add(new JMenuItem(new NewRaytracerDialog(imageViewer).getDialogAction()));
        file.add(new JMenuItem(new ImageSaver(imageViewer)));
        file.add(new JMenuItem(new ImageExit()));

        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene1", exercise2, imageViewer)));
        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene2", exercise2, imageViewer)));
        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene3", exercise2, imageViewer)));
        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene4", exercise2, imageViewer)));
        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene5", exercise2, imageViewer)));
        raytracerWOL.add(new JMenuItem(new ExerciseAction("Scene6", exercise2, imageViewer)));

        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene1", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene2", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene3", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene4", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene5", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene6", exersice3, imageViewer)));
        raytracerWL.add(new JMenuItem(new ExerciseAction("Scene7", exersice3, imageViewer)));

        raytracerWS.add(new JMenuItem(new ExerciseAction("Scene1", exercise4, imageViewer)));
        raytracerWS.add(new JMenuItem(new ExerciseAction("Scene2", exercise4, imageViewer)));
        raytracerWS.add(new JMenuItem(new ExerciseAction("Scene3", exercise4, imageViewer)));
        
        raytracerWN.add(new JMenuItem(new ExerciseAction("Scene1", exercise5, imageViewer)));
        raytracerWN.add(new JMenuItem(new ExerciseAction("Scene2", exercise5, imageViewer)));
        raytracerWN.add(new JMenuItem(new ExerciseAction("Scene3", exercise5, imageViewer)));

        add(file);
        add(raytracerWOL);
        add(raytracerWL);
        add(raytracerWS);
        add(raytracerWN);
    }
}
