$(document).ready(function(){
    var row = $('#rowBuku');    
    $.get('./action?handler=loadbuku',function(data){        
        
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td>"+obj.id+"</td>");
            row.append("<td><img src=../../../../asset/image/produk/${obj.gambar} width=120/></td>");
            row.append("<td>"+obj.judul+"</td>");
            row.append("<td>"+obj.penulis+"</td>");
            row.append("<td>"+obj.penerbit+"</td>");
            row.append("<td>"+obj.tahun_terbit+"</td>");
            row.append("<td>"+obj.jml_hal+"</td>");
            row.append("<td>"+obj.jenis_cover+"</td>");
            row.append("<td>"+obj.isbn+"</td>"); 
            row.append("<td>"+obj.bahasa+"</td>");
            row.append("<td>"+obj.harga+"</td>");
            row.append("<td>"+obj.stok+"</td>");
            row.append("<td>"+obj.deskripsi+"</td>");
            
            row.append("<td>"+
                "<a href=\'action?handler=editbuku&id="+obj.id+"\'>edit</a> | "+
                "<a href=\'action?handler=deletebuku&id="+obj.id+"\'>delete</a>");
            row.append("</td>");
            row.append("</tr>");
        });
        
    });
    
});





