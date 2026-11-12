package messageboard;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

/** An example demonstrating how to create a simple message board using jetty/servlets.
 *  Run MessageServer, then go to localhost:8091/messageBoard
 *  Courtesy of Prof. Engle.
 */
public class MessageServer {

	public static final int PORT = 8091;

	static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(MessageServlet.class, "/messages");
		server.setHandler(handler);
		server.start();
		server.join();
	}
}