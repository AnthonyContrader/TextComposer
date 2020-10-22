package it.contrader.view.search;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DefinitionView extends AbstractView {
	
	private String word;
	private String choice;
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi fare:");
		System.out.println("[C]erca nuovo vocabolo, [E]esci");
		this.choice = this.getInput();
	}

	@Override
	public void submit() {
		switch(choice) {
		case "C":
		case "c":	
			System.out.println("Vocabolo da ricercare: ");
			this.word = getInput();
			Request request = new Request();
			request.put("word", word);
			MainDispatcher.getInstance().callAction("search.Definition", "doControl", request);
			break;
		case "e":
		case "E":
			MainDispatcher.getInstance().callView("HomeUser", null);
		}
	}

}
