import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileHandlingHelper {

	private Path pathName;
	
	public FileHandlingHelper(String pathName) throws IOException {
		this.pathName = Files.createDirectories(Paths.get(pathName));
	}
	
	public boolean add(String fileName) throws IOException {
		fileName = fileName.trim();
		if(!exists(fileName)) {
			File file = new File(pathName.resolve(fileName).toString());
			file.createNewFile();
			return true;
		}
		return false;
	}
	
	public boolean delete(String fileName) throws IOException {
		fileName = fileName.trim();
		if(exists(fileName)) {
			File file = new File(pathName.resolve(fileName).toString());
			file.delete();
			return true;
		}
		return false;
	}
	
	public boolean search(String fileName) throws IOException {
		fileName = fileName.trim();
		if(exists(fileName)) {
			File file = new File(pathName.resolve(fileName).toString());
	        long fileSize = file.length();
	        System.out.format("File Size: %d bytes", fileSize);
	        System.out.println();
			String out = "";
			FileInputStream fis = new FileInputStream(file);
			while(fis.available() != 0) {
				int i = fis.read();
				char c = (char) i;
				out += c;
			}
			System.out.println("File Contents:\n" + out);
			fis.close();
	        return true;
		}
		return false;
	}
	
	private boolean exists(String fileName) {
		File file = new File(pathName.resolve(fileName).toString());
		return file.exists();
	}
	
	public void list() {
		File dir = new File(pathName.toString());
		String[] pathNames = dir.list();
		Arrays.sort(pathNames);
		if(pathNames.length == 0) {
			System.out.println("This directory is empty!");
		} else {
	        for(String pathName : pathNames) {
	            System.out.println(pathName);
	        }
		}
	}
	
}
