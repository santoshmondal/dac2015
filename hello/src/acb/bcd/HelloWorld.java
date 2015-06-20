package acb.bcd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(name="hello", urlPatterns={"/hello", "/hi"}, asyncSupported=true)
public class HelloWorld extends HttpServlet {
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
		final AsyncContext asyncContext = request.startAsync();
		
		asyncContext.addListener(new AsyncListener() {
			
			@Override
			public void onTimeout(AsyncEvent arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onComplete(AsyncEvent arg0) throws IOException {
				// TODO Auto-generated method stub
				System.out.println("COMPLETED!!");
				
			}
		});
		
		
		asyncContext.start(new Runnable() {
			@Override
			public void run() {
				try{
					System.out.println("ASYNC " + Thread.currentThread().getName());
					ServletRequest request2 = asyncContext.getRequest();
					ServletResponse response2 = asyncContext.getResponse();
					
					
					Thread.sleep(10000);
					
					PrintWriter out = response2.getWriter();
					out.println("HELLO ASYNC SERVLET!!");
					System.out.println("ASYNC " + Thread.currentThread().getName());

					asyncContext.complete();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		System.out.println("MAIN THREAD ENDS " + Thread.currentThread().getName());
	}

}
