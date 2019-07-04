<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill Add Page</title>
</head>
<body>
<div class="modal fade bill-add-modal" tabindex="-1" role="dialog" aria-labelledby="bill-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增账单</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_bill_form">
                    <div class="form-group">
                        <label for="add_amount" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-8">
                            <input type="value" name="goodsName" class="form-control" id="add_goodsName" placeholder="输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_amount" class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-8">
                            <input type="number" name="amount" class="form-control" id="add_amount" placeholder="输入数量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">支付状态</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" checked="checked" name="isPay" id="add_isPay1" value=1> 已支付
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isPay" id="add_isPay2" value=0> 未支付
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary bill_save_btn">提交订单</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

    <!-------------------------------------账单新增操作-------------------------------------->

    $(".bill_add_btn").click(function () {

        $.ajax({
            url:"/market/bill/getGoodsList",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $.each(result.extendInfo.goodsList, function () {
                        var optionEle = $("<option></option>").append(this.goodsName).attr("value", this.goodsId);
                        optionEle.appendTo("#add_bill");
                    });
                }
            }
        });

        $('.bill-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });

    //3 保存

    $(".bill_save_btn").click(function () {


        $.ajax({
            url:"/market/bill/addBill",
            type:"POST",
            data:$(".add_bill_form").serialize(),
            success:function (result) {
                if (result.code == 100){
                    alert("账单已提交");
                    $('#bill-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"/market/bill/getTotalPages",
                        type:"GET",
                        success:function (result) {
                            var totalPage = result.extendInfo.totalPages;
                            window.location.href="/market/bill/getBillList?pageNo="+totalPage;
                        }
                    })
                } else {
                    alert("提交失败！该商品不存在");
                }
            }

        });

    });

</script>
</body>
</html>
