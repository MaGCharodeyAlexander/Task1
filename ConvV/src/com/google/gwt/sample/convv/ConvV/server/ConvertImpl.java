package com.google.gwt.sample.convv.ConvV.server;

import com.google.gwt.sample.convv.ConvV.client.Convert;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ConvertImpl extends RemoteServiceServlet implements Convert {

	public String ConvServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		//Конвертация полученного от клиента значения(input) .
		//Если, символы(то конвертитуем)->цифры ,иначе цифры(то конвертитуем)->символы
		if (input.matches("^[a-z]{1,15}$")) {
			String [][] matr=
			  { { "a","b","c","d","e","f"},
	            { "g","h","i","j","k","l"},
	            { "m","n","o","p","q","r"},
	            { "s","t","u","v","w","x"},
	            { "y","z","-","-","-","-"}, };
			String c ="" ,res="";
			char tmpchar;
		
			c = input;
			for (int k = 0; k < c.length(); k++)
				{
				tmpchar = c.charAt(k);
						for (int i = 0; i < 5; i++)
							{
								for (int j = 0; j < 6; j++)
									{
										if (tmpchar==matr[i][j].charAt(0)) 
											{
													res += Integer.toString(i+1)+Integer.toString(j+1);
											}
									}

							}
				};
				input =res;

		}
		// Escape data from the client to avoid cross-site script vulnerabilities.
		else if(input.matches("^[1-9]{1,30}$")){
				String [][] matr=
				  { { "a","b","c","d","e","f"},
		            { "g","h","i","j","k","l"},
		            { "m","n","o","p","q","r"},
		            { "s","t","u","v","w","x"},
		            { "y","z","-","-","-","-"},  };
				 	String c ="" ,res="";
				 	char tmpi,tmpj;
				 
				 int i, j,len,k=0;
				 c = input;
				 len=c.length()-1;
				 while(k <len)
				 {
					 	tmpi = c.charAt(k);
					 	k ++;
					 	tmpj = c.charAt(k);
					 	i = tmpi;
					 	j = tmpj;
					 	i-=49;
					 	j-=49;
					 	res += matr[i][j];
					 	k++;
				 }
				input = res;
				};
		input = escapeHtml(input);
		
		return input ;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
