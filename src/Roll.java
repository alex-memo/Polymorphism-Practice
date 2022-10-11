public class Roll extends Flooring {
	//creates private variables
	private int rollWidthInch;
	private double rollPricePerInch;

	public Roll(String mt, int width,double price) {
		super(mt, price/width);
		super.setType("roll");
		rollWidthInch=width;
		rollPricePerInch=price;
		//super.setPricePerSqInch(price/rollWidthInch);//price /rollwidthin 
	}
	/**
	 * calculates the amount of material used 
	 */
	public int amountOfMaterial(int l, int w) {
		double x=(double)w/rollWidthInch+.99;
		double y=(double)l/rollWidthInch+.99;
		x=(int)x;
		y=(int)y;
		int i=(int) (rollWidthInch*x*l);
		int j=(int) (rollWidthInch*y*w);

		if(i<=j) {
			return i;
		}
		return j;//roll width * price
	}

	@Override
	public String toString() {
		return "Flooring-" + super.getType() +" " + super.getMaterial() + " @"+rollPricePerInch+" per inch of a "+super.toFeet(rollWidthInch)+" roll";
	}
	/**
	 * calculates the amount of unused material
	 */
	public int unusedMaterial(int l, int w) {
		return((amountOfMaterial(l,w))-super.amountOfMaterial(l, w));
	}


}