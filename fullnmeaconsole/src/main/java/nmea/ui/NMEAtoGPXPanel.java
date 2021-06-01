package nmea.ui;

import coreutilities.Utilities;
import utils.NMEAtoGPX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NMEAtoGPXPanel
        extends JPanel {
    @SuppressWarnings("compatibility:-469133995607650775")
    public final static long serialVersionUID = 1L;

    private GridBagLayout layout = new GridBagLayout();
    private JLabel fileInLabel = new JLabel();
    private JLabel fileOutLabel = new JLabel();
    private JTextField fileInTextField = new JTextField();
    private JTextField fileOutTextField = new JTextField();
    private JButton browseFileInButton = new JButton();
    private JButton browseFileOutButton = new JButton();
    private JButton txButton = new JButton();

    public NMEAtoGPXPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit()
            throws Exception {
        this.setLayout(layout);
        setSize(new Dimension(450, 280));
        fileInLabel.setText("Log file Name:");
        fileOutLabel.setText("GPX file Name:");
        fileInTextField.setPreferredSize(new Dimension(200, 19));
        fileOutTextField.setPreferredSize(new Dimension(200, 19));
        browseFileInButton.setText("...");
        browseFileInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browseFileInButton_actionPerformed(e);
            }
        });
        browseFileOutButton.setText("...");
        browseFileOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browseFileOutButton_actionPerformed(e);
            }
        });
        txButton.setText("Transform");
        txButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txButton_actionPerformed(e);
            }
        });
        this.add(fileInLabel,
                new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(fileOutLabel,
                new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(fileInTextField,
                new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(fileOutTextField,
                new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(browseFileInButton,
                new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(browseFileOutButton,
                new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
        this.add(txButton,
                new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(10, 0, 0, 0), 0, 0));
    }

    private void browseFileInButton_actionPerformed(ActionEvent e) {
        String fileIn = Utilities.chooseFile(JFileChooser.FILES_ONLY, "nmea", "NMEA Log-Files", "Choose the logged data file", "Select");
        if (fileIn.trim().length() > 0)
            fileInTextField.setText(fileIn);
    }

    private void browseFileOutButton_actionPerformed(ActionEvent e) {
        String fileOut = Utilities.chooseFile(JFileChooser.FILES_ONLY, "gpx", "GPX files", "Choose the GPX file to create", "Create");
        if (fileOut.trim().length() > 0)
            fileOutTextField.setText(fileOut);
    }

    private void txButton_actionPerformed(ActionEvent e) {
        String fIn = fileInTextField.getText();
        String fOut = fileOutTextField.getText();
        txButton.setEnabled(false);
        try {
            NMEAtoGPX.transform(fIn, fOut);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        txButton.setEnabled(true);
        JOptionPane.showMessageDialog(this, "GPX File is ready", "NMEA to GPX", JOptionPane.INFORMATION_MESSAGE);
    }
}
