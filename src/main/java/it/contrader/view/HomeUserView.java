package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice,word;
	Request request;
	
	@Override
	public void showResults(Request request) {
		//System.out.println("\n-----Purtroppo in questo sample l'utente non puà fare nulla, ci scusiamo per il disagio.-----");

	}

	@Override
	public void showOptions() {
		
		
		System.out.println("\n-------------MENU------------\n");
		System.out.println("Inserisci:");
		System.out.println("[1] Definizione");
		System.out.println("[2] Sinonimi");
		choice = this.getInput();

	}

	@Override
	public void submit() {

		switch (choice) {
		
		case "1":
			System.out.println("Vocabolo da ricercare:");
			word=this.getInput();
			request = new Request();
			request.put("word", word);
			MainDispatcher.getInstance().callAction("search.Definition", "doControl", request);
			
			break;
		case "2":
			break;

		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
