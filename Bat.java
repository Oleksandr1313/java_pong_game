public class Bat {
    private int x;
    private int y;
    private final int width = 10;
    private final int height = 100;
    private final int speed = 5;

    public Bat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (y > 0) {
            y -= speed;
        }
    }

    public void moveDown(int panelHeight) {
        if (y + height < panelHeight) {
            y += speed;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBottom() {
        return y + height;
    }
}
