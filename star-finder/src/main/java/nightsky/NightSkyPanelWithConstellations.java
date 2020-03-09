package nightsky;

import app.starfinder.StarFinder;
import nightsky.ctx.SkyMapContext;
import oracle.xml.parser.v2.DOMParser;
import oracle.xml.parser.v2.XMLDocument;
import oracle.xml.parser.v2.XMLElement;
import org.w3c.dom.NodeList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This reproduces the Star Finder (2102-D).
 * With constellations.
 */
public class NightSkyPanelWithConstellations
		extends NightSkyPanel {
	public final static long serialVersionUID = 1L;

	private final transient static boolean rotateConstNames = true;

	private Color CONSTELLATION_LINE_COLOR_FOR_PRINT = Color.white;
	private Color CONSTELLATION_LINE_COLOR_FOR_NO_PRINT = Color.black;
	private Color CONSTELLATION_NAME_COLOR_FOR_PRINT = Color.orange;
	private Color CONSTELLATION_NAME_COLOR_FOR_NO_PRINT = Color.red;

	public NightSkyPanelWithConstellations() {
		super();
	}

	public NightSkyPanelWithConstellations(int option) {
		super(option);
	}

	@Override
	protected void drawConstellations(Graphics2D g2d) {
		g2d.setColor(forPrint ? CONSTELLATION_LINE_COLOR_FOR_PRINT : CONSTELLATION_LINE_COLOR_FOR_NO_PRINT);
		DOMParser parser = SkyMapContext.getInstance().getParser();
		synchronized (parser) {
			try {
				parser.parse(StarFinder.class.getResource("constellations.xml"));
				XMLDocument doc = parser.getDocument();
				NodeList constellationList = doc.selectNodes("//constellation");
				for (int i = 0; i < constellationList.getLength(); i++) {
					XMLElement constellation = (XMLElement) constellationList.item(i);
					//      System.out.println("Constellation:[" + constellation.getAttribute("name") + "]");
					Map<String, ConstellationStar> starMap = new HashMap<String, ConstellationStar>();
					NodeList starList = constellation.selectNodes("./stars/star");
					for (int j = 0; j < starList.getLength(); j++) {
						XMLElement star = (XMLElement) starList.item(j);
						String name = star.getAttribute("name");
						double ra = Double.parseDouble(star.getElementsByTagName("ra").item(0).getTextContent()); // * hemisphere;
						double d = Double.parseDouble(star.getElementsByTagName("d").item(0).getTextContent()) * hemisphere;
						starMap.put(name, new ConstellationStar(name, ra, d));
					}
					NodeList lineList = constellation.selectNodes("./lines/line");
					for (int j = 0; j < lineList.getLength() && withConstellations; j++) {
						XMLElement line = (XMLElement) lineList.item(j);
						String from = line.getAttribute("from");
						String to = line.getAttribute("to");
						//        System.out.println(" - from [" + from + "] to [" + to + "]");
						double dec = starMap.get(from).getD();
						if (dec < -80) {
							continue;
						}
						double ra = starMap.get(from).getRa();
						double lng = 360 - (ra * 360d / 24d);
						lng += lhaAries;
						if (lng > 180) {
							lng -= 360;
						}
						Point p1 = plotCoordinates(g2d, dec, lng, center, radius, from);
						dec = starMap.get(to).getD();
						if (dec < -80) {
							continue;
						}
						ra = starMap.get(to).getRa();
						lng = 360 - (ra * 360d / 24d);
						lng += lhaAries;
						if (lng > 180) {
							lng -= 360;
						}
						Point p2 = plotCoordinates(g2d, dec, lng, center, radius, to);
						g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
					}
					// Constellation name
					if (withConstellationNames) {
						Font f = g2d.getFont();
						if (forPrint) {
							g2d.setFont(f.deriveFont(Font.BOLD, 12f));
						}
						double minDec = Double.MAX_VALUE, maxDec = -Double.MAX_VALUE;
						double minRA = Double.MAX_VALUE, maxRA = -Double.MAX_VALUE;
						Set<String> keys = starMap.keySet();
						// AverageCosinus: Manage 23-1 for RA, find 0, not 12
						double averageCosinus = 0;
						int nbStars = 0;
						for (String k : keys) {
							ConstellationStar cs = starMap.get(k);
							minDec = Math.min(minDec, cs.getD());
							maxDec = Math.max(maxDec, cs.getD());
							minRA = Math.min(minRA, cs.getRa());
							maxRA = Math.max(maxRA, cs.getRa());
							averageCosinus += Math.cos(Math.toRadians(hoursToDegrees(cs.getRa())));
							nbStars++;
						}
						averageCosinus /= nbStars;

						String cName = constellation.getAttribute("name");

						double lng = 360 - (((maxRA + minRA) / 2) * 360d / 24d);
						if (averageCosinus > 0 && lng > 90 && lng < 270) {
							lng -= 180;
						}
						lng += lhaAries;
						if (lng > 180) {
							lng -= 360;
						}
						double dec = (maxDec + minDec) / 2;
						//      System.out.println("For [" + cName + "],\n" + minDec + "<= dec <= " + maxDec + ", " + minRA + "<= RA <=" + maxRA + "\nCenter:" + dec + "/" + ((maxRA + minRA) / 2));
						Point ccenter = plotCoordinates(g2d, dec, lng, center, radius, cName);
						int l = g2d.getFontMetrics(g2d.getFont()).stringWidth(cName);
						Color c = g2d.getColor();
						g2d.setColor(forPrint ? CONSTELLATION_NAME_COLOR_FOR_PRINT : CONSTELLATION_NAME_COLOR_FOR_NO_PRINT);
						// Rotate the constellation name
						if (rotateConstNames) {
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
							g2d.drawString(cName, center.x - (l / 2), center.y + yOffset - 4);
							if (displayOption == SKY_CHART_OPTION) {
								g2d.rotate(Math.toRadians(lng * -hemisphere) * -1, center.x, center.y);
							} else {
								g2d.rotate(Math.toRadians(lng * hemisphere) * -1, center.x, center.y);
							}
						} else {
							g2d.drawString(cName, ccenter.x - (l / 2), ccenter.y);
						}
						g2d.setColor(c);
						g2d.setFont(f);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private double hoursToDegrees(double d) {
		return 360d * d / 24d;
	}

	private class ConstellationStar {
		private String name;
		private double ra, d;

		public ConstellationStar(String name, double ra, double d) {
			this.name = name;
			this.ra = ra;
			this.d = d;
		}

		public String getName() {
			return name;
		}

		public double getRa() {
			return ra;
		}

		public double getD() {
			return d;
		}
	}
}
