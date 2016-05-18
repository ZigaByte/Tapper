package com.zigabyte.tapper.math;

public class Vector2f {

    public float x;
    public float y;

    public Vector2f() {
        this(0, 0);
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float lenght() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float dot(Vector2f r) {
        return x * r.getX() + y * r.getY();
    }

    public Vector2f normalize() {
        float lenght = lenght();
        x /= lenght;
        y /= lenght;
        return this;
    }

    public Vector2f rotate(float angle) {

        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        return new Vector2f((float) (x * cos - y * sin), (float) (x * sin + y * cos));
    }

    public Vector2f add(Vector2f r) {
        return new Vector2f(x + r.getX(), y + r.getY());
    }

    public Vector2f add(float r) {
        return new Vector2f(x + r, y + r);
    }

    public Vector2f sub(Vector2f r) {
        return new Vector2f(x - r.getX(), y - r.getY());
    }

    public Vector2f sub(float r) {
        return new Vector2f(x - r, y - r);
    }

    public Vector2f mul(Vector2f r) {
        return new Vector2f(x * r.getX(), y * r.getY());
    }

    public Vector2f mul(float r) {
        return new Vector2f(x * r, y * r);
    }

    public Vector2f div(Vector2f r) {
        if (r.getX() != 0 && r.getY() != 0)
            return new Vector2f(x / r.getX(), y / r.getY());
        return r;
    }

    public Vector2f div(float r) {
        if (r != 0)
            return new Vector2f(x / r, y / r);
        return new Vector2f(0, 0);
    }

    public boolean isInside(float x0, float y0, float x1, float y1){
        return (x0 <= x && x <= x1 && y0 <= y && y <= y1);
    }

    public String toString() {
        return "(" + x + " " + y + ")";
    }

    public float getX() {
        return x;
    }

    public int getXi() {
        return (int) x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public int getYi() {
        return (int) y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
