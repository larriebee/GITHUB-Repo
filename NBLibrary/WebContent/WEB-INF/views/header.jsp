<link rel="stylesheet" href="<c:url value="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" /> " />
<link href="<c:url value="resources/css/styles.css"  />" rel="stylesheet" type="text/css" >
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"  />"  type="text/javascript" > </script>
<script src="<c:url value="http://code.jquery.com/ui/1.9.2/jquery-ui.js"  />" ></script>
<script src="<c:url value="resources/js/scriptUI.js"  />"  type="text/javascript" > </script>

<script type="text/javascript">
			$(document).ready(function() {
			
				$( ".auto_complete_email" ).autocomplete({
					source: '${pageContext. request. contextPath}/get_email_list.html'
				});
				
				$( ".auto_complete_title" ).autocomplete({
					source: '${pageContext. request. contextPath}/get_title_list.html'
				});
				
			});
</script>