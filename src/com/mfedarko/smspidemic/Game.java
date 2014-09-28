package com.mfedarko.smspidemic;
import java.util.*;

public class Game {

	private ArrayList<Player> players;
	
	/**LATER, MAKE THIS ITERATE THROUGH THE ARRAY IF POSSIBLE. MAYBE....**/
	
	public Game(ArrayList<Player> players){
		int playerSize=players.size()-1;
		int doctorNumber=(int)(playerSize*.3);
		int incubatingNumber=(int)(playerSize*.2);
		
		players.get(0).infect();		
		
		for(int i=1;i<doctorNumber;i++){
			players.get(i).setDoctor();
		}
		
		for(int i=doctorNumber;i<doctorNumber+incubatingNumber;i++){
			players.get(i).setIncubating();
		}
		
	}
	
}
