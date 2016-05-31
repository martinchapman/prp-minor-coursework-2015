package Coursework3;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Utility class is optional, but nice.
 * @author Martin
 *
 */
/**
 * @author Martin
 *
 */
public class Utils {

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
	
	/**
	 * @param lower
	 * @param upper
	 * @return
	 */
	public static double inRangeExclusive( double lower, double upper ) {
		
		Random random = new Random();
		
		return (random.nextDouble() * (upper - lower)) + lower;
		
	}
	
	/**
	 * @param upper
	 * @return
	 */
	public static double randomInclusive( double upper ) {
		
		double random = new Random().nextDouble(); // Math.random();
		
		double randomUpper = random * upper;
		
		if (  randomUpper == 0 ) {
		
			return 1.0 * upper;
		
		} else {
		    
			return Math.random() * upper;
			
		}
		
		// return Math.random() < 0.5 ? ( ( 1 - Math.random() ) * ( max - min ) + min ) : ( Math.random() * ( max - min ) + min );
		
	}

}
