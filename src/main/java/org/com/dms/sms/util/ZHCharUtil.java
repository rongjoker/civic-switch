package org.com.dms.sms.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author rongjoker
 * @date:2016-3-10 下午3:45:14
 * @company:
 * @description:
 * @version:0.0.1
 */
public class ZHCharUtil {

	private static Properties simplecharMap = new Properties();
	private static Properties tradcharMap = new Properties();

	public static final int TRADITIONAL = 0;
	public static final int SIMPLIFIED = 1;
	private static final String[] propertyFiles = new String[2];

	static {
		propertyFiles[TRADITIONAL] = "zh2Hant.properties";
		propertyFiles[SIMPLIFIED] = "zh2Hans.properties";

		ZHCharUtil util = new ZHCharUtil();

		util.ZHConverter(propertyFiles[TRADITIONAL], tradcharMap);
		util.ZHConverter(propertyFiles[SIMPLIFIED], simplecharMap);

	}

	/**
	 * 简繁转换
	 * 
	 * @param input
	 * @param type
	 * @return
	 */
	public static String regularize(String input, int type) {
		StringBuilder sbr = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			sbr.append(regularize(c,type));
		}

		return sbr.toString();
	}
	
	
	public static char regularize(char c, int type) {
			Object o = null;
			if (type == TRADITIONAL) {
				o = tradcharMap.get(c + "");
			} else if (type == SIMPLIFIED) {
				o = simplecharMap.get(c + "");
			}
			
			if(o!=null){
				c = o.toString().charAt(0);
			}

		return c;
	}
	
	

	public void ZHConverter(String propertyFile, Properties charMap) {

		InputStream is = null;

		is = getClass().getResourceAsStream(propertyFile);

		if (is != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(is));
				charMap.load(reader);
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null)
						reader.close();
					if (is != null)
						is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(ZHCharUtil.regularize("lao东西東西", ZHCharUtil.TRADITIONAL));
		System.out
				.println(ZHCharUtil
						.regularize(
								"廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行",
								ZHCharUtil.SIMPLIFIED));
		
		char c = '简';
		System.out.println(ZHCharUtil.regularize(c,  ZHCharUtil.SIMPLIFIED));
		

	}

}
