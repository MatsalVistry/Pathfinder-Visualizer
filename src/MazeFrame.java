import java.awt.*;
import javax.swing.*;
public class MazeFrame extends JFrame
{
    public MazeFrame(String frameName)
    {
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        MazePanel p = new MazePanel ();
        Insets frameInsets = getInsets();
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}