package it.polito.tdp.extflightdelays.model;

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
	
	public void creaGrafo(double distanza) {
		this.grafo= new SimpleWeightedGraph(DefaultWeightedEdge.class);
		
		dao.loadAllAirports(idMap);
		Graphs.addAllVertices(grafo, idMap.values());
		
		for (Adiacenza a : dao.getAllAdiacenze()) {
			if ( a.getPeso()>distanza)
				Graphs.addEdge(grafo, idMap.get(a.getId1()), idMap.get(a.getId2()), a.getPeso());
		}
		System.out.println("Grafo Creato!!!!!");
		System.out.println("# vertici: "+grafo.vertexSet().size());
		System.out.println("# archi: "+grafo.edgeSet().size());
	}
	
	public String stampaArchiConDistanza() {
		for (DefaultWeightedEdge e: grafo.edgeSet()) {
		}
		String s="";
		return s;
	}
}
