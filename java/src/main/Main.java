package main;


import controllers.VCCRunnable;
import logging.Monitor;
import user.GUIRunnable;

public class Main {
	public static void main (String[] args) {
		
		/*
		 * Multithreading to handle the user's gui, the VCC gui, and a resource manager
		 */
		
		//the vcc and vcc gui are being set to 
		//Runnable tasks being set
		
		VCCRunnable vccr = new VCCRunnable();
		
		Monitor monitor  = new Monitor();
		
		GUIRunnable owner_gui_task = new GUIRunnable(monitor);
		//Setting Threads
		Thread guit = new Thread(owner_gui_task);
	    Thread vcct = new Thread(vccr);
	    Thread updateMonitor = new Thread(monitor);
	    //Starting parallel processes
	    guit.start();
	    vcct.start();
	    updateMonitor.start();
	}
	
}
