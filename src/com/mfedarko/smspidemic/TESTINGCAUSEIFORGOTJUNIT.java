package com.mfedarko.smspidemic;
import java.util.*;

public class TESTINGCAUSEIFORGOTJUNIT {

	
	
	public static void main(String[]args){
		
		Game g = game1();
	}
	
	static Game game1(){
		
		
		ArrayList<Player> p = new ArrayList<Player>();
		p.add(new Player("Bobby","999999999"));
		
		
		for(int i=0;i<100;i++)
			p.add(new Player("Bobby"+i,"999999999"+i));
		Game g = new Game(p);
		
		return g;
	}
}
