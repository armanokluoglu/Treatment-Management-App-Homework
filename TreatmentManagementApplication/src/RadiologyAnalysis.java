import java.util.concurrent.ThreadLocalRandom;

public class RadiologyAnalysis extends Analysis {
	
	private boolean brokenBone;
	private int chanceOfPneumonia;
	private int chanceOfBreastCancer;
	
	public RadiologyAnalysis(Patient patient) {
		super(patient);
		double brokenBoneChance = Math.random();
		if(brokenBoneChance > 0.5) {
			brokenBone = true;
		} else {
			brokenBone = false;
		}
		chanceOfPneumonia = ThreadLocalRandom.current().nextInt(0, 6);
		chanceOfBreastCancer = ThreadLocalRandom.current().nextInt(0, 3);
	}
	
	@Override
	public String toString() {
		return "Broken bone: " + brokenBone + "\n" + 
			   "Chance of pneumonia: " + chanceOfPneumonia + "%" + "\n" + 
			   "Chance of breast cancer: " + chanceOfBreastCancer + "%";
	}
	
}