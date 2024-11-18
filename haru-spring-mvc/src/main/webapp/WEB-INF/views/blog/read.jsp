<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL(JavaServer Pages Standard Tag Library) 사용 설정 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% pageContext.setAttribute("CRLF", "\r\n"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>블로그 컨텐츠 읽기</title>
  </head>
  <body>
  	<%-- 모델에 추가한 blogCont 속성(attribute)에 접근한다
	     Map<String, Object> 타입 객체인 blogCont에 접근해 BLG_CONT_SEQ 키의 값을 출력한다 --%> 
	<p>글번호 : ${blogCont.BLG_CONT_SEQ}</p>
    <p>제목 : ${blogCont.TITLE}</p>
    <hr />
    <%-- jSTL: replace 함수 - 출력을 올바르게 하기 위해 오라클의 줄바꿈(CRLF)을 HTML의 줄바꿈으로 바꾼다 --%>
    <div>
      ${fn:replace(blogCont.CONT_BDY, CRLF ,' <br />')}
    </div>
    <hr />
    <p>
      입력일 : 
      <%-- jSTL: formatDate 함수 - 날짜 형식을 지정한다 --%>
      <fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss" />
    </p>
    <div>
      <form method="post" action="/delete">
        <input type="hidden" name="_method" value="delete" />
        <input type="hidden" name="blogContSeq" value="${blogCont.BLG_CONT_SEQ}" />
        <input type="submit" name="delete_button" value="삭제" />
      </form>
    </div>
  </body>
</html>