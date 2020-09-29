package org.jomaveger.examples.chapter1;

public abstract class Shape {

    private Point2D position;

    public Shape(final Point2D p) {
        this.position = p;
    }

    public Shape(final Integer x, final Integer y) {
        this.position = new Point2D(Double.parseDouble(x.toString()), Double.parseDouble(y.toString()));
    }

    public Shape(final Double x, final Double y) {
        this.position = new Point2D(x, y);
    }

    public abstract Double getArea();
}
