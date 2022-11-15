
public abstract class HolidayBonus {
	public static final int HIGHEST_BONUS = 15, LOWEST_BONUS = 5, OTHER_BONUS = 10; //get actual values
	public static double[] calculateHolidayBonus(double[][] array) {
		
		double[] output = new double[array.length];
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (TwoDimRaggedArrayUtility.getHighestInColumn(array, j) == array[i][j]) {
					total += HIGHEST_BONUS;
				}
				else if (TwoDimRaggedArrayUtility.getLowestInColumn(array, j) == array[i][j]) {
					total += LOWEST_BONUS;
				}
				else {
					total += OTHER_BONUS;
				}
			}
			output[i] = total;
			total = 0;
		}
		
		return output;
	}
	public static double calculateTotalHolidayBonus(double[][] array) {
		int total = 0;
		double[] holidayBonusArray = calculateHolidayBonus(array);
		for (int i = 0; i < holidayBonusArray.length; i++) {
			total += holidayBonusArray[i];
		}
		return total;
	}
}
