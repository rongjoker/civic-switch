package org.com.dms.sms.test;

import org.com.dms.sms.util.ZHCharUtil;

/**
 *@author rongjoker
 *@date:2016-3-22 下午5:47:09
 *@company:
 *@description:
 *@version:0.0.1
 */
public class TestSwitch {
	
	public  static void test1(){
		
		System.out.println(ZHCharUtil.regularize("lao东西東西", ZHCharUtil.TRADITIONAL));
		System.out
				.println(ZHCharUtil
						.regularize(
								"廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行廣東發展銀行",
								ZHCharUtil.SIMPLIFIED));
		
		char c = '简';
		System.out.println(ZHCharUtil.regularize(c,  ZHCharUtil.SIMPLIFIED));
		
		
	}
	
	
	public static void main(String[] args) {
		test1();
	}

}
