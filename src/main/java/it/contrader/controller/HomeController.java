package it.contrader.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;

public class HomeController implements Controller {

	private LoginService loginService;
/**
 * Istanzia un oggetto di classe LoginService tramite il costruttore della classe
 */
	public HomeController() {
		loginService = new LoginService();
	}

	/**
	 * Se la request non � nulla la spacchetta estraendo i valori relativi alle chiavi "usename" e "password". Quindi chiama il Login Service 
	 * e ottiene uno usertype dal database. Se non trova le credenziali rimanda alla Login View-
	 */
	public void doControl(Request request) {
		if (request != null) {
			
			String username = request.get("username").toString();
			String password = SecurityController.hashPassword(request.get("password").toString());

			// Qui invoca il Login Service
			String usertype= loginService.login(username, password);

			// Se usertype è null allora il login non è andato a buon fine
			if (usertype == null){
				System.out.println("Wrong username and/or password");
				MainDispatcher.getInstance().callView("Login", null);
			}

			// Reindirizza alla giusta view in base allo usertype
			switch(usertype) {
			
			case "ADMIN":
				MainDispatcher.getInstance().callView("HomeAdmin", request);
				break;
				
			case "USER": 
				MainDispatcher.getInstance().callView("HomeUser", request);
				break;
			
			default:
				 MainDispatcher.getInstance().callView("Login", null);
				 break;
			}
		}
		else MainDispatcher.getInstance().callView("Login", null);

	}
}
