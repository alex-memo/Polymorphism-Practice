public class QuoteTable {
	//create variables
	private Flooring[]option;
	private int lengthInch;
	private int widthInch;
	private double markup;

	private static String displayHundredths(int hundredths) {
		return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
	}
	//setters
	public void setOptions(Flooring[] option) {
		this.option = option;
	}
	//setters
	public void setLength(int lengthInch) {
		this.lengthInch = lengthInch;
	}
	//setters
	public void setWidth(int widthInch) {
		this.widthInch = widthInch;
	}
	//setters
	public void setMarkup(double markup) {
		this.markup = markup;
	}

	public String display() {
		String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";

		int cheapestValue = getCheapestValue();
		double cleanestValue = getCleanestValue();

		out += "Material\tWaste\tCost\n";
		out += "--------\t-----\t----\n";
		for (int i = 0; i < option.length; i++) {
			double waste = option[i].wasteRatio(lengthInch, widthInch);
			int cost = option[i].quoteCents(lengthInch, widthInch, markup);

			out += option[i].getType() + "-";
			out += option[i].getMaterial() + "\t";
			out += displayHundredths((int) (10000 * waste)) + "%\t";
			out += "$" + displayHundredths(cost);
			if (waste == cleanestValue)
				out += " Eco";
			if (cost == cheapestValue)
				out += " $$";
			out += "\n";
		}
		return out;
	}
	/**
	 * Initializes variables
	 * @param floor
	 * @param length
	 * @param width
	 * @param mark
	 */
	public QuoteTable(Flooring[]floor, int length, int width, double mark) {
		option=floor;
		lengthInch=length;
		widthInch=width;
		markup=mark;
	}
	/**
	 * gets the cheapest value
	 * @return cheapest price available
	 */
	public int getCheapestValue() {
		int i=0; double []prices=new double[option.length];
		while (i<option.length) {
			prices[i]=option[i].quoteCents(lengthInch, widthInch, markup);
			i++;
		}
		i=0; double cheapest=prices[0];
		while(i<prices.length) {
			if(prices[i]<=cheapest) {
				cheapest=prices[i];
			}
			i++;
		}
		return (int) cheapest;
	}
	/**
	 * gets the cleanest value
	 * @return cleanes waste value
	 */
	public double getCleanestValue() {
		int i=0; double []prices=new double[option.length];
		while (i<option.length) {
			prices[i]=option[i].wasteRatio(lengthInch, widthInch);
			i++;
		}
		i=0; double cheapest=prices[0];
		while(i<prices.length) {
			if(prices[i]<=cheapest) {
				cheapest=prices[i];
			}
			i++;
		}
		return cheapest;
	}

}