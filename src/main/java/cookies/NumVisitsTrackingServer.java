package cookies;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

/**
 * Demonstrates how to use cookies to track the number of user's visits to the website.
 * Modified from the example of Prof. Engle.
 */
public class NumVisitsTrackingServer {
	public final static int PORT = 8090;

	static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(NumVisitsTrackingServlet.class, "/");
		handler.addServlet(ClearCookiesServlet.class, "/clear");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}