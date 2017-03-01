            //魔改了footstep_common.js
            //请删除控制表格按钮的两个var
            
            var totalPage=0;

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
                    //操作按钮,在本例中已固定
                    row += "<td>";
                    row += "<a href='javascript:editDept(\""+ ii.name +"\")'>魔改部门</a>&nbsp;";
					row += "<a href='javascript:editUser(\""+ii.name+"\")'>魔改人员</a>&nbsp;";
					row += "<a href='javascript:editPrp(\""+ii.name+"\")'>魔改PRP阶段</a>&nbsp;";
                    row += "</td>";
                    row += "</tr>";

                    $(".footstep_table  tbody").append($(row));
                });
                //翻页部件该变色了


            }

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
            
//          function deleteItem(id) {
//          	$.ajax({
//                  url: ajaxDeleteMethod ,
//                  type: ajaxType ,
//                  data: {"id":id},
//                  success: function(data) {
//                  	$.refresh();
//                  },
//                  error: function(code, message, details) {
//                      console.log(message);
//                      console.log(code);
//                      console.log(details);
//                  }
//              });
//          }

			function mScroll(id){
				$("html,body").stop(true);
				$("html,body").animate({
					scrollTop: $("#"+id).offset().top
				}, 1000);
			}
			function submitDept(pname) {
				alert($("#project_dept_edit_form").serialize());
				$.ajax({
                    url: "http://localhost:8888/project/setDepartment",
                    type: "get" ,
                    data: $("#project_dept_edit_form").serialize(),
                    success: function(data) {refresh();},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
			}
			function submitUser() {
				$.ajax({
                    url: "http://localhost:8888/project/setUser",
                    type: "get" ,
                    data: $("#project_user_edit_form").serialize(),
                    success: function(data) {refresh();},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
			}
			function submitPrp(pname) {
				$.ajax({
                    url: "http://localhost:8888/project/setPrp",
                    type: "get" ,
                    data: $("#project_prp_edit_form").serialize(),
                    success: function(data) {refresh();},
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
			}
			function editDept(pname) {
				$("#project_dept_edit_form_container input[name=projectName]").val(pname);
				loadDeptSelect("project_edit_select");
				
				
				
				$("#project_prp_edit_form_container").hide("fast");
				$("#project_user_edit_form_container").hide("fast");
				$("#project_dept_edit_form_container").show("fast");
				//mScroll("project_dept_edit_form_container");
				
			}
			function editUser(pname) {
				$("#project_user_edit_form_container input[name=projectName]").val(pname);
				ajaxSimpleSelectBox("user_miltiselect","http://localhost:8888/project/getUserByDept",{name : pname},null,null);
				
				$("#user_miltiselect").select2();
				
				
				$.getJSON("http://localhost:8888/project/getUser",{name : pname},function(data){
					$('#user_miltiselect').val(data).trigger('change');
					
				});
				$(".select2-container--bootstrap").removeAttr("style"); //防止select2的自动变窄
				
				
				$("#project_dept_edit_form_container").hide("fast");
				$("#project_prp_edit_form_container").hide("fast");
				$("#project_user_edit_form_container").show("fast");
				//mScroll("project_user_edit_form_container");
				
			}
			function editPrp(pname) {
				$("#project_prp_edit_form_container input[name=projectName]").val(pname);
			
				ajaxSimpleSelectBox("prp_miltiselect","http://localhost:8888/project/getAllPrp",null,null,null);
				
				$("#prp_miltiselect").select2();
				
				
				$.getJSON("http://localhost:8888/project/getPrp",{name : pname},function(data){
					$('#prp_miltiselect').val(data).trigger('change');
					
				});
				$(".select2-container--bootstrap").removeAttr("style"); //防止select2的自动变窄
				
				
				$("#project_user_edit_form_container").hide("fast");
				$("#project_dept_edit_form_container").hide("fast");
				$("#project_prp_edit_form_container").show("fast");
				//mScroll("project_prp_edit_form_container");
				
			}
			
			
            
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
            
            function queryUpdate() {
            	$.ajax({
                    url: ajaxDataRows ,
                    type: ajaxType ,
					
                    data: footstep_param ,
                    success: function(data) { //页面初始化过程，仅在刷新时执行
                        totalPage=Math.ceil(data/5);
                        console.log(totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:doAjax(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:doAjax(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:doAjax(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
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
			
			function submitQueryForm(formID,HTTPMethod) {
				request = $('#footstep_form').serialize();
				request += "&page=1";
				
				$.ajax({
					url: ajaxDataRows,
					type: HTTPMethod,
					data: request ,
					success: function(data) {
						totalPage=Math.ceil(data/5);
                        console.log(totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:doAjax(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:doAjax(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:doAjax(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        //可以取值了
                        currentPage=1;
						formdata=request;
						//formdata+="&page="+page;
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
						if(!Object.prototype.toString.call(data) === '[object Array]') { //判断返回是否为数组
							console.log("请返回对象数组!");
							return;
						}
						data.forEach(function(obj){
							$target.append("<option>"+obj+"</option>");
						});
						
					},
					error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
				});
				
			}
			
			function loadDeptSelect(selectId) {
				var deptLabelJson;
				var deptLabelHtml="";
				$.getJSON("http://localhost:8888/department/alloptionlabel",null,function(data){
					deptLabelJson=data;
					data.forEach(function(d){
						deptLabelHtml+="<option>"+d.text+"</option>";
					})
					$("#"+selectId).empty();
					$("#"+selectId).append(deptLabelHtml);
					deptSetDefault();
				});
			}
			function deptSetDefault() {
				$.getJSON("http://localhost:8888/project/getDepartment",{name:$("#project_dept_edit_form_container input[name=projectName]").val()},function(data) {
						
						$("#project_edit_select").val(data.department);
					});
			}
			
			function refresh(){
				$.ajax({
                    url: ajaxDataRows ,
                    type: ajaxType ,
					
                    data: footstep_param ,
                    success: function(data) { //页面初始化过程，仅在刷新时执行
                        totalPage=Math.ceil(data/5);
                        console.log(totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:doAjax(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:doAjax(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:doAjax(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
                        $(".pagination").empty();
                        $(".pagination").append($(pagehtml));
                        //可以取值了
                        doAjax(currentPage);
                    },
                    error: function(code, message, details) {
                        console.log(message);
                        console.log(code);
                        console.log(details);
                    }
                });
			}
			
			function addNew(){
				$.ajax({
					url: "http://localhost:8888/project/insert" ,
					type : "post" ,
					data :$("#footstep_form").serialize() ,
					async: true ,
					success : function(){
						alert("创建成功。");
						refresh();
					} ,
					error: function(){
						console.log(message);
                        console.log(code);
                        console.log(details);
                        alert("创建失败。");
					}
					
				})
			}


            $(document).ready(function(){
            	//$(".js-example-basic-multiple").select2();
                //初始化总页数值
                $.ajax({
                    url: ajaxDataRows ,
                    type: ajaxType ,
                    data: null ,
                    success: function(data) { //页面初始化过程，仅在刷新时执行
                        totalPage=Math.ceil(data/5);
                        console.log(totalPage);
                        //生成页码标记
                        var pagehtml="<li id='footstep_btn_prev' class=\"prev disabled\"><a href=\"javascript:doAjax(" +(currentPage-1)+ ")\" title=\"Prev\"><i class=\"fa fa-angle-left\"></i></a>";
                        for(i=1;i<=totalPage;i++) {
                            pagehtml+=("<li id='footstep_page_" + i + "'><a href=\"javascript:doAjax(" +i+ ")\">"+ i +"</a></li>");
                        }
                        pagehtml+="<li id='footstep_btn_next' class=\"next\"><a href=\"javascript:doAjax(" +(currentPage+1)+ ")\" title=\"Next\"><i class=\"fa fa-angle-right\"></i></a></li>"
                        
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