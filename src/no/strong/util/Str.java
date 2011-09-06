

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
	
	/**
	 * @param s
	 * @return s after trimming and removing quotes 
	 */
	public static String unquote( String s ) {
		if (s==null) return null;
		String t = s.trim();
		if (t.length()>2 && t.startsWith("\"") && t.endsWith("\""))
			return t.substring(1, t.length()-1);
		else return s;
	}
	
}
