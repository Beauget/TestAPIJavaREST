package fr.umfds.TPtestServicesREST;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Brainstorm")
public class Brainstorm implements Comparable<Brainstorm> {
	
	//Attributs
	
	protected String nom;
	protected int idBrainstorm;
	protected List<Idea> ideaList;
	
	//Constructeur
	
	public Brainstorm() {
		
	}
	
	public Brainstorm(String newNom, int newId) {
		this.nom = newNom;
		this.idBrainstorm = newId;
		this.ideaList = new ArrayList<Idea>();
	}
	
	//Accesseurs
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getId() {
		return this.idBrainstorm;
	}
	
	public void setId( int id) {
		this.idBrainstorm = id;
	}
	
	public List<Idea> getIdea() {
		return this.ideaList;
	}
	
	public void setIdea(List<Idea> list) {
		this.ideaList = list;
	}

	@Override
	public int compareTo(Brainstorm o) {
		return (this.nom.compareTo(o.nom)); 
	}
	

}
