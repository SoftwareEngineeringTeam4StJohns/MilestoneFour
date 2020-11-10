package users;
//super class!
public class User {
private String ID;
private String fname;
private String lname;
private int rating;
private String Org;


public void requestStartService() {
	
}


public String getID() {
	return ID;
}


public void setID(String iD) {
	ID = iD;
}


public String getFname() {
	return fname;
}


public void setFname(String fname) {
	this.fname = fname;
}


public String getLname() {
	return lname;
}


public void setLname(String lname) {
	this.lname = lname;
}


public int getRating() {
	return rating;
}


public void setRating(int rating) {
	this.rating = rating;
}


public String getOrg() {
	return Org;
}


public void setOrg(String org) {
	Org = org;
}


public void requestEndService(){
	
}



public void leaveOrg() {
	
}
}
