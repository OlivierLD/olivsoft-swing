package examples.world;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class SampleFrame extends JFrame {

    public SampleFrame() {
        borderLayout1 = new BorderLayout();
        commandPanel1 = new CommandPanel();
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit()
            throws Exception {
        getContentPane().setLayout(borderLayout1);
        setSize(new Dimension(600, 400));
        setTitle("Example 0 - The world");
        getContentPane().add(commandPanel1, BorderLayout.CENTER);
    }

    private BorderLayout borderLayout1;
    private CommandPanel commandPanel1;
}
