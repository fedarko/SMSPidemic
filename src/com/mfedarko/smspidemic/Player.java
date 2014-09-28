
package com.mfedarko.smspidemic;

import java.util.*;
/**FIIIIIIIIIIIIIXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX THE TOSTRING!!!!!!!!!!!!!!!!!!!!!!!!!!**/
public class Player {
	
	private static enum STATUS{NORMAL,BIO,INFECTED,DOCTOR,INCUBATING}
	private boolean isAlive;
	private STATUS status;
	private String name;
	private String phoneNumber;
	
	//contructor takes in name and phone
	public Player(String name, String phone){
		isAlive=true;
		status=STATUS.NORMAL;
		this.name=name;
		phoneNumber=phone;
	}
	//sets the player up as a doctor
	public void setDoctor(){
		status=STATUS.DOCTOR;
	}
	//the player is set as has a disease and is gonna die
	public void setIncubating(){
		status=STATUS.INCUBATING;
	}
	//infects a player
	public void infect(){	
		status=STATUS.INFECTED;
	}
	//the unstoppable force of a mean guy
	public void setBio(){
		status=STATUS.BIO;
	}
	//cures a player
	public void cure(){
		status=STATUS.NORMAL;
	}
	public void kill(){
		isAlive=false;
	}
	//sets the name
	public void setName(String name){
		this.name=name;
	}
	
	//gets the name
	public String getName(){		
		return name;
	}
	
	//sets the phone number
	public void setPhone(String phone){
		phoneNumber=phone;
	}
	public boolean isAlive(){
		return isAlive;
	}
	//gets the phone number
	public String getPhone(){
		return phoneNumber;
	}
	//returns a string representation of this object
	public String toString(){
		return name+": "+status.toString();
	}
}

