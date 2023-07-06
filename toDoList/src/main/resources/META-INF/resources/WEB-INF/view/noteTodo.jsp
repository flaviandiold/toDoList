<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="container">
	<h1>${title}</h1>
	<form:form method="post" modelAttribute="todo">
	<form:input type="hidden" path="id"/>
	<form:textarea class="form-control mb-3" path="notes"
		rows="3" readonly="true"></form:textarea>
	<form:input type="hidden" path="title"/>
	<form:input type="hidden" path="status"/>
	<form:input type="hidden" path="targetDate"/>
	<input type="button" class="btn btn-success" id="editable" value="Update">
	<input type="submit" class="btn btn-success" value="Done">
	</form:form>
	<script>$(function(){
	    $("#editable").click(function(){
	        $('textarea').removeAttr("readonly");    
	    });             
	})</script>
</div>
