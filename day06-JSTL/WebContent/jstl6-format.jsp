<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(6) JSP Format Tag :
		   formatNumber, formatDate</title>
</head>
<body>

<!--6. 사용할 값을 설정 -->
<c:set var="number"   value="123456.789" scope="page"/>
<c:set var="currency" value="2300000" 	 scope="page"/>

<%--
	<fmt:formatNumber>
	숫자 형식을 포맷팅하여 출력하는 태그
	통화(화폐단위)코드, 심볼을 표기
	숫자 패턴화 출력 : 세자리 숫자 끊어 읽기, 소숫점 이하 버림 등..
--%>

<h3>1. 숫자형식 출력</h3>
${number} 값을 : 3자리 끊어 읽기 적용 <br />

<fmt:formatNumber value="${number}" type="number" /> <br />
<fmt:formatNumber value="987654.321" type="number" /> <br />

<br />

(2) ${number} 값 : 통화 형태로 읽기 <br />
한국 원화 <br />
<fmt:formatNumber value="${number}" type="currency" currencyCode="KRW"/> <br />
<br />
유럽 유로화 <br />
<fmt:formatNumber value="5000" type="currency" currencyCode="EUR"/> <br />
<fmt:formatNumber value="5000" type="currency" currencySymbol="￡"/> <br />
<br />
달러 <br />
<fmt:formatNumber value="3000" type="currency" currencyCode="USD"/> <br />
<fmt:formatNumber value="3000" type="currency" currencySymbol="$"/> <br />
<br />
일본 엔화 <br />
<fmt:formatNumber value="2000" type="currency" currencyCode="JPY"/> <br />
<fmt:formatNumber value="2000" type="currency" currencySymbol="￥"/> <br />
<br />
중국 위안화<br />
<fmt:formatNumber value="1000" type="currency" currencyCode="CNY"/> <br />
<fmt:formatNumber value="1000" type="currency" currencySymbol="￥"/> <br />
<br />
영국 파운드화 <br />
<fmt:formatNumber value="500" type="currency" currencyCode="GBP"/> <br />
<fmt:formatNumber value="500" type="currency" currencySymbol="£"/> <br />
<hr />
(2) ${number} 값 : 소수점 읽기 패턴화 적용 <br />
<!-- type 이 number 이므로 숫자 세자리 끊어읽기 적용, 소숫점 이하 2자리까지 출력 -->
<fmt:formatNumber value="${number}" type="number" pattern=".00" /> <br />
<fmt:formatNumber value="1234567.123456789" pattern="0,000,000.00" /> <br />
<hr />
<h3>2. 날짜 형식 출력(패턴 적용)</h3>
<c:set var="today" value="<%=new Date() %>"/>

(1) 시간만 출력
<fmt:formatDate value="${today}" type="time"/> <br />

(2) 날짜만 출력
<fmt:formatDate value="${today}" type="date"/> <br />

(3) 시간 + 날짜 출력
<fmt:formatDate value="${today}" type="both"/> <br />

<hr />
<!-- 
	1. 100만 ~ 500만 까지 100만 단위로 늘어나는 숫자를
		numbers 리스트에 저장, for 구문 사용할 것
	
	2. fmt:formatNumber 태그를 사용하여 세자리 끊어 읽기 적용 출력
	
	3. fmt:formatNumber 태그를 사용하여 numbers 리스트의 각 원소 값에 대해 세자리 끊어 읽기 적용 출력
	
	4. 3을 출력할 때, 각 100만 ~ 500만 사이의 숫자중 3의 배수인 숫자를 판별하는 내용을 같이 출력할 것
	
	5. fmt:formatNumber 태그를 사용하여 numbers 리스트의 각 원소 값에 대해 통화코드 한국 원화 적용 출력
 -->

<!-- (1) -->
<%
 List<Integer> numbers = new ArrayList<>();
 
 for (int idx = 1000000; idx <= 5000000; idx+= 1000000) {
 	numbers.add(idx);
 }
 request.setAttribute("numbers", numbers);
 %>
 
 
<!-- (2) -->
<%-- request.setAttribute("numbers", numbers); 이것과 아래 문구는 같은 말 --%> 
<%--c:set var="numbers" value="${numbers}" scope="request"/ --%>
<hr />

<!-- (3) -->
<c:forEach var="number" items="${numbers}">
	 <!-- (5) -->
	 <fmt:formatNumber value="${number}" type="currency" currencyCode="KRW" />
	 <!-- (4) -->
	 <c:if test="${number % 3 eq 0}">
	 	3의 배수 입니다.
	 </c:if>
	 <br />
</c:forEach> 

<br />

</body>
</html>













