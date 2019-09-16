<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 입력하는 화면</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="beans" name="bookSaveForm" method="post">
	<table class="w3-table-all">
		<tr>
			<th class="w3-pink" colspan ="2">
			책 정보 입력 
			</th>
		</tr>
		<tr>
			<td class="w3-deep-orange">책 일련 번호</td>
			<td>
				<input type="number" name="sequence" required="required" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">ISBN</td>
			<td>
				<input type="text" name="isbn" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">도서명</td>
			<td>
				<input type="text" name="title" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">저자</td>
			<td>
				<input type="text" name="author" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">출판사</td>
			<td>
				<input type="text" name="company" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">페이지 수</td>
			<td>
				<input type="number" name="totalPage" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">가격</td>
			<td>
				<input type="number" name="price" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange">재고수량</td>
			<td>
				<input type="number" name="quantity" />
			</td>
		</tr>
		<tr>
			<td class="w3-deep-orange" colspan="2">
				<input type="reset" value="초기화"/>
				<input type="submit" value="저장하기"/>
			</td>
		</tr>
	</table>
</form>




</body>
</html>