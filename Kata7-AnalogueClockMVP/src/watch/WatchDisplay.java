package watch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JPanel;

public class WatchDisplay extends JPanel{

    private Point[] points = new Point[0];
    private final Image background;

    public WatchDisplay(Image background) {
        this.background = background;
    }
    
    public void paint(Point[] points){
        this.points = points;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        int width = 1;
        g.drawImage(background, 0, 0, this);
        for (Point point : points)  
            paintLine((Graphics2D) g, point, width++);
    }

    private void paintLine(Graphics2D g, Point point, int width) {
        int ox = getWidth()/2;
        int oy = getHeight()/2;
        g.setStroke(new BasicStroke(width));
        g.setColor(Color.darkGray);
        g.drawLine(ox, oy, ox + point.x, oy - point.y);
    }
}