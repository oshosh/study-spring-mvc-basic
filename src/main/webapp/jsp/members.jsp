<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-08
  Time: 오후 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>

<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
  <table>
    <thead>
      <th>id</th>
      <th>username</th>
      <th>age</th>
    </thead>
    <tbody>
      <%
        for (Member member : members) {
          out.write(" <tr>");
          out.write(" <td>" + member.getId() + "</td>");
          out.write(" <td>" + member.getUsername()+ "</td>");
          out.write(" <td>" + member.getAge() + "</td>");
          out.write(" </tr>");
        }
      %>
    </tbody>
  </table>
</body>
</html>
