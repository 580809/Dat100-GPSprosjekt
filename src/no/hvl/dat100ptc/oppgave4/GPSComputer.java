package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		
		for (int i = 0; i < (gpspoints.length - 1); i++) {
			
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
		}
		
		return distance;
	}

	public double totalElevation() {

		double elevation = 0;
		double tempElevation = gpspoints[0].getElevation();
		
		for (int i = 0; i < (gpspoints.length); i++) {
			
			if (tempElevation < gpspoints[i].getElevation()) {
				
				elevation += (gpspoints[i].getElevation() - tempElevation);
			}
			
			tempElevation = gpspoints[i].getElevation();
		}
		
		return elevation;
		
	}

	public int totalTime() {
		
		int time = 0;
		int tempTime = gpspoints[0].getTime();
		
		for (int i = 0; i < gpspoints.length; i++) {
			
			if (tempTime < gpspoints[i].getTime()) {
				
				time += (gpspoints[i].getTime() - tempTime);
				
			}
			
			tempTime = gpspoints[i].getTime();
			
		}
		
		return time;
			
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i < (gpspoints.length - 1); i++) {
			
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			
		}
		
		return speeds;
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		double[] speeds = new double[gpspoints.length-1];
		
		for (int i = 0; i < (gpspoints.length - 1); i++) {
			
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		
		maxspeed = GPSUtils.findMax(speeds);
		
		return maxspeed;
	}

	public double averageSpeed() {

		double average = 0;
		
		double startTime = gpspoints[0].getTime();
		double endTime = gpspoints[gpspoints.length - 1].getTime();
		double deltaTime = endTime - startTime;
		double distance = 0;
		
		for (int i = 0; i < (gpspoints.length - 1); i++) {
			
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
		}
		
		average = distance / deltaTime;
		
		return average;
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;

		if (speedmph < 10.0) {
			met = 4.0;
		} if (speedmph >= 10.0 || speedmph < 12.0) {
			met = 6.0;
		} if (speedmph >= 12.0 || speedmph < 14.0) {
			met = 8.0;
		} if (speedmph >= 14.0 || speedmph < 16.0) {
			met = 10.0;
		} if (speedmph >= 16.0 || speedmph < 20.0) {
			met = 12.0;
		} if (speedmph >= 20.0) {
			met = 16.0;
		}
		
		kcal = (met * weight * (secs/3600));
		
		return kcal;
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		double speed = 0;
		int time = 0;
		double kcal = 0;
		
		for (int i = 0; i < (gpspoints.length - 1); i++) {
			
			speed = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			time = (gpspoints[i+1].getTime() - gpspoints[i].getTime());
			kcal = kcal(weight, time, speed);
			totalkcal += kcal;
		}
		
		return totalkcal;
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		
		
	}

}
