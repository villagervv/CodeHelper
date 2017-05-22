package com.rx.fileproc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
		
		String file="GW.gz";
		
		Map<String, String> map = new HashMap<String, String>();
		
		List<String> chineseWordsList = new ArrayList<String>();
		Set<String> wx_set = new HashSet<String>();

		
		File fileName = new File(pathname+file);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream(fileName)), "GBK"));
				
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line = null;
		
		int i=0;
		
		while( (line = reader.readLine())!=null){
			i++;
			try {
//				System.out.println(line.split("\\|", -1)[7]);
		
//				System.out.println(GzHelper.Decoder("aHR0cDovL3Nkay5jb25mLmlnZXhpbi5jb20vY29uZmlnL2h6LWh6djMuY29uZg=="));
//				String host = GzHelper.Decoder(line.split("\\|", -1)[6]);
//				String cookie = GzHelper.Decoder(line.split("\\|", -1)[10]);
				String reffer = GzHelper.Decoder(line.split("\\|",-1)[8]);
  				String url = GzHelper.Decoder(line.split("\\|",-1)[7]);
  				String ua = GzHelper.Decoder(line.split("\\|",-1)[9]);

//  				System.out.println(line.split("\\|",-1)[7]);
//  				String user = line.split("\\|",-1)[0];
//  				String reffer = line.split("\\|",-1)[38];
  				
  				String wxuid = line.split("\\|",-1)[0];
  				String wxaddr = line.split("\\|",-1)[1];
  				if(ua.toLowerCase().contains("ios")&&reffer.length()>0){
  				System.out.println(ua+"^"+url+"^"+reffer);
  				}
//  				Pattern p = Pattern.compile("http:\\/\\/mp\\.weixin\\.qq\\.com\\/s\\?\\_\\_biz=([a-zA-Z0-9]{14})==\\S*");
//  				Matcher m = p.matcher("http://mp.weixin.qq.com/s?__biz=MzAwOTYwMjg0NA==&mid=2664837634&idx=1");
  				

				Pattern p = Pattern.compile("(uid=[0-9]{1,20})");
//				Matcher m = p.matcher("tvfe_boss_uuid=24afa45c8cd25a9c; pt2gguin=o0419499330; o_cookie=419499330; pgv_pvid=6178306480; pgv_pvi=8282414080; sd_cookie_crttime=1479359260683; sd_userid=76391479359260683");
				Matcher m = p.matcher("http://api.weibo.cn/2/remind/unread_count?uid=1650563653&source=211160679&gsid=_2A251_H9rDeRxGedI7lIU9i3Kzj-IHXVUqPWjrDV6PUJbjdANLWL1kWpUoB-ZuHEsMCQYrwctpyG848uwvw..&s=57cb7000&c=weicoandroid&v_p=29&with_comment_attitude=1&from=1055095010");  				
  				
  				while(m.find()){
  					String name = m.group(1);
//  					System.out.println(name);
  				}
  				
  				String ss = "http://mp.weixin.qq.com/s?__biz=MzA5Mzk5MDM5MA==&mid=2650822431&idx=2&sn=aaf879968a45fdfbd174ab7b0b24dd12&chksm=8ba18b86bcd602906ae1291fa2f50c996647a9735918c7629b5ca4cb73a65f0b813d41751a7d&scene=0&ascene=7&devicetype=a";
  				
//  				System.out.println(ss.split("\\/")[2]);
  				
				
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
//  				System.out.println(wxuid+"----"+wxaddr);
  				
  				String[] sub_ref = wxaddr.split("\\,",-1);
  				
  				wx_set.clear();
  				for(int i1 =0;i1<sub_ref.length-1;i1++)
  			    {
  					wx_set.add(sub_ref[i1]);
  				}
  		
//  				System.out.println(wx_set.size());

  				Iterator<String> iter= wx_set.iterator();
  				/*while (iter.hasNext()) {

  	  				System.out.println(wxuid+"^"+iter.next());

  				}
  				*/
  				
  				}
					}
				
				
			 catch (Exception e) {
				// TODO: handle exception
				continue;
			}
			
		}
		
		}
	
}
