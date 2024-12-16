import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gravitating extends JFrame implements ActionListener{
    GravDisplay gDisplay = new GravDisplay();
    Timer tm;
    public Gravitating(){
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        final int MAX_WIDTH = (int) device.getDisplayMode().getWidth();
        final int MAX_HEIGHT = (int) device.getDisplayMode().getHeight();

        gDisplay.setSize(gDisplay.getPreferredSize());
        gDisplay.setLocation(0, (int) Math.round(((MAX_HEIGHT - gDisplay.getHeight())*0.5)));
        this.add(gDisplay);
        
        
        
        
        this.setLayout(null);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        device.setFullScreenWindow(this);
        tm = new Timer(30, this);
        tm.start();
        
    }
    public static void main(String[] args){
        Gravitating gravit = new Gravitating();
    }
    boolean once = true;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (once) {gDisplay.scale = 0.5; once = false;}

        gDisplay.update();
        gDisplay.repaint();
    }
}