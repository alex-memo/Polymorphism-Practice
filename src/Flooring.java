public class Flooring {
	//creates private variables
	private String type;
	private String materialName;
	private double pricePerSqInch;
	//initializes variables
	public Flooring (String mt, double price) {
		type="poured";
		materialName=mt;
		pricePerSqInch=price;
	}
	//getters and setters
	public String getType() {
		return type;
	}
	//getters and setters
	public void setType(String type) {
		this.type = type;
	}
	//getters and setters
	public String getMaterial() {
		return materialName;
	}
	//getters and setters
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	//getters and setters
	public double getPricePerSqInch() {
		return pricePerSqInch;
	}
	//getters and setters
	public void setPricePerSqInch(double pricePerSqInch) {
		this.pricePerSqInch = pricePerSqInch;
	}
	/**
	 * gets the area of the floor
	 * @param length
	 * @param width
	 * @return
	 */
	public int amountOfMaterial(int length, int width) {	
		return length*width;
	}
	/**
	 * gets the price of the floor
	 * @param length
	 * @param width
	 * @param com
	 * @return
	 */
	public int quoteCents(int length, int width, double com) {//120*500*4*1.1
		double inches=amountOfMaterial(length,width);
		double cost = (double)Math.ceil(inches * 100 * getPricePerSqInch() * (1+com));//math.ceil round up
		return (int) cost;
	}
	/**
	 * converts inches to feet
	 * @param inch
	 * @return
	 */
	public static String toFeet(int inch) {	
		if(inch<12) {
			return (inch+"''");
		}
		int feet=0;
		feet=(int)(inch/12);
		inch=inch%12;
		if(inch>0) {
			return(feet+"'"+inch+"''");
		}
		return(feet+"'");
	}
	/**
	 * calculates the unused material
	 * @param length
	 * @param width
	 * @return
	 */
	public int unusedMaterial(int length, int width) {
		if(type.equals("poured")) {
			return 0;
		}
		//size of material is 8' x5''		96''x5''
		return 0;
	}
	/**
	 * calculates the waste ration in decimal form
	 * @param length
	 * @param width
	 * @return
	 */
	public double wasteRatio(int length, int width) {
		return  (double)unusedMaterial(length, width)/(double)amountOfMaterial(length, width);

	}

	@Override
	public String toString() {
		return "Flooring-" + type + " " + materialName + " @" + pricePerSqInch + " sq. in";
	}


}