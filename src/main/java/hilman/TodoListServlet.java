package hilman.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

@WebServlet("/todo/list")
public class TodoListServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
										throws IOException, ServletException {
		// Data yg akan ditampilkan,nantinya ambil dr database
		List<todo> daftartodo = new ArrayList<todo>();
		
		todo t1 = new todo();
		t1.setId(1);
		t1.setKeterangan("Registrasi Openshift");
		t1.setSelesai(true);
		daftartodo.add(t1);
		
		todo t2 = new todo();
		t2.setId(2);
		t2.setKeterangan("Buat app baru");
		t2.setSelesai(false);
		daftartodo.add(t2);
		
		todo t3 = new todo();
		t3.setId(3);
		t3.setKeterangan("Deploy Aplikasi");
		t3.setSelesai(false);
		daftarTodo.add(t3);
		
		//masukan data ke request attribute
		req.setAttribute("todo", daftarTodo);
		
		// redirect ke tampilan
		String lokasiJsp = "/WEB-INF/jsp/todo.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(lokasiJsp);
		rd.forward(req, res);
	}
}
									

