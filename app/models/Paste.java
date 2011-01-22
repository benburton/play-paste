package models;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.persistence.Entity;
import javax.persistence.Lob;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * @author Ben Burton
 */
@Entity
public class Paste extends Model {

	@Required
	public String code;

	@Lob
	public String content;

	private static final long serialVersionUID = 1L;

	public Paste(String content) {
		this.code = findRandomCode();
		this.content = content;
	}

	/**
	 * Returns the {@link Paste} object matching the provided code.
	 * 
	 * @param code
	 *            code to use in query
	 * @return the {@link Paste} object matching the provided code
	 */
	public static Paste findByCode(String code) {
		return find("code", code).first();
	}

	/**
	 * Returns a valid code to uniquely identify the {@link Paste} in the
	 * database.
	 * 
	 * @return a code string to identify the {@link Paste}
	 */
	private String findRandomCode() {
		String code = generateRandomCode();
		while (findByCode(code) != null) {
			code = generateRandomCode();
		}
		return code;
	}

	/**
	 * Generates a random string to use as a potential code value.
	 * 
	 * @return a random string
	 */
	private static String generateRandomCode() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(25, random).toString(32);
	}

	@Override
	public String toString() {
		return String.format("Paste[code=%s, content=%s]", code, content);
	}

}
