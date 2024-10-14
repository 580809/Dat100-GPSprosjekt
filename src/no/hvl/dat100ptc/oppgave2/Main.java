package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

		GPSPoint punkt1 = new GPSPoint (1, 3.1, 2.4, 2.8);
		GPSPoint punkt2 = new GPSPoint (2, 3.4, 2.7, 2.2);
		
		GPSData data1 = new GPSData(2);
		
		data1.insertGPS(punkt1);
		data1.insertGPS(punkt2);
		
		data1.print();
		
	}
}
