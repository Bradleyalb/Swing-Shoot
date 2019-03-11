import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Actor
{
    boolean firstTime = true;
    boolean upmove;
    public Bullet2()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() -30,image.getHeight() - 130);
        setImage(image);
    }
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("w") && firstTime)
        {
            upmove = true;
            firstTime = false;
        }
        if (Greenfoot.isKeyDown("s") && firstTime)
        {
            upmove = false;
            firstTime = false;
        }    
        if (upmove == true)
        {
            setLocation(getX(), getY()-8);
        }
        if (upmove == false)
        {
            setLocation(getX(), getY()+8);
        }
        if (getY() > 848 || getY() < 2)
        {
            getWorld().removeObject(this);
        }  
    }    
}
