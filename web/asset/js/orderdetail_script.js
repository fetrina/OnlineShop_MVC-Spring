$(document).ready(function(){
    var row = $('#rowOrderDetail');    
    $.get('./action?handler=loadorderdetail',function(data){        
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+ obj.id +"</td>");
            row.append("<td>"+ obj.buku +"</td>");
            row.append("<td>"+ obj.qty +"</td>");
            row.append("<td>"+ obj.subtotal +"</td>");
 
            row.append("</td>");
            row.append("</tr>");
        });
        
    });
    
});



