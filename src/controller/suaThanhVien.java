package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ThanhVienDAO;
import model.ThanhVien;

/**
 * Servlet implementation class suaThanhVien
 */
@WebServlet("/suaThanhVien")
public class suaThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaThanhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html:charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		boolean error = false;
		
		String matvCu = (String) session.getAttribute("thanhvien_id");
		
		int STT = Integer.parseInt(request.getParameter("STT"));
		session.setAttribute("STT", STT);
		
		String MaTV = request.getParameter("MaTV");
		session.setAttribute("MaTV", MaTV);
		
		String tenTV = request.getParameter("tenTV");
		session.setAttribute("tenTV", tenTV);
		
		
		String gioiTinh = request.getParameter("gioiTinh");
		session.setAttribute("gioiTinh", gioiTinh);
		
		int tuoi = Integer.parseInt(request.getParameter("tuoi"));
		session.setAttribute("tuoi", tuoi);
		
		String date = request.getParameter("date");
		session.setAttribute("date", date);

		String loai = request.getParameter("loai");
		session.setAttribute("loai", loai);
		
		String tkkh = request.getParameter("tkkh");
		session.setAttribute("tkkh", tkkh);
		
		String pass = request.getParameter("pass");
		session.setAttribute("pass", pass);
		
		String link;
		if (error) {
			link = request.getContextPath() + "/ThemTV.jsp";
			response.sendRedirect(link);
		} else {
			
			ThanhVien tv = new ThanhVien(STT, MaTV, tenTV, gioiTinh, tuoi, date, loai, tkkh, pass);
			ThanhVienDAO.edit(tv, matvCu);
			link = request.getContextPath() + "/QuanLyTV.jsp";
			response.sendRedirect(link);
		}
	}		
	
}
