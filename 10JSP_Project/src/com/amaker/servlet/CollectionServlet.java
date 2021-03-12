package com.amaker.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.bean.CollectionBean;
import com.amaker.dao.CollDao;
import com.amaker.dao.impl.CollDaoImpl;

public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CollectionServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("save")) {
			save(request, response);
		} else if (action != null && action.equals("list")) {
			list(request, response);
		} else if (action != null && action.equals("get")) {
			get(request, response);

		} else if (action != null && action.equals("update")) {
			update(request,response);
		} else if(action!=null&&action.equals("delete")) {
			delete(request,response);
		}else{
			
		}

	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = new CollectionBean();
		bean.setName(name);
		bean.setUrl(url);
		dao.save(bean);
		list(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		CollDao dao = new CollDaoImpl();
		CollectionBean bean = new CollectionBean();
		bean.setId(new Integer(id).intValue());
		bean.setName(name);
		bean.setUrl(url);
		dao.update(bean);
		list(request, response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		CollDao dao = new CollDaoImpl();
		dao.delete(ids);
		list(request, response);

	}

	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CollDao dao = new CollDaoImpl();

		CollectionBean bean = dao.get(new Integer(id).intValue());
		request.setAttribute("CollectionBean", bean);
		request.getRequestDispatcher("/CollectionEdit.jsp").forward(request, response);

	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CollDao dao = new CollDaoImpl();

		List list = dao.list();
		request.setAttribute("CL", list);

		request.getRequestDispatcher("/Collection.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
