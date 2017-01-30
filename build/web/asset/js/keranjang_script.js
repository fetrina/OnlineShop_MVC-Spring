$(document).ready(function(){
    var row = $('#rowKeranjang');    
    $.get('./action?handler=loadbuku',function(data){        
             
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+obj.id+"</td>");
            row.append("<td>"+obj.qty+"</td>");
            row.append("<td>"+obj.subtotal+"</td>");
            row.append("<td>"+obj.buku+"</td>");
            
            row.append("<td>"+
                "<a href=\'action?handler=editkeranjang&id="+obj.id+"\'>edit</a> | "+
                "<a href=\'action?handler=deletekeranjang&id="+obj.id+"\'>delete</a>");
            row.append("</td>");
            row.append("</tr>");
           
        });
        
    });
    
});





