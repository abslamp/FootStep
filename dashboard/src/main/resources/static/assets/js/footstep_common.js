            var totalPage=0; //本地存储总页数
            
            var currentSubmitData=""; //本地存储当前查询的数据

			//用数据更新表格，内部用
            function updateTable(data){
                //表格添加数据项
                $(".footstep_table  tbody").empty(); //clear old data
                data.forEach(function(ii){
                    var row="<tr>";
                    for(var item in ii){
                        //遍历i对象中的属性，只显示出非函数的属性
                        if(typeof(ii[item])== "function")
                            continue;
                        row += "<td>"+(ii[item] ? ii[item] : "-")+"</td>"; //如果该列为null用-替换
                    }
                    //删除以及修改按钮
                    if(isDeleteExists||isUpdateExists) {
                    	row+="<td>";
                    	if(isDeleteExists) {
                    	row += "<a href='javascript:deleteItem("+ ii.id +")'><i class='fa fa-remove' style='margin-right: 10px;'></i>";
                    	}
	                    if(isUpdateExists) {
	                    	row += "<a href='javascript:showUpdateDialog("+ii.id+")'><i class='fa fa-edit'></i>";
	                    }
                    	row+="</td>";
                    }
                    
                    
                    row+="</tr>"

                    $(".footstep_table  tbody").append($(row));
                });
                //翻页部件该变色了


            }
            
            //刷掉分页重新生成。内部用。不设置高亮。需要currentPage和totalPage被正确设置后调用。
            function generatePagination() {
            	var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:goPage(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                for(i=1;i<=totalPage;i++) {
                    pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:goPage(" +i+ ")\">"+ i +"</a></li>");
                }
                pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:goPage(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                $(".pagination").empty();
                $(".pagination").append($(pagehtml));
                if(totalPage==0) $(".pagination").empty();
            }

			//更新分页高亮(当前第几页)，内部用
            function updatePage() {
                $(".pagination li").removeClass("active");
                $("#footstep_page_"+currentPage).addClass("active");
                if(currentPage==1){
					$("#footstep_btn_prev").addClass("disabled");
                }else{
                	$("#footstep_btn_prev").removeClass("disabled");
                }
                if(currentPage==totalPage){
					$("#footstep_btn_next").addClass("disabled");
                }else{
                	$("#footstep_btn_next").removeClass("disabled");
                }
                $("#footstep_btn_prev a").attr("href","javascript:doAjax("+ (currentPage-1) +")");
                $("#footstep_btn_next a").attr("href","javascript:doAjax("+ (currentPage+1) +")");
            }
            
            //删除元素。自动绑定。
            function deleteItem(id) {
            	$.ajax({
                    url: ajaxDeleteMethod ,
                    type: ajaxType ,
                    data: {"id":id},
                    success: function(data) {
                    	refreshData();
                    },
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }
            
            //备用的更新。
            function updateItem(id) {
            	footstep_param.id=id;
            	$.ajax({
                    url: ajaxUpdateMethod ,
                    type: ajaxType ,
                    data: footstep_param,
                    success: function(data) {refresh();},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }
            
            //在查询后的更新视图
            function queryUpdate() {
            	$.ajax({
                    url: ajaxDataRows ,
                    type: ajaxType ,
					
                    data: footstep_param ,
                    success: function(data) { //页面初始化过程，仅在刷新时执行
                        totalPage=Math.ceil(data/5);
                        console.log("queryUpdate:totalPage:"+totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:doAjax(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:doAjax(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:doAjax(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        if(totalPage==0) $(".pagination").empty();
                        //可以取值了
                        doAjax(1);
                    },
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }

            //进行一次AJAX并更新表格
            function doAjax(page) {
                currentPage=page;
                footstep_param.page=page;
                $.ajax({
                    url: ajaxDataSource ,
                    type: ajaxType ,
                    data: footstep_param,
                    success: function(data) {updatePage();updateTable(data);},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }
			
			//适配serialize的更新。
			function doAjax2(page,formID) {
                currentPage=page;
                formdata=$("#"+formID).serialize();
				//formdata+="&page="+page;
                $.ajax({
                    url: ajaxDataSource ,
                    type: ajaxType ,
                    data: formdata,
                    success: function(data) {updatePage();updateTable(data);},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }
			
			//页面跳转。保留查询条件。
			function goPage(page) {
                currentPage=page;
                var pagedata=currentSubmitData;
				pagedata+="&page="+page;
                $.ajax({
                    url: ajaxDataSource ,
                    type: ajaxType ,
                    data: pagedata,
                    success: function(data) {updatePage();updateTable(data);},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
            }
			
			//根据当前查询条件全面更新表格和分页的短手方法。使用GET方法。用于更新数据之后的局部刷新。保留页码。
			function refreshData() {
				refreshDataParam("get");
			}
			
			
			//根据当前查询条件全面更新表格和分页。用于更新数据之后的局部刷新。可以使用参数。保留页码。
			function refreshDataParam(HTTPMethod){
				console.log("currentSubmitData:"+currentSubmitData);
				console.log("currentPage:"+currentPage);
				submitData = currentSubmitData;
				$.ajax({
					url: ajaxDataRows,
					type: HTTPMethod,
					data: submitData,
					success: function(data) {
						totalPage=Math.ceil(data/5);
                        console.log("totalPage:"+totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:goPage(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:goPage(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:goPage(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        if(totalPage==0) $(".pagination").empty();
                        if(currentPage>totalPage) currentPage=totalPage;//防止删除后页码越界
                        submitData+=("&page="+totalPage);
                        //可以取值了
						$.ajax({
							url: ajaxDataSource ,
							type: HTTPMethod ,
							data: submitData,
							success: function(data) {updatePage();updateTable(data);},
							error: function(code, message, details) {
								alert("网络连接失败。");
								console.log(message);
								console.log(code);
								console.log(details);
							}
						});
					}
				}
				
				);
				
			}
			
			//提交一个查询表单。URL在网页中给定。将查询条件保存以用于页面刷新。页码重置为1。
			function submitQueryForm(formID,HTTPMethod) {
				console.log($("#"+formID).serialize());
				currentSubmitData=$("#"+formID).serialize();
				var submitdata=$('#footstep_form').serialize();
				submitdata+="&page=1";
				$.ajax({
					url: ajaxDataRows,
					type: HTTPMethod,
					data: submitdata,
					success: function(data) {
						totalPage=Math.ceil(data/5);
                        console.log("submitQueryForm:totalPage:"+totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:goPage(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:goPage(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:goPage(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        if(totalPage==0)
                            $(".pagination").empty();

                        //可以取值了
                        currentPage=1;
						formdata=$("#"+formID).serialize();
						formdata+="&page=1";
						$.ajax({
							url: ajaxDataSource ,
							type: HTTPMethod ,
							data: formdata,
							success: function(data) {updatePage();updateTable(data);},
							error: function(code, message, details) {
								console.log(message);
								console.log(code);
								console.log(details);
							}
						});
					}
				}
				
				);
				
			}
			
			//AJAX读取List<String>作为<select>的<option>
			function ajaxSimpleSelectBox(selectId,url,ajaxdata,defaultName,defaultValue){
				$target = $("#"+selectId);
				$target.empty(); //清空
				if(!defaultName===null) {
					if(!defaultValue===null) { //同时绑定默认name和value
						$target.append("<option value='"+defaultValue+"' selected>"+defaultName+"</option>");
					} else {
						$target.append("<option value='' selected>"+defaultName+"</option>");
					}
				}
				//ajax
				$.ajax({
					type:"get",
					url:url,
					async:true,
					data: ajaxdata,
					success: function(data) {
						if(!Object.prototype.toString.call(o) === '[object Array]') { //判断返回是否为数组
							console.log("请返回对象数组!");
							return;
						}
						data.forEach(function(obj){
							$target.append("<option>"+defaultName+"</option>");
						});
						
					},
					error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
				});
				
			}
			


            $(document).ready(function(){
                //初始化总页数值
                $.ajax({
                    url: ajaxDataRows ,
                    type: ajaxType ,
                    data: null ,
                    success: function(data) { //页面初始化过程，仅在刷新时执行
                        totalPage=Math.ceil(data/5);
                        console.log("ready:totalPage:"+totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:goPage(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:goPage(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:goPage(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        //可以取值了
                        doAjax(1);
                    },
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });

            });