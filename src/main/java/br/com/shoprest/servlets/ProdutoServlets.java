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

@WebServlet(name = "ProdutoServlets", urlPatterns = "/produtos")
public class ProdutoServlets extends HttpServlet {

	private static final long serialVersionUID = -6570640301908138095L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdutoBean p = new ProdutoBean();
		p.setCodigo("1");
		p.setDescricaoProduto("Produto 1");
		p.setCodigoBarra("789");
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.setStatus(200);

		PrintWriter printWriter = resp.getWriter();
//		
//		printWriter.print(new Gson().toJson(p));
		
		printWriter.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProdutoBean> list = new ArrayList<>();
		
		ProdutoBean p = new ProdutoBean();
		p.setCodigo("1");
		p.setDescricaoProduto("Produto 1");
		p.setCodigoBarra("789");
		list.add(p);
		
		ProdutoBean p2 = new ProdutoBean();
		p2.setCodigo("2");
		p2.setDescricaoProduto("Sabao");
		p2.setCodigoBarra("789");
		list.add(p2);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		resp.setStatus(201);
		
		List<String> atributos = new ArrayList<>();
		String at = null;
		while ((at = req.getReader().readLine()) != null) {
			atributos.add(at);
			
		}
		
		
		list.forEach(arg ->{
			atributos.forEach(string ->{
//				try {
//					resp.getWriter().print(string.split("\"descricao\":"));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
					
				 JSONObject jsonbject = new JSONObject(string);
				 
				 System.out.println(string);
				 
				
				 
//				
//				
//				System.out.println(string);
//				if(arg.getDescricaoProduto().contains(string)) {
//					try {
//						resp.getWriter().print(new Gson().toJson(arg));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
			});
		});			
				
		
	}
	
}
