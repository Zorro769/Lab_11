import java.awt.*;
import java.awt.event.*;

class PaintWindow extends Frame implements MouseListener, MouseMotionListener {
    Point p1;
    class MyEventWindowAdapter extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            dispose();
            System.exit(0);
        }
    }

    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        p1 = e.getPoint();
        if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
            Color backgroundColor = getBackground();
            Graphics g = getGraphics();
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
            System.out.println("2");
        }

    }
    public void mouseDragged(MouseEvent e){
        if (e.getModifiers() == MouseEvent.BUTTON2_MASK) {
            Point p2 = e.getPoint();
            Graphics g = getGraphics();
            g.drawLine(p1.x,p1.y, p2.x,p2.y);
            p1 = p2;
        }

    }
    public PaintWindow(){
        super("Малювання курсором миші");
        addWindowListener(new MyEventWindowAdapter());
        addMouseListener(this);
        addMouseMotionListener(this);
        setSize(900,600);
        setLocation(20,30);
        setVisible(true);
    }
}
