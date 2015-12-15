package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Serializando JSON com Jackson
 * 
 * @author tca85
 *
 */
public class TestaMarshalJson {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("livro.json"), livro);
		
		Livro livro2 = objectMapper.readValue(new File("livro.json"), Livro.class);
		System.out.println(livro2.getCodigo());
	}
}