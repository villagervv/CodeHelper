import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class GzHelper {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		String pathname = "C:/Users/Administrator/Desktop/2017翼起成长/数据源/";
		String file="3G.gz";
		File fileName = new File(pathname+file);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName)), "GBK"));
		
		System.out.println(reader.readLine());
		}
	
}
