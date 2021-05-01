package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		double dist=1000;
		model.creaGrafo(dist);
		model.stampaArchiConDistanza(dist);
	}

}
