package catalogo_brasil;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {

	public static void main(String[] args) throws IOException, ParseException {
	
		FileReader readerProduto = new FileReader("src/producto.json");
		FileReader readerSemeadura = new FileReader("src/semeadura.json");
		FileReader readerAgronomicas = new FileReader("src/caracteristicas_agronomicas.json");
		FileReader readerdoencas = new FileReader("src/comportamiento_doencas.json");
		FileReader readerpontos_fortes = new FileReader("src/pontos_fortes.json");
		
		ContainerFactory containerFactory = new ContainerFactory(){
	        @Override
	        public Map createObjectContainer() {
	            return new LinkedHashMap();
	        }

	        @Override
	        public List creatArrayContainer() {
	            return null;
	        }
	    };
		
		JSONParser jsonparser1 = new JSONParser();
		JSONParser jsonparser2 = new JSONParser();
		JSONParser jsonparser3 = new JSONParser();
		JSONParser jsonparser4 = new JSONParser();
		JSONParser jsonparser5 = new JSONParser();
		
		
		Object prod = jsonparser1.parse(readerProduto,(ContainerFactory) containerFactory);
		Object semead = jsonparser2.parse(readerSemeadura,(ContainerFactory) containerFactory);
		Object agronom = jsonparser3.parse(readerAgronomicas,(ContainerFactory) containerFactory);
		Object pdoencas = jsonparser4.parse(readerdoencas,(ContainerFactory) containerFactory);
		Object fortes = jsonparser5.parse(readerpontos_fortes,(ContainerFactory) containerFactory);
		
		
		JSONArray arrayProd = (JSONArray) prod;
		JSONArray arraySemeadura = (JSONArray) semead;
		JSONArray arrayAgronomica = (JSONArray) agronom;
		JSONArray arrayDoencas = (JSONArray) pdoencas;
		JSONArray arrayPFortes = (JSONArray) fortes;
		
		JSONArray tmp = new JSONArray();
		
		for (int i = 0; i < arrayProd.size()-1; i++) {
			
			LinkedHashMap produto = (LinkedHashMap) arrayProd.get(i);
			LinkedHashMap semeadura = (LinkedHashMap) arraySemeadura.get(i);	
			LinkedHashMap agronomica = (LinkedHashMap) arrayAgronomica.get(i);	
			LinkedHashMap pontosF = (LinkedHashMap) arrayPFortes.get(i);	
			LinkedHashMap cDoencas = (LinkedHashMap) arrayDoencas.get(i);	
		

			
			produto.put("Época de semeadura", semeadura);
			produto.put("Caracteristicas Agronomicas", agronomica);
			produto.put("Pontos Fortes", pontosF);
			produto.put("Comportamento doenças", cDoencas);
			
			tmp.add(produto);
			
			//System.out.println(tmp);
		}
		System.out.println(tmp);
		
	}
	
	
	
}
