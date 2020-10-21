package it.contrader.controller.search;

import it.contrader.main.MainDispatcher;
import it.contrader.controller.Request;
import it.contrader.controller.Controller;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

/* Classe che si occuperà della ricerca delle definizioni
 * Utilizza il sito "dizionario-italiano.it" per poter ricercare le definizioni.
 * Request contiene 
 * - "word" : parola da ricercare
 * - "pipeline" : cosa ricercare
 * "pipeline" è una lista che può contenere
 * "lemma"
 * "definizione" Al momento, torna solo la definizione
 * ecc.
 */

public class DefinitionController implements Controller {
	public DefinitionController() {
	}
	public void doControl(Request request) {
		if(request != null) {
			try {
				String word = request.get("word").toString();
				Document doc = Jsoup.connect("https://www.dizionario-italiano.it/dizionario-italiano.php?parola="+word).get();
				Elements definitions = doc.getElementsByClass("italiano");
				for (Element def:definitions) {
					System.out.println(def.text());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		MainDispatcher.getInstance().callView("search.Definition", request);
	}
}
