package myShapes;

public class EquilateralTri extends Triangle {
    // Class instances
    private double side;

    // Constructor
    public EquilateralTri(double side, int color) {
        super(side, side, side, color);
        setSide(side);
    }

    // Getter methods
    public double getSide() {
        return this.side;
    }

    // Setter methods
    public boolean setSide(double side) {
        if (checkSide(side)) {
            this.side = side;
            return true;
        }
        return false;
    }

    @Override
    public boolean isRightTriangle() {
        return false;
    }

    @Override
    public boolean isEquilateralTriangle() {
        return true;
    }
    
}