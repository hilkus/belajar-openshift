package hilman;
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
		List<Todo> daftarTodo = new ArrayList<Todo>();
		
		Todo t1 = new Todo();
		t1.setId(1);
		t1.setKeterangan("Registrasi Openshift");
		t1.setSelesai(true);
		daftarTodo.add(t1);
		
		Todo t2 = new Todo();
		t2.setId(2);
		t2.setKeterangan("Buat app baru");
		t2.setSelesai(false);
		daftarTodo.add(t2);
		
		Todo t3 = new Todo();
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
									

