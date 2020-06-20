import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;


public class MazePanel extends JPanel implements MouseListener, KeyListener, MouseMotionListener
{
    vertex[][] screen = new vertex[140][140];


    public MazePanel ()
    {
        super();
        for(int x=0;x<screen.length;x++)
        {
            for(int y=0;y<screen[0].length;y++)
            {
                screen[x][y] = new vertex(x,y,0);
            }
        }
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setSize(800,700);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,700,700);
        g.setColor(Color.gray);
        g.fillRect(700,0,100,700);
        Color lightBrown = new Color(178, 113, 33);
        g.setColor(Color.BLACK);

        for(int row=0;row<screen.length;row++)
        {
            for(int col=0;col<screen[0].length;col++)
            {
                if(screen[row][col].getVal()==1)
                    g.fillRect(row*5,col*5,5,5);
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

    @Override
    public void mouseDragged(MouseEvent e)
    {
        int xpos = e.getX();
        xpos -= xpos%5;
        int ypos = e.getY();
        ypos -= ypos%5;

        if(e.getX()<700 && e.getX()>=0 && e.getY()>=0 && e.getY()<700 )
        {
            System.out.println(e.getX() + "         " + e.getY());
            screen[xpos/5][ypos/5].setVal(1);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
    public static class vertex
    {
        private int row;
        private int col;
        private vertex parent;
        private int val;

        public vertex(int row, int col, int val)
        {
            this.row=row;
            this.col=col;
            this.val=val;
            parent=null;
        }

        public void setVal(char val)
        {
            this.val = val;
        }

        public int getRow()
        {
            return row;
        }

        public int getVal()
        {
            return val;
        }

        public void setVal(int val)
        {
            this.val = val;
        }

        public void setRow(int row)
        {
            this.row = row;
        }

        public int getCol()
        {
            return col;
        }

        public void setCol(int col)
        {
            this.col = col;
        }

        public vertex getParent()
        {
            return parent;
        }

        public void setParent(vertex parent)
        {
            this.parent = parent;
        }
        public LinkedList getNeighbors(vertex[][] board)
        {
            LinkedList<vertex> ll = new LinkedList<>();
            if(row+1<board[0].length)
                ll.add(board[row+1][col]);
            if(row-1>=0)
                ll.add(board[row-1][col]);
            if(col+1<board.length)
                ll.add(board[row][col+1]);
            if(col-1>=0)
                ll.add(board[row][col-1]);
            return ll;
        }
    }
}