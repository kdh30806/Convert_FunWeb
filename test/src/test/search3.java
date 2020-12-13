package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * Servlet implementation class search3
 */
@WebServlet("/search3")
public class search3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search3() {
    }
    
    public boolean isEmpty(String value){
    	if(value == null || value == ""){
			return true;
		}else{
			return false;
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int count = 0;
		String id = request.getParameter("id");
		String node = request.getParameter("node");
		String att_name = request.getParameter("att_name");
		String att_value = request.getParameter("att_value");

		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//			Document document = documentBuilder.parse("C:\\Users\\CI\\git\\Repository\\test\\WebContent\\white.xhtml");
			Document document = documentBuilder.parse(request.getRealPath("/")+"/white.xhtml");
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			
			XPathExpression expr = xPath.compile("//*[@name='"+node+"']");
			Object result = expr.evaluate(document, XPathConstants.NODESET);
			
			NodeList nodes = (NodeList) result;
			
			if(id == "") { // 폼의 아이디의 입력 값이 비어있으면
				for(int i = 0 ; i < nodes.getLength() ; i++) { //name 으로 찾은 노드의 갯수 만큼 반복
					Element element = (Element) nodes.item(i);
//					System.out.println(element.getAttribute("class"));
					if(nodes.item(i) != null) { //널이 아니면
						if(!isEmpty(att_name)) { // att_name 이 비어있지 않다면
							if(!isEmpty(att_value)) {
								if(element.getAttribute(att_name).equalsIgnoreCase(att_value)) {
									count++;
								}
							}else {
								if(!isEmpty(element.getAttribute(att_name))) {
									System.out.println();
									count++;
								}
							}
						}else {
							count = nodes.getLength();
						}
					}
				}
				
			}else { // 폼의 아이디의 입력 값이 비어있지 않다면 => 아이디는 유일하게 1개
				count = 1;
			}
			
//			expr = xPath.compile("//div[@id='c']");
//			result = expr.evaluate(document, XPathConstants.NODESET);
//			Node node1 = (Node) result;
//			node1.setTextContent("찾은 갯수는 " + count + "개 입니다.");
			System.out.println("찾은 갯수는 : " + count + "개 입니다.");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().append("찾은 갯수는: " + count + "개 입니다.");
//			response.sendRedirect("white.xhtml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
