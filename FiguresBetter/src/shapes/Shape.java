package shapes;

import java.awt.Color;

public abstract class Shape {
    private final Color color;

    public Shape(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("color must not be null");
        }
        this.color = color;
    }

    public final Color getColor() {
        return color;
    }

    public abstract double area();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{color=" + color + "}";
    }
}
