package runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		/* mantém o relatório do Console no estilo do Cucumber */
		plugin = "pretty",
		/* tira caracteres especiais */
		monochrome = true,
		/* deixa os métodos da classe Steps no estilo 
		 * camelCase, mantendo o padrão do Java
		 * Obs. Por padrão o Cucumber cria métodos
		 * com underline. Exemplo:
		 * a_especificação_deve_finalizar_com_sucesso() */
		snippets = SnippetType.CAMELCASE,
		/* valida se o mapeamento está correto se estiver como "true"
		 * valida os testes se estiver como "false" 
		 * Obs.: por padrão, ele é "false" */
		dryRun = false,
		/* Se add novos passos no Gherkin
		 * como "true" ele falha o teste, pois falta um passo à ser mapeado
		 * como "false" ele passa o teste, pulando o passo não mapeado 
		 * e aponta a "dica" de criar novo passo
		 * Obs.: por padrão, ele é "false" */
		strict = false
		)
public class Runner {
}
