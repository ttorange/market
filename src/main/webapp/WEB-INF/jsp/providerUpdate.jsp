<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑供应商信息</title>
</head>
<body>
<div class="modal fade pro-update-modal" tabindex="-1" role="dialog" aria-labelledby="pro-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_pro_form">
                    <div class="form-group">
                        <label for="update_proName" class="col-sm-2 control-label">供应商名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="proName" class="form-control" id="update_proName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_proContacts" class="col-sm-2 control-label">联系人</label>
                        <div class="col-sm-8">
                            <input type="text" name="proContacts" class="form-control" id="update_proContacts">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_proPhone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-8">
                            <input type="text" name="proPhone" class="form-control" id="update_proPhone">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary pro_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
    <!-- ==========================供应商新增操作=================================== -->
    //1 点击编辑按钮，发送AJAX请求查询对应id的供应商信息，进行回显；
    //2 进行修改，点击更新按钮发送AJAX请求，将更改后的信息保存到数据库中；
    //3 跳转到当前更改页；
    var edit_proId = 0;
    var curPageNo = ${curPageNo};

    $(".pro_edit_btn").click(function () {
        edit_proId = $(this).parent().parent().find("td:eq(0)").text();
        alert("id"+edit_proId);
        //查询对应deptId的部门信息
        $.ajax({
            url:"/market/porvider/getProById/"+edit_proId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var proData = result.extendInfo.provider;
                    //回显
                    $("#update_proName").val(proData.proName);
                    $("#update_proContacts").val(proData.proContacts);
                    $("#update_proPhone").val(proData.proPhone);
                }else {
                    alert(result.extendInfo.get_pro_error);
                }
            }
        });
    });

    $(".pro_update_btn").click(function () {
        $.ajax({
            url:"/market/provider/updatePro/"+edit_proId,
            type:"PUT",
            data:$(".update_pro_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("更新成功！");
                    window.location.href = "/market/provider/getProList?pageNo="+curPageNo;
                } else {
                    alert(result.extendInfo.update_pro_error);
                }
            }

        });
    });


</script>
</body>
</html>
