<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>수량</th>
				<th>판매여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ajaxList}" var="vo">
				<tr>
					<td>${vo.productNum}</td>
					<td class="detail" data-num="${vo.productNum}">${vo.productName}</td>
					<td>${vo.productPrice}</td>
					<td>${vo.productCount}</td>
					<th>${vo.sale=='1'?'판매중':'판매중지'}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row my-4">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a data-pn="${pager.pre?pager.startNum-1:0}" class="page-link pager"
					href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
	
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a data-pn="${i}" class="page-link pager"
						href="#">${i}</a></li>
				</c:forEach>
	
				<li class="page-item"><a data-pn="${pager.next?pager.lastNum+1:0}" class="page-link pager"
					href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>