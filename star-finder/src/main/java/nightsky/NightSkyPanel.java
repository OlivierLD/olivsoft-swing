package nightsky;


import astro.calc.GeoPoint;
import images.Images;
import nauticalalmanac.Anomalies;
import nauticalalmanac.Context;
import nauticalalmanac.Core;
import nauticalalmanac.Jupiter;
import nauticalalmanac.Mars;
import nauticalalmanac.Moon;
import nauticalalmanac.Saturn;
import nauticalalmanac.Star;
import nauticalalmanac.Venus;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * This reproduces the Star Finder (2102-D)
 * or a Sky Chart like Sirius.
 */
public class NightSkyPanel extends JPanel {
	public final static long serialVersionUID = 1L;

	protected double observerLatitude = 35D; // Default, Boulder = 40 N
	protected double lhaAries = 0D;

	private final static boolean GLOSSY_DISPLAY = true;
	private final static boolean WITH_TEXTURE = true;

	public final static int NORTH_HEMISPHERE = 1;
	public final static int SOUTH_HEMISPHERE = -1;

	protected int hemisphere = NORTH_HEMISPHERE;

	public final static int STAR_FINDER_OPTION = 0;
	public final static int SKY_CHART_OPTION = 1;

	private boolean showFullGrid = true;

	protected int displayOption = STAR_FINDER_OPTION;

	protected boolean forPrint = "true".equals(System.getProperty("for.print", "false"));

	protected Color HOURSCALE_COLOR_FOR_PRINT = Color.white;
	protected Color HOURSCALE_COLOR_FOR_NO_PRINT = Color.cyan;
	protected Color SKY_GRID_COLOR_FOR_PRINT = Color.black;
	protected Color SKY_GRID_COLOR_FOR_NO_PRINT = Color.blue;
	protected Color AXIS_COLOR_FOR_PRINT = Color.black;
	protected Color AXIS_COLOR_FOR_NO_PRINT = Color.blue;
	protected Color BG_COLOR_FOR_PRINT = new Color(0, 0, 25); // Color.black; // darkGray;
	protected Color BG_COLOR_FOR_NO_PRINT = Color.black;
	protected Color NUMERIC_DATA_COLOR_WITH_TEXTURE = Color.white;
	protected Color NUMERIC_DATA_COLOR_WITH_NO_TEXTURE = Color.white;
	protected Color CELEST_SPHERE_GRID_COLOR = Color.gray;
	protected Color STAR_NAME_COLOR_FOR_PRINT = Color.white;
	protected Color STAR_NAME_COLOR_FOR_NO_PRINT = Color.black;
	protected Color TOP_DISC_BG_FOR_PRINT = new Color(0, 0, 50); // Color.darkGray;
	protected Color TOP_DISC_BG_FOR_NO_PRINT = Color.white;
	protected Color STAR_COLOR_FOR_PRINT = Color.yellow;
	protected Color STAR_COLOR_FOR_NO_PRINT = Color.orange;
	protected Color EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT = Color.white;
	protected Color EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT = Color.black;
	protected Color CARDINAL_POINT_COLOR_FOR_PRINT = Color.yellow;
	protected Color CARDINAL_POINT_COLOR_FOR_NO_PRINT = Color.red;

	protected boolean withStars = true;
	protected boolean withStarNames = true;
	protected boolean withConstellations = true;
	protected boolean withConstellationNames = true;
	protected boolean withVisibleSky = true;
	protected boolean withCelestSphere = true;
	protected boolean withWanderingBodies = false;

	protected boolean withTexture = (forPrint ? false : WITH_TEXTURE);
	protected boolean glossy = (forPrint ? false : GLOSSY_DISPLAY);

	private transient Image moonSymbol = new ImageIcon(Images.class.getResource("moon.png")).getImage();
	private transient Image sunSymbol = new ImageIcon(Images.class.getResource("sun.png")).getImage();
	private transient Image venusSymbol = new ImageIcon(Images.class.getResource("venus.png")).getImage();
	private transient Image marsSymbol = new ImageIcon(Images.class.getResource("mars.png")).getImage();
	private transient Image jupiterSymbol = new ImageIcon(Images.class.getResource("jupiter.png")).getImage();
	private transient Image saturnSymbol = new ImageIcon(Images.class.getResource("saturn.png")).getImage();

	public void setWithStars(boolean withStars) {
		this.withStars = withStars;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithStarNames(boolean withStarNames) {
		this.withStarNames = withStarNames;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithConstellations(boolean withConstellations) {
		this.withConstellations = withConstellations;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithConstellationNames(boolean withConstellationNames) {
		this.withConstellationNames = withConstellationNames;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithVisibleSky(boolean withVisibleSky) {
		this.withVisibleSky = withVisibleSky;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithCelestSphere(boolean withCelestSphere) {
		this.withCelestSphere = withCelestSphere;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithWanderingBodies(boolean withWanderingBodies) {
		this.withWanderingBodies = withWanderingBodies;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setWithTexture(boolean withTexture) {
		this.withTexture = withTexture;
	}

	public void setGlossy(boolean glossy) {
		this.glossy = glossy;
	}

	private enum Month {
		JANUARY("January", 31),
		FEBRUARY("February", 28), // Hard coded, no leap year.
		MARCH("March", 31),
		APRIL("April", 30),
		MAY("May", 31),
		JUNE("June", 30),
		JULY("July", 31),
		AUGUST("August", 31),
		SEPTEMBER("September", 30),
		OCTOBER("October", 31),
		NOVEMBER("November", 30),
		DECEMBER("December", 31);

		private final String mname;
		private final int nbDays;

		public final static long serialVersionUID = 1L;

		Month(String name, int days) {
			this.mname = name;
			this.nbDays = days;
		}

		public String mname() {
			return mname;
		}

		public int nbDays() {
			return nbDays;
		}
	}

	private final static double EXTERNAL_RADIUS_COEFF = 1.050;
	private final static double INTERNAL_RADIUS_COEFF = 1.025;

	private final static DecimalFormat HF = new DecimalFormat("00");

	public NightSkyPanel() {
		this(STAR_FINDER_OPTION);
	}

	public NightSkyPanel(int option) {
		if (option != STAR_FINDER_OPTION && option != SKY_CHART_OPTION) {
			throw new RuntimeException("Unknown Option");
		}
		this.displayOption = option;
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.setLayout(null);
//  this.setBackground(new Color(255, 165, 165));
	}

	private static void drawGlossyCircularDisplay(Graphics2D g2d, Point center, int radius, Color lightColor, Color darkColor, float transparency) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
		g2d.setPaint(null);

		g2d.setColor(darkColor);
		g2d.fillOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);

		Point gradientOrigin = new Point(center.x - radius,
				center.y - radius);
		GradientPaint gradient = new GradientPaint(gradientOrigin.x,
				gradientOrigin.y,
				lightColor,
				gradientOrigin.x,
				gradientOrigin.y + (2 * radius / 3),
				darkColor); // vertical, light on top
		g2d.setPaint(gradient);
		g2d.fillOval((int) (center.x - (radius * 0.90)),
				(int) (center.y - (radius * 0.95)),
				(int) (2 * radius * 0.9),
				(int) (2 * radius * 0.95));
	}

	public void setLatitude(double d) {
		this.observerLatitude = d * hemisphere;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setLHAAries(double d) {
		this.lhaAries = d;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setHemisphere(int h) {
		if (h != NORTH_HEMISPHERE && h != SOUTH_HEMISPHERE) {
			throw new RuntimeException("What kind of hemisphere is that?");
		}
		if (hemisphere != h) {
			hemisphere = h;
			observerLatitude *= -1;
		}
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setObserverLatitude(double d) {
		if (d < 0) {
			hemisphere = SOUTH_HEMISPHERE;
		} else {
			hemisphere = NORTH_HEMISPHERE;
		}
		observerLatitude = d;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected transient Stroke thick = new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
	protected transient Stroke dotted = new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{1f, 10f}, 0f);
	protected transient Stroke origStroke = null;

	protected int radius = 0;
	protected Point center = null;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.setBackground(forPrint ? BG_COLOR_FOR_PRINT : BG_COLOR_FOR_NO_PRINT);
//  g.setColor(Color.white);
//  g.fillRect(0, 0, this.getWidth(), this.getHeight());

		radius = Math.min(this.getWidth(), this.getHeight()) / 2;
		center = new Point(this.getWidth() / 2, this.getHeight() / 2);

		// For the scale and shadow:
		radius *= 0.8; // 0.9;

//  g.setColor(Color.lightGray);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		origStroke = g2d.getStroke();

		if (withTexture) {
			ImageIcon bgImage = new ImageIcon(Images.class.getResource("carbon.fiber.1280x800.png"));
			g2d.drawImage(bgImage.getImage(), 0, 0, null); // , bgImage.getIconWidth(), bgImage.getIconHeight());
//    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
		}

		if (glossy) {
			Color bgColor = this.getBackground();
			if (withTexture) {
				bgColor = new Color(bgColor.getRed(),
						bgColor.getGreen(),
						bgColor.getBlue(),
						10); // transparent
			}
			// Shaded bevel
			RadialGradientPaint rgp = new RadialGradientPaint(center,
					(int) (radius * 1.15) + 15,
					new float[]{0f, 0.85f, 1f},
					new Color[]{bgColor, Color.black, bgColor});
			g2d.setPaint(rgp);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			// White disc scale
			g2d.setColor(Color.white);
			int extRadius = (int) (radius * EXTERNAL_RADIUS_COEFF) + 15; // 10 is the font size, for the months (in case of map)
			g2d.fillOval(center.x - extRadius, center.y - extRadius, 2 * extRadius, 2 * extRadius);
			// Glossy Display
			drawGlossyCircularDisplay(g2d, center, radius, Color.lightGray, Color.darkGray, 1f);
		}

		if (withVisibleSky) {
			drawSky(g2d);            // Visible sky, with or without full grid
		}
		if (withCelestSphere) {
			drawGrid(g2d);           // Full grid, for both hemispheres
		}
		Font f = g2d.getFont();
		if (forPrint) {
			g2d.setFont(f.deriveFont(Font.BOLD, 12f));
		}
		drawStars(g2d);            // Stars
		g2d.setStroke(origStroke);
		g2d.setFont(f);

		drawConstellations(g2d); // Constellations, blank (do nothing)( by default.

		if (withWanderingBodies) {
			drawWanderingBodies(g2d);
		}
		drawNumericData(g2d);
	}

	private void drawWanderingBodies(Graphics2D g2d) {
		// Calculate current almanac
		Calendar now = GregorianCalendar.getInstance();
		now.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		calculate(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH) + 1,
				now.get(Calendar.DAY_OF_MONTH),
				now.get(Calendar.HOUR_OF_DAY),
				now.get(Calendar.MINUTE),
				now.get(Calendar.SECOND));

		// Plot
//  System.out.println("GHA Aries:" + Context.GHAAtrue);
		plotBody(g2d, "Sun", Context.DECsun, Context.GHAsun - Context.GHAAtrue, sunSymbol);
		plotBody(g2d, "Moon", Context.DECmoon, Context.GHAmoon - Context.GHAAtrue, moonSymbol);
		plotBody(g2d, "Venus", Context.DECvenus, Context.GHAvenus - Context.GHAAtrue, venusSymbol);
		plotBody(g2d, "Mars", Context.DECmars, Context.GHAmars - Context.GHAAtrue, marsSymbol);
		plotBody(g2d, "Jupiter", Context.DECjupiter, Context.GHAjupiter - Context.GHAAtrue, jupiterSymbol);
		plotBody(g2d, "Saturn", Context.DECsaturn, Context.GHAsaturn - Context.GHAAtrue, saturnSymbol);
	}

	private void plotBody(Graphics gr, String name, double decl, double ra) {
		plotBody(gr, name, decl, ra, null);
	}

	private void plotBody(Graphics gr, String name, double decl, double gha, Image img) {
		double lng = gha;
		lng += lhaAries;
		if (lng > 180) {
			lng -= 360;
		}
//  if ("Sun".equals(name))
//    System.out.println("Plotting " + name + ": GHA=" + gha + ", D=" + decl + ", G:" + lng);
		double D = decl * hemisphere;
		Point pt = plotCoordinates(gr, D, lng, center, radius);
		if (img == null) {
			gr.fillOval(pt.x - 2, pt.y - 2, 4, 4);
			gr.drawString(name, pt.x + 2, pt.y);
		} else {
			boolean gloss = true;
			if (gloss) {
				int radius = 10;
				Graphics2D g2d = (Graphics2D) gr;
				Point center = pt;
				boolean shadow = false;
				if (shadow) {
					Color bgColor = this.getBackground();
					Point shadowCenter = new Point((center.x + (radius / 3)), (center.y + (radius / 3)));
					RadialGradientPaint rgp = new RadialGradientPaint(shadowCenter,
							(int) (radius * 1.0),
							new float[]{0f, 0.9f, 1f},
							new Color[]{Color.white, Color.gray, bgColor});
					g2d.setPaint(rgp);
					g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
				}
				Color lightColor = Color.lightGray;
				Color darkColor = Color.gray;
				drawGlossyCircularBall(g2d, center, radius, lightColor, darkColor, 1f);

				gr.drawImage(img, pt.x - 7, pt.y - 7, null); // Image is 13x13
			} else {
				gr.fillOval(pt.x - 8, pt.y - 8, 16, 16);
				gr.drawImage(img, pt.x - 7, pt.y - 7, null); // Image is 13x13
			}
		}
	}

	private static void drawGlossyCircularBall(Graphics2D g2d, Point center, int radius, Color lightColor, Color darkColor, float transparency) {
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
		g2d.setPaint(null);

		g2d.setColor(darkColor);
		g2d.fillOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);

		Point gradientOrigin = new Point(center.x - radius, center.y - radius);
		GradientPaint gradient = new GradientPaint(gradientOrigin.x,
				gradientOrigin.y,
				lightColor,
				gradientOrigin.x,
				gradientOrigin.y + (2 * radius / 3),
				darkColor); // vertical, light on top
		g2d.setPaint(gradient);
		g2d.fillOval((int) (center.x - (radius * 0.90)),
				(int) (center.y - (radius * 0.95)),
				(int) (2 * radius * 0.9),
				(int) (2 * radius * 0.95));
	}

	private void drawNumericData(Graphics2D g2d) {
//  System.out.println("drawNumericData " + lhaAries + " " + observerLatitude);
		g2d.setColor(withTexture ? NUMERIC_DATA_COLOR_WITH_TEXTURE : NUMERIC_DATA_COLOR_WITH_NO_TEXTURE);

		if (withVisibleSky) {
			g2d.drawString("Latitude  " + Integer.toString((int) Math.abs(observerLatitude)) + "\272" + (observerLatitude < 0 ? "S" : "N"), 5, 15);
		}
		if (withCelestSphere && !forPrint) {
			int lha = (int) lhaAries;
			if (lha == 360) lha = 0;
			g2d.drawString("LHA Aries " + Integer.toString((lha < 0 ? 360 + lha : lha)) + "\272", 5, 30);
		}
	}

	/**
	 * The big disc of the star finder or Sky Map
	 *
	 * @param g2d
	 */
	private void drawGrid(Graphics2D g2d) {
		g2d.setColor(CELEST_SPHERE_GRID_COLOR);
		g2d.setStroke(thick);
		// Center
		g2d.fillOval(center.x - 2, center.y - 2, 4, 4);
		// Equateur celeste
		g2d.drawOval(center.x - (radius / 2), center.y - (radius / 2), radius, radius);
		// Pole abaiss�
		g2d.drawOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
		// Horizontal axis
		g2d.drawLine(0, center.y, this.getWidth(), center.y);

		// Scale, on the edge
		g2d.setStroke(origStroke);
		int externalScaleRadius = (int) (radius * EXTERNAL_RADIUS_COEFF);
		int internalScaleRadius = (int) (radius * INTERNAL_RADIUS_COEFF);
		g2d.setColor(forPrint ? EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT : EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT);
		g2d.drawOval(center.x - externalScaleRadius, center.y - externalScaleRadius, 2 * externalScaleRadius, 2 * externalScaleRadius);
		if (displayOption == STAR_FINDER_OPTION) {
			for (int d = 0; d <= 360; d += 1) {
				int scaleRadius = internalScaleRadius;
				if (d % 5 == 0) {
					scaleRadius = externalScaleRadius;
				}
				int fromX = center.x + (int) (radius * Math.sin(Math.toRadians((d - this.lhaAries) * hemisphere)));
				int fromY = center.y + (int) (radius * Math.cos(Math.toRadians((d - this.lhaAries) * hemisphere)));
				int toX = center.x + (int) (scaleRadius * Math.sin(Math.toRadians((d - this.lhaAries) * hemisphere)));
				int toY = center.y + (int) (scaleRadius * Math.cos(Math.toRadians((d - this.lhaAries) * hemisphere)));
				g2d.drawLine(fromX, fromY, toX, toY);
				if (d % 10 == 0 && d != 360) {
					String str = Integer.toString(d) + "\272";
					int strWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
					Color c = g2d.getColor();
					g2d.setColor(forPrint ? EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT : EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT);
					g2d.rotate(Math.toRadians((d - this.lhaAries) * -hemisphere), center.x, center.y);
					g2d.drawString(str, center.x - (strWidth / 2), center.y + internalScaleRadius + (g2d.getFont().getSize() / 2));
					g2d.rotate(Math.toRadians((d - this.lhaAries) * -hemisphere) * -1, center.x, center.y);
					g2d.setColor(c);
				}
			}
		}
		if (displayOption == SKY_CHART_OPTION) {
			g2d.setColor(forPrint ? EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT : EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT);
			// 0 is 21 Septembre
			for (int day = 1; day <= 365; day += 1) {
				findCorrespondingDay(day);
//      System.out.println("month:" + month.name() + ", dayOfMonth:" + dayOfMonth);
				double d = 360 * (day - 1) / 365d; // The angle on the circle
				int scaleRadius = internalScaleRadius;
				Color c = g2d.getColor();
				if (dayOfMonth == 1) {
					scaleRadius = externalScaleRadius;
				}
				int fromX = center.x + (int) (radius * Math.sin(Math.toRadians((d - this.lhaAries) * -hemisphere)));
				int fromY = center.y + (int) (radius * Math.cos(Math.toRadians((d - this.lhaAries) * -hemisphere)));
				int toX = center.x + (int) (scaleRadius * Math.sin(Math.toRadians((d - this.lhaAries) * -hemisphere)));
				int toY = center.y + (int) (scaleRadius * Math.cos(Math.toRadians((d - this.lhaAries) * -hemisphere)));
				g2d.drawLine(fromX, fromY, toX, toY);
				g2d.setColor(c);
				if (dayOfMonth % 5 == 0) // Print the day #
				{
					String str = Integer.toString(dayOfMonth);
					int strWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
					c = g2d.getColor();
					g2d.setColor(forPrint ? EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT : EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT);
					g2d.rotate(Math.toRadians((d - this.lhaAries) * hemisphere), center.x, center.y);
					g2d.drawString(str, center.x - (strWidth / 2), center.y + internalScaleRadius + (g2d.getFont().getSize() / 2));
					g2d.rotate(Math.toRadians((d - this.lhaAries) * hemisphere) * -1, center.x, center.y);
					g2d.setColor(c);
				}
				if (dayOfMonth == (month.nbDays() / 2)) // Print the month name
				{
					String str = month.mname();
					//    System.out.println("Printing " + str);
					int strWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
					c = g2d.getColor();
					g2d.setColor(forPrint ? EXTERNAL_SCALE_DIGIT_COLOR_FOR_PRINT : EXTERNAL_SCALE_DIGIT_COLOR_FOR_NO_PRINT);
					g2d.rotate(Math.toRadians((d - this.lhaAries) * hemisphere), center.x, center.y);
					g2d.drawString(str, center.x - (strWidth / 2), center.y + externalScaleRadius + g2d.getFont().getSize() + 2);
					g2d.rotate(Math.toRadians((d - this.lhaAries) * hemisphere) * -1, center.x, center.y);
					g2d.setColor(c);
				}
			}
//      // Hour scale
//      g2d.setStroke(thick);
//      Font f = g2d.getFont();
//      Color c = g2d.getColor();
//      g2d.setColor(Color.cyan);
//      g2d.setFont(f.deriveFont(Font.BOLD));
//      int scaleRadius = (int)(radius / INTERNAL_RADIUS_COEFF);
//      int upTo = 24; // 12
//      for (int h=0; false && h<=upTo; h++)
//      {
//        // 0: 18h
//        int hour = (h + 18) % 24;
////      System.out.println("Hour:" + hour);
//        double d = (h - 6) * 15;
//        int fromX = center.x + (int)(radius * Math.sin(Math.toRadians((d) * hemisphere)));
//        int fromY = center.y + (int)(radius * Math.cos(Math.toRadians((d) * hemisphere)));
//        int toX   = center.x + (int)(scaleRadius * Math.sin(Math.toRadians((d) * hemisphere)));
//        int toY   = center.y + (int)(scaleRadius * Math.cos(Math.toRadians((d) * hemisphere)));
//        g2d.drawLine(fromX, fromY, toX, toY);
//        String str = HF.format(hour);
//        int strWidth  = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
//        g2d.rotate(Math.toRadians(d * -hemisphere), center.x, center.y);
//        g2d.drawString(str, center.x - (strWidth / 2), center.y + scaleRadius - 6);
//        g2d.rotate(Math.toRadians(d * -hemisphere) * -1, center.x, center.y);
//      }
//      g2d.setColor(c);
//      g2d.setFont(f);
//      g2d.setStroke(origStroke);
		}
		g2d.setStroke(dotted);
		for (int i = -80; i < 90; i += 10) {
			if (i == 0) {
				continue;
			}
			int r = (int) Math.round(((double) (radius / 2)) * ((90 - i) / 90d));
			g2d.drawOval(center.x - r, center.y - r, 2 * r, 2 * r);
		}
	}

	/**
	 * The blue part of the Star Finder or SkyMap.
	 * Visible Sky, "transparent" part of the device.
	 *
	 * @param g2d
	 */
	private void drawSky(Graphics2D g2d) {
		GradientPaint gradient = new GradientPaint(0, 0, Color.gray, this.getWidth(), this.getHeight(), Color.darkGray); // Diagonal
		GeoPoint observer = new GeoPoint(observerLatitude, 0D);
		// Build horizon
		Polygon horizon = new Polygon();
		for (double z = 0; z <= 360; z += 0.25) {
			double _z = -z; // (z + 180) % 360;
			GeoPoint dr = deadReckoning(observer, 90 * 60, _z);
			//System.out.println(Integer.toString(i) + "\272 => " + dr.toString());
			Point p = plotCoordinates(g2d, dr.getL() * hemisphere, dr.getG(), center, radius, Double.toString(_z));
			horizon.addPoint(p.x, p.y);
		}
//  g2d.setColor(Color.gray);
		if (glossy) {
			g2d.setPaint(gradient);
		}
		// g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .75f));

		if (!glossy) {
			g2d.setColor(forPrint ? TOP_DISC_BG_FOR_PRINT : TOP_DISC_BG_FOR_NO_PRINT);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		g2d.setColor(Color.white); // For the visible sky
		g2d.fillPolygon(horizon);
//  g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		g2d.setColor(forPrint ? SKY_GRID_COLOR_FOR_PRINT : SKY_GRID_COLOR_FOR_NO_PRINT);
		// Zenith
		// Radius = 180 degrees. 0=Equateur center - (radius / 2), 90:center - 0
		int zenith = (int) Math.round(((double) (radius / 2)) * ((90 - observerLatitude * hemisphere) / 90d));
		if (displayOption == SKY_CHART_OPTION) {
			zenith *= -1;
		}
		Point zenithPt = new Point(center.x, center.y + zenith);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g2d.fillOval(zenithPt.x - 2, zenithPt.y - 2, 4, 4);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
		g2d.setStroke(origStroke);
		// Altitudes
		for (int dz = 10; dz <= 90; dz += 10) {
			if (dz == 90) // Horizon
				g2d.setStroke(thick);
			//  else
			//    g2d.setStroke(dotted);
			Point previous = null;
			for (double z = 0; z <= 360; z += 0.25) {
				if (false && !showFullGrid && dz == 90) {
					continue;
				}

				double _z = -z; // (z + 180) % 360;
				GeoPoint dr = deadReckoning(observer, dz * 60, _z);
				//  System.out.println(Integer.toString(i) + "\272 => " + dr.toString());
				Point p = plotCoordinates(g2d, dr.getL() * hemisphere, dr.getG(), center, radius, Double.toString(z));
				if (dz == 90) {
					if (false && z % 10 == 0) {
						g2d.drawString(Double.toString(z), p.x + 3, p.y - 3);
					}
					if (z % 90 == 0) {
						Font f = g2d.getFont();
						g2d.setFont(f.deriveFont(Font.BOLD)); // Cardinal Point
						Color c = g2d.getColor();
						g2d.setColor(forPrint ? CARDINAL_POINT_COLOR_FOR_PRINT : CARDINAL_POINT_COLOR_FOR_NO_PRINT);
						g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
						//        g2d.fillOval(p.x - 3, p.y - 3, 6, 6);
						//     if (hemisphere == NORTH_HEMISPHERE)
						{
							if (z == 0) {
								g2d.drawString("N", p.x - 5, p.y + (hemisphere == NORTH_HEMISPHERE ? 14 : -8));
							} else if (z == 180) {
								g2d.drawString("S", p.x - 5, p.y + (hemisphere == NORTH_HEMISPHERE ? -8 : 14));
							} else if (z == 90) {
								g2d.drawString("E", p.x + (hemisphere == NORTH_HEMISPHERE ? 4 : -12), p.y + 12);
							} else if (z == 270) {
								g2d.drawString("W", p.x + (hemisphere == NORTH_HEMISPHERE ? -12 : 4), p.y + 12);
							}
						}
						//   else if (hemisphere == SOUTH_HEMISPHERE)
						//   {
						//     if (z == 0)
						//       g2d.drawString("N", p.x - 5, p.y + 10);
						//     else if (z == 180)
						//       g2d.drawString("S", p.x - 5, p.y - 3);
						//     else if (z == 90)
						//       g2d.drawString("W", p.x + 3, p.y);
						//     else if (z == 270)
						//       g2d.drawString("E", p.x - 10, p.y);
						//   }
						g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f));
						g2d.setColor(c);
						g2d.setFont(f);
					}
				}
				if (previous != null) {
					g2d.drawLine(previous.x, previous.y, p.x, p.y);
				}
				previous = p;
			}
		}
		g2d.setStroke(origStroke);
		// Azimuth
		for (int z = 0; z < 360; z += 5) {
			Point previous = null;
			if (z % 90 == 0) {
				g2d.setStroke(thick);
			} else {
				g2d.setStroke(origStroke);
			}
			if (!showFullGrid && z % 90 != 0)
				continue;

			for (int dz = 10; dz <= 90; dz += 1) {
				GeoPoint dr = deadReckoning(observer, dz * 60, z);
				Point p = plotCoordinates(g2d, dr.getL() * hemisphere, dr.getG(), center, radius, Integer.toString(z));
				if (previous != null) {
					g2d.drawLine(previous.x, previous.y, p.x, p.y);
				}
				previous = p;
			}
		}
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

		if (displayOption == STAR_FINDER_OPTION) { // Downward arrow
			g2d.drawLine(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2, this.getHeight());
		}
		if (displayOption == SKY_CHART_OPTION) {  // Index
			g2d.setStroke(thick);
			int externalScaleRadius = (int) (radius * EXTERNAL_RADIUS_COEFF);
			g2d.drawLine(this.getWidth() / 2,
					center.y + radius - 5,
					this.getWidth() / 2,
					center.y + externalScaleRadius + 5);
			g2d.setStroke(origStroke);
		}
		// Plot the center (axis)
		g2d.setColor(forPrint ? AXIS_COLOR_FOR_PRINT : AXIS_COLOR_FOR_NO_PRINT);
		g2d.fillOval(center.x - 2, center.y - 2, 4, 4);

		// Hour scale
		g2d.setStroke(thick);
		Font f = g2d.getFont();
		Color c = g2d.getColor();
		g2d.setColor(forPrint ? HOURSCALE_COLOR_FOR_PRINT : HOURSCALE_COLOR_FOR_NO_PRINT); // Hour scale color
		g2d.setFont(f.deriveFont(Font.BOLD)); // hours for the sky map
		int scaleRadius = (int) (radius / INTERNAL_RADIUS_COEFF);
		int upTo = 24; // 12
		for (double h = 0; withVisibleSky && h <= upTo; h += 0.25) {
			// 0: 18h
			double hour = (h + 18) % 24;
			//      System.out.println("Hour:" + hour);
			double d = (h - 6) * 15;
			if (h == (int) h) {
				g2d.setStroke(thick);
			} else {
				g2d.setStroke(origStroke);
			}
			int fromX = center.x + (int) (radius * Math.sin(Math.toRadians((d) * hemisphere)));
			int fromY = center.y + (int) (radius * Math.cos(Math.toRadians((d) * hemisphere)));
			int toX = center.x + (int) (scaleRadius * Math.sin(Math.toRadians((d) * hemisphere)));
			int toY = center.y + (int) (scaleRadius * Math.cos(Math.toRadians((d) * hemisphere)));
			g2d.drawLine(fromX, fromY, toX, toY);
			if (h == (int) h) {
				String str = HF.format(hour);
				int strWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
				g2d.rotate(Math.toRadians(d * -hemisphere), center.x, center.y);
				g2d.drawString(str, center.x - (strWidth / 2), center.y + scaleRadius - 6);
				g2d.rotate(Math.toRadians(d * -hemisphere) * -1, center.x, center.y);
			}
		}
		// Circle around
		g2d.drawOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);

		g2d.setColor(c);
		g2d.setFont(f);
		g2d.setStroke(origStroke);
	}

	private boolean rotateStarNames = true;

	private void drawStars(Graphics2D g2d) {
		if (!withStars && !withStarNames) {
			return;
		}
//  g2d.setColor(Color.black);
		for (Star star : Star.getCatalog()) {
			double dec = star.getDec() * hemisphere;
			double ra = star.getRa(); // * hemisphere;
			double lng = 360 - (ra * 360d / 24d);
//    if ("Spica".equals(star.getStarName()))
//      System.out.println(star.getStarName() + ":RA=" + ra + ", G=" + lng);

			lng += lhaAries;
			if (lng > 180) {
				lng -= 360;
			}
			Point p = plotCoordinates(g2d, dec, lng, center, radius, star.getStarName());
			if (withStars) {
				g2d.setColor(forPrint ? STAR_COLOR_FOR_PRINT : STAR_COLOR_FOR_NO_PRINT);
				g2d.fillOval(p.x - 3, p.y - 3, 6, 6);
				g2d.setColor(Color.black);
				g2d.drawOval(p.x - 3, p.y - 3, 6, 6);
			}
			if (withStarNames) {
				Color c = g2d.getColor();
				g2d.setColor(forPrint ? STAR_NAME_COLOR_FOR_PRINT : STAR_NAME_COLOR_FOR_NO_PRINT); // Name Font Color
				if (rotateStarNames) {
					String str = star.getStarName();
					int strWidth = g2d.getFontMetrics(g2d.getFont()).stringWidth(str);
					if (displayOption == SKY_CHART_OPTION) {
						g2d.rotate(Math.toRadians(lng * -hemisphere), center.x, center.y);
					} else {
						g2d.rotate(Math.toRadians(lng * hemisphere), center.x, center.y);
					}
					double rayon = (((90D - dec) / 180d) * (double) radius);
					int yOffset = (int) rayon; // (Math.round(rayon * Math.cos(Math.toRadians(_lng))));
					if (displayOption == SKY_CHART_OPTION) {
						yOffset *= -1;
					}
					g2d.drawString(str, center.x - (strWidth / 2), center.y + yOffset - 4); // Star name
					if (displayOption == SKY_CHART_OPTION) {
						g2d.rotate(Math.toRadians(lng * -hemisphere) * -1, center.x, center.y);
					} else {
						g2d.rotate(Math.toRadians(lng * hemisphere) * -1, center.x, center.y);
					}
				} else {
					g2d.drawString(star.getStarName(), p.x + 3, p.y - 3);
				}
				g2d.setColor(c);
			}
		}
	}

	/**
	 * That one to be overriden
	 *
	 * @param g2d
	 */
	protected void drawConstellations(Graphics2D g2d) {
	}

	private static double deltaT = 66.4749d; // 2011. Overridden by deltaT system variable.

	public static synchronized void calculate(int year,
	                                          int mon /* starts with 1 (Jan) */,
	                                          int day,
	                                          int hour,
	                                          int minute,
	                                          int second) {
//  System.out.println("Almanac Computation " + year + "/" + mon + "/" + day + " " + hour + ":" + minute + ":" + second);
		deltaT = Double.parseDouble(System.getProperty("deltaT", Double.toString(deltaT)));
		Core.julianDate(year, mon, day, hour, minute, second, deltaT);
		Anomalies.nutation();
		Anomalies.aberration();

		Core.aries();
		Core.sun();
		Moon.compute();
		Venus.compute();
		Mars.compute();
		Jupiter.compute();
		Saturn.compute();
		// Core.polaris();
		// Core.moonPhase();
		// Core.weekDay();
	}

	protected Point plotCoordinates(Graphics gr, double lat, double lng, Point center, int radius) {
		return plotCoordinates(gr, lat, lng, center, radius, null);
	}

	protected Point plotCoordinates(Graphics gr, double lat, double lng, Point center, int radius, String label) {
		// Assuming N latitude, radius = 180 degrees
		double rayon = (((90D - lat) / 180d) * (double) radius);
		int xOffset = (int) (Math.round(rayon * Math.sin(Math.toRadians(lng)))) * hemisphere;
		int yOffset = (int) (Math.round(rayon * Math.cos(Math.toRadians(lng))));
		if (displayOption == SKY_CHART_OPTION) {
			yOffset *= -1;
		}

		Point p = new Point(center.x - xOffset, center.y + yOffset);
		if (false) {
			gr.fillOval(p.x - 2, p.y - 2, 4, 4);
		}
		if (false) {
			gr.drawString(label, p.x + 3, p.y - 3);
		}
		return p;
	}

	/**
	 * Spherical Model used here
	 *
	 * @param start   in degrees
	 * @param dist    in nautical miles
	 * @param bearing in degrees
	 * @return
	 */
	private static GeoPoint deadReckoning(GeoPoint start, double dist, double bearing) {
		GeoPoint reached = null;
		double radianDistance = Math.toRadians(dist / 60d);
		double finalLat = (Math.asin((Math.sin(Math.toRadians(start.getL())) * Math.cos(radianDistance)) +
				(Math.cos(Math.toRadians(start.getL())) * Math.sin(radianDistance) * Math.cos(Math.toRadians(bearing)))));
		double finalLng = Math.toRadians(start.getG()) + Math.atan2(Math.sin(Math.toRadians(bearing)) * Math.sin(radianDistance) * Math.cos(Math.toRadians(start.getL())),
				Math.cos(radianDistance) - Math.sin(Math.toRadians(start.getL())) * Math.sin(finalLat));
		finalLat = Math.toDegrees(finalLat);
		finalLng = Math.toDegrees(finalLng);

		reached = new GeoPoint(finalLat, finalLng);
		return reached;
	}

	public void setShowFullGrid(boolean showFullGrid) {
		this.showFullGrid = showFullGrid;
		try {
			SwingUtilities.invokeAndWait(() -> repaint());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Month month = null;
	private static int dayOfMonth = 0;

	private static void findCorrespondingDay(int d) {
		// Day 1 is September 21st.
		Month currMonth = Month.SEPTEMBER;
		int day = 21;
		int currDay = day;
		for (int i = 1; i < d; i++) {
			currDay++;
			if (currDay > currMonth.nbDays()) {
				currDay = 1;
				currMonth = nextMonth(currMonth);
			}
		}
		month = currMonth;
		dayOfMonth = currDay;
	}

	private static Month nextMonth(Month m) {
		boolean ah = false;
		Month next = Month.JANUARY; // If not found, that will be Jaunuary
		for (Month month : Month.values()) {
			if (ah) {
				next = month;
				break;
			}
			ah = (m.equals(month));
		}
		return next;
	}

	public RenderedImage createSkyImage(int w, int h) {
		int width = w;
		int height = h;

		// Create a buffered image in which to draw
		final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		final NightSkyPanel instance = this;
		try {
			SwingUtilities.invokeAndWait(() -> {
				// Create a graphics contents on the buffered image
				Graphics2D g2d = bufferedImage.createGraphics();
				instance.paintComponent((Graphics) g2d);
				// Graphics context no longer needed so dispose it
				g2d.dispose();
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bufferedImage;
	}

	public void genImage(File f, String ext, int width, int height) {
		RenderedImage rendImage = createSkyImage(width, height);
		// Write generated image to a file
		try {
			OutputStream os = new FileOutputStream(f);
			ImageIO.write(rendImage, ext, os);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	public static void main_0(String[] args) {
		for (int i = 1; i <= 365; i++) {
			findCorrespondingDay(i);
			System.out.println("Day " + i + " => " + month.mname + " " + dayOfMonth);
		}
	}
}
