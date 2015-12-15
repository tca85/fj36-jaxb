package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

/**
 * Existe o comando xjc para gerar classe java a partir de um
 * arquivo XSD
 * 
 * ir na pasta do projeto:
 * xjc schema.xsd -d src -p br.com.caelum.generated
 * 
 * @author tca85
 *
 */
public class TestaGeraSchema {
	
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		
		context.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				StreamResult result = new StreamResult(new File("schema.xsd"));
				return result;
			}
		});
	}
}