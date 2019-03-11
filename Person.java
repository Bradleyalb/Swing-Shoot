import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Object;
/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor 
{
    
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 0;
    int speedY = 0;
    int speedS = 0;
    int speedX = 0;
    boolean firstRight=true;
    int Xcenter;
    int Ycenter;
    int radius;
    int timer = 0;
    boolean person1 = false;
    boolean person2 = false;
    boolean flipDirection = false;
    boolean first = true;
    private MyWorld world;
    private GreenfootImage image;
    
    public void act() 
    {
        if (first)
        {
            saveWorld();
        }
        timer++;
        getWorld().setBackground(new GreenfootImage("space.jpg"));
        if (getY() < 2 && speedY < 0)
        {
            speedY = 0;
        } 
        if ((!Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left")) || (Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left")))
        {
            if (!firstRight) //Makes sure that the first time that the button is pressed it moves in the right direction 
            {
                flipDirection = false;
            }    
            speedY++;
            setLocation(getX() + speedX,getY()+speedY);
            setRotation(0);
            firstRight=true;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            shoot();
        }
        if (Greenfoot.isKeyDown("down"))
        {
            shoot();
        }
        if (Greenfoot.isKeyDown("right")&& !(getY() >= 845) && !Greenfoot.isKeyDown("left"))
        {
            swingRight();
        }
        if (getY() >= 845)
        {
            jump();
        }    
        if (Greenfoot.isKeyDown("left") && !(getY() >= 845) && !Greenfoot.isKeyDown("right"))
        {
            swingLeft();
        }
        if (isTouching(Bullet2.class) && !Greenfoot.isKeyDown("shift"))
        {
            reset();
        }
    }       
    public boolean isZero() //function to check if the swinger needs to change direction
    {
        if (speedS == 0)
        {
            return true;
        }    
        else
        {
            return false;
        }
    }
    private void shoot(){ //Shoots up or down based on whether the "up" key or "down" key is pressed
        if (timer > 100)
            {
                Bullet bullet = new Bullet();
                getWorld().addObject(bullet,getX(),getY());
                timer = 0;
            }
    }
    private void saveWorld(){
        world=(MyWorld)this.getWorld();
        image=world.getBackground();
        first = false;
    }
    private void swingRight(){ //Swing to the right in an arc when the right button is pushed
        if (firstRight)
        {
            Xcenter = getX() + 200;
            Ycenter = getY();
            radius = 200;
            speed = speedY;
            firstRight=false;
        }
        getWorld().getBackground().setColor(Color.BLUE);
        getWorld().getBackground().drawLine(getX(), getY(), Xcenter, Ycenter);            
        speedS = ((Ycenter - getY())/40) - speed/10 - 2;
        if (isZero())
        {
             if (!flipDirection)
             {
                 speedS = speedS - 5;
             }
             if (flipDirection)
             {
                 speedS = speedS - 5;
             }
             flipDirection = !flipDirection;
        }    
        if (flipDirection)
        {
            speedS = -speedS;
        }    
        turnTowards(Xcenter, Ycenter);
        move(radius);
        turn(speedS);
        move(-radius);
        speedX = speedS*(Ycenter - getY())/40;
        speedY = -speedS*(Xcenter-getX())/34;
    }
    public void swingLeft(){ //Swings to the left when the "left" key is pressed
        if (firstRight)
        {
             Xcenter = getX() - 200;
             Ycenter = getY();
             radius = 200;
             speed = speedY;
             firstRight=false;
        }  
        getWorld().getBackground().setColor(Color.BLUE);
        getWorld().getBackground().drawLine(getX(), getY(), Xcenter, Ycenter);
        speedS = ((Ycenter - getY())/40) - speed/10 - 2;
        if (isZero())
        {
           if (!flipDirection)
           {
               speedS = speedS - 5;
           }
           if (flipDirection)
           {
               speedS = speedS - 5;
           }
           flipDirection = !flipDirection;
        }    
        if (flipDirection)
        {
            speedS = -speedS;
        }    
        turnTowards(Xcenter, Ycenter);
        move(radius);
        turn(-speedS);
        move(-radius);
        speedX = -speedS*(Ycenter - getY())/40;
        speedY = speedS*(Xcenter-getX())/34;        
    }
    private void jump(){ //When the player is on the ground they can press "space" key to jump up 
        speedX = 0;
        speedY = 0;
        if (Greenfoot.isKeyDown("space"))
        {
            speedY = -30;
        }
    }
    private void reset() //When the player is hit the player position resets to the start
    {
        setLocation(72,53);
        Counter.addS = true;
        speedY=0;
        speedX=0;
        firstRight = true;
    }
}