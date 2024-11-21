<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL(JavaServer Pages Standard Tag Library) 사용 설정 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% pageContext.setAttribute("CRLF", "\r\n"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>블로그 컨텐츠 목록</title>
  </head>
  <body>
  	<!-- 검색창 -->
  	<div>
  	  <form>
  	    <input type="text" name="search" value="${blogListRequestVo.search}" style="width:50%;" />
  	    <input type="submit" name="search_btn" value="검색" />
  	  </form>
  	</div>
  	<c:if test="${not empty blogListResponseVoList}">
  	  <table>
  	    <thead>
  	      <tr>
  	        <th>글 번호</th>
  	        <th>제목</th>
  	        <th>작성일</th>
  	        <th>수정</th>
  	      </tr>
  	    </thead>
  	    <tbody>
  	      <c:forEach var="blogListResponseVo" items="${blogListResponseVoList}">
  	        <tr>
  	          <td>${blogListResponseVo.blgContSeq}</td>
  	          <td>${blogListResponseVo.title}</td>
  	          <td>${blogListResponseVo.createDt}</td>
  	          <td>
  	            <a href="/edit/${blogListResponseVo.blgContSeq}">수정</a>
  	          </td>
  	        </tr>
  	      </c:forEach>
  	    </tbody>
  	  </table>
  	</c:if>
  	<c:if test="${empty blogListResponseVoList}">
  	  <strong>검색 결과가 없습니다.</strong>
  	</c:if>
  </body>
</html>