package br.com.shoprest.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.shoprest.bean.ProdutoBean;
import br.com.shoprest.dao.ProdutoDAOSQLServerJTDS;

@WebServlet(name = "ProdutoServlets", urlPatterns = "/produtos")
public class ProdutoServlets extends HttpServlet {

	private static final long serialVersionUID = -6570640301908138095L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");

		resp.setStatus(201);

		List<String> atributos = new ArrayList<>();
		String at = null;
		while ((at = req.getReader().readLine()) != null) {
			atributos.add(at);
		}

		atributos.forEach(string -> {

			JSONObject jsonbject = new JSONObject(string);

			List<ProdutoBean> list = new ProdutoDAOSQLServerJTDS()
					.procuraProdutos(jsonbject.get("descricao").toString());
			try {
				resp.getWriter().print(new JSONArray(list).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

	}

}
