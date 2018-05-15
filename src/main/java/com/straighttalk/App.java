package com.straighttalk;

import com.straighttalk.rest.Convert;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * App - This is a self contained jetty server serving up an interface to
 * convert numbers to words.  It also has an underlying REST API to support
 * the interface.
 * @author    Blanca Polo
 */
public class App {

    /**
     * Starts the jetty server and registers REST API classes with the jersey servlet.
     * @param args A string array containing the command line arguments.
     * @exception Exception
     * @return No return value.
     */
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/sonatypehw/*");

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                Convert.class.getCanonicalName());

        ServletHolder staticServlet = context.addServlet(DefaultServlet.class,"/*");
        staticServlet.setInitParameter("resourceBase","src/main/webapp");
        staticServlet.setInitParameter("pathInfoOnly","true");

        jettyServer.setHandler(context);

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        } finally {
            jettyServer.destroy();
        }
    }
}