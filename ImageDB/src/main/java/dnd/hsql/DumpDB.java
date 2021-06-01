package dnd.hsql;

import coreutilities.sql.SQLUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * For migration to SQLite
 */
public class DumpDB {
	public static void main(String... args)
			throws Exception {
		Connection conn = SQLUtil.getConnection("." + File.separator + "db", "IMAGES", "images", "images");

		try {
			dumpDB(conn, "./dump");

//			insertNewImage(conn, "." + File.separator + "img" + File.separator + "PA080038.JPG", new String[] {"Corine", "Olivier", "en mer", "1ere etape"});
//			insertNewImage(conn, "." + File.separator + "img" + File.separator + "PB180647.JPG", new String[] {"Olivier", "Banian", "Nuku-Hiva"});
//			insertNewImage(conn, "." + File.separator + "img" + File.separator + "PB300770.JPG", new String[] {"Corine", "Rangiroa", "Tiare"});

			conn.close();
			conn = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	private static void dumpDB(Connection conn,
							   String folderName) throws Exception {
		File dir = new File(folderName);
		if (!dir.exists()) {
			boolean created = dir.mkdirs();
			if (created) {
				System.out.printf("%s was created\n", folderName);
			} else {
				System.out.printf("%s was NOT created\n", folderName);
				System.exit(1);
			}
		}
		BufferedWriter csv = new BufferedWriter(new FileWriter(String.format("%s%sdump.csv", folderName, File.separator)));

		// We assume that img_types is already created and populated
		try {
			// Images
			String stmt = "select name, imagetype, width, height, created, image from images";
			//                    1     2          3      4       5        6
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(stmt);
			while (rs.next()) {
				String name = rs.getString(1);
				String type = rs.getString(2);
				int w = rs.getInt(3);
				int h = rs.getInt(4);
				java.sql.Date cr = rs.getDate(5);
				byte[] imgData = rs.getBytes(6);
				String imageLine = String.format("IMAGE;%s;%d;%d;%s;%s\n", name, w , h, type, cr.toString());
				csv.write(imageLine);

				BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
				FileOutputStream fos = new FileOutputStream(folderName + File.separator + name);
				ImageIO.write(image, type, fos);
				fos.close();

				// Tags
				String tagStmt = "select rnk, label from tags where imgname = ? order by rnk";
				PreparedStatement pStmt = conn.prepareStatement(tagStmt);
				pStmt.setString(1, name);
				ResultSet tagRs = pStmt.executeQuery();
				while (tagRs.next()) {
					int rnk = tagRs.getInt(1);
					String label = tagRs.getString(2);
					String tagLine = String.format("TAG;%d;%s\n", rnk, label);
					csv.write(tagLine);
				}
				tagRs.close();
				pStmt.close();

				csv.flush();

//				break; // On first one
			}
			rs.close();
			statement.close();
		} catch (Exception ex) {
			throw ex;
		}
		csv.flush();
		csv.close();
	}
}
