package controllers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import cloudEntities.Job;

public class VCC {
	
	Queue<Job> jobs = new LinkedList<Job>(); ;
	
	public void addJob(int id,  int approxJobTime) {
		Job job = new Job(id, approxJobTime);
		jobs.add(job);
		
	}
	
	public void jobCompletionTime(int id) {
		boolean found = false;
		int position = 0;
		
		Iterator iterator = jobs.iterator();  
		
        while (iterator.hasNext() && !found) { 
        	Job element = (Job) iterator.next();
        	
            if (element.getId()==id) {
            	found = true;
            }
            position++;   
        }
		
        iterator = jobs.iterator(); 
        int i = 0;
        int time = 0;
        while (iterator.hasNext() && i < position) { 
        	Job element = (Job) iterator.next();
            time = time + element.getApproxTime();
            i++;
        }
        
       System.out.println("The completion time for Job " + id + " is " + time);
	}
}
