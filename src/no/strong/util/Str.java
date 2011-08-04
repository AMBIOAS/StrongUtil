

package no.strong.util;

/**
 * String utilities
 * 
 * @author fredpallesen
 *
 */
public class Str {
	public static boolean isEmpty( String value ) {
		return value == null || value.trim().isEmpty();
	}

	public static boolean isNotEmpty( String value ) {
		return !isEmpty(value);
	}
}
