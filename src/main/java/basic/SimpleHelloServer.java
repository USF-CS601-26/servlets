package basic;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHandler;
import org.eclipse.jetty.server.Server;

/**
 * A simple web server that sends the same response for each GET request (an
 * html page that says Hello, friends!)
 *
 */
public class SimpleHelloServer {

	public static final int PORT = 8080;

	static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");

		context.addServlet(SimpleHelloServlet.class, "/hello"); // test by going to http://localhost:8080/hello

		context.addServlet(WelcomeServlet.class, "/welcome"); // takes the name as a parameter for a custom greeting
		// test WelcomeServlet by typing the following in the browser
		// http://localhost:8080/welcome?name=Swetha

		server.setHandler(context);

		server.start();
		server.join();
	}
}