//触发模态框的同时调用此方法
function deleteInfo(id, title) {
    //向模态框中传值
    $('#delete-title').text(title)
}
//提交更改
function update(id) {
    $.ajax({
        type: "get",
        url: "delete.do",
        data: {id: id},
        success: function(result) {
            //location.reload();
        }
    });
}