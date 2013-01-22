$(document).ready(function () {
	
	
	path = window.location.href;		//Gets path from the address bar
	suffix = path.split("/");			//Splits the path and returns an array of strings
	suffix = suffix[suffix.length-1];	//Targets the end of the array to get the current page name
	//alert(suffix);
	$('a[href="/NBLibrary/'+suffix+'"]').parent().addClass('selected');
	
	var date = new Date();
	date.setFullYear(1900, 0, 1);
	
	$(function() {
        $( "#datepicker" ).datepicker({
            changeMonth: true,
            changeYear: true,
            minDate: date,
            maxDate: new Date(),
            yearRange: "-113:-0",
            showAnim: "slideDown"
        });
    });
	}
	

);


	
	