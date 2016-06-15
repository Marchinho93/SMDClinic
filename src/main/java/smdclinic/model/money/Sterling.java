package smdclinic.model.money;

public class Sterling extends Money{

		public Sterling(double amount){
			super(amount);
		}
		
		@Override
		public String toString() {
			return Double.toString(this.getAmount())+"£";
		}
	}
