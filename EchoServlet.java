package com.patni.ch2;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Echo servlet.  A variation on Snoop Servlet.  This servlet will echo the input content
 * body back out with no processing.
  */

public class EchoServlet extends HttpServlet {

    private static final int ONE_MEG = 1024*1024;

    // Since entity bodies are only present in POST, we'll just use that.
    public void doPost (HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
    {
	int buffsize = 1024*8;
	int contentLength = req.getContentLength();

        //value chosen to limit denial of service - 1 MB, in this case
        if (contentLength > ONE_MEG) {  
	    res.setContentType("text/html");
            ServletOutputStream out = res.getOutputStream();
	    out.println("<html><head><title>Too big</title></head>");
	    out.println("<body><h1>Error - content length &gt;8k not ");
	    out.println("</h1></body></html>");
        } else {
	    ServletInputStream in = req.getInputStream();
            byte[] b = new byte[contentLength];
	    int result;
	    int totalRead = 0;

	    try {
		result = in.readLine(b, 0, b.length);
		while (result != -1) {
		    totalRead += result;
		    result = in.readLine(b, totalRead, buffsize);
		}
	    } catch (IOException ioe) {
		// Ignore, it's probably from EOF
	    }

	    res.setContentType("text/html");
	    ServletOutputStream out = res.getOutputStream();
	    out.println("<html>");
	    out.println("<head><title>Echo Servlet</title></head>");
	    out.println("<body>");
    
	    Enumeration e = req.getHeaderNames();
	    if (e.hasMoreElements()) {
	        out.println("<h1>Request headers:</h1>");
	        out.println("<pre>");
	        while (e.hasMoreElements()) {
		    String name = (String)e.nextElement();
		    out.println(" " + name + ": " + req.getHeader(name));
	        }
	        out.println("</pre>");
	    }
    
            out.println("<h1>Content: </h1>");
	    out.println("<pre>");
	    out.write(b, 0, totalRead);
	    out.flush();
            
	    out.println("</pre>");
	    out.println("</body></html>");
        }
    }
    
    public String getServletInfo() {
	return "A servlet that shows the request headers and body sent by the client";
    }
}
