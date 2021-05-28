import java.util.*;
import java.io.*;
import java.lang.*;


public class Runner {

	public static void main(String[] args) throws IOException {
		
		
		
		Scanner sc = new Scanner(new File("peak_picking.txt"));
		Methods M = new Methods();
		
		ArrayList<Row> allData = M.Generate(sc);
		
		for (Row R : allData) {
			if (R.getData(9).length()<1) {
				String CloseRT = R.getData(7);
				Double exRT = Double.parseDouble(CloseRT);
				String DetRT = R.getData(8);
				int numDet = 1;
				for (int i = 0; i < DetRT.length(); i++) {
					if (DetRT.charAt(i)==',') {
						numDet++;
					}
				}
				ArrayList<Double> allDRT = new ArrayList<>(numDet);
				for (int i = 0; i < numDet-1; i++) {
					Double RT = Double.parseDouble(DetRT.substring(0, DetRT.indexOf(",")));
					allDRT.add(RT);
					DetRT=DetRT.substring(DetRT.indexOf(",")+1);
				}
				allDRT.add(Double.parseDouble(DetRT));
				Double indicate1 = 99.0;
				Double indicate2 = 99.0;
				Double indicate3 = 99.0;
				for (Double d : allDRT) {
					indicate3 = Math.abs(d-exRT);
					if (indicate3 < indicate2) {
						indicate1 = d;
						indicate2 = indicate3;
					}
				}
				R.getDat().set(9, indicate1.toString());
			}
		}
		
		
		M.write(allData);


	}

}
