package catalogo_latam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
		FileReader readerSoja = new FileReader("src/fichaSoja.json");
		FileReader readerMaiz = new FileReader("src/fichaMaiz.json");
		FileReader readerTrigo = new FileReader("src/fichaTrigo.json");

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

		Object listadoVariedades = jsonparser1.parse(readerListado, (ContainerFactory) containerFactory);
		Object soja = jsonparser2.parse(readerSoja, (ContainerFactory) containerFactory);
		Object maiz = jsonparser3.parse(readerMaiz, (ContainerFactory) containerFactory);
		Object trigo = jsonparser4.parse(readerTrigo, (ContainerFactory) containerFactory);

		JSONArray arrayVariedades = (JSONArray) listadoVariedades;
		JSONArray arraySoja = (JSONArray) soja;
		JSONArray arrayMaiz = (JSONArray) maiz;
		JSONArray arrayTrigo = (JSONArray) trigo;
		JSONArray tmp = new JSONArray();
		LinkedHashMap producto = null;
		LinkedHashMap producto2 = null;
		LinkedHashMap producto3 = null;
		LinkedHashMap lSoja = null;
		LinkedHashMap lMais = null;
		LinkedHashMap lTrigo = null;

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
		for (int i = arraySoja.size() + arrayMaiz.size(); i < arraySoja.size() + arrayMaiz.size()
				+ arrayTrigo.size(); i++) {
			producto3 = (LinkedHashMap) arrayVariedades.get(i);
			
			lTrigo = (LinkedHashMap) arrayTrigo.get(indtmp);
			producto3.put("ficha", lTrigo);
			indtmp++;
			tmp.add(producto3);
		}

		// processJson(tmp.toString());
		System.out.println(tmp);

	}

	public static void processJson(String file) throws IOException {
		String charset = "ISO-8859-1"; // or what corresponds
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}
}