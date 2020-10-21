package it.contrader.view.user;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class UserInsertView extends AbstractView{
	private Request request;

	private String username;
	private String password;
	private String usertype;
	private final String mode = "INSERT";
	private final String readUser = "READUSER";

	public UserInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		
		if (request!=null) {
			boolean user = (boolean) request.get("readUser");
			if(user) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}else{
			System.out.println("Username gia esistente. Cambia username e riprova.\n");
			MainDispatcher.getInstance().callView("user.UserInsert", null);
		}
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci username dell'utente:");
			username = getInput();
			System.out.println("Inserisci password dell'utente:");
			password = getInput();
			//System.out.println("Inserisci tipo dell'utente:(ADMIN o USER)");
			usertype = "USER";
			
			if(username.isEmpty() || password.isEmpty()) {
				System.out.println("Dati inseriti non validi");
				MainDispatcher.getInstance().callView("user.UserInsert", null);
			}
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("username", username);
		request.put("mode", readUser);
		MainDispatcher.getInstance().callAction("User", "doControl", request);
		
		
			boolean user = (boolean) request.get("readUser");
			if(user) {
				request = new Request();
				request.put("username", username);
				request.put("password", password);
				request.put("usertype", usertype);
				request.put("mode", mode);
				MainDispatcher.getInstance().callAction("User", "doControl", request);
		}
		
	}


}
