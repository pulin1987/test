package com.test;

import com.google.common.collect.Lists;

/**
 * Created by MyPC on 2016/5/25.
 * mq 延时调度
 * http://blog.csdn.net/kimmking/article/details/8443872
 */
public class TestSql {
	public static void main(String[] args) {
		String ssss="591924,591927,591928,592848,595144,595157,595158,595159,595160,595161,595162,595163,595164,595165,595166,595177,595178,595179,595180,595181,595182,595183,595184,595185,595186,595187,595188,595189,595190,595191,595192,595193,595194,595195,595196,595197,595198,595199,595200,595201,595202,595203,595204,595205,595206,595207,595208,595209,595210,595211,595212,595213,595214,595215,595216,595217,595218,595219,595220,595221,595222,595223,595224,595225,595226,595227,595228,595229,595230,595231,595232,595233,595234,595235,595236,595237,595238,595239,595240,595241,595242,595243,595244,595245,595246,595247,595248,595249,595250,595251,595252,595253,595254,595255,595256,595257,595258,595259,595260,595261,595262,595263,595264,595265,595266,595267,595268,595269,595270,595271,595272,595273,595274,595275,595276,595277,595278,595279,595280,595281,595282,595283,595284,595285,595286,595287,595289,595290,595291,595292,595293,595294,595295,595296,595297,595298,595299,595300,595301,595302,595303,595304,595305,595306,595307,595308,595309,595310,595311,595312,595313,595314,595315,595316,595317,595318,595319,595320,595321,595322,595323,595324,595325,595326,595327,595328,595329,595330,595331,595332,595333,595334,595335,595336,595337,595338,595339,595340,595341,595342,595343,595344,595345,595346,595347,595348,595349,595350,595351,595352,595353,595354,595355,595356,595357,595358,595359,595360,595361,595362,595363,595364,595365,595366,595367,595368,595369,595370,595371,595372,595373,595374,595375,595376,595377,595378,595379,595380,595381,595382,595383,595384,595385,595386,595387,595388,595389,595390,595391,595392,595393,595394,595395,595396,595397,595398,595399,595400,595401,595402,595403,595404,595405,595406,595407,595408,595409,595410,595411,595412,595413,595414,595415,595416,595417,595418,595419,595420,595421,595422,595423,595424,595425,595426,595427,595428,595429,595430,595431,595432,595433,595434,595435,595436,595437,595438,595439,595440,595441,595442,595443,595444,595445,595446,595447,595448,595449,595450,595451,595452,595453,595454,595455,595456,595457,595458,595459,595460,595461,595462,595463,595464,595465,595466,595467,595468,595469,595470,595471,595472,595473,595474,595475,595476,595477,595478,595479,595480,595481,595482,595483,595484,595485,595486,595487,595488,595489,595490,595491,595492,595493,595494,595495,595496,595497,595498,595499,595500,595501,595502,595503,595504,595505,595506,595507,595508,596559,596639,597155,597156,597157,597158,597159,597160,597161,597162,597163,597164,597165,597166,597167,597168,597169,597170,597171,597172,597173,597174,597175,597176,597177,597178,597179,597180,597181,597182,597183,597184,597185,597186,597187,597188,597189,597190,597191,597192,597193,597194,597195,597196,597197,597198,597199,597200,597201,597202,597203,597204,597205,597206,597207,597208,597209,597210,597211,597212,597213,597214,597215,597216,597217,597218,597219,597220,597221,597222,597223,597224,597225,597226,597227,597228,597229,597230,597231,597232,597233,597234,597235,597236,597237,597238,597239,597240,597241,597242,597243,597244,597245,597246,597247,597248,597249,597250,597251,597252,597253,597254,597255,597256,597257,597258,597259,597260,597261,597262,597263,597264,597265,597266,597267,597268,597269,597270,597271,597272,597273,597274,597275,597276,597277,597278,597279,597280,597281,597282,597283,597284,597285,597286,597287,597288,597289,597290,597291,597292,597293,597294,597295,597296,597297,597298,597299,597300,597301,597302,597303,597304,597305,597306,597307,597308,597309,597310,597311,597312,597313,597314,597315,597316,597317,597318,597319,597320,597321,597322,597323,597324,597325,597326,597327,597328,597329,597330,597331,597332,597333,597334,597335,597336,597337,597338,597339,597340,597341,597342,597343,597344,597345,597346,597347,597348,597349,597350,597351,597352,597353,597354,597355,597356,597357,597358,597359,597360,597361,597362,597363,597364,597365,597366,597367,597368,597369,597370,597371,597372,597373,597374,597375,597376,597377,597378,597379,597380,597381,597382,597383,597384,597385,597386,597387,597388,597389,597390,597391,597392,597393,597394,597395,597396,597397,597398,597399,597400,597401,597402,597403,597404,597405,597406,597407,597408,597409,597410,597411,597412,597413,597414,597415,597416,597417,597418,597419,604022,604047,604101";
		String[] bb = ssss.split(",");
		
		StringBuffer sb = new StringBuffer();
		//sb.append("select * from dish_shop where shop_identy=810002951 and  brand_identy=4988 and brand_dish_id in "+Lists.newArrayList(bb).toString().replace("[", "(").replace("]", ")")).append("\n");
		
		
		for(int i=0;i<100;i++){
			if(i==0){
				sb.append("select * from dish_shop where shop_identy=810002951 and brand_identy=4988 and brand_dish_id = "+bb[i]).append("\n");
			}else{
				sb.append("  UNION ALL select * from dish_shop where shop_identy=810002951 and brand_identy=4988 and brand_dish_id = "+bb[i]).append("\n");
			}
		}
	
		
		System.out.println(sb.toString());
	}
}
