import java.awt.Color;

public class Sphere {
    //sphere diameter
    private int diameter = 1;
    //coordinates in a three-dimensional space
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int nx = x;
    private int ny = y;
    private int nz = z;
    //velocity of the sphere in each of the space directions
    private double vx = 0;
    private double vy = 0;
    private double vz = 0;
    private double nvx = vx;
    private double nvy = vy;
    private double nvz = vz;
    
    //mass of the sphere
    private double mass = 1;
    //color of the sphere
    private Color color = new Color(0,0,0);
    
    //getters and setters
    public void setX(int val){ this.nx = val; }
    public void setY(int val){ this.ny = val; }
    public void setZ(int val){ this.nz = val; }
    public void setVX(double val){ this.nvx = val; }
    public void setVY(double val){ this.nvy = val; }
    public void setVZ(double val){ this.nvz = val; }
    public void setDiameter(int val){ this.diameter = val; }
    public void setMass(double val){ this.mass = val; }
    public void setColor(Color val){ this.color = val; }
    public void updateCoord(){this.x = this.nx; this.y = this.ny; this.z = this.nz;}
    public void updateSpeed() {this.vx = this.nvx; this.vy = this.nvy; this.vz = this.nvz;}
    public void update(){ updateCoord();updateSpeed();}
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public int getZ(){ return this.z; }
    public double getVX(){ return this.vx; }
    public double getVY(){ return this.vy; }
    public double getVZ(){ return this.vz; }
    public int getDiameter(){ return this.diameter; }
    public double getMass(){ return this.mass; }
    public Color getColor() { return this.color; }
    // get the center of the sphere object
    public double getCX(){return this.x + this.diameter * 0.5;} 
    public double getCY(){return this.y + this.diameter * 0.5;} 
    public double getCZ(){return this.z + this.diameter * 0.5;} 

    public Sphere(int diameter){
        this.diameter = diameter;
    }
}
