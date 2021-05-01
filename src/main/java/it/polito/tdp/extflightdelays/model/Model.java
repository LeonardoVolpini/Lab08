package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport,DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer,Airport> idMap;
	
	public Model() {
		dao= new ExtFlightDelaysDAO();
		idMap= new HashMap<Integer,Airport>();
	}
	
	private List<Adiacenza> getAdiacenze(){
		return dao.getAllAdiacenze();
	}
	
	private List<Adiacenza> getAdiacenzeValide(double distanza){
		List<Adiacenza> valide = new ArrayList<Adiacenza>();
		for (Adiacenza a : getAdiacenze()) {
			if ( a.getPeso()>distanza)
				valide.add(a);
		}
		return valide;
	}
	
	public void creaGrafo(double distanza) {
		this.grafo= new SimpleWeightedGraph(DefaultWeightedEdge.class);
		
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(grafo, idMap.values());
		
		for (Adiacenza a : getAdiacenze()) {
			if ( a.getPeso()>distanza)
				Graphs.addEdge(grafo, idMap.get(a.getId1()), idMap.get(a.getId2()), a.getPeso());
		}
		System.out.println("Grafo Creato!!!!!");
		System.out.println("# vertici: "+grafo.vertexSet().size());
		System.out.println("# archi: "+grafo.edgeSet().size());
	}
	
	public String stampaNumArchi() {
		return ("# Archi: "+grafo.edgeSet().size());
	}
	
	public String stampaNumVertici() {
		return ("# Vertici: "+grafo.vertexSet().size());
	}
	
	public String stampaArchiConDistanza(double distanza) {
		String s="";
		for(Adiacenza a : this.getAdiacenzeValide(distanza)) {
			s+= "Arco con gl id: ("+a.getId1()+","+a.getId2()+") con distanza media: "+a.getPeso()+"\n";
		}
		return s;
	}
}
