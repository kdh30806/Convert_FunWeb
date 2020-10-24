<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javax.mail.*" %>
<%@ page import = "javax.mail.internet.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%   
   Properties prop = new Properties();
   prop.put("mail.smtp.host", request.getParameter("smtpServer"));
   prop.put("mail.smtp.user", request.getParameter("serverAccount"));   
   javax.mail.Session mailSession = 
             javax.mail.Session.getDefaultInstance(prop, null);   
   MimeMessage message = new MimeMessage(mailSession);
   InternetAddress from = new InternetAddress(request.getParameter("senderEmail"));
   message.setFrom(from);   
   InternetAddress to = new InternetAddress(request.getParameter("receiverEmail"));
   InternetAddress[] toList = {to};
   message.setRecipients(Message.RecipientType.TO, toList);
   message.setSubject(request.getParameter("subject"), "iso8859-1");
   message.setContent(request.getParameter("content"), "text/plain");   
   Transport.send(message);
%>
<html>
<head><title>메일전송완료</title></head>
<body>
메일을 전송하였습니다.
</body>
</html>
</body>
</html>