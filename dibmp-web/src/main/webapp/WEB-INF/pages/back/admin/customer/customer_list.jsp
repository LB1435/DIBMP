<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/customer/customer_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="22"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;客户信息列表</strong>
			</div>
			<div class="panel-body">
				<div>
					<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
				</div>
				<table class="table table-condensed">
					<thead>
						<tr>
							<th class="text-center" style="width:10%;">客户姓名</th> 
							<th class="text-left" style="width:10%;">客户电话</th>
							<th class="text-left" style="width:10%;">重要性</th>
							<th class="text-left" style="width:20%;">联系地址</th>
							<th class="text-left" style="width:10%;">记录日期</th>
							<th class="text-center" style="width:10%;">联系次数</th>
							<th class="text-center" style="width:10%;">记录者</th>
							<th class="text-left" style="width:20%;">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${allcustomer }" var="allcustomer">
						<tr name="vo" id="vo">
							<td class="text-center"><span id="cid-${allcustomer.cuid }" style="cursor:pointer;" title="查看联系记录">${allcustomer.name }</span></td>
							<td class="text-left">${allcustomer.phone }</td>
							<td class="text-left"><span class="text-danger">${citems[allcustomer.ciid] }</span></td>
							<td class="text-left">${allcustomer.address }</td>
							<td class="text-left"><fmt:formatDate value="${allcustomer.inDate}" pattern="yyyy-MM-dd" type="date"  /></td>
							<td class="text-center">${allcustomer.connum }</td>
							<td class="text-center"><span id="mid-admin" style="cursor:pointer;">${allcustomer.recorder }</span></td> 
							<td class="text-left">
								<button class="btn btn-primary btn-xs" id="input-1">
										<span class="glyphicon glyphicon-floppy-save"></span>&nbsp;追加记录</button>
								<button class="btn btn-danger btn-xs" id="out-${allcustomer.cuid }">
										<span class="glyphicon glyphicon-log-out"></span>&nbsp;商品出库</button>
							</td>
						</tr>
							</c:forEach>
					</tbody>
				</table>
				<div id="splitBarDiv" style="float:right">
					<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/> 
				</div>
			</div>
			<div class="panel-footer" style="height:100px;">
				<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/member_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/customer_record_list_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/customer_record_input_modal.jsp"/> 
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
