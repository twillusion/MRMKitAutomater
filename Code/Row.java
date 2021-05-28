import java.io.*;
import java.util.*;
import java.lang.*;

public class Row {
	
	ArrayList<String> Data;
	
	public Row() {
		Data = new ArrayList<>();
	}
	
	public void addData(String s) {
		this.Data.add(s);
	}
	
	public String getData(int i) {
		return this.Data.get(i);
	}
	
	public ArrayList<String> getDat() {
		return this.Data;
	}

}
