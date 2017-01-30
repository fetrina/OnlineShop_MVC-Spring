$(document).ready(function(){
    var row = $('#rowCategories');  
    
     //====untuk menampilkan data kategori=====
    $.get('./action?handler=loadcategory',function(data){        
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+obj.id+"</td>");
            row.append("<td>"+obj.name+"</td>");
            row.append("<td>"+
                "<a href=\'action?handler=editcategory&id="+obj.id+"\'>edit</a> | "+
                "<a href=\'action?handler=deletecategory&id="+obj.id+"\'>delete</a>");
            row.append("</td>");
            row.append("</tr>");
        });
        
    });
    
});

