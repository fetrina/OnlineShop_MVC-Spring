$(document).ready(function(){
    var row = $('#rowCustomer');    
    $.get('./action?handler=loadcustomer',function(data){        
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+obj.id+"</td>");
            row.append("<td>"+obj.nama+"</td>");
            row.append("<td>"+obj.hp+"</td>");
            row.append("<td>"+obj.email+"</td>");
            row.append("<td>"+obj.alamat+"</td>");
            row.append("<td>"+obj.kota+"</td>");
            row.append("<td>"+obj.provinsi+"</td>");
            
            row.append("<td>"+
                "<a href=\'action?handler=editcustomer&id="+obj.id+"\'>edit</a> | "+
                "<a href=\'action?handler=deletecustomer&id="+obj.id+"\'>delete</a>");
            row.append("</td>");
            row.append("</tr>");
        });
        
    });
    
});



