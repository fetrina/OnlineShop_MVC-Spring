$(document).ready(function(){
var name_ = $('#name');
  
    
    $.get('./get',function(data){
        $('#tblContent').html(data);
    });
    
    $("#dob").datepicker();
    
    //====untuk memberikan tampilan menarik pada button====
    $('#btnInsert').button().click(function(){
        $("#dialog-form").dialog("open");
    });   
    
    //====untuk mengeluarkan dialogform input kategori===
    $("#dialog-form").dialog({
        autoOpen: false,
        height: 320,
        width: 370,
        modal: true,
        buttons: {
            "Save Data": function() {
                $.post('./insert_category',{
                    "name": name_.val()
                },function(data){
                    $('#tblContent').html(data); 
                });
                $(this).dialog("close");
                name_.val('');
               
            },
            Cancel: function() {
                $(this).dialog("close");
                name_.val('');
               
            }
        },
        close: function() {
            name_.val('');
 
        }
    });
    
    //====untuk menampilkan data kategori=====
    var row = $('#rowCategories');    
    $.get('./category',function(data){        
        
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