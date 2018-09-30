
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.collect.Lists;

public class Teste {
	
	public static void main(String[] args) throws JAXBException{
		try {
			
			Pai pai = new Pai("Bruce Wayne", "Marta", Lists.newArrayList(new Filhos("Clark Kent", "Superman", 1000)));
			JAXBContext jaxbContext = JAXBContext.newInstance(Pai.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(pai, System.out);
			 
		} catch(ArrayIndexOutOfBoundsException exception){
			System.out.println("Erro ao carregar XML");
		}
	}

}
