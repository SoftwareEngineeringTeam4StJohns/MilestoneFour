package main;


import controllers.VCCRunnable;
import logging.Monitor;
import users.GUIRunnable;

public class Main {
	public static void main (String[] args) {
		
		/*
		 * Multithreading to handle the user's gui, the VCC gui, and a resource manager
		 */
		
		//the vcc and vcc gui are being set to 
		//Runnable tasks being set
		
		controllers.GUI vccGUI = new controllers.GUI();
		users.GUI clientGUI = new users.GUI();
		
		clientGUI.addObserver(vccGUI);
		
		VCCRunnable vccr = new VCCRunnable(vccGUI);
		GUIRunnable owner_gui_task = new GUIRunnable(clientGUI);
		Monitor monitor  = new Monitor();
		
		
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
