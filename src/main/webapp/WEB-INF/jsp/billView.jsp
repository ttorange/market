<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill View Page</title>
</head>
<body>
<<div class="modal fade bill-view-modal" tabindex="-1" role="dialog" aria-labelledby="bill-view-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">订单详情：</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal biew_view_form">
                    <div class="form-group">
                        <label for="view_bilId" class="col-sm-2 control-label">订单编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="bilId" class="form-control" id="view_bilId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="view_goodsName" class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="goodsName" class="form-control" id="view_goodsName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="view_amount" class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-8">
                            <input type="text" name="payment" class="form-control" id="view_amount">
                        </div>
                    </div>
                    <div class="form-group">
                            <label for="view_payment" class="col-sm-2 control-label">订单金额</label>
                            <div class="col-sm-8">
                                <input type="text" name="payment" class="form-control" id="view_payment">
                            </div>
                        </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">

    $(".bill_view_btn").click(function () {
        bilId = $(this).parent().parent().find("td:eq(0)").text();
        //alert("id"+bilId);
        $.ajax({
            url:"/market/bill/billView/"+bilId,
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    var billData = result.extendInfo.bill;
                    var payment=result.extendInfo.payment;
                    //回显
                    $("#view_bilId").val(billData.bilId);
                    $("#view_goodsName").val(billData.goodsName);
                    $("#view_amount").val(billData.amount);
                    $("#view_payment").val(payment)
                }else {
                    alert("无此订单");
                }
            }
        });
    });

    $(".bill_select_btn").click(function () {
        bilId= $("#bilId").val();
        alert("id"+bilId);
        $.ajax({
            url: "/market/bill/billView/"+bilId,
            type: "GET",
            success: function (result) {
                if (result.code == 100){
                    var billData = result.extendInfo.bill;
                    var payment=result.extendInfo.payment;
                    //回显
                    $("#view_bilId").val(billData.bilId);
                    $("#view_goodsName").val(billData.goodsName);
                    $("#view_amount").val(billData.amount);
                    $("#view_payment").val(payment)
                }else {
                    alert("无此订单");
                }

            }
        });
    });
</script>
</body>
</html>
