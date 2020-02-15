package openfeedbackbackend;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }

    public static String getHelloMessage() {
        return "<h1>Hello World!</h1>";
    }

    public static class HelloHandler extends AbstractHandler {

        @Override
        public void handle(
            final String target,
            final Request baseRequest,
            final HttpServletRequest request,
            final HttpServletResponse response
        ) throws IOException, ServletException {
            response.setContentType("text/html; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            final PrintWriter out = response.getWriter();
            out.println(Main.getHelloMessage());
            baseRequest.setHandled(true);
        }
    }

}
