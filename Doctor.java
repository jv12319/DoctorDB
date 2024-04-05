

public class Doctor implements SeesPatients, Comparable<Doctor>{
	private static int numDoctors = 0;
	private String name;
	private int licenseNumber;
	private Patient [] patients = new Patient[100];
	private int numberOfPatients = 0;
	
	public Doctor(String name) {
		numDoctors++;
		licenseNumber = numDoctors;
		patients = new Patient[100];
		this.name = name;
	}
	
	public static int getNumDoctors() {
		return numDoctors;
	}
	
	public int getLicenseNumber() {
		return licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfPatients() {
		return numberOfPatients;
	}

	@Override
	public void addPatient(Patient p) throws PatientException {
		if(numberOfPatients < patients.length) {
			patients[numberOfPatients] = p;
			numberOfPatients++;
		} else {
			throw new PatientException("Number of patients has reached capacity of 100");
	}
	}

	

	
	public String getPatientsAsString() {

		String patientsStr = "patients= ";
		/*for(int i = 0; i < patients.length; i++) {
			if(patients[i] != null) {
				patientsStr += patients[i].toString();
				patientsStr += ", ";
			}
		}*/
		for (int i = 0; i < numberOfPatients; i++) {
			//instead of looping through length of patients object i now
			//loop tthrough the num of patients and i add a comma till reaching 
			//the last patient
	        patientsStr += patients[i].toString();
	        if (i < numberOfPatients - 1) {
	            patientsStr += ", ";
	        }
	    }
		return patientsStr;
	}
	
	@Override
	public String toString() {
		return String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber,getPatientsAsString());
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Doctor){
			Doctor otherP = (Doctor)o;
			if(this.name.equals(otherP.name)){
					if(this.numberOfPatients == otherP.numberOfPatients){
						return true;
					}
			}
		}
		return false;
	}

	
	public int compareTo(Doctor d) {
		if(this.numberOfPatients > d.numberOfPatients) {
			return 1;
		} else if(this.numberOfPatients < d.numberOfPatients) {
			return -1;
		}return 0;
		//The compareTo method uses numberOfPatients to determine sorting order
	}

	@Override
	public Patient[] getPatients() {
			return patients;
	}

	@Override
	public boolean isPatient(Patient p) {
		for(int i = 0; i < numberOfPatients; i++) {
			if(patients[i].equals(p)) {
				return true;
			}
		}
		return false;
	}
}
