package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Utils {
	public static String join(String[] arr, String spliter){
		//张三  李四  王五  赵六    ,
		//张三,李四,王五,赵六,
		if(arr == null) return null;
		if(arr.length == 0) return "";
		if(spliter == null) return null;
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str).append(spliter);
		}
		//篮球，足球，排球，
		sb.delete(sb.length() - spliter.length(), sb.length());
		return sb.toString();
	}
	/**
	 * 将字符串类型的数字转换为int类型
	 * @param str
	 * @return
	 */
	public static int toInt(String str){
		if(str == null || "".equals(str)) return 0;
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	
	public static Date toDate(String str, String pattern){
		if(isEmpty(str)) return null;
		if(isEmpty(pattern)) pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date toDate(String str){
		return toDate(str, "yyyy-MM-dd");
	}
	
	public static boolean isEmpty(String str){
		return str == null || "".equals(str);
	}
}
