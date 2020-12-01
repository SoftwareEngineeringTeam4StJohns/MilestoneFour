package logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Monitor implements Runnable{
	public static int cycles;
		
	public void run() {
		cycles=0;
		while (true){
			try {
				Thread.sleep(4000); //sleep for 4 seconds...
				String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
				cycles++;
				if (Loggers.generateLogs()) 
					System.out.println("Activity has been made. Logs made @["+timeStamp+"]");	
				else
					System.out.println("System scanned, no activity. @["+timeStamp+"]");
				
				
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
