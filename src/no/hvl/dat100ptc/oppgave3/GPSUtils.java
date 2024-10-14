package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < latitudes.length; i++) {
			
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < longitudes.length; i++) {
			
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;
	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		double a, c;

		latitude1 = toRadians(gpspoint1.getLatitude());
		longitude1 = toRadians(gpspoint1.getLongitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude2 = toRadians(gpspoint2.getLongitude());
		
		a = compute_a(latitude1, latitude2, (latitude2-latitude1), (longitude2-longitude1));
		c = compute_c(a);
		
		d = R*c;
		
		return d;
				
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		double a;
		
		a = (pow (sin (deltaphi/2), 2.0) + cos(phi1) * cos(phi2) * pow (sin (deltadelta/2), 2.0));
		
		return a;
	}

	private static double compute_c(double a) {
		
		double c;
		
		c = 2 * atan2 (sqrt (a), sqrt (1-a));
		
		return c;

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		double deltaMeter = distance(gpspoint1, gpspoint2);
		
		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		
		secs = (time2 - time1);
		
		speed = (deltaMeter / secs);
		
		return speed;
		
	}
	// "  03:02:01"
	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int timer = (secs / 3600);
		int min = (secs % 3600)/60;
		int sek = secs % 60;
		
		timestr = ("%02d%s%02d%s%02d");
		
		timestr = String.format(timestr, timer, TIMESEP, min, TIMESEP, sek);
		
		timestr = String.format("%10s", timestr);
		
		return timestr;
	}	
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = ("%10.2f");
		
		double number = Math.round(d * 100);
		number = number/100;
		
		str = (number + "");
		
		str = String.format("%10s", str);
		
		return str;
		
		
	}
		
}
