package Servlet;

public class Utils {
	public static String join(String[] arr,String fh){
		if(arr==null) return null;
		if(arr.length==0) return "";
		StringBuilder sb=new StringBuilder();
		for(String str:arr){
			sb.append(str).append(fh);
		}
		sb.delete(sb.length()-fh.length(),sb.length());
		return sb.toString();
	}

}
