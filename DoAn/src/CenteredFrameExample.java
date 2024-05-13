import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CenteredFrameExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Centered Frame Example");

        // Set the size of the frame
        int width = 400;
        int height = 300;
        frame.setSize(width, height);

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the position to center the frame
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;

        // Set the frame's location
        frame.setLocation(x, y);

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the frame
        frame.setVisible(true);
    }
}
