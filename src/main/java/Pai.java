import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pai {
	
	@XmlElement
	private String nome = null;
	
	@XmlElement
	private String esposa = null;
	
	@XmlElement
	private List<Filhos> filhos = new ArrayList<Filhos>();
	
	public Pai() {		
	}
	
	public Pai(String nome, String esposa, List<Filhos> filhos) {
		this.nome = nome;
		this.esposa = esposa;
		this.filhos = filhos;
	}
}
