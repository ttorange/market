<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加供应商</title>
</head>
<body>
<div class="modal fade pro-add-modal" tabindex="-1" role="dialog" aria-labelledby="pro-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增供应商</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_pro_form">
                    <div class="form-group">
                        <label for="add_proName" class="col-sm-2 control-label">供应商名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="proName" class="form-control" id="add_proName" placeholder="xxx">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_proContacts" class="col-sm-2 control-label">联系人</label>
                        <div class="col-sm-8">
                            <input type="text" name="proContacts" class="form-control" id="add_proContacts" placeholder="XXX">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_proPhone" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-8">
                            <input type="text" name="proPhone" class="form-control" id="add_proPhone" placeholder="XXX">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary pro_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    <!-- ==========================供应商新增操作=================================== -->
    // 为简单操作，省去了输入名称的验证、错误信息提示等操作
    //1 点击供应商新增按钮，弹出模态框；
    //2 输入新增供应商信息，点击保存按钮，发送AJAX请求到后台进行保存；
    //3 保存成功跳转最后一页
    $(".pro_add_btn").click(function () {
        $('.pro-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    });

    $(".pro_save_btn").click(function () {
        var proName = $("#add_proName").val();
        var proContacts = $("#add_proContacts").val();
        var proPhone=$("#add_proPhone").val();
        //验证省略...
        $.ajax({
            url:"/market/provider/addPro",
            type:"PUT",
            data:$(".add_pro_form").serialize(),
            success:function (result) {
                if(result.code == 100){
                    alert("新增成功");
                    $('.pro-add-modal').modal("hide");
                    $.ajax({
                        url:"/market/provider/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            if (result.code == 100){
                                var totalPages1 = result.extendInfo.totalPages;
                                window.location.href="/market/provider/getProList?pageNo="+totalPages;
                            }
                        }
                    });
                }else {
                    alert(result.extendInfo.add_pro_error);
                }
            }
        });
    });

</script>
</body>
</html>
