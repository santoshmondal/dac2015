package dac;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAsync
 */
@WebServlet(urlPatterns={"/TestAsync"}, asyncSupported=true)
public class TestAsync extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(Thread.currentThread().getName());
		AsyncContext startAsync = request.startAsync();
		
		startAsync.start(new Runnable() {
			@Override
			public void run() {
				try {
					ServletRequest request2 = startAsync.getRequest();
					ServletResponse response2 = startAsync.getResponse();
					
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(10000);
					System.out.println("ASYNC FINISH" + Thread.currentThread().getName());
					response2.getWriter().println("HELLO ASYNC!!");
					startAsync.complete();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("FINDISHED::" + Thread.currentThread().getName());
	}

}
