import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class GravDisplay extends JPanel implements MouseListener{
    //original tile size mean the lowest diameter for a element sphere (1m)
    //value chosen of 8 so it could be drawn a inner solid state and around it a layer for element viscosity
    final int originalTileSize = 8;
    Double scale = 1.0;

    final int tileSize = (int)Math.round(originalTileSize * scale);
    final int maxScreenCol = 120;
    final int maxScreenRow = 90;
    final int screenWidth = maxScreenCol * tileSize;
    final int screenHeight = maxScreenRow * tileSize;
    public List<Sphere> shapez = new ArrayList();

    public GravDisplay(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
    }
    public void update(){
        for (Sphere sph : shapez){
            sph.setX((int)Math.round(sph.getX()+sph.getVX()));
            sph.setY((int)Math.round(sph.getY()+sph.getVY()));
            sph.update();
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(this.getBackground());
        g.fillRect(0, 0, screenWidth, screenHeight);
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        g2d.transform(at);
        for (Sphere sph : shapez){
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            Ellipse2D.Double hole = new Ellipse2D.Double();
            hole.width = sph.getDiameter();
            hole.height = sph.getDiameter();
            hole.x = sph.getX();
            hole.y = sph.getY();
            g2d.setColor(Color.white);
            g2d.draw(hole);
            g2d.setColor(sph.getColor());
            g2d.fill(hole);
        }

        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (int)Math.round(e.getX()/scale);
        int y = (int)Math.round(e.getY()/scale);
        System.out.println("x:" + x +" - y:"+y);
        Sphere newSphere = new Sphere(8);
        newSphere.setX(x);
        newSphere.setY(y);
        newSphere.updateCoord();
        newSphere.setVX(Math.random()*6-3.0);
        newSphere.setVY(Math.random()*6-3);
        System.out.println(Math.round(Math.random()*255));
        int red = (int)Math.round(Math.random()*255)+1;
        int green = (int)Math.round(Math.random()*255)+1;
        int blue = (int)Math.round(Math.random()*255)+1;        
        newSphere.setColor(new Color(red, green, blue));
        shapez.add(newSphere);

        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
}
