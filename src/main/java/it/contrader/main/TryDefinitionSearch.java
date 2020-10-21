package it.contrader.main;

// Classe creata solo per testare la libreria di ricerca delle definizioni
public class TryDefinitionSearch {
	public static void main(String[] args) {
		MainDispatcher.getInstance().callAction("search.Definition", "doControl", null);
    }
}
