package hello.models;

public class Adresa {
	
	private String oras;
	private String strada;
	private String sector;
	private int numar;
	
	public Adresa(String oras, String strada, String sector, int numar) {
		this.oras = oras;
		this.strada = strada;
		this.sector = sector;
		this.numar = numar;
	};

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getStrada() {
		return strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getNumar() {
		return numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}
}
