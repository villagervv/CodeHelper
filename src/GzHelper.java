
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.apache.commons.codec.binary.Base64;

public class GzHelper {
	
	public static String Decoder(String s){
		String rlt="";
		byte[] asBytes = Base64.decodeBase64(s);
		rlt = new String(asBytes);
		return rlt;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
		String pathname = "D:/dpidataset/";
		
		String file="hour-weixin";
		
		Map<String, String> map = new HashMap<String, String>();
		
		List<String> chineseWordsList = new ArrayList<String>();

		
		File fileName = new File(pathname+file);
		/*BufferedReader reader = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName)), "GBK"));
				*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = null;
		
		int i=0;
		
		while( (line = reader.readLine())!=null){
			i++;
			try {
//				System.out.println(line);
		
				/*String host = GzHelper.Decoder(line.split("\\|", -1)[6]);
				String cookie = GzHelper.Decoder(line.split("\\|", -1)[10]);
//				String reffer = GzHelper.Decoder(line.split("\\|",-1)[8]);
  				String url = GzHelper.Decoder(line.split("\\|",-1)[7]);
  				String user = line.split("\\|",-1)[0];
  				String reffer = line.split("\\|",-1)[38];*/
  				
  				String wxuid = line.split("\\^",-1)[0];
  				String wxaddr = line.split("\\^",-1)[1];
  				
				
				/*if ((host.contains(".")&&cookie.length()!=0)||reffer.length()!=0){				

				byte[] asBytes = Base64.decodeBase64(cookie);
				String cookiede = new String(asBytes);
				System.out.println(reffer);
				}*/
//				System.out.println(reffer);

				/*
				if (reffer.length()!=0&&reffer.contains("video")){				
//					System.out.println(reffer);
//					System.out.println(url);
//					System.out.println(host);
					
					reffer = URLDecoder.decode(reffer, "utf-8");
					System.out.println(reffer);
					
						    String reg="([\u4e00-\u9fa5]+)";
						    Matcher matcher = Pattern.compile(reg).matcher(reffer);
						    while(matcher.find()){
						        chineseWordsList.add(matcher.group());
						    }
						map.put(user, reffer);

						Iterator it = chineseWordsList.iterator();
						String newline="";
						
						while (it.hasNext()) {
							String ss= (String)it.next();
							newline = newline+ss+"\n";
						}
//						System.out.println(newline);
					}*/
  				if(wxuid.length()!=0){
  				System.out.println(wxuid+"----"+wxaddr);
  				}
					}
				
				
			 catch (Exception e) {
				// TODO: handle exception
				continue;
			}
			
		}
		
		Iterator iter= map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
//			System.out.println(key.toString());
//			System.out.println(val.toString());
			
		}
		}
	
}
