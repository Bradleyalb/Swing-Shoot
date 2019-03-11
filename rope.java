import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rope here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rope extends Actor
{
    /**
     * Act - do whatever the rope wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawALine(100,100,200,200);
    }    
    public void drawALine(int X1,int Y1,int X2,int Y2)
    {
       World world = (World)getWorld();
       GreenfootImage img = new GreenfootImage(2,100);    
       img.drawLine(X1, Y1, X2, Y2);
       setImage(img); 
    }
}