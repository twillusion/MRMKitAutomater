import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Methods {
	
	public Methods() {
		
	}
	
	public ArrayList<Row> Generate(Scanner sc) {
		ArrayList<Row> output = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			Row r = new Row();
			String allR = sc.nextLine();
			while (allR.contains("\t")) {
				int tloc = allR.indexOf("\t");
				String Data = allR.substring(0, tloc);
				r.addData(Data);
				allR = allR.substring(tloc+1);
			}
			r.addData(allR);
			output.add(r);
		}
		
		return output;
	}
	
	public void write(ArrayList<Row> A) throws IOException {
		  FileWriter fw=new FileWriter("E:\\mrmKit18Feb\\peak_picking.txt");   
		  for (Row R : A) {
			  //System.out.println(R.getDat().size());
			  for (int i = 0; i < 10; i++) {
				  fw.write(R.getData(i)+"\t");
				  //System.out.print(s + "\t");
			  }
			  //System.out.println();
			  fw.write("\r\n");
		  }
		  fw.flush();
          fw.close();    
	}

}
