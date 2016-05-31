package Coursework3.Simple;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Utility class is optional, but nice.
 * @author Martin
 *
 */
public class Utils2 {

	/**
	 * @param soldiers
	 * @param i
	 * @param j
	 */
	public static void swap(Soldier[] soldiers, int i, int j) {
		
		Soldier swapped = soldiers[i];
		
		soldiers[i] = soldiers[j];
		
		soldiers[j] = swapped;
		
	}
	
	/**
	 * @param value
	 * @return
	 */
	public static String round(double value) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		df.setRoundingMode(RoundingMode.CEILING);
		
		return df.format(value);
		
	}

}
