package math;

import java.util.Objects;
import raytracer.Ray;

/**
 *
 * @author Arnold
 */
public class Transform {

    /**
     * Transformationsmatrix
     */
    public final Mat4x4 m;

    /**
     * Inverse von m
     */
    public final Mat4x4 i;

    /**
     * Dieser KOnstrukter erstellt eine Einheitsmatrix
     */
    public Transform() {
        this.m = new Mat4x4(1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0);
        this.i = new Mat4x4(1.0, 0.0, 0.0, 0.0,
                0.0, 1.0, 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0);
    }

    private Transform(final Mat4x4 m, final Mat4x4 i) {
        this.m = m;
        this.i = i;
    }

    /**
     * Translation um Vector vec
     *
     * @param vec
     * @return
     */
    public Transform translate(final Vector3 vec) {
        final Mat4x4 transMat = new Mat4x4(
                1.0, 0.0, 0.0, vec.x,
                0.0, 1.0, 0.0, vec.y,
                0.0, 0.0, 1.0, vec.z,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 transM = this.m.mul(transMat);
        final Mat4x4 transMatI = new Mat4x4(
                1.0, 0.0, 0.0, -vec.x,
                0.0, 1.0, 0.0, -vec.y,
                0.0, 0.0, 1.0, -vec.z,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 transI = this.i.mul(transMatI);
        return new Transform(transM, transI);
    }

    /**
     * Skalierung um Vektor vec
     *
     * @param vec
     * @return
     */
    public Transform scale(final Vector3 vec) {
        final Mat4x4 scaleMat = new Mat4x4(
                vec.x, 0.0, 0.0, 0.0,
                0.0, vec.y, 0.0, 0.0,
                0.0, 0.0, vec.z, 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 scaleM = this.m.mul(scaleMat);
        final Mat4x4 scaleMatI = new Mat4x4(
                1.0 / vec.x, 0.0, 0.0, 0.0,
                0.0, 1.0 / vec.y, 0.0, 0.0,
                0.0, 0.0, 1.0 / vec.z, 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 scaleI = this.i.mul(scaleMatI);
        return new Transform(scaleM, scaleI);
    }

    /**
     * Rotation um X-Achse
     *
     * @param angle
     * @return
     */
    public Transform rotateX(final double angle) {
        final Mat4x4 rotMat = new Mat4x4(
                1.0, 0.0, 0.0, 0.0,
                0.0, Math.cos(angle), -Math.sin(angle), 0.0,
                0.0, Math.sin(angle), Math.cos(angle), 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 rotM = m.mul(rotMat);
        final Mat4x4 rotMatI = new Mat4x4(
                1.0, 0.0, 0.0, 0.0,
                0.0, Math.cos(angle), Math.sin(angle), 0.0,
                0.0, -Math.sin(angle), Math.cos(angle), 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 rotI = i.mul(rotMatI);
        return new Transform(rotM, rotI);
    }

    /**
     * Rotation um Y-Achse
     *
     * @param angle
     * @return
     */
    public Transform rotateY(final double angle) {
        Mat4x4 rotMat = new Mat4x4(
                Math.cos(angle), 0.0, Math.sin(angle), 0.0,
                0.0, 1.0, 0.0, 0.0,
                -Math.sin(angle), 0.0, Math.cos(angle), 0.0,
                0.0, 0.0, 0.0, 1.0);
        Mat4x4 rotM = m.mul(rotMat);
        Mat4x4 rotMatI = new Mat4x4(
                Math.cos(angle), 0.0, -Math.sin(angle), 0.0,
                0.0, 1.0, 0.0, 0.0,
                Math.sin(angle), 0.0, Math.cos(angle), 0.0,
                0.0, 0.0, 0.0, 1.0);
        Mat4x4 rotI = i.mul(rotMatI);
        return new Transform(rotM, rotI);
    }

    /**
     * Rotation um Z-Achse
     *
     * @param angle
     * @return
     */
    public Transform rotateZ(final double angle) {
        final Mat4x4 rotMat = new Mat4x4(
                Math.cos(angle), -Math.sin(angle), 0.0, 0.0,
                Math.sin(angle), Math.cos(angle), 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 rotM = m.mul(rotMat);
        final Mat4x4 rotMatI = new Mat4x4(
                Math.cos(angle), Math.sin(angle), 0.0, 0.0,
                -Math.sin(angle), Math.cos(angle), 0.0, 0.0,
                0.0, 0.0, 1.0, 0.0,
                0.0, 0.0, 0.0, 1.0);
        final Mat4x4 rotI = i.mul(rotMatI);
        return new Transform(rotM, rotI);
    }

    /**
     * Multiplikation eines Strahls mit der Inversenmatrix
     *
     * @param r
     * @return
     */
    public Ray mul(final Ray r) {
        return new Ray(i.mul(r.o), i.mul(r.d));
    }

    /**
     * Multiplikation der Normal mit der InversenMAtrix
     *
     * @param normal
     * @return
     */
    public Normal3 mul(final Normal3 normal) {
        return this.i.transpose().mul(new Vector3(normal.x, normal.y, normal.z)).asNormal();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.m);
        return 67 * hash + Objects.hashCode(this.i);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transform other = (Transform) obj;
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        return Objects.equals(this.i, other.i);
    }

    @Override
    public String toString() {
        return "Transform{" + "m=" + m + ", i=" + i + '}';
    }

}
