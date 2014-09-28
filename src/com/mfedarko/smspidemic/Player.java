package com.mfedarko.smspidemic;

import java.util.*;

public class Player {

	private String name;
	private String phoneNumber;
	private boolean inGame;
	private int score;
	private boolean infected;
	private boolean isDoctor;
	private boolean incubating;
	
	//contructor takes in name and phone
	public Player(String name, String phone){
		this.name=name;
		phoneNumber=phone;
	}
	//sets the player up as a doctor
	public void setDoctor(){
		isDoctor=true;
	}
	//the player is set as has a disease and is gonna die
	public void setIncubating(){
		incubating=true;
	}
	//infects a player
	public void infect(){	
		
		infected=true;
	}
	
	//cures a player
	public void cure(){
		infected=false;
	}
	
	//sets the name
	public void setName(String name){
		name=name;
	}
	
	//gets the name
	public String getName(){		
		return name;
	}
	
	//sets the phone number
	public void setPhone(String phone){
		phoneNumber=phone;
	}
	
	//gets the phone number
	public String getPhone(){
		return phoneNumber;
	}
}
