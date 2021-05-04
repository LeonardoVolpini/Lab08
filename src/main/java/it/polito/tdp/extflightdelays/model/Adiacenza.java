package it.polito.tdp.extflightdelays.model;

public class Adiacenza {

	private int id1;
	private int id2;
	private double peso;
	private int idAdiacenza;
	
	public Adiacenza(int a1, int a2, double peso) {
		this.id1 = a1;
		this.id2 = a2;
		this.peso = peso;
		this.idAdiacenza= id1+id2;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int a1) {
		this.id1 = a1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int a2) {
		this.id2 = a2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIdAdiacenza() {
		return this.idAdiacenza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAdiacenza;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adiacenza other = (Adiacenza) obj;
		if (idAdiacenza != other.idAdiacenza)
			return false;
		return true;
	}
	
	
}
