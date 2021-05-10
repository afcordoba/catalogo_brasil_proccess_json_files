package catalogo_latam;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONCatalogoLAS {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader readerListado = new FileReader("src/variedadesList.json");
		FileReader readerSoja = new FileReader("src/fichaSoja.json");//26
		FileReader readerMaiz = new FileReader("src/fichaMaiz.json");//27-33
		FileReader readerTrigo = new FileReader("src/fichaTrigo.json");//34-40
		FileReader readerSojaUru = new FileReader("src/fichaSojaUruguay.json");//41-52
		FileReader readerMaizUru = new FileReader("src/fichaMaizUru.json");//53-56
		FileReader readerTrigoUru = new FileReader("src/fichaTrigoUru.json");//57-61
		FileReader readerSojaBolivia = new FileReader("src/fichaSojaBolivia.json");//62-65
		FileReader readerSojaParaguay = new FileReader("src/fichaSojaParaguay.json");//66-74
		
		
	

		ContainerFactory containerFactory = new ContainerFactory() {
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
		JSONParser jsonparser6 = new JSONParser();
		JSONParser jsonparser7 = new JSONParser();
		JSONParser jsonparser8 = new JSONParser();
		JSONParser jsonparser9 = new JSONParser();
		
		Object listadoVariedades = jsonparser1.parse(readerListado, (ContainerFactory) containerFactory);
		Object soja = jsonparser2.parse(readerSoja, (ContainerFactory) containerFactory);
		Object maiz = jsonparser3.parse(readerMaiz, (ContainerFactory) containerFactory);
		Object trigo = jsonparser4.parse(readerTrigo, (ContainerFactory) containerFactory);
		Object sojaUru = jsonparser5.parse(readerSojaUru, (ContainerFactory) containerFactory);
		Object maizUru = jsonparser6.parse(readerMaizUru, (ContainerFactory) containerFactory);
		Object trigoUru = jsonparser7.parse(readerTrigoUru, (ContainerFactory) containerFactory);
		Object sojaBol = jsonparser8.parse(readerSojaBolivia, (ContainerFactory) containerFactory);
		Object sojaPar = jsonparser7.parse(readerSojaParaguay, (ContainerFactory) containerFactory);

		
		
		JSONArray arrayVariedades = (JSONArray) listadoVariedades;
		JSONArray arraySoja = (JSONArray) soja;
		JSONArray arrayMaiz = (JSONArray) maiz;
		JSONArray arrayTrigo = (JSONArray) trigo;
		
		JSONArray arraySojaUru = (JSONArray) sojaUru;
		JSONArray arrayMaizUru = (JSONArray) maizUru;
		JSONArray arrayTrigoUru = (JSONArray) trigoUru;
		JSONArray arraySojaBol = (JSONArray) sojaBol;
		JSONArray arraySojaPar = (JSONArray) sojaPar;
		
		JSONArray tmp = new JSONArray();
		LinkedHashMap producto = null;
		LinkedHashMap producto2 = null;
		LinkedHashMap producto3 = null;
		
		LinkedHashMap producto4 = null;
		LinkedHashMap producto5 = null;
		LinkedHashMap producto6 = null;
		
		LinkedHashMap producto7 = null;
		LinkedHashMap producto8 = null;
		
		LinkedHashMap lSoja = null;
		LinkedHashMap lMais = null;
		LinkedHashMap lTrigo = null;
		
		
		LinkedHashMap lSojaUru = null;
		LinkedHashMap lMaisUru = null;
		LinkedHashMap lTrigoUru = null;
		
		LinkedHashMap lSojaBol = null;
		LinkedHashMap lSojaPar = null;
		

		for (int i = 0; i < arraySoja.size(); i++) {

			producto = (LinkedHashMap) arrayVariedades.get(i);
			lSoja = (LinkedHashMap) arraySoja.get(i);
			producto.put("ficha", lSoja);
			tmp.add(producto);
		}
		int indtmp = 0;
		for (int i = arraySoja.size(); i < arraySoja.size() + arrayMaiz.size(); i++) {
			producto2 = (LinkedHashMap) arrayVariedades.get(i);
			
			lMais = (LinkedHashMap) arrayMaiz.get(indtmp);
			producto2.put("ficha", lMais);
			indtmp++;
			tmp.add(producto2);
		}
		indtmp = 0;
		for (int i = arraySoja.size() + arrayMaiz.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size(); i++) {
			producto3 = (LinkedHashMap) arrayVariedades.get(i);
			
			lTrigo = (LinkedHashMap) arrayTrigo.get(indtmp);
			producto3.put("ficha", lTrigo);
			indtmp++;
			tmp.add(producto3);
		}
		
		indtmp = 0;
		for (int i = arraySoja.size() + arrayMaiz.size()+ arrayTrigo.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size(); i++) {
			producto4 = (LinkedHashMap) arrayVariedades.get(i);
			
			lSojaUru = (LinkedHashMap) arraySojaUru.get(indtmp);
			producto4.put("ficha", lSojaUru);
			indtmp++;
			tmp.add(producto4);
		}
		
		indtmp = 0;
		for (int i = arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size(); i++) {
			producto5 = (LinkedHashMap) arrayVariedades.get(i);
			
			lMaisUru = (LinkedHashMap) arrayMaizUru.get(indtmp);
			producto5.put("ficha", lMaisUru);
			indtmp++;
			tmp.add(producto5);
		}
		
		indtmp = 0;
		for (int i = arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size() + arrayTrigoUru.size(); i++) {
			producto6 = (LinkedHashMap) arrayVariedades.get(i);
			
			lTrigoUru = (LinkedHashMap) arrayTrigoUru.get(indtmp);
			producto6.put("ficha", lTrigoUru);
			indtmp++;
			tmp.add(producto6);
		}
		indtmp = 0;
		for (int i = arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size() + arrayTrigoUru.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size() + arrayTrigoUru.size() + arraySojaBol.size(); i++) {
			producto7 = (LinkedHashMap) arrayVariedades.get(i);
			
			lSojaBol = (LinkedHashMap) arraySojaBol.get(indtmp);
			producto7.put("ficha", lSojaBol);
			indtmp++;
			tmp.add(producto7);
		}
		indtmp = 0;
		for (int i =arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size() + arrayTrigoUru.size() + arraySojaBol.size(); i < arraySoja.size() + arrayMaiz.size() + arrayTrigo.size() + arraySojaUru.size() + arrayMaizUru.size() + arrayTrigoUru.size() + arraySojaBol.size() + arraySojaPar.size(); i++) {
			producto8 = (LinkedHashMap) arrayVariedades.get(i);
			
			lSojaPar = (LinkedHashMap) arraySojaPar.get(indtmp);
			producto8.put("ficha", lSojaPar);
			indtmp++;
			tmp.add(producto8);
		}

		// processJson(tmp.toString());
		System.out.println(tmp);

	}

}