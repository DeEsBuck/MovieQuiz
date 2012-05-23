package minirestwebservice;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public class mvqTestServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String url = ( args.length > 0 ) ? args[0] : "http://localhost:4434";

		SelectorThread srv = GrizzlyServerFactory.create( url );

		System.out.println( "URL: " + url );
		Thread.sleep( 1000 * 60 * 10 );
		srv.stopEndpoint();

	}

}
