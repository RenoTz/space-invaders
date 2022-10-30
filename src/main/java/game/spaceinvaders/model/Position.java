package game.spaceinvaders.model;

public class Position {
	private int xpix;
	private int ypix;
	
	public Position(int xpix, int ypix){
		this.xpix = xpix;
		this.ypix = ypix;
	}
	
	public int getXpix() {
		return xpix;
	}
	public void setXpix(int xpix) {
		this.xpix = xpix;
	}
	public int getYpix() {
		return ypix;
	}
	public void setYpix(int ypix) {
		this.ypix = ypix;
	}
}
