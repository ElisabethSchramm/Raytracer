/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import math.Mat3x3;
import math.Point3;
import math.Vector3;
import raytracer.Ray;

/**
 *
 * @author Arnold
 */
public class FisheyeCamera extends Camera {

    private final double angle;

    public FisheyeCamera(Point3 e, Vector3 g, Vector3 t, double angle) {
        super(e, g, t);
        this.angle = angle;
    }

    @Override
    public Ray rayFor(int w, int h, int x, int y) {
        final int a = Integer.min(w, h);
        if (x >= (w - a) / 2 && x <= (w - (w - a - 1) / 2) && y >= (h - a) / 2 && y <= (h - (h - a - 1) / 2)) {
            final double denominatorU = ((double) (a - 1));
            final double numeratorU = (double) (x - ((w - a) / 2)) - denominatorU / 2.0;
            final double newX = numeratorU / denominatorU;

            final double denominatorV = ((double) (a - 1));
            final double numeratorV = (double) (y - ((h - a) / 2)) - denominatorV / 2.0;
            final double newY = numeratorV / denominatorV;

        //final double newX = ((double)(2 * x)) / ((double)(w - 1));
            //final double newY = ((double)(2 * y)) / ((double)(h - 1));
            final double rad = Math.sqrt(newX * newX + newY * newY);
            if (rad >= 0.0 && rad <= 0.5) {

                final double phi;
                if (rad == 0.0) {
                    phi = 0.0;
                } else if (newX < 0.0) {
                    phi = Math.PI - Math.asin(newY / rad);
                } else {
                    phi = Math.asin(newY / rad);
                }
                final double theta = rad * angle / 2.0;

                final Vector3 vecX = super.u.mul(Math.sin(theta) * Math.cos(phi));
                final Vector3 vecY = super.v.mul(Math.sin(theta) * Math.sin(phi));
                final Vector3 vecZ = super.w.changeDirection().mul(Math.cos(theta));
                //final Vector3 r = new Vector3(Math.sin(theta) * Math.cos(phi), Math.sin(theta) * Math.sin(phi), Math.cos(theta));
                final Vector3 r = vecX.add(vecY).add(vecZ);
                return new Ray(this.e, r.normalized());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private Mat3x3 transformMatrix() {
        final Mat3x3 basicMat = new Mat3x3(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0);
        final Mat3x3 targetMat = basicMat.changeCol1(super.u).changeCol2(super.v).changeCol3(super.w.changeDirection());
        final Mat3x3 transformMat = targetMat.mul(basicMat);
        return basicMat;
    }
}
