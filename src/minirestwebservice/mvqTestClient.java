package minirestwebservice;

import com.sun.jersey.api.client.*;

public class mvqTestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434";
		String nam = ( args.length > 1 ) ? args[1] : "ich";
		url = url + "/helloworld?name=" + nam;
		System.out.println( "URL: " + url );

		WebResource wrs = Client.create().resource( url );

		System.out.println( "\nTextausgabe:" );
		System.out.println( wrs.accept( "text/plain" ).get( String.class ) );
		System.out.println( "\nHTML-Ausgabe:" );
		System.out.println( wrs.accept( "text/html"  ).get( String.class ) );

	}

}
