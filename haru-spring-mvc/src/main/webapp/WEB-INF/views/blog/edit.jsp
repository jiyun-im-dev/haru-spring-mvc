<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL(JavaServer Pages Standard Tag Library) 사용 설정 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% pageContext.setAttribute("CRLF", "\r\n"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>블로그 컨텐츠 수정</title>
  </head>
  <body>
    <form method="post">
      <input type="hidden" name="_method" value="put" />
      <p>글 번호: ${blogCont.BLG_CONT_SEQ}</p>
      <p>
        제목:
        <input type="text" name="title" style="width:80%" value="${blogCont.TITLE}" />
      </p>
      <p>
        본문
      </p>
      <p>
        <textarea rows="10" name="content_body" style="width:100%">${blogCont.CONT_BDY}</textarea>
      </p>
      <p>
        <%-- JSTL - formatDate 함수: 날짜 형식을 지정한다 --%>
        <fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss" />
      </p>
      <p>
        <input type="submit" name="create" value="저장" />
      </p>
    </form>
  </body>
</html>