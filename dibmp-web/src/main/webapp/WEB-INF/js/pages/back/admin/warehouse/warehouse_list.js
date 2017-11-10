wid = 0 ;
$(function(){
	
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			console.log("仓库管理员编号：" + mid) ;
			$("#memberInfo").modal("toggle") ;
		}) ;
	}) ;
	
	
	$("button[id^=editadmin-]").each(function(){
		$(this).on("click",function(){
			wid = this.id.split("-")[1] ;
			console.log("修改仓库管理员，仓库编号：" + wid) ;
			loadData() ; // 异步数据加载与分页控制
			$("#memberDeptInfo").modal("toggle") ;
			if (wid != null) {
			$.post("/dibmp/pages/back/admin/warehouse/getDept.action",function(data){
				$("#did option:gt(0)").remove();
				//console.log("##########");
				for(var x=0; x<data.length; x++){
					$("#did").append("<option value="+data[x].did+">"+data[x].dname+"</option>");
					//console.log(data[x].did);
				}
			},"json");
			}else{
				$("#did option:gt(0)").remove();
			}
			$("select[id=did]").each(function(){
				$(this).on("change",function(){
					var did=($("#did  option:selected").attr("value"));
					console.log("部门编号:"+did +"、 仓库编号:"+wid);
					$.post("/dibmp/pages/back/admin/warehouse/getMember.action",{"did":did,"wid":wid},
							function(data){
						//console.log(data);
						$("#member").empty();
						for (var x = 0; x < data.length; x++) {
//							console.log(data[x].mid);
//							console.log(data[x].name);
							
							$("#member").append("<tr>"
									+"<td class='text-center'>"+"<img src='upload/member/nophoto.png' style='width:20px;'/>"+"</td>"
									+"<td class='text-center' id='memberName-"+data[x].mid+"'>"+data[x].name+"</td>"
									+"<td class='text-center'>"+data[x].lid+"</td>"
									+"<td class='text-center'>"+data[x].phone+"</td>"
									+"<td class='text-center'>"
									+"<button class='btn btn-danger btn-xs' id="+"addadmin-"+data[x].mid+">"
									+"<span class='glyphicon glyphicon-plus-sign'></span> "
									+" 设置为库管"+"</button>"
									+"</td>"
									+"</tr>");
						}
						
						$("button[id^=addadmin-]").each(function(){
							$(this).on("click",function(){
								 var mid = this.id.substring(this.id.indexOf("-")+1) ;
								
								 var name = $("#memberName-"+mid).text() ;
								
								console.log("新的仓库管理员编号：" + mid) ;
								console.log("管理员姓名"+ name);
								console.log("仓库编号：" + wid) ;
								ele = $("<span id='mid-admin' style='cursor:pointer;'>"+name+"</span>") ;
								ele.on("click",function(){
									console.log("仓库管理员ID：" + mid) ;
									$("#memberInfo").modal("toggle") ;
									
								}) ;
								$("#admin-" + wid).html(ele) ;
								$("#memberDeptInfo").modal("toggle") ;
								$.post("/dibmp/pages/back/admin/warehouse/editAdmin.action",{"wid":wid,"admin":name},
										function(data){
									operateAlert(data,"仓库管理员修改成功！","仓库管理员修改失败！") ;
								});
//								
							}) ;
						})
					});
				});
			});
		}) ;
	}) ;
	
}) ;

function loadData() {	// 该函数名称一定要固定，不许修改
	// 如果要想进行分页的处理列表前首先查询出部门编号
	did = $("#did").val() ;	// 取得指定组件的value
	tid = $("#tid").val() ;
	//console.log("部门编号：" + did) ;
	// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	createSplitBar(10) ;	// 创建分页控制项
}