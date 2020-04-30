package com.raja.flames;
import java.lang.String;
public class Flames {
	    static String arrange(String a) {
	    	String b=new String();
			String use[ ];
			use=a.split(",");
			for(int i=0;i<use.length;i++)
				if(!use[i].equals(" "))
					b=b.concat(use[i]);
			a=null;
			System.gc();
			return b;
		}
		static String remCommons(String a,String b) {
			char a1[]=new char[a.length()];
			char b1[]=new char[b.length()];
			a.getChars(0,a.length(),a1,0);
			b.getChars(0,b.length(),b1,0);
			for(int i=0;i<a.length();i++){
	            if(a1[i]==' ')
	                a1[i]=',';
	            for(int j=0;j<b.length();j++){
	            	if(a1[i]==b1[j]){
	            		a1[i]=',';
	            		b1[j]=',';
	            	}
	            }
			}
			a=new String(a1);
			b=new String(b1);
			a=Flames.arrange(a);
			b=Flames.arrange(b);
			System.gc();
			return (a+b);
		}
		static char comNumOfRes(int n) {
			char a1[]={'s','e','f','e','f','m','e','a','e','l','m','a','a','f','a','f','l','e'};
			return a1[n-1];
		}
		public static char get(String a,String b){
		a=a.toLowerCase();
		b=b.toLowerCase();
		System.gc();
		return (Flames.comNumOfRes((Flames.remCommons(a,b)).length()));
	}
}
