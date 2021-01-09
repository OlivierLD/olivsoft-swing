package dnd.gui;

import dnd.gui.utils.ImagePanel;
import dnd.gui.utils.ImageTable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class MainFrame
		extends JFrame {
	private final BorderLayout layoutMain = new BorderLayout();
	private final JPanel panelCenter = new JPanel();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu menuFile = new JMenu();
	private final JMenuItem menuFileExit = new JMenuItem();
	private final JMenu menuHelp = new JMenu();
	private final JMenuItem menuHelpAbout = new JMenuItem();
	private final JLabel statusBar = new JLabel();
	private final JToolBar toolBar = new JToolBar();

	private final JButton buttonHelp = new JButton();

	private final ImageIcon imageHelp = new ImageIcon(MainFrame.class.getResource("help.gif"));
	private final JSplitPane jSplitPane1 = new JSplitPane();
	private final BorderLayout borderLayout1 = new BorderLayout();

	private final ImageTable imageTable = null;
	private final ImagePanel imagePanel = new ImagePanel();

	private final MainFrame instance = this;

	public MainFrame() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		setJMenuBar(this.menuBar);
		getContentPane().setLayout(this.layoutMain);
		this.panelCenter.setLayout(this.borderLayout1);
		setSize(new Dimension(1162, 742));
		setTitle("Image DnD");
		this.menuFile.setText("File");
		this.menuFileExit.setText("Exit");
		this.menuFileExit.addActionListener(this::fileExit_ActionPerformed);
		this.menuHelp.setText("Help");
		this.menuHelpAbout.setText("About");
		this.menuHelpAbout.addActionListener(this::helpAbout_ActionPerformed);
		this.statusBar.setText("");

		this.buttonHelp.setToolTipText("Help");
		this.buttonHelp.setIcon(this.imageHelp);
		this.buttonHelp.addActionListener(e ->
				JOptionPane
						.showMessageDialog(
								MainFrame.this.instance,
								"<html><b>Drag & drop</b> images on the right pane.<br/>And do whatever you want from there.</html>",
								"Help!", JOptionPane.INFORMATION_MESSAGE));
		this.menuFile.add(this.menuFileExit);
		this.menuBar.add(this.menuFile);
		this.menuHelp.add(this.menuHelpAbout);
		this.menuBar.add(this.menuHelp);
		getContentPane().add(this.statusBar, BorderLayout.SOUTH);

		this.toolBar.add(this.buttonHelp);
		getContentPane().add(this.toolBar, BorderLayout.NORTH);

		this.jSplitPane1.setOneTouchExpandable(true);
		this.jSplitPane1.setContinuousLayout(true);
		this.panelCenter.add(this.jSplitPane1, BorderLayout.CENTER);

		this.jSplitPane1.setLeftComponent(this.imageTable); // I know... do something here.
		this.jSplitPane1.setRightComponent(this.imagePanel);

		getContentPane().add(this.panelCenter, BorderLayout.CENTER);
	}

	private void fileExit_ActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void helpAbout_ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, new MainFrame_AboutBoxPanel(), "About", JOptionPane.PLAIN_MESSAGE);
	}
}
