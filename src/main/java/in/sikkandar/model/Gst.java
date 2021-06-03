package in.sikkandar.model;

public class Gst {
	
	private double gstCalculation ;
	public Gst(double gstCalculation) {
		super();
		
		this.gstCalculation = gstCalculation;
	}
	@Override
	public String toString() {
		return "Order1 [ gstCalculation=" + gstCalculation + "]";
	}
	
	public double getGstCalculation() {
		return gstCalculation;
	}
	public void setGstCalculation(double gstCalculation) {
		this.gstCalculation = gstCalculation;
	}

}
