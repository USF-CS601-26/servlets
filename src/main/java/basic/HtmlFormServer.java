package basic;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHandler;
import org.eclipse.jetty.server.Server;

/** An example that demonstrates how to process HTML forms with servlets.
 *  Run this server, then go to the browser, type localhost:8080/form  */
public class HtmlFormServer {

	public static final int PORT = 8083;

	static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler context = new ServletContextHandler();
		context.addServlet(HtmlFormServlet.class, "/form");
		context.addServlet(WelcomeServlet.class, "/welcome");
		server.setHandler(context);
		server.start();
		server.join();
	}
}