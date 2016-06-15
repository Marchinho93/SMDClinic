package smdclinic.model.money;

public class Dollar extends Money{

		public Dollar(double amount){
			super(amount);
		}
		
		@Override
		public String toString() {
			return Double.toString(this.getAmount())+"$";
		}
	}
