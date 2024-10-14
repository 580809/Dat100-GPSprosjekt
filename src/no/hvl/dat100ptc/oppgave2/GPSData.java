package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {

		gpspoints = new GPSPoint[antall];
		antall = 0;
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			inserted = true;
		}
			
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		return insertGPS(gpspoint);	
		
	}

	public void print() {

		String out = "====== GPS Data - START ======" + '\n';
		
		for (int i = 0; i < gpspoints.length; i++) {
			out += gpspoints[i].toString();
		}
		out += "====== GPS Data - SLUTT ======";
		System.out.print(out);
	}	
}
