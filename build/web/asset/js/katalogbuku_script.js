$(document).ready(function(){
    var row = $('#rowBuku');    
    $.get('./action?handler=loadbuku',function(data){        
                    
        $.each($.parseJSON(data), function(idx, obj) {
            row.append("<tr>");
            row.append("<td><table><tr><td><img src=../../../../asset/image/produk/${obj.gambar} width=120></td></tr></table></td>");
            row.append("<td>");
            row.append("<table>");
            row.append("<tr><td>Judul </td><td>:</td><td> "+obj.judul+"</td></tr>");
            row.append("<tr><td>Penulis </td><td>:</td><td> "+obj.penulis+"</td></tr>");
            row.append("<tr><td>Penerbit </td><td>:</td><td> "+obj.penerbit+"</td></tr>");
            row.append("<tr><td>Harga </td><td>:</td><td> Rp. "+obj.harga+"</td></tr>");
            
            row.append("<tr><td>"+
                "<a href=\'action?handler=belibuku&id="+obj.id+"\'>Beli</a> | "+
                "<a href=\'action?handler=detailbuku&id="+obj.id+"\'>Lihat Detail</a></td></tr>");
             row.append("</table>");
            row.append("</td>");
            row.append("</tr>");
            row.append("<tr></tr>");
        });
        
    });
    
});





