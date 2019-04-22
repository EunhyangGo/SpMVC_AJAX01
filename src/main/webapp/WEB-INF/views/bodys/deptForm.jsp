<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(function(){
	$("#btn-new").click(function(){
		$("#d_code").val("")
		$("#d_name").val("")
		$("#d_ceo").val("")
	})
	
	$("#btn-save").click(function(){
		let dcode = $("#d_code").val()
		let dname = $("#d_name").val()
		let dceo = $("#d_ceo").val()
		
		$.ajax({
			url: "<c:url value = 'dept_save' />",
			method: "POST",
			// serialize를 이용하게되면 아래 data부분을 대신해서 알아서 만들어주고 서버 전송까지해줌
			// form에 입력할 데이터가 많으면 하나하나 입력하지 않고 serialize를 이용하기
			// form의 input box에 담긴 데이터를 전송할 수 있도록 변환(묶음)시키는 기능
			// deptvo에서 정보를 받아서 똑같은 방법으로 끄집어내면됨.
			data:{deptVO:$("#dept-input").serialize()},
			
			/*
			data:{d_code:dcode, d_name:dname, d_ceo:dceo},
			*/
			success:function(result){
				alert(result)
			},
			
			error:function(){
				alert("서버와 통신 오류!!")
			}
		})
	})
})
</script>
<form id="dept-input">
	<label for="d_code">거래처코드</label>
	<input type="text" id="d_code" name="d_code"><br>
	
	<label for="d_code">거래처 이름</label>
	<input type="text" id="d_name" name="d_name"><br>
	
	<label for="d_code">거래처 대표</label>
	<input type="text" id="d_ceo" name="d_ceo"><br>
	
	<button type="button" id="btn-new">새로작성</button>
	<button type="button" id="btn-save">저장</button>
</form>