

public class Gerontologist extends Doctor{
	private boolean performsHouseCalls = true;	// true default value
	private double visitFee = 0.0;			// 0.0 default value


	public Gerontologist(String name) {
		super(name);
	}
	
	public Gerontologist(String name, boolean performsHouseCalls, double visitFee) {
		//(name, performsHouseCalls, visitFee)
		super(name);
		this.performsHouseCalls = performsHouseCalls;
		this.visitFee = visitFee;
	}
	
	public boolean performsHouseCalls() {
		return performsHouseCalls;
	}
	
	public double getVisitFee() {
		return visitFee;
	}
	
	public void setPerformsHouseCalls(boolean performsHouseCalls) {
		this.performsHouseCalls = performsHouseCalls;
	}
	
	public void setVisitFee(double visitFee) {
		if(visitFee >= 0.0) {
			this.visitFee = visitFee;
		} else {
			this.visitFee = 0.0;
		}
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + "patients= \nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
	}
	//The equals method uses the performsHouseCalls 
	//and visitFee with a precision of .05 to determine equality.
	@Override
	public boolean equals(Object o) {
		if(super.equals(o) == true) {
			if (o == null){ return false; }
			if (this == o) { return true; }
			if(o instanceof Gerontologist) {
				Gerontologist otherP = (Gerontologist)o;
				double precision = 0.05;
				double diff = Math.abs(visitFee - otherP.visitFee);
				if(diff < precision) {
					if(performsHouseCalls == otherP.performsHouseCalls){
						return true;
					}
				}
			}
			}
		return false;
		}
	
	@Override
	public void addPatient(Patient p) throws PatientException	{
		//Override so it only add patients who are greater than 65 years old
		int age = 2023 - p.getBirthYear();
		if(age > 65) {
			super.addPatient(p);
		} else {
			throw new PatientException("Number of patients has reached capacity of 100");
	}
	}

	
	

}
