/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Player {
    //Pre-decalred variables
 private static int numPlayers=0;
 private int x;
 private int y;
 private int z;
 private int direction;
 private int hp;
 private String name;
 
 //CONSTRUCTORS
 public Player(){
   numPlayers++;
   name="P"+numPlayers;
   teleport(0,0,0);
   setHp(20);
   setDirection(1);
 }
 
 public Player(String me, int x, int y, int z){
   numPlayers++;
   name=me;
   teleport(x,y,z);
   setHp(20);
   setDirection(1);
 }
 
 public Player(String me, int x, int y, int z, int health, int direc){
   numPlayers++;
   name=me;
   teleport(x,y,z);
   setHp(health);
   if(direc>=1 && direc<=6){
     setDirection(direc);
   }
   else{
     setDirection(1);
   }
 }
 
 //Simple accessors
 
 public static int getNumPlayers(){
   return numPlayers;
 }
 
 public String getName(){
   return name;
 }
 
 public int getX(){
   return x;
 }
 
 public int getY(){
   return y;
 }
 
 public int getZ(){
   return z;
 }
 
 public int getHp(){
   return hp;
 }
 
 public int getDirection(){
   return direction;
 }
 
 //Complex accessors
 public String toString(){
   return ("Name: "+name+"\nHealth: "+hp+"\nCoordinates: X "+x+" Y "+y+" Z "+z+"\nDirection: "+direction);
 }
   
 public double getDistance(int x2, int y2, int z2){
   //gets distance between your player and the inputed coordinates
   int x1=getX();
   int y1=getY();
   int z1=getZ();
   double dist;
   
   //calculations
   dist=Math.sqrt( (Math.pow((x2-x1),2)) + (Math.pow((y2-y1),2)) + (Math.pow((z2-z1),2)) );
   
   return dist;
 }
 
 public double getDistance(Player player){
   //gets distance between your player and the inputed player
   int X=player.getX();
   int Y=player.getY();
   int Z=player.getZ();
   double dist=getDistance(X,Y,Z);
   return dist;
 }
 
 //Mutators
 public void setHp(int HP){
   if(HP>=0){
     hp=HP;
   }
   else{
     hp=0;
   }
 }
 
 public void setDirection(int direc){
   if(direc>=1 && direc<=6){
     direction=direc;
   }
 }
 
 public void move(int direc, int units){
   //set new direction and coordinates
   //Change north/south
     if(direc==1){
       x=x+units;
     }
     else if(direc==2){
       x=x-units;
     }
     //change east/west
     else if(direc==5){
       z=z+units;
     }
     else if(direc==6){
       z=z-units;
     }
     //change up/down
     else if(direc==3){
       y=y+units;
     }
     else if(direc==4){
       y=y-units;
     }
 }
 
 public void teleport(int tempX, int tempY, int tempZ){
   //set new coordinates
   x=tempX;
   y=tempY;
   z=tempZ;
 }
 
 public void teleport(Player otherPlayer){
   //set coordinates to the coordinates of the inputed player
   int tempX=otherPlayer.getX();
   int tempY=otherPlayer.getY();
   int tempZ=otherPlayer.getZ();
   teleport(tempX, tempY, tempZ);
 }
 
 public void attack(Player player, int damage){
   //attack someone
   player.setHp(player.getHp()-damage);
   int hpBonus=damage/2;
   setHp(hp+hpBonus);
 }
}
