package smdclinic.model.money;

public class Euro extends Money {

	public Euro(double amount){
		super(amount);
	}
	
	@Override
	public String toString() {
		return Double.toString(this.getAmount())+"€";
	}
}
