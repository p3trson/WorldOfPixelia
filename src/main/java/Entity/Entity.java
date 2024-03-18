package Entity;

import java.awt.image.BufferedImage;

public class Entity {

    public int x;
    public int y;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public Direction direction;

    public int animNum = 1;

    public int animCounter = 0;
}
