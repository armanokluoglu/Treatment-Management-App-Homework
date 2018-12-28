import java.util.concurrent.ThreadLocalRandom;

public class BloodTestAnalysis extends Analysis {
	
	private int numOfNormalBloodCells;
	private int numOfAbnormalBloodCells;
	
	
	public BloodTestAnalysis(Patient patient) {
		super(patient);
		this.numOfNormalBloodCells = ThreadLocalRandom.current().nextInt(22, 29);
		this.numOfAbnormalBloodCells = ThreadLocalRandom.current().nextInt(1, 6);
	}
	
	public int getNumOfNormalBloodCells() {return numOfNormalBloodCells;}
	
	public int getNumOfAbnormalBloodCells() {return numOfAbnormalBloodCells;}
	
	public String toString() {
		return "Number of normal blood cells: " + numOfNormalBloodCells + " trillion \n" + 
			   "Number of abnormal blood cells: " + numOfAbnormalBloodCells + "trillion";
	}
}