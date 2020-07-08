package myShapes;

public class RightTri extends Triangle {
    private double base;
    private double height;
    private double hypotenuse;

    // Constructor
    public RightTri(double base, double height, int color) {
        super(base, height, 0, color);
        setBase(base);
        setHeight(height);
        setHypotenuse(base, height);
        super.setSide3(getHypotenuse());
    }

    // Getter methods
    public double getBase() {
        return this.base;
    }

    public double getHeight() {
        return this.height;
    }

    public double getHypotenuse() {
        return this.hypotenuse;
    }

    // Setter methods
    public boolean setBase(double base) {
        if (checkSide(base)) {
            this.base = base;
            return true;
        }
        return false;
    }

    public boolean setHeight(double height) {
        if (checkSide(height)) {
            this.height = height;
            return true;
        }
        return false;
    }

    public boolean setHypotenuse(double base, double height) {
        if (checkSide(base) && checkSide(height)) {
            this.hypotenuse = Math.sqrt(base * base + height * height);
            return true;
        }
        return false;
    }

    @Override
    public double area() {
        return 0.5 * getBase() * getHeight();
    }

    @Override
    public boolean isRightTriangle() {
        return true;
    }

    @Override
    public boolean isEquilateralTriangle() {
        return false;
    }

   
}