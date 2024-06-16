package math;

/**
 * Diese Klasse testet die Akzeptanzkriterien der Klassen Mat3x3, Vector3,
 * Point3 und Normal3
 *
 * @author Arnold
 */
public class Akzeptanzkriterien {

    public static void main(String[] args) {
        /**
         * Multiplikation der Normalen(1/2/3) mit 0.5
         */
        final Normal3 norm1 = new Normal3(1.0, 2.0, 3.0);
        final Normal3 normMul = norm1.mul(0.5);
        System.out.println("Normalen Multi. : ( " + normMul.x + " / " + normMul.y + " / " + normMul.z + " )");
        /**
         * Addition der Normalen(1/2/3) mit der Normalen(3/2/1)
         */
        final Normal3 norm2 = new Normal3(3.0, 2.0, 1.0);
        final Normal3 normAdd = norm1.add(norm2);
        System.out.println("Normalen Add. : ( " + normAdd.x + " / " + normAdd.y + " / " + normAdd.z + " )");
        /**
         * Skalarprodukt von Normale und Vektor, Vektor mit Normale und Vektor
         * mit Vektor
         */
        final Normal3 norm3 = new Normal3(1.0, 0.0, 0.0);
        final Normal3 norm4 = new Normal3(0.0, 1.0, 0.0);
        final Vector3 vec1 = new Vector3(1.0, 0.0, 0.0);
        final Vector3 vec2 = new Vector3(0.0, 1.0, 0.0);
        System.out.println("Skalar Normale(1/0/0) und Vector(1/0/0) : " + norm3.dot(vec1));
        System.out.println("Skalar Normale(1/0/0) und Vector(0/1/0) : " + norm3.dot(vec2));
        System.out.println("Skalar Vector(1/0/0) und Normale(1/0/0) : " + vec1.dot(norm3));
        System.out.println("Skalar Vector(1/0/0) und Normale(0/1/0) : " + vec1.dot(norm4));
        System.out.println("Skalar Vector(1/0/0) und Vector(1/0/0) : " + vec1.dot(vec1));
        System.out.println("Skalar Vector(1/0/0) und Vector(0/1/0) : " + vec1.dot(vec2));
        /**
         * Sub. von 2. Punkten
         */
        final Point3 poi1 = new Point3(1.0, 1.0, 1.0);
        final Point3 poi2 = new Point3(2.0, 2.0, 0.0);
        final Vector3 poiSubpoi = poi1.sub(poi2);
        System.out.println("Punkt Sub. Punkt : ( " + poiSubpoi.x + " / " + poiSubpoi.y + " / " + poiSubpoi.z + " )");
        /**
         * Sub. Vector von Punkt
         */
        final Vector3 vec3 = new Vector3(4.0, 3.0, 2.0);
        final Point3 poiSubVec = poi1.sub(vec3);
        System.out.println("Punkt Sub. Vektor : ( " + poiSubVec.x + " / " + poiSubVec.y + " / " + poiSubVec.z + " )");
        /**
         * Add. Vector zum Punkt
         */
        final Point3 poiAddVec = poi1.add(vec3);
        System.out.println("Punkt Add. Vektor : ( " + poiAddVec.x + " / " + poiAddVec.y + " / " + poiAddVec.z + " )");
        /**
         * Betrag des Vectors(1.0,1.0,1.0)
         */
        System.out.println("Betrag des Vectors(1/1/1) : " + new Vector3(1.0, 1.0, 1.0).magnitude);
        /**
         * Add. , Sub. und Mul. für Vector3
         */
        final Vector3 vecAdd = vec1.add(vec2);
        System.out.println("Vector(1/0/0) + Vector(0/1/0) : ( " + vecAdd.x + " / " + vecAdd.y + " / " + vecAdd.z + " )");
        final Vector3 vecAddNorm = vec1.add(norm4);
        System.out.println("Vector(1/0/0) + Normale(0/1/0) : ( " + vecAddNorm.x + " / " + vecAddNorm.y + " / " + vecAddNorm.z + " )");
        final Vector3 vecSub = vec1.sub(norm4);
        System.out.println("Vector(1/0/0) - Normale(0/1/0) : ( " + vecSub.x + " / " + vecSub.y + " / " + vecSub.z + " )");
        final Vector3 vecMul = vec3.mul(0.5);
        System.out.println("Vector(4/3/2) * 0.5 : ( " + vecMul.x + " / " + vecMul.y + " / " + vecMul.z + " )");
        /**
         * Reflektion an einer Normalen
         */
        final Vector3 refl = new Vector3(-0.707, 0.707, 0.0).reflectedOn(new Normal3(0.0, 1.0, 0.0));
        System.out.println("Reflektierter Vector1 : ( " + refl.x + " / " + refl.y + " / " + refl.z + " )");
        final Vector3 refl2 = new Vector3(0.707, 0.707, 0.0).reflectedOn(new Normal3(1.0, 0.0, 0.0));
        System.out.println("Reflektierter Vector2 : ( " + refl2.x + " / " + refl2.y + " / " + refl2.z + " )");
        /**
         * Matrix mit Vektor multiplizieren
         */
        final Mat3x3 mat1 = new Mat3x3(1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0);
        final Vector3 mat1MulVec = mat1.mul(new Vector3(3.0, 2.0, 1.0));
        System.out.println("Matrix Mul. Vector: ( " + mat1MulVec.x + " / " + mat1MulVec.y + " / " + mat1MulVec.z + " )");
        /**
         * Matrix Mul. Matrix
         */
        final Mat3x3 mat2 = new Mat3x3(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        System.out.println("Matrix2 Mul. Matrix1 : \n" + mat2.mul(mat1).toString());
        final Mat3x3 mat3 = new Mat3x3(0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0);
        System.out.println("Matrix2 Mul. Matrix3 : \n" + mat2.mul(mat3).toString());
        /**
         * Spaltenaustausch
         */
        System.out.println("Matrix2 col1 : \n" + mat2.changeCol1(new Vector3(8.0, 8.0, 8.0)).toString());
        System.out.println("Matrix2 col2 : \n" + mat2.changeCol2(new Vector3(8.0, 8.0, 8.0)).toString());
        System.out.println("Matrix2 col3 : \n" + mat2.changeCol3(new Vector3(8.0, 8.0, 8.0)).toString());
    }
}
