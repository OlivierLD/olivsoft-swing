package nightsky.full;

import nightsky.NightPanelHolder;
import nightsky.NightSkyPanel;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


public class SkyApplet extends JApplet {
	private NightPanelHolder nphOne = null;
	private NightPanelHolder nphTwo = null;
	private JTabbedPane tabbedPane = new JTabbedPane();

	public SkyApplet() {
	}

	private void jbInit()
			throws Exception {
//  NightSkyPanel panelOne = new NightSkyPanelWithConstellations();
//  NightSkyPanel panelTwo = new NightSkyPanelWithConstellations(NightSkyPanel.SKY_CHART_OPTION);
		nphOne = new NightPanelHolder(NightSkyPanel.STAR_FINDER_OPTION, null, NightPanelHolder.WITHOUT_CONSTELLATIONS);
		nphTwo = new NightPanelHolder(NightSkyPanel.SKY_CHART_OPTION, null, NightPanelHolder.WITHOUT_CONSTELLATIONS);

		this.getContentPane().setLayout(new BorderLayout());
		tabbedPane.add("Star Finder", nphOne);
		tabbedPane.add("Sky Map", nphTwo);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

	public void init() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) {
		SkyApplet applet = new SkyApplet();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		frame.setTitle("Applet Frame");
		applet.init();
		applet.start();
		frame.setSize(600, 600);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		frame.setLocation((d.width - frameSize.width) / 2, (d.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
}
