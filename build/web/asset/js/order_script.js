$(document).ready(function(){
    var row = $('#rowOrder');    
    $.get('./action?handler=loadorder',function(data){        
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+ obj.id +"</td>");
            row.append("<td>"+ obj.tanggal +"</td>");
            row.append("<td>"+ obj.waktu +"</td>");
            row.append("<td>"+ obj.total_bayar +"</td>");
            row.append("<td>"+ obj.status_order +"</td>");
            
            row.append("<td>"+
                "<a href=\'action?handler=editorder&id="+obj.id+"\'>edit</a> | "+
                "<a href=\'action?handler=orderdetail&id="+obj.id+"\'>detail order</a>");
            row.append("</td>");
            row.append("</tr>");
        });
        
    });
    
});



