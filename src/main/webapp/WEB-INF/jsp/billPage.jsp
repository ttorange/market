<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账单列表</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 中间账单信息展示内容 -->
        <div class="bill_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">账单管理</a></li>
                        <li class="active">账单列表</li>
                    </ol>
                </div>
                <!-- Table -->
                <form class="form-inline selectBillFrom" role="form">
                    <div class="form-group ">
                        <label>输入订单ID</label>
                        <input type="value" class="form-control" id="bilId" placeholder="请输入订单ID">
                        <a href="#" role="button" class="btn btn-primary bill_select_btn" data-toggle="modal" data-target=".bill-view-modal">订单详情</a>
                    </div>
                </form>
                <table class="table table-bordered table-hover" id="bill_table">
                    <thead>
                    <th>账单编号</th>
                    <th>商品名称</th>
                    <th>供应商名称</th>
                    <th>数量</th>
                    <th>支付状态</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${bill}" var="b">
                            <tr>
                                <td>${b.bilId}</td>
                                <td>${b.goodsName}</td>
                                <td>${b.proName}</td>
                                <td>${b.amount}</td>
                                <td>${b.isPay == 1 ? "已支付": "未支付"}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary bill_view_btn" data-toggle="modal" data-target=".bill-view-modal">订单详情</a>
                                    <a href="#" role="button" class="btn btn-danger bill_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPage}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="/market/bill/getBillList?pageNo=1">首页</a></li>
                            <c:if test="${curPage==1}">
                                <li class="disabled">
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                <c:if test="${curPage == itemPage}">
                                    <li class="active"><a href="/market/bill/getBillList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPage != itemPage}">
                                    <li><a href="/market/bill/getBillList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${curPage==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPage!=totalPages}">
                                <li>
                                    <a href="#" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="/market/bill/getBillList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="billAdd.jsp"%>
<%@ include file="billView.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/market/bill/getBillList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/market/bill/getBillList?pageNo="+pageNo);
            }
        });
    })

    <!-- =========================  账单删除操作=================================== -->
    $(".bill_delete_btn").click(function () {
        var curPage = ${curPage};
        var delbilId = $(this).parent().parent().find("td:eq(0)").text();
        if (confirm("确认删除订单号【" + delbilId+ "】的信息吗？")){
            $.ajax({
                url:"/market/bill/deleteBill/"+delbilId,
                type:"DELETE",
                success:function (result) {
                    if (result.code == 100){
                        alert("删除成功！");
                        window.location.href="/market/bill/getBillList?pageNo="+curPage;
                    }else {
                        alert(result.extendInfo.bill_del_error);
                    }
                }
            });
        }
    });



</script>
</body>
</html>
