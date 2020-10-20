package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView extends AbstractView {

	private String choice;

	private String username;
	
	private String password;

	public void showResults(Request request) {

	}
	/**
	 * chiede in input all'utente uno username e una password usando il metodo getInput() presente in AbstractView
	 */
	public void showOptions() {

		System.out.println("Inserire 1 per Login, 2 per creare user");
		this.choice = getInput();

		switch (this.choice) {
			case "1":
				System.out.println("----- .:LOGIN:. ----");

				System.out.println(" Nome utente:");
				this.username = getInput();

				System.out.println(" Password:");
				this.password = getInput();
				break;
			case "2":
				MainDispatcher.getInstance().callView("user.UserInsert", null);
		}
	}

	/**
	 * Impacchetta una request (metodo request.put("chiave", valore)) e la manda al controller Home tramite il Dispatcher
	 */
	public void submit() {

		if (this.choice.equals("1")){
			Request request = new Request();

			request.put("username", username);
			request.put("password", password);

			MainDispatcher.getInstance().callAction("Home", "doControl", request);
		}
		

	}


}
