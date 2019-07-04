<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">供应商管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="pro_info">供应商列表</a></li>
                <li role="presentation"><a href="#" role="button" class="pro_add_btn" data-toggle="modal" data-target=".pro-add-modal">新增供应商</a></li>
                <li role="presentation"><a href="#" class="pro_clearall_btn">供应商详情</a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">账单管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="bill_info">账单列表</a></li>
                <li role="presentation"><a href="#" class="bill_add_btn" data-toggle="modal" data-target=".bill-add-modal">添加账单</a></li>
                <li role="presentation"><a href="#" class="bill_view_btn">用户管理</a></li>
            </ul>
        </li>
    </ul>

</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
    //跳转到供应商页面
    $(".pro_info").click(function () {
        $(this).attr("href", "/market/provider/getProList");
    });
    //跳转到账单页面
    $(".bill_info").click(function () {
        $(this).attr("href", "/market/bill/getBillList");
    });
    //功能暂未实现的功能
    $(".pro_clearall_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
    //暂未实现的功能
    $(".bill_view_btn").click(function () {
        alert("对不起，您暂无权限进行操作！请先获取权限");
    });
</script>
</body>
</html>
