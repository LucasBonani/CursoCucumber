import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Filhos {
	
	@XmlElement
	private String nome;
	
	@XmlAttribute(name = "apelido")
	private String apelido;
	
	@XmlElement
	private int idade;
	
	public Filhos(String nome, String apelido, int idade) {
		this.nome = nome;
		this.apelido = apelido;
		this.idade = idade;
	}

}
