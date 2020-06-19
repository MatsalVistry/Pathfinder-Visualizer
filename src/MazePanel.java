import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class MazePanel extends JPanel implements MouseListener, KeyListener, MouseMotionListener
{
    int [][] screen = new int[800][700];

    public MazePanel ()
    {
        super();
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setSize(800,700);
    }
    public void paint(Graphics g)
    {
        Color lightBrown = new Color(178, 113, 33);
        g.setColor(lightBrown);
        g.fillRect(0,0,50,50);
        for(int row=0;row<screen.length;row++)
        {
            for(int col=0;col<screen[0].length;col++)
            {
                if(screen[row][col]==1)
                    g.fillRect(row,col,1,1);
            }
        }
    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mousePressed(MouseEvent e)
    {
//        System.out.println(e.getX()+"         "+e.getY());
    }

    public void mouseReleased(MouseEvent e)
    {
//        System.out.println(e.getX()+"         "+e.getY());

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }


    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
    public BufferedImage scale(BufferedImage src, int w, int h)
    {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];

        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;

        for (x = 0; x < w; x++)
        {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }

        return img;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        System.out.println(e.getX()+"         "+e.getY());
        int xpos = e.getX();
        int ypos = e.getY();
        for(int x=-5;x<5;x++)
        {
            for(int y=-5;y<5;y++)
            {
                screen[xpos+x][ypos+y] = 1;
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}