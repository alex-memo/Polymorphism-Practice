public class Tile extends Plank{

	public Tile(String mt, int l, double price) {
		super(mt, l, l, price);
		super.setType("tile");
	}
	//as tostring is not overriden this means that plank tostring must comply with the requirements for tile

}