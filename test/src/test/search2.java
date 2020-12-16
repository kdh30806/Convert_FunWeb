package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Servlet implementation class search3
 */
@WebServlet("/search2")
public class search2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public search2() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int count = 0;
		String id = request.getParameter("id");
		String node_name = request.getParameter("node_name");
		String att_name = request.getParameter("att_name");
		String att_value = request.getParameter("att_value");	
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("id", isEmpty(id));
		map.put("node_name", isEmpty(node_name));
		map.put("att_name", isEmpty(att_name));
		map.put("att_value", isEmpty(att_value));
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(request.getRealPath("/") + "/white.xhtml");
			Element root = document.getDocumentElement();

			Node node1 = root.getChildNodes().item(3).getChildNodes().item(1);		
			count = checkDOM(node1, id, node_name, att_name, att_value, map, 0);
			
			System.out.println("찾은 갯수는 : " + count + "개 입니다.");
			response.sendRedirect("white.xhtml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int checkDOM(Node node1, String id, String node_name, String att_name, String att_value, Map<String, Boolean> map, int depth) {

		if (node1.getNodeType() == Node.ELEMENT_NODE) {
			if (node1.hasChildNodes()) {
				for (int i = 0; i < node1.getChildNodes().getLength(); i++) {
					Node node2 = node1.getChildNodes().item(i);
					depth = checkDOM(node2, id, node_name, att_name, att_value, map, depth);
				}
			}
			Element ele = (Element) node1;

			if (!map.get("id") && !(ele.getAttribute("id").equals(id))) {
				return depth;
			}

			if (!map.get("node_name") && !(ele.getNodeName().equals(node_name))) {
				return depth;
			}

			if (!map.get("att_name") && !(ele.hasAttribute(att_name))) {
				return depth;
			}

			if (!map.get("att_value") && !(ele.getAttribute(att_name).equals(att_value))) {
				return depth;
			}
			
			depth++;
		}
		return depth;
	}
	
	public boolean isEmpty(String value) {
		if (value == null || value == "") {
			return true;
		} else {
			return false;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
