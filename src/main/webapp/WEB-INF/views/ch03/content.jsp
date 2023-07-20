<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card">
	<div class="card-header">Ch03.요청 매핑(처리) 메소드의 매개 변수 </div>
	<div class="card-body">
	   <div class="card m-2">
         <div class="card-header">
            GET 방식으로 요청
         </div>
         <div class="card-body">
            <a class="btn btn-info btn-sm" 
               href="method1?param2=5&param3=3.14&param4=true&param5=2021-08-27">요청</a>
            <hr/>
            <form method="get" action="method2">
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param1</span></div>
                  <input type="text" name="param1" class="form-control" value="문자열">
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param2</span></div>
                  <input type="text" name="param2" class="form-control" value="5" >
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param3</span></div>
                  <input type="text" name="param3" class="form-control" value="3.14">
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param4</span></div>
                  <div class="btn-group btn-group-toggle" data-toggle="buttons">
                     <label class="btn btn-secondary active">
                       <input type="radio" name="param4" checked value="true"> true
                     </label>
                     <label class="btn btn-secondary">
                       <input type="radio" name="param4" value="false"> false
                     </label>
                  </div>
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param5</span></div>
                  <input type="date" name="param5" class="form-control" value="2030-12-05">
               </div>
               <input class="mt-2 btn btn-info btn-sm" type="submit" value="요청"/>
            </form>
         </div>
      </div>
      
      <div class="card m-2">
         <div class="card-header">
            POST 방식으로 요청
         </div>
         <div class="card-body">
            <form method="post" action="method3">
               <!-- <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param1</span></div>
                  <input type="text" name="param1" class="form-control" value="문자열">
               </div> -->
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param2</span></div>
                  <input type="text" name="param2" class="form-control" value="5" >
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param3</span></div>
                  <input type="text" name="param3" class="form-control" value="3.14">
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param4</span></div>
                  <div class="btn-group btn-group-toggle" data-toggle="buttons">
                     <label class="btn btn-secondary active">
                       <input type="radio" name="param4" checked value="true"> true
                     </label>
                     <label class="btn btn-secondary">
                       <input type="radio" name="param4" value="false"> false
                     </label>
                  </div>
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param5</span></div>
                  <input type="date" name="param5" class="form-control" value="2030-12-05">
               </div>
               <input class="mt-2 btn btn-info btn-sm" type="submit" value="요청"/>
            </form>
         </div>
      </div>
   
      <div class="card m-2">
         <div class="card-header">
            AJAX로 요청
         </div>
         <div class="card-body">
            <form id="form1" name="form1">
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param1</span></div>
                  <input type="text" id="param1" name="param1" class="form-control" value="문자열">
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param2</span></div>
                  <input type="text" id="param2" name="param2" class="form-control" value="5" >
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param3</span></div>
                  <input type="text" id="param3" name="param3" class="form-control" value="3.14">
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param4</span></div>
                  <div class="btn-group btn-group-toggle" data-toggle="buttons">
                     <label class="btn btn-secondary active">
                       <input type="radio" id="radio1" name="param4" checked value="true"> true
                     </label>
                     <label class="btn btn-secondary">
                       <input type="radio" id="radio2" name="param4" value="false"> false
                     </label>
                  </div>
               </div>
               <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text">param5</span></div>
                  <input type="date" id="param5" name="param5" class="form-control" value="2030-12-05">
               </div>
            </form>
            <div class="mt-2">
               <button class="btn btn-info btn-sm" onclick="requestGet()">GET 방식 요청</button>
               <button class="btn btn-info btn-sm" onclick="requestPost()">POST 방식 요청</button>
               <button class="btn btn-info btn-sm" onclick="requestPost2()">POST 방식 요청</button>
            </div>
         </div>
         <script>
            function requestGet() {
               const param1 = document.form1.param1.value;
               const param2 = document.querySelector("#param2").value;
               const param3 = $("#param3").val();
               const param4 = $("#form1 input[name=param4]:checked").val();
               const param5 = $("#param5").val();
               
               console.log("param1:", param1);
               console.log("param2:", param2);
               console.log("param3:", param3);
               console.log("param4:", param4);
               console.log("param5:", param5);
               
               $.ajax({
                  url:"method4",
                  method:"get",
                  data: {
                     param1, 
                     param2 : param2, 
                     param3 : param3, 
                     param4 : param4,
                     param5 : param5
                  },
               	success : function(data){
               		console.log(data)
               	}
               });
            }
            
            function requestPost() {
               const param1 = document.form1.param1.value;
               const param2 = document.querySelector("#param2").value;
               const param3 = $("#param3").val();
               const param4 = $("#form1 input[name=param4]:checked").val();
               const param5 = $("#param5").val();
               
               //요청 본문
               //contentType : "application/x-www-form-urlencoded"
               //param1=문자열&param2=2&param3=3.1&param4=true&param5=2030-12-05
               $.ajax({
                  url:"method4",
                  method:"post",
                  contentType : "application/x-www-form-urlencoded",
                  data: {
                     param1:param1, 
                     param2, 
                     param3, 
                     param4, 
                     param5
                  },
                  success : function(data){
                 		console.log(data)
                 	}
                 });
              }
            
            function requestPost2() {
                const param1 = document.form1.param1.value;
                const param2 = document.querySelector("#param2").value;
                const param3 = $("#param3").val();
                const param4 = $("#form1 input[name=param4]:checked").val();
                const param5 = $("#param5").val();
                
                //요청 본문
                //contentType : "application/json; charset=UTF-8"
                //{"param1":"문자열", "param2":2, "param3":3.1 "param4":true, "param5":2030-12-05}
                $.ajax({
                   url:"method5",
                   method:"post",
                   contentType : "application/json; charset=UTF-8",
                   data: JSON.stringify({
                      param1:param1, 
                      param2, 
                      param3, 
                      param4, 
                      param5
                   }),
                   success : function(data){
                  		console.log(data)
                  	}
                  });
               }
         </script>
      </div>
     
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>