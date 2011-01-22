package controllers;

import java.util.Arrays;
import java.util.List;

import models.Paste;
import play.mvc.Controller;

/**
 * A {@link Controller} which displays a {@link Paste} with a specified code.
 * 
 * @author Ben Burton
 */
public class ViewPaste extends Controller {

	/**
	 * Action to show a paste from the database based on the provided code.
	 * 
	 * @param c
	 *            the code of the {@link Paste} to display.
	 */
	public static void index(String c) {
		Paste paste = Paste.findByCode(c);
		if (paste != null) {
			List<String> lines = Arrays.asList(paste.getContent().split("\n"));
			render(paste, lines);
		} else {
			notFound();
		}
	}

}
