public class Surgery extends Treatment {

	private Surgeon surgeon;
	
	public Surgery(Surgeon surgeon) {
		setSurgeon(surgeon);
	}

	@Override
	public void startTreatment() {
		// TODO Auto-generated method stub
		
	}
	
	public Surgeon getSurgeon() {
		return surgeon;
	}
	
	public void setSurgeon(Surgeon surgeon) {
		this.surgeon = surgeon;
	}
}