package dnd.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainFrame_AboutBoxPanel
		extends JPanel {
	private final JLabel labelTitle = new JLabel();
	private final JLabel labelAuthor = new JLabel();
	private final JLabel labelCopyright = new JLabel();
	private final JLabel labelCompany = new JLabel();
	private final GridBagLayout layoutMain = new GridBagLayout();
	private final Border border = BorderFactory.createEtchedBorder();

	public MainFrame_AboutBoxPanel() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		setLayout(this.layoutMain);
		setBorder(this.border);
		this.labelTitle.setText("Image DnD sample/scaffolding");
		this.labelAuthor.setText("Olivier Le Diouris (aka Anakin Skywalker");
		this.labelCopyright.setText("Copyright 2021");
		this.labelCompany.setText("OlivSoft strikes again, Bam!");
		add(this.labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(5, 15, 0, 15), 0, 0));
		add(this.labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 15, 0, 15), 0, 0));
		add(this.labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 15, 0, 15), 0, 0));
		add(this.labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0D, 0.0D, 17, 0, new Insets(0, 15, 5, 15), 0, 0));
	}
}
