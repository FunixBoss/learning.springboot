<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajax</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
</head>
<body>
	<h3>Demo 1 - Simple</h3>

	<input type="button" value="Demo 1" id="buttonDemo1"/>
	
	<span id="result"></span>

	<h3>Demo 2 - Get</h3>
	Fullname <input type="text" name="" id="textBoxFullname">
		<input type="button" value="Demo 2" id="buttonDemo2"/>
	<span id="result2"></span>
	
	<h3>Demo 3 - Post</h3>
	Username <input type="text" name="" id="textBoxUsername"> <br>
	Password <input type="password" name="" id="textBoxPassword">
			<input type="button" value="Demo 3" id="buttonDemo3"/>
	<span id="result3"></span>
	
	<h3>Demo 4 - Json</h3>
	<input type="button" value="Demo 4" id="buttonDemo4"/>
	<span id="result4"></span>
	
	<h3>Demo 5 - Json - Display a List</h3>
	<input type="button" value="Demo 5" id="buttonDemo5"/>
	<span id="result5"></span>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#buttonDemo1").click(function(){
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/ajax/ajax1',
					success: function(data){
						$("#result").html(data)
					}
				})
			})
			$("#buttonDemo2").click(function(){
				var fullname = $("#textBoxFullname").val();
				$.ajax({
					type: 'GET',
					data: {
						fullname: fullname,
					},
					url: '${pageContext.request.contextPath}/ajax/ajax2',
					success: function(data){
						$("#result2").html(data)
					}
				})
			})
			$("#buttonDemo3").click(function(){
				var fullname = $("#textBoxUsername").val();
				var password = $("#textBoxPassword").val();
				$.ajax({
					type: 'POST',
					data: {
						fullname: fullname,
						password: password
					},
					url: '${pageContext.request.contextPath}/ajax/ajax3',
					success: function(data){
						$("#result3").html(data)
					}
				})
			})
			$("#buttonDemo4").click(function(){
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/ajax/ajax4',
					success: function(product){
						var s = '<br>id: ' + product.id;
						s += '<br>name: ' + product.name;
						s += '<br>price: ' + product.price;
						s += '<br>photo: ' + product.photo;
						s += '<br>category: ' + product.category;
						$("#result4").html(s);
					}
				})
			})
			
			$("#buttonDemo5").click(function(){
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath}/ajax/ajax5',
					success: function(products){
						var s = ''
						for(var i = 0; i < products.length; i++){
							s += '<br>id: ' + products[i].id;
							s += '<br>name: ' + products[i].name;
							s += '<br>price: ' + products[i].price;
							s += '<br><img src="${pageContext.request.contextPath}/resources/images/' + products[i].photo + '" width=120 hight=200>';
							s += '<br>category: ' + products[i].category;
							s += '<br>-----------------------------------------'
						}
						$("#result5").html(s);
					}
				})
			})
		})
	</script>
</body>
</html>