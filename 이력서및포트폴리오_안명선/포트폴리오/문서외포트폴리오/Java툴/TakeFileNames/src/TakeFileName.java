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
		System.out.print("���� ��ġ : " + here.getAbsolutePath());
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
			FileWriter myFileWriter = new FileWriter("fileNames.txt"); // �����ּ� ��� ���� 
			BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter); 
			myBufferedWriter.write(fileNames); 
			myBufferedWriter.close(); 
		}catch(Exception e){
			System.out.print("���𰡰� �߸��Ǿ����ϴ�. �̰� ���� ������� �������ּ���.");
		}
	}
	
	void go(){
		takeNameList();
		writeFileNameListToTextFile();
	}
}
