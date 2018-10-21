package steps;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import converters.DataConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {
	
//  Exemplo sem camelCase 
//	@Dado("^que criei o arquivo corretamente$")
//	public void que_criei_o_arquivo_corretamente() throws Throwable {
//	
//	}

	// exemplos usando snippets = SnippetType.CAMELCASE 
	// @Dado, @Quando e @ Então não são lidos pelo Cucumber dentro daqui dos Steps, ou seja, não influencia nos steps
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
	}	

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
		//Com Assertivo para o cucumber manterá como cenário falho
		// e para o JUnit será  como passo falho
		Assert.assertEquals(arg1 , contador);
		// Com Exception para o cucumber manterá como cenário falho
		// e para JUnit será como passo error e cenário error
		//throw new RuntimeException();
	}
	
	Date entrega = new Date();
	//transform = vai converter a variável para o formato da data determinado na classe
	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DataConverter.class)Date data) throws Throwable {
		entrega = data;
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if(tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		}
		if(tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);
		}
		entrega = cal.getTime();
	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormatada = format.format(entrega);
		Assert.assertEquals(data, dateFormatada);
	}
	
	/***  DESAFIO  ***/ 
	
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉ(String tipo , String arg1) throws Throwable {
	}

	@Dado("^que o valor da passagem é R\\$ (\\d+).(\\d+)$") //R\\$ (.*) - aceita qualquer tipo de caracter
	public void queOValorDaPassagemÉR$(int arg1 , int arg2) throws Throwable {
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$") // de 5 a 20 caracteres
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	}
	
}

