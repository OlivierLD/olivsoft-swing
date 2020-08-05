package coreutilities.gui.sample;

import coreutilities.Utilities;

import coreutilities.gui.HeadingPanel;
import coreutilities.gui.JumboDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame
        extends JFrame {
    HeadingPanel testJumbo = null;
    JPanel panel = new JPanel() {
        public void paintComponent(Graphics gr) {
            gr.setColor(Color.blue);
            gr.setFont(gr.getFont().deriveFont(Font.BOLD, 16f));
            String[][] data = new String[][]
                    {
                            {"ah!-", "123.00", "cou"},
                            {"ah!", "1.10", "couc"},
                            {"ah-gh!", "65465546", "couco"},
                            {"ah!127542", "-123.00", "coucou"},
                            {"ah!adasada", "0.00", "coucouxxx"},
                            {"oh!", "12.34", "coucoux"}
                    };
            int y = Utilities.drawPanelTable(data, gr, new Point(20, 20), 10, 2, new int[]{Utilities.LEFT_ALIGNED, Utilities.RIGHT_ALIGNED, Utilities.CENTER_ALIGNED});
            gr.setColor(Color.red);
            y = Utilities.drawPanelTable(data, gr, new Point(50, y), 30, 2, new int[]{Utilities.LEFT_ALIGNED, Utilities.RIGHT_ALIGNED, Utilities.CENTER_ALIGNED});
        }
    };

    public TestFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit()
            throws Exception {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setSize(new Dimension(400, 300));
        this.setTitle("Duh");
        testJumbo = new HeadingPanel();
        testJumbo.setBounds(10, 10, 130, 30);
        this.getContentPane().add(testJumbo, BorderLayout.SOUTH);
    }
}
