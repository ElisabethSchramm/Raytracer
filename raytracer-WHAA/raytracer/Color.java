package raytracer;

/**
 * dargestellte Klasse repräsentiert eine Farbe im RGB Die einzelnen Komponenten
 * sollen hierbei in der Regel einen Wert zwischen 0 und 1 annehmen können.
 * Farbraum. eine farbe kann mit einer anderen addiert, subtrahiert und
 * multipliziert werden. Darüber hinaus kann eine Farbe mit einem Skalar
 * multipliziert werden.
 */
public class Color {

    /**
     * Farbwert für Rot
     */
    public final double r;

    /**
     * Farbwert für Grün
     */
    public final double g;

    /**
     * Farbwert für Blau
     */
    public final double b;

    /**
     * Konstrukter für Schwarz
     */
    public Color() {
        this.r = 0.0;
        this.g = 0.0;
        this.b = 0.0;
    }

    /**
     * Benutzerdefinierte Farbe
     *
     * @param r Rot zwischen 0.0 und 1.0
     * @param g Grün zwischen 0.0 und 1.0
     * @param b Blau zwischen 0.0 und 1.0
     */
    public Color(final double r, final double g, final double b) {
        if (r < 0.0 || r > 1.0) {
            throw new IllegalArgumentException("Das der Color übergeben r muss zwischen [0.0,1.0] liegen");
        }
        if (g < 0.0 || g > 1.0) {
            throw new IllegalArgumentException("Das der Color übergeben g muss zwischen [0.0,1.0] liegen");
        }
        if (b < 0.0 || b > 1.0) {
            throw new IllegalArgumentException("Das der Color übergeben b muss zwischen [0.0,1.0] liegen");
        }
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Diese Farbe mit Farbe c addieren.
     *
     * @param c Farbe
     * @return
     */
    public Color add(final Color c) {
        if (c == null) {
            throw new NullPointerException("Die übergeben Color darf nicht null sein");
        }
        double rSum = 1.0;
        double gSum = 1.0;
        double bSum = 1.0;

        if ((this.r + c.r) <= 1.0) {
            rSum = this.r + c.r;
        }
        if ((this.g + c.g) <= 1.0) {
            gSum = this.g + c.g;
        }
        if ((this.b + c.b) <= 1.0) {
            bSum = this.b + c.b;
        }
        return new Color(rSum, gSum, bSum);
    }

    /**
     * Von dieser Farbe, Farbe c subtrahieren
     *
     * @param c
     * @return
     */
    public Color sub(final Color c) {
        if (c == null) {
            throw new NullPointerException("Die übergeben Color darf nicht null sein");
        }
        double rSum = 0.0;
        double gSum = 0.0;
        double bSum = 0.0;
        if ((this.r - c.r) >= 0.0) {
            rSum = this.r - c.r;
        }
        if ((this.g - c.g) >= 0.0) {
            gSum = this.g + c.g;
        }
        if ((this.b - c.b) >= 0.0) {
            bSum = this.b - c.b;
        }
        return new Color(rSum, gSum, bSum);
    }

    /**
     * Diese Farbe mit Farbe c multiplizieren
     *
     * @param c
     * @return
     */
    public Color mul(final Color c) {
        if (c == null) {
            throw new NullPointerException("Die übergeben Color darf nicht null sein");
        }
        return new Color(this.r * c.r, this.g * c.g, this.b * c.b);
    }

    /**
     * Diese Farbe mit einen Skalar v multiplizieren
     *
     * @param v
     * @return
     */
    public Color mul(final double v) {
        if (v < 0.0) {
            throw new NullPointerException("Der übergebene double darf nicht < 0 sein");
        }
        double rSum = 1.0;
        double gSum = 1.0;
        double bSum = 1.0;
        if ((this.r * v) <= 1.0) {
            rSum = this.r * v;
        }
        if ((this.g * v) <= 1.0) {
            gSum = this.g * v;
        }
        if ((this.b * v) <= 1.0) {
            bSum = this.b * v;
        }
        return new Color(rSum, gSum, bSum);
    }

    /**
     * Erzeugt ein ARGB_int
     *
     * @return int
     */
    public int getRGB() {
        final int alpha = 255 << 24;
        final int red = ((int) (r * 255.0)) << 16;
        final int green = ((int) (g * 255.0)) << 8;
        final int blue = ((int) (b * 255.0));
        return alpha + red + green + blue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.g) ^ (Double.doubleToLongBits(this.g) >>> 32));
        return 41 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Color other = (Color) obj;
        if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(other.r)) {
            return false;
        }
        if (Double.doubleToLongBits(this.g) != Double.doubleToLongBits(other.g)) {
            return false;
        }
        return Double.doubleToLongBits(this.b) == Double.doubleToLongBits(other.b);
    }

    @Override
    public String toString() {
        return "Color{" + "r=" + r + ", g=" + g + ", b=" + b + "}";
    }
}
