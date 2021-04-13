package fr.umfds.TPtestServicesREST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class BrainstormDB {
	
	protected static List<Brainstorm> BrainstormList = new ArrayList<Brainstorm>();
	

	
	public BrainstormDB() {
		
	}
	
	public List<Brainstorm> getDB() {
		BrainstormList.add(new Brainstorm("ArchiDistrib",1));
		BrainstormList.add(new Brainstorm("ZevMobile",2));
		BrainstormList.add(new Brainstorm("PythonProj",3));
		
		Collections.sort(BrainstormList);
		return BrainstormList;
	}
	
	public void addDB(Brainstorm e) {
		BrainstormDB.BrainstormList.add(e);
	}

}
