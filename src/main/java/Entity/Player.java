package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity{
    private Rectangle bounds;

    public Player(int x, int y, int width, int height) {
        this.bounds = new Rectangle(x, y, width, height);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        direction = Direction.DOWN;
    }


    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Player up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Player up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Player down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Player down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Player left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Player left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Player right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Player right2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void move(int steps, Direction direction) {
        switch(direction) {
            case UP -> {
                bounds.y -= steps;
                break;
            }

            case DOWN -> {
                bounds.y += steps;
                break;
            }

            case LEFT -> {
                bounds.x -= steps;
                break;
            }

            case RIGHT -> {
                bounds.x += steps;
                break;
            }
        }
        animCounter++;
        if(animCounter > 6) {
            if(animNum == 1){
                animNum = 2;
            }
            else if(animNum == 2) {
                animNum = 1;
            }
            animCounter = 0;
        }

        this.direction = direction;

    }

    public void generate(Graphics2D g2) {

        BufferedImage image = null;

        switch(direction) {
            case UP:
                if (animNum == 1) {
                    image = up1;
                }
                if (animNum == 2) {
                    image = up2;
                }
                break;
            case DOWN:
                if (animNum == 1) {
                    image = down1;
                }
                if (animNum == 2) {
                    image = down2;
                }
                break;
            case LEFT:
                if (animNum == 1) {
                    image = left1;
                }
                if (animNum == 2) {
                    image = left2;
                }
                break;
            case RIGHT:
                if (animNum == 1) {
                    image = right1;
                }
                if (animNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, null);
    }



}