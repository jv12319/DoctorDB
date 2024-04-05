

public class Pediatrician extends Doctor{
	private boolean hasPrivatePractice;
	private String hospitalName;

	public Pediatrician(String name) {
		super(name);
	}
	
	public Pediatrician(String name, boolean hasPrivatePractice, String hospitalName) {
		//(name, hasPrivatePractice, hospitalName)
		super(name);
		this.hasPrivatePractice = hasPrivatePractice;
		this.hospitalName = hospitalName;
	}
	
	public boolean hasPrivatePractice() {
		return hasPrivatePractice;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String Hname) {
		this.hospitalName = Hname;
	}
	
	@Override
	public String toString() {
		if(hasPrivatePractice == true) {
			String practice = "has private practice";
			return String.format(super.toString()  + "\nPediatrician: %s | hospital name=%15s",practice,hospitalName);
	} else {
		String practice = "does not have private practice";
		return String.format(super.toString()  + "\nPediatrician: %s | hospital name=%15s",practice,hospitalName);
	}
	}
	
	@Override
	public boolean equals(Object o) {
		//The equals method uses the hasPrivatePractice 
		//and hospitalName to determine equality.
		if(o instanceof Pediatrician){
			Pediatrician otherP = (Pediatrician)o;
			if(this.hasPrivatePractice == otherP.hasPrivatePractice){
					if(this.hospitalName == otherP.hospitalName){
						return true;
					}
			}
		}
		return false;
	}
	
	@Override
	public void addPatient(Patient p) throws PatientException	{
		//Override so it only add patients who are less than 18 years old
		int age = 2023 - p.getBirthYear();
		if(age < 18) {
			super.addPatient(p);
		} else {
			throw new PatientException("Number of patients has reached capacity of 100");
	}
	}

	

} 
