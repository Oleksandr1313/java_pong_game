public class Ball {
    private int x;
    private int y;
    private int diameter = 20;
    private int xSpeed = 3;
    private int ySpeed = 3;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounceX() {
        xSpeed = -xSpeed;
    }

    public void bounceY() {
        ySpeed = -ySpeed;
    }

    public void resetPosition(int startX, int startY) {
        x = startX;
        y = startY;
        xSpeed = -xSpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getBottom() {
        return y + diameter;
    }
}
