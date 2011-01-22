package controllers;

import models.Paste;
import play.mvc.Controller;

/**
 * A {@link Controller} which allows the user to create a {@link Paste}.
 * 
 * @author Ben Burton
 */
public class CreatePaste extends Controller {

	public static void index() {
		render();
	}

	public static void create(String paste) {
		Paste pasteObj = new Paste(paste).save();
		ViewPaste.index(pasteObj.code);
	}
}
