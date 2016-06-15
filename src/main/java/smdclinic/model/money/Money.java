package smdclinic.model.money;

/* Classe per la gestione del denaro TODO*/
public abstract class Money {
	private double amount;
	
	public Money(double amount){
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public abstract String toString();
	
	public static Money parse(String s) throws Exception{
		String amountParsed = "";
		for(int i = 0; i<s.length(); i++){
			char temp = s.charAt(i);
			if(temp >= '0' && temp <='9' || temp =='.')
				amountParsed += temp;
			else
				switch (temp){
					case ('$') :
						return new Dollar(Double.parseDouble(amountParsed));
					case ('€') :
						return new Euro(Double.parseDouble(amountParsed));
					case ('£') :
						return new Sterling(Double.parseDouble(amountParsed));
					default :
						throw new Exception();
						
				}
		}
		return null;
		
	}
}
