import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandlingHelper {

	private File file;
	public Boolean fileExists;
	
	public FileHandlingHelper(String pathName) throws IOException {
		this.file = new File(pathName);
		this.fileExists = this.exists();
		if(!this.exists()) this.create();
	}
	
	public String read() throws IOException {
		String out = "";
		FileInputStream fis = new FileInputStream(this.file);
		while(fis.available() != 0) {
			int i = fis.read();
			char c = (char) i;
			out += c;
		}
		fis.close();
		return out;
	}
	
	public void write(String in) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.file);
		for(int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			fos.write((int) c);
		}
		fos.close();
	}
	
	public void append(String in) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.file, true);
		for(int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			fos.write((int) c);
		}
		fos.close();
	}
	
	public void wipe() throws IOException {
		this.delete();
		this.create();
	}
	
	private void create() throws IOException {
		this.file.createNewFile();
	}
	
	public void delete() {
		this.file.delete();
	}
	
	private Boolean exists() {
		return this.file.exists();
	}
	
}
