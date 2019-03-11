import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x850 cells with a cell size of 1x1 pixels.
        super(1600, 850, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Counter counter = new Counter();
        addObject(counter,57,40);
        Counter2 counter2 = new Counter2();
        addObject(counter2,1489,38);
        Person person = new Person();
        addObject(person,191,68);
        Person2 person2 = new Person2();
        addObject(person2,1324,76);
        person2.setLocation(1320,77);
        counter.setLocation(1468,34);
        counter2.setLocation(58,31);
        person.setLocation(1368,78);
        person2.setLocation(148,51);
    }

    public void newBullet(int X,int Y)
    {
        Bullet bullet = new Bullet();
        addObject(bullet,X,Y);
    }    
}
