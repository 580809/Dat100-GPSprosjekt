package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		hr = Integer.parseInt(timestr.substring(11, 13));
		min = Integer.parseInt(timestr.substring(14, 16));
		sec = Integer.parseInt(timestr.substring(17, 19));
		
		hr = ((hr*60)*60);
		min = min*60;
		
		secs = hr + min + sec;
				
		return secs;
		
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
}
