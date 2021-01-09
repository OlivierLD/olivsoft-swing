package dnd.gui;

import coreutilities.sql.SQLUtil;
import dnd.gui.ctx.AppContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;

public class MainGUI {
	public static final String SERVER_DB = "server.db";
	public static final String FILE_DB = "file.db";

	public MainGUI() {
		String dbLocation = System.getProperty("db.location", "." + File.separator + "db");
		String dbFlavor = System.getProperty("db.flavor", "file.db");
		String dbURL = System.getProperty("db.url", "//localhost:2345/images");

		try {
			Connection conn;
			if (dbFlavor.equals("file.db")) {
				conn = SQLUtil.getConnection(dbLocation, "IMAGES", "images", "images");
			} else {
				conn = SQLUtil.getServerConnection(dbURL, "images", "images");
			}
			AppContext.getInstance().setConn(conn);
		} catch (Exception ex) {
			System.err.println("From " + System.getProperty("user.dir"));
			ex.printStackTrace();
		}
		JFrame frame = new MainFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				AppContext.getInstance().closeConnection();
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}

	public static void main(String... args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainGUI();
	}
}
