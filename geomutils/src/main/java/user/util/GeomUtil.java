package user.util;

import astro.calc.GeoPoint;
import astro.calc.GreatCircle;
import java.text.DecimalFormat;

public final class GeomUtil {
	public static final int HTML = 0;
	public static final int SHELL = 1;
	public static final int SWING = 2;
	public static final int NO_DEG = 3;

	public static final int NONE = 0;
	public static final int NS = 1;
	public static final int EW = 2;

	public static final int LEADING_SIGN = 0;
	public static final int TRAILING_SIGN = 1;

	public final static String DEGREE_SYMBOL = "\u00b0"; // = \272

	public static class PolyAngle {

		public double getAngleInDegrees() {
			return angleInDegrees;
		}

		private double angleInDegrees;
		public static final short DEGREES = 0;
		public static final short HOURS = 1;

		public PolyAngle() {}

		public PolyAngle(double d, short type) {
			switch (type) {
				case 0:
					angleInDegrees = d;
					break;
				case 1:
					//      angleInDegrees = GeomUtil.ra2ha(d);
					break;
			}
		}

		public PolyAngle(String str, short type) {}
	}

	/**
	 * Get the direction
	 * 
	 * @param x horizontal displacement
	 * @param y vertical displacement
	 * @return the angle, in degrees
	 */
	public static double getDir(float x, float y) {
		double dir = 0.0D;
		if (y != 0)
			dir = Math.toDegrees(Math.atan((double) x / (double) y));
		if (x <= 0 || y <= 0) {
			if (x > 0 && y < 0)
				dir += 180D;
			else if (x < 0 && y > 0)
				dir += 360D;
			else if (x < 0 && y < 0)
				dir += 180D;
			else if (x == 0) {
				if (y > 0)
					dir = 0.0D;
				else
					dir = 180D;
			} else if (y == 0) {
				if (x > 0)
					dir = 90D;
				else
					dir = 270D;
			}
		}

		while (dir >= 360D)
			dir -= 360D;
		return dir;
	}

	/**
	 * 
	 * @param fullString like [N 37�55.49], or [N 37�55'12.49"]
	 * @return
	 * @throws RuntimeException
	 */
	public static double sexToDec(String fullString) throws RuntimeException {
		try {
			String sgn = fullString.substring(0, 1);
			int degSignIndex = fullString.indexOf(DEGREE_SYMBOL);
			if (degSignIndex < 0)
				degSignIndex = fullString.indexOf(DEGREE_SYMBOL);
			String degrees = fullString.substring(2, degSignIndex);
			String minutes = "";
			String seconds = "";
			if (fullString.indexOf("\"") > -1) {
				minutes = fullString.substring(degSignIndex + 1, fullString.indexOf("'"));
				seconds = fullString.substring(fullString.indexOf("'") + 1, fullString.indexOf("\""));
			} else {
				minutes = fullString.substring(degSignIndex + 1);
			}
			double d = 0L;
			if (seconds.trim().length() > 0)
				d = sexToDec(degrees, minutes, seconds);
			else
				d = sexToDec(degrees, minutes);
			if (sgn.equals("S") || sgn.equals("W"))
				d = -d;
			return d;
		} catch (Exception e) {
			throw new RuntimeException("For [" + fullString + "] :" + e.getMessage());
		}
	}

	public static double sexToDec(String degrees, String minutes)
			throws RuntimeException {
		double deg = 0.0D;
		double min = 0.0D;
		double ret = 0.0D;
		try {
			deg = Double.parseDouble(degrees);
			min = Double.parseDouble(minutes);
			min *= (10.0 / 6.0);
			ret = deg + min / 100D;
		} catch (NumberFormatException nfe) {
			throw new RuntimeException("Bad number [" + degrees + "] [" + minutes + "]");
		}
		return ret;
	}

	public static double sexToDec(String degrees, String minutes, String seconds)
			throws RuntimeException {
		double deg = 0.0D;
		double min = 0.0D;
		double sec = 0.0D;
		double ret = 0.0D;
		try {
			deg = Double.parseDouble(degrees);
			min = Double.parseDouble(minutes);
			min *= (10.0 / 6.0);
			sec = Double.parseDouble(seconds);
			sec *= (10.0 / 6.0);
			min += ((sec / 0.6) / 100D);
			ret = deg + (min / 100D);
		} catch (NumberFormatException nfe) {
			throw new RuntimeException("Bad number");
		}
		return ret;
	}

	public static String decToSex(double v)
	{
		return decToSex(v, GeomUtil.SHELL);
	}

	public static String decToSex(double v, int display)
	{
		return decToSex(v, GeomUtil.HTML, display);
	}

	public static String decToSex(double v, int output, int displayType) {
		return decToSex(v, output, displayType, TRAILING_SIGN);
	}

	public static String decToSex(double v, int output, int displayType, boolean truncMinute) {
		return decToSex(v, output, displayType, TRAILING_SIGN, truncMinute);
	}

	public static String decToSex(double v, int output, int displayType, int signPosition) {
		return decToSex(v, output, displayType, signPosition, false);
	}

	public static String decToSex(double v, int output, int displayType, int signPosition, boolean truncMinute) {
		String s = "";
		double absVal = Math.abs(v);
		double intValue = Math.floor(absVal);
		double dec = absVal - intValue;
		int i = (int) intValue;
		dec *= 60D;
		DecimalFormat df = (truncMinute ? new DecimalFormat("00") : new DecimalFormat("00.00"));
		if (output == GeomUtil.HTML)
			s = Integer.toString(i) + "&deg;" + df.format(dec) + "&apos;";
		else if (output == GeomUtil.SWING)
			s = Integer.toString(i) + DEGREE_SYMBOL + df.format(dec) + "'";
		else if (output == GeomUtil.NO_DEG)
			s = Integer.toString(i) + ' ' + df.format(dec) + "'";
		else
			s = Integer.toString(i) + '\370' + df.format(dec) + "'";
		if (v < 0.0D) {
			switch (displayType) {
				case NONE:
					s = "-" + s;
					break;
				case NS:
					s = (signPosition == TRAILING_SIGN ? s + "S" : "S " + lpad(s, " ", (output == HTML) ? 13 : 9));
					break;
				case EW:
					s = (signPosition == TRAILING_SIGN ? s + "W" : "W " + lpad(s, " ", (output == HTML) ? 14 : 10));
					break;
			}
		} else {
			switch (displayType) {
				case NONE:
					s = " " + s;
					break;
				case NS:
					s = (signPosition == TRAILING_SIGN ? s + "N" : "N " + lpad(s, " ", (output == HTML) ? 13 : 9));
					break;
				case EW:
					s = (signPosition == TRAILING_SIGN ? s + "E" : "E " + lpad(s, " ", (output == HTML) ? 14 : 10));
					break;
			}
		}
		return s;
	}

	protected final static String lpad(String s, String p, int l) {
		String str = s;
		while (str.length() < l)
			str = p + str;
		return str;
	}

	protected final static String rpad(String s, String p, int l) {
		String str = s;
		while (str.length() < l)
			str += p;
		return str;
	}

	public static String angle2Hour(double angle) {
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		double deg = angle;
		for (deg += 180; deg < 0.0D; deg += 360D)
			;
		for (; deg > 360D; deg -= 360D)
			;
		double nbMinArc = deg * 60D;
		double nbH = Math.floor(nbMinArc / (double) 900);
		nbMinArc -= nbH * (double) 900;
		double dnbM = (4D * nbMinArc) / 60D;
		double nbM = Math.floor(dnbM);
		double nbS = (dnbM - nbM) * 60D;
		hValue = nf.format(nbH) + ":" + nf.format(nbM) + ":" + nf.format(nbS);
		return hValue;
	}

	public static double degrees2hours(double d)
	{
		return d / 15D;
	}

	public static double hours2degrees(double d)
	{
		return d * 15D;
	}

	public static String formatInHours(double deg) {
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		DecimalFormat nf2 = new DecimalFormat("00.0");
		double nbMinArc = deg * 60D;
		double nbH = nbMinArc / (double) 900;
		nbMinArc -= Math.floor(nbH) * (double) 900;
		double dnbM = (4D * nbMinArc) / 60D;
		double nbS = (dnbM - Math.floor(dnbM)) * 60D;
		hValue = nf.format(Math.floor(nbH)) + ":" + nf.format(Math.floor(dnbM)) + ":" + nf2.format(nbS);
		return hValue;
	}

	public static String formatDegInHM(double deg) {
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		double nbMinArc = deg * 60D;
		double nbH = nbMinArc / (double) 900;
		nbMinArc -= Math.floor(nbH) * (double) 900;
		double dnbM = (4D * nbMinArc) / 60D;
		//  double nbS = (dnbM - Math.floor(dnbM)) * 60D;
		hValue = nf.format(Math.floor(nbH)) + "h" + nf.format(Math.floor(dnbM));
		return hValue;
	}

	public static String formatHMS(double h) {
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		DecimalFormat nf2 = new DecimalFormat("00.000");
		double min = (h - Math.floor(h)) * 60D;
		double sec = (min - Math.floor(min)) * 60D;
		hValue = nf.format(Math.floor(h)) + ":" + nf.format(Math.floor(min)) + ":" + nf2.format(sec);
		return hValue;
	}

	public static String formatHM(double h) {
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		double min = (h - Math.floor(h)) * 60D;
		hValue = nf.format(Math.floor(h)) + ":" + nf.format(min);
		return hValue;
	}

	public static String formatDMS(double d)
	{
		return formatDMS(d, DEGREE_SYMBOL);
	}

	public static String formatDMS(double d, String degChar) {
		boolean positive = true;
		if (d < 0) {
			d = -d;
			positive = false;
		}
		String hValue = "";
		DecimalFormat nf = new DecimalFormat("00");
		DecimalFormat nf2 = new DecimalFormat("00.000");
		double min = (d - Math.floor(d)) * 60D;
		double sec = (min - Math.floor(min)) * 60D;
		hValue = nf.format(Math.floor(d)) + degChar + nf.format(Math.floor(min)) + "'" + nf2.format(sec) + "\"";
		return (positive ? "" : "-") + hValue;
	}

	public static double getLocalSolarTime(double g, double hms) {
		double ahh = degrees2hours(g);
		double localSolar = hms + ahh;
		while (localSolar < 0)
			localSolar += 24;
		while (localSolar > 24)
			localSolar -= 24;
		return localSolar;
	}

	public static String signedDegrees(int i) {
		String prefix = "N";
		if (i == 0) prefix = "";
		if (i < 0) prefix = "S";
		return prefix + " " + Integer.toString(Math.abs(i));
	}

	/**
	 * see http://en.wikipedia.org/wiki/Maidenhead_Locator_System
	 */
	public static String gridSquare(double lat, double lng) {
		String gridSquare = "";

		lng += 180;
		lat += 90;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//                 0         1         2
		//                 01234567890123456789012345. Useless beyond X
		int first = (int) (lng / 20d);
		gridSquare += alphabet.charAt(first);
		int second = (int) (lat / 10d);
		gridSquare += alphabet.charAt(second);

		int third = (int) ((lng % 20) / 2);
		gridSquare += Integer.toString(third);
		int fourth = (int) ((lat % 10));
		gridSquare += Integer.toString(fourth);

		double d = lng - ((int) (lng / 2) * 2);
		int fifth = (int) (d * 12);
		gridSquare += alphabet.toLowerCase().charAt(fifth);
		double e = lat - (int) lat;
		int sixth = (int) (e * 24);
		gridSquare += alphabet.toLowerCase().charAt(sixth);

		return gridSquare;
	}

	public static void main(String... args) {
		DecimalFormat nf3 = new DecimalFormat("000.0000000");
		double d = sexToDec("333", "22.07");
		//  PolyAngle pa = new PolyAngle(d, PolyAngle.DEGREES);
		//  System.out.println(nf3.format(d) + " degrees = " + formatHMS(degrees2hours(ha2ra(pa.getAngleInDegrees()))) + " hours (hours turn the other way...)");

		System.out.println(formatDMS(d));
		System.out.println(decToSex(d, SWING));

		double d2 = sexToDec("333", "22", "04.20");
		System.out.println("Returned:" + nf3.format(d2));
		System.out.println(formatDMS(d2));
		System.out.println(decToSex(d2, SWING));

		double l = sexToDec("37", "29", "48.34");
		double g = sexToDec("122", "15", "20.91");

		System.out.println("LogiSail headquarters - L:" + l + ", G:" + g);

		l = sexToDec("37", "39", "51.26");
		g = sexToDec("122", "22", "48.94");
		System.out.println("Don Pedro at Oyster Point - L:" + l + ", G:" + g);

		// Converting degrees to hours
		g = -sexToDec("142", "01.9");
		double hours = degrees2hours(g);
		System.out.println("142 01.9 W = " + formatHMS(hours) + " hours");
		// At GMT 17:37:58
		double gmt = sexToDec("17", "37", "58");
		double localSolar = gmt + hours;
		System.out.println("Local Solar:" + formatHMS(localSolar));

		System.out.println("142 01.9 W, at 17:37:58 GMT, local solar:" + formatHMS(getLocalSolarTime(-sexToDec("142", "01.9"), sexToDec("17", "37", "58"))));
		System.out.println("142 28.1 W, at 20:44:23 GMT, local solar:" + formatHMS(getLocalSolarTime(-sexToDec("142", "28.1"), sexToDec("20", "44", "23"))));
		System.out.println("143 02.4 W, at 00:41:30 GMT, local solar:" + formatHMS(getLocalSolarTime(-sexToDec("143", "02.4"), sexToDec("00", "41", "30"))));

		System.out.println("  9 24 45 S =" + (-sexToDec("9", "24", "45")));
		System.out.println("139 47 00 W =" + (-sexToDec("139", "47", "00")));

		System.out.println("Nuku-Hiva");
		System.out.println("  8 55 12.45 S =" + (-sexToDec("8", "55", "12.45")));
		System.out.println("140 05 18.39 W =" + (-sexToDec("140", "05", "18.39")));
		System.out.println("Ua-Huka");
		System.out.println("  8 55 04.76 S =" + (-sexToDec("8", "55", "04.76")));
		System.out.println("139 33 08.39 W =" + (-sexToDec("139", "33", "08.39")));
		System.out.println("Ua-Pou");
		System.out.println("  9 24 00.00 S =" + (-sexToDec("9", "24", "00.00")));
		System.out.println("140 04 37.45 W =" + (-sexToDec("140", "04", "37.45")));

		System.out.println("Hiva-Oa");
		System.out.println("  9 49 37.33 S =" + (-sexToDec("9", "49", "37.33")));
		System.out.println("139 03 37.84 W =" + (-sexToDec("139", "03", "37.84")));
		System.out.println("Tahuata");
		System.out.println("  9 56 57.88 S =" + (-sexToDec("9", "56", "57.88")));
		System.out.println("139 04 53.00 W =" + (-sexToDec("139", "04", "53.00")));
		System.out.println("Mohotani");
		System.out.println("  9 59 21.66 S =" + (-sexToDec("9", "59", "21.66")));
		System.out.println("138 46 54.94 W =" + (-sexToDec("138", "46", "54.94")));

		System.out.println("Fatu-Hiva");
		System.out.println(" 10 28 32 S =" + (-sexToDec("10", "28", "32")));
		System.out.println("138 39 59 W =" + (-sexToDec("138", "39", "59")));

		System.out.println("37 48.22 N  =" + (sexToDec("37", "48.22")));
		System.out.println("122 22.43 W =" + (-sexToDec("122", "22.43")));

		System.out.println("Cook:");
		System.out.println("19 00.00 N  =" + (sexToDec("19", "00.00")));
		System.out.println("160 00.00 W =" + (-sexToDec("160", "00.00")));

		System.out.println("Niue:");
		System.out.println("19 00.00 N  =" + (sexToDec("19", "00.00")));
		System.out.println("170 00.00 W =" + (-sexToDec("170", "00.00")));

		GreatCircle gc = new GreatCircle();
		gc.setStart(new GeoPoint(Math.toRadians(sexToDec("19", "00.00")),
				Math.toRadians((-sexToDec("160", "00.00")))));
		gc.setArrival(new GeoPoint(Math.toRadians(sexToDec("19", "00.00")),
				Math.toRadians((-sexToDec("170", "00.00")))));
		gc.calculateGreatCircle(20);
		//  Vector route = gc.getRoute();
		double distance = gc.getDistance();
		System.out.println("Dist:" + (Math.toDegrees(distance) * 60) + " nm");

		System.out.println("Tonga:");
		System.out.println("21 10.00 N  =" + (sexToDec("21", "10.00")));
		System.out.println("175 08.00 W =" + (-sexToDec("175", "08.00")));

		gc = new GreatCircle();
		gc.setStart(new GeoPoint(Math.toRadians(sexToDec("19", "00.00")),
				Math.toRadians((-sexToDec("170", "00.00")))));
		gc.setArrival(new GeoPoint(Math.toRadians(sexToDec("21", "10.00")),
				Math.toRadians((-sexToDec("175", "08.00")))));
		gc.calculateGreatCircle(20);
		//  Vector route = gc.getRoute();
		distance = gc.getDistance();
		System.out.println("Dist:" + (Math.toDegrees(distance) * 60) + " nm");

		System.out.println("Fiji:");
		System.out.println("18 00.00 N  =" + (sexToDec("18", "00.00")));
		System.out.println("180 00.00 W =" + (-sexToDec("180", "00.00")));

		gc = new GreatCircle();
		gc.setStart(new GeoPoint(Math.toRadians(sexToDec("21", "10.00")),
				Math.toRadians((-sexToDec("175", "08.00")))));
		gc.setArrival(new GeoPoint(Math.toRadians(sexToDec("18", "00.00")),
				Math.toRadians((-sexToDec("180", "00.00")))));
		gc.calculateGreatCircle(20);
		//  Vector route = gc.getRoute();
		distance = gc.getDistance();
		System.out.println("Dist:" + (Math.toDegrees(distance) * 60) + " nm");

		double bug = -sexToDec("10", "58", "20.8");
		System.out.println("Bug:" + bug + " " + formatDMS(bug) + " (fixed)");

		System.out.println("Display (no deg):[" + GeomUtil.decToSex(37.123, GeomUtil.NO_DEG, GeomUtil.NS) + "]");

		String fromJPEG = String.format("N 37%s39'49.8\"", DEGREE_SYMBOL);
		System.out.println(fromJPEG + " is [" + sexToDec(fromJPEG) + "]");

		fromJPEG = String.format("W 112%s9'34.36\"", DEGREE_SYMBOL);
		System.out.println(fromJPEG + " is [" + sexToDec(fromJPEG) + "]");

		double lat = 37.750585;
		double lng = -122.507891;
		System.out.println("Grid Square: " + new GeoPoint(lat, lng).toString() + " => " + gridSquare(lat, lng));
	}
}
