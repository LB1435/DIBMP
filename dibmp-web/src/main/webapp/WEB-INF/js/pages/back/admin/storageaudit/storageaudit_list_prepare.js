$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.substring(this.id.indexOf("-") + 1);
			$("#memberInfo").modal("toggle") ;
			console.log(mid) ; 
			$.post("pages/back/admin/storageaudit/member_info",{"mid":mid},function(data){
				$("#ename").text(data.member.name) ; 
				$("#lid").text(data.level[data.member.lid].title) ; 
				$("#dname").text(data.dept[data.member.did-1].dname) ; 
				$("#phone").text(data.member.phone) ; 
				$("#note").text(data.member.note) ; 
			},"json")
		}) ;
	}) ;
	$("span[id^=sid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			console.log("sid="+ sid) ;
			$("#storageDetailsInfo").modal("toggle") ;
			$.post("pages/back/admin/storageaudit/storage_info",{"said":sid},function(data){
				var price =  parseFloat(data.sadetails.price).toFixed(2)
				console.log(data.allsad) ; 
			$("#title").text(data.sapply.title) ; 	
			$("#wid").text(data.sapply.wid) ; 
			$("#wiid").text(data.sapply.wiid) ; 
			$("#price").text(price) ; 
			$("#note").text(data.sapply.note) ; 
			console.log(data.allsad.length) ; 
			for(var x=0 ; x<data.allsad.length ; x++){
				if(x == 0){
					$("#info").empty() ; 
				}
				var said = data.allsad[x].said ; 
				var name = data.allsad[x].name ; 
				var num = data.allsad[x].num ; 
				var price = data.allsad[x].price ; 
				var weight = data.allsad[x].weight ; 
				var allPrice = data.allsad[x].num * data.allsad[x].price ; 
				$("#info").append("<tr>"+"<td>"+said+"</td>"
										+"<td>"+name+"</td>"
										+"<td>"+num+"</td>"
										+"<td>"+price+"</td>"+
										"<td>"+weight+"</td>"
										+"<td>"+allPrice+"</td>"+"</tr>") ;
			}
			},"json")
		}) ;
	}) ;
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			console.log("wid") ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
