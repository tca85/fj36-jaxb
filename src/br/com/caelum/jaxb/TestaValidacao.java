package br.com.caelum.jaxb;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Testa a validação do arquivo XML com o XSD
 * 
 * Inserir no final do arquivo xsd, antes do </xs:schema> só para testar:
 * 
//  <xs:simpleType name ="codigo">
//     <xs:restriction base="xs:string">
//        <xs:pattern value="[A-Z]{3}"/>
//     </xs:restriction>
//  </xs:simpleType>
//
//  <xs:simpleType name ="valor">
//     <xs:restriction base="xs:decimal">
//        <xs:minExclusive value="0"/>
//        <xs:fractionDigits value="2"/>
//     </xs:restriction>
//  </xs:simpleType>
 * @author soa5447
 *
 */
public class TestaValidacao {
	
	public static void main(String[] args) throws Exception {
		Livro livro = new Livro();
		livro.setCodigo("arq"); // o código deve ser maíusculo
		livro.setValor(new BigDecimal("-1.00")); // valor não pode ser negativo
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		JAXBSource source = new JAXBSource(context, livro);
		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		Schema schema = sf.newSchema(new File("schema.xsd"));
		
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ValidationHandler());
		validator.validate(source);
		
		// para validar o xml:
		// validator.validate(new StreamSource(new File("livro.xml")));
	}
}