package com.mfedarko.smspidemic;
import java.util.*;
/****!!!!!!!!!!!!!!!!!!!!!!!!!!READ THIS---- SET PLAYERS TO PRVIATE WHEN FINAL TEST IS DONE!!!!!!***/
public class Game {

	public ArrayList<Player> players;
	
	/**LATER, MAKE THIS ITERATE THROUGH THE ARRAY IF POSSIBLE. MAYBE....**/
	
	public Game(ArrayList<Player> players){
		Collections.shuffle(players);
		this.players=players;
		int doctorNumber=(int)(players.size()*.3);
		int incubatingNumber=(int)(players.size()*.2);
		
		players.get(0).setBio();		
		int counter=0;
		for(int i=1;i<doctorNumber;i++){
			players.get(i).setDoctor();
		}
		
		for(int i=doctorNumber;i<doctorNumber+incubatingNumber;i++){
			players.get(i).setIncubating();
		}
		for(int i=doctorNumber+incubatingNumber;i<players.size();i++){
			players.get(i).cure();
		}
		
	}
	
	//returns a string representation of this object
	public String toString(){
		return players+"";
	}
	
}
