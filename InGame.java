import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InGame extends World
{
    private int spawntime=0;
    private int pause=0;
    private int life = 3;
    private int clockt;
    private int second;
    public int getPoint;
    private GreenfootImage lvl1;
    private GreenfootImage lvl2;
    private GreenfootImage lvl3;
    private GreenfootImage lvl4;
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    public int maxhigh = 100;
    int time = 60 + Greenfoot.getRandomNumber(180);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public InGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 700, 1); 
        prepare();
        clockt = 0;
        setPaintOrder(Score.class, GameOver.class, WinGame.class, LoseOverlay.class, Mc.class, Ground.class);
        lvl1 = new GreenfootImage("BGunderground.jpg");
        lvl2 = new GreenfootImage("surface.jpg");
        lvl3 = new GreenfootImage("Sky.jpg");
        lvl4 = new GreenfootImage("Space.jpg");
    }

    public GreenfootImage getLevel1(){
        return lvl1;
    }

    public GreenfootImage getLevel2(){
        return lvl2;
    }

    public GreenfootImage getLevel3(){
        return lvl3;
    }

    public GreenfootImage getLevel4(){
        return lvl4;
    }

    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,275,698);

        addObject(new Underground(),50 + Greenfoot.getRandomNumber(450),480);
        addObject(new Underground(),50 + Greenfoot.getRandomNumber(450),330);
        addObject(new Underground(),50 + Greenfoot.getRandomNumber(450),165);
        addObject(new Underground(),50 + Greenfoot.getRandomNumber(450),0); 
        Mc mc = new Mc();
        addObject(mc,250,624);
        Score score = new Score();
        addObject(score,550/2 ,30);
        score.setPrefix("Score : ");

    }

    public void act(){

            
        WinScreen();
        Things();
        DieScreen();

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    public void addscore(int point){
        getPoint += point;

    }

    public void WinScreen(){
        if(!getObjects(Score.class).isEmpty()){
            int scoretemp = getObjects(Score.class).get(0).getValue();

            if(scoretemp >= maxhigh){

                if (this != null) {
                    removeObjects(getObjects(null));
                    addObject(new WinGame(), getWidth()/2, getHeight()/2);
                    
                    Greenfoot.stop();
                }
            }
        }

    }

    public int getHigh(){
        return maxhigh;
    }

    public void DieScreen(){
        if(!getObjects(Mc.class).isEmpty()){
            if(getObjects(Mc.class).get(0).getY() >= 699){
                removeObjects(getObjects(null));
                addObject(new LoseOverlay(), getWidth()/2, getHeight()/2);
                addObject(new GameOver(), getWidth()/2, getHeight()/2);
                
                Greenfoot.stop();
            }
        }
    }

    public void Things(){
        if(!getObjects(Score.class).isEmpty()){

            int scoree = getObjects(Score.class).get(0).getValue();

            if(scoree >= maxhigh * 75/100){
                time--;
                if(time== 0){          
                    addObject(new Meteor(),550,10 + Greenfoot.getRandomNumber(450));
                    time = 60 + Greenfoot.getRandomNumber(120);
                }
            }
            else if(scoree >= maxhigh * 50/100){
                time--;
                if(time== 0){          
                    addObject(new BgCloud(),550,10 + Greenfoot.getRandomNumber(450));
                    time = 60 + Greenfoot.getRandomNumber(120);
                }
            }
        }
    }
}
