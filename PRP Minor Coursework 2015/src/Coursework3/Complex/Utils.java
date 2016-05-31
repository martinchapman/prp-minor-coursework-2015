package Coursework3.Complex;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Utility class is optional, but nice.
 * @author Martin
 *
 */
public class Utils {
	
	/**
	 * @param value
	 * @return
	 */
	public static String format(double value) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		df.setRoundingMode(RoundingMode.CEILING);
		
		return df.format(value);
		
	}

}
