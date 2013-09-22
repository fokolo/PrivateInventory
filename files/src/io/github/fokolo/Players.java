package io.github.fokolo;

import java.util.ArrayList;
import java.util.List;

public class Players {
	static List<String> p= new ArrayList<String>();
	
	public static void addPlayer(String ps){
		p.add(ps);
	}
	public static void removePlayer(String ps){
		p.remove(ps);
	}
	
	public static boolean isPlayer(String ps){
		return p.contains(ps);
	}

}
