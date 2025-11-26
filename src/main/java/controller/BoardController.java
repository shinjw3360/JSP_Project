package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Board;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
       

	private RequestDispatcher rdp;
	private String destPage;
	private int isOk;
	private BoardService bsv;
	
	
	
    public BoardController() {
    	bsv = new BoardServiceImpl();
    }
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("BoardController Service method in Test!!");
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//jsp에서 요청하는 주소를 받는 객체
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> {}", uri);
		
		
	    switch(path) {
	    case "register" :
	    	destPage = "/board/register.jsp";
	    	break;
	    case "insert" :
	    	try {
	    		String title = request.getParameter("title");
	    		String writer = request.getParameter("writer");
	    		String content = request.getParameter("content");
	    		
	    		Board b = new Board(title, writer, content);
	    		isOk = bsv.insert(b);
	    		
	    		destPage = "/index.jsp";
	    	//
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    		}
	    	break;
	    	}
	    rdp = request.getRequestDispatcher(destPage);
	    rdp.forward(request, response);
		}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		service(request, response);
	}

}
