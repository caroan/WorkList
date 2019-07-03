import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class TakeFileName {
	String path;
	File[] list;
	File here;
	
	public TakeFileName() {
		// TODO Auto-generated constructor stub
	}
	
	void takeNameList(){
		here = new File(".");
		System.out.print("현재 위치 : " + here.getAbsolutePath());
		list = here.listFiles();
		Arrays.sort(list);
	}
	
	void writeFileNameListToTextFile(){
		
		String fileNames = new String(); 
		
		for(File targetFile:list){
			if(targetFile.isFile() && !(targetFile.getName().equals( "fileNames.txt" )) && !(targetFile.getName().equals("fileNames.exe"))){

				String temp = targetFile.getName().substring(0, targetFile.getName().lastIndexOf("."));
				
				fileNames = fileNames+temp + "\t" + ".ImagePathExample." + temp + "_ResourceNameExample" + "\r\n";
			}
		}
		
		
		try{
			FileWriter myFileWriter = new FileWriter("fileNames.txt"); // 절대주소 경로 가능 
			BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter); 
			myBufferedWriter.write(fileNames); 
			myBufferedWriter.close(); 
		}catch(Exception e){
			System.out.print("무언가가 잘못되었습니다. 이거 만든 사람한테 연락해주세요.");
		}
	}
	
	void go(){
		takeNameList();
		writeFileNameListToTextFile();
	}
}
