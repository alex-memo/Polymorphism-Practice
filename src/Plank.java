public class Plank extends Flooring {
	//creates variables
	private int plankLengthInch;
	private int plankWidthInch;
	private double plankPrice;
	/**
	 * initializes variables
	 * @param mt
	 * @param l
	 * @param w
	 * @param price
	 */
	public Plank(String mt, int l, int w,double price) {
		super(mt, price/(l*w));
		super.setType("plank");
		plankLengthInch=l;
		plankWidthInch=w;	
		plankPrice=price;
		//super.setPricePerSqInch(price/(plankLengthInch*plankWidthInch));
	}
	/**
	 * calculates the amount of material used 
	 */
	public int amountOfMaterial(int l,int w) {
		double x=(double)w/(double)plankWidthInch+.99;
		double y=(double)l/(double)plankLengthInch+.99;

		double x2=(double)l/(double)plankWidthInch+.99;
		double y2=(double)w/(double)plankLengthInch+.99;


		x=(int)x;
		y=(int)y;

		x2=(int)x2;
		y2=(int)y2;


		int i=(int) (x*y);
		int j=(int) (x2*y2);

		i=i*plankLengthInch*plankWidthInch;
		j=j*plankLengthInch*plankWidthInch;
		if(i<=j) {
			return i;
		}
		return j;

	}
	@Override
	public String toString() {
		return "Flooring-" + super.getType() +" " + super.getMaterial() + " @"+plankPrice+" per "+super.toFeet(plankLengthInch)+" by "+super.toFeet(plankWidthInch);
	}
	/**
	 * calculates the amount of unused material
	 */
	public int unusedMaterial(int l, int w) {
		return((amountOfMaterial(l,w))-super.amountOfMaterial(l, w));
	}
}