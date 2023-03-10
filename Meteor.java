import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int slide = 1 + Greenfoot.getRandomNumber(3);

    public Meteor(){

    }

    public void act()
    {
        setLocation (getX()-slide, getY());
        turn(1);
        int scoree = getWorld().getObjects(Score.class).get(0).getValue();
        InGame mw = (InGame)getWorld();
        int height = mw.getHigh();
        if(getX() == 0){
            getWorld().removeObject(this);
        }else if(scoree < height * 75/100 || scoree >= height){
            getWorld().removeObject(this);
        }
    }
}
