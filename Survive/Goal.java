import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Goal
 * A class that represents a goal defence. The goal defence is what the enemies
 * are attracted to. Upon defeat of this goal defence, game over is triggered.
 * @author Edward Wu
 * @version 1.0, June 15, 2021
 */
class Goal extends Defence{
    /*-----Variables for this goal-----*/
    private Level level;
    private String path;
    private BufferedImage sprite;

    /**
     * FenceVertical
     * A constructor that constructs a goal defence.
     * @param level The leve that this goal is created for.
     * @param x The x-coordinate of the top-left corner of this goal relative to the window.
     * @param y The y-coordinate of the top-left corner of this goal relative to the window.
     */
    Goal(Level level, int x, int y){
        //All fences have a maximum health of 300
        super(level, "Goal", x, y, 300);
        this.level = level;
        this.path = level.getPath();
        loadSprites();
        super.setBoundingBox(64, 64);
    }
    /**
     * loadSprites
     * Loads the goal sprites from the Sprites folder of the game directory.
     */
    public void loadSprites(){
        try{
            sprite = ImageIO.read(new File(path+"\\Sprites\\Defence\\goal.png"));
        }catch(Exception e){
            System.out.println("Could not load horizontal fence sprite");
        }
    }
    /**
     * death
     * An overwridden method from the Defence class that intitates the death of this goal defence.
     */
    public void death(){
        level.getPanelManager().setActivePanel("GameOverPanel");
    }
    //Overwrriden from Defence class
    /**
     * draw
     * An overwridden method from the Defence class that draws this goal defence on screen.
     * @param g The graphics object that this defence is to be drawn on.
     */
    public void draw(Graphics g){
        g.drawImage(sprite, this.getRelativeX(), this.getRelativeY(), null);
        g.setColor(new Color(255, 255, 0));
        //Draw yellow outline around this goal defence
        g.drawRect(this.getRelativeX(), this.getRelativeY(), 64, 64);
    }
}
