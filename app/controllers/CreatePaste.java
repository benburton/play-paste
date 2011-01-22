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

	/**
	 * Creates a {@link Paste} object in the database, and redirects the browser
	 * to the paste view.
	 * 
	 * @param title
	 *            title of the {@link Paste}
	 * @param author
	 *            author of the {@link Paste}
	 * @param contentType
	 *            content-type of the {@link Paste}
	 * @param content
	 *            content of the {@link Paste}
	 */
	public static void create(String title, String author, String contentType,
			String content) {
		Paste pasteObj = new Paste(title, author, contentType, content).save();
		ViewPaste.index(pasteObj.getCode());
	}
}
