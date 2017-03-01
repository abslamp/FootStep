//JS for FootStep: department management only.
//DO NOT apply this script to other pages.

var deptLabelJson=new Object;
var deptLabelHtml="";
var labelReady=false;


function notifyInfo(id) {
	if(parseInt(id)==NaN) console.log("notifyInfo():Please specify the ID of department.");
	$.getJSON("http://localhost:8888/department/id",{id : parseInt(id)},function(data){
		//console.log(data);
		$("#dept_form_leader").val(data.leader);
		$("#dept_form_name").val(data.name);
		$("#dept_form_superior_id").val(data.superiorId);
		$("#dept_form_superior_id_create").val(data.id);
		$("#dept_form_remark").val(data.remark);
		$("#dept_form_id").val(data.id);
		if(data.id==1) {
			$("#dept_form_superior_id").parent().hide("slow");
		}else{
			$("#dept_form_superior_id").parent().show("slow");
		}
		
	});
}

function showCreateForm() {
	$("#create_form_div").show("fast");
	$("#department_edit").hide("fast");
}

function hideCreateForm() {
	$("#department_edit").show("fast");
	$("#create_form_div").hide("fast");
}


function submitFormEdit() {
	if($("#dept_form_id").val()=="") {
		alert("未选定部门");
		return;
	}
	if($("#dept_form_name").val()=="") {
		$("#dept_form_name").parent().parent().addClass("has-error");
		$("#dept_form_name").parent().parent().append("<span class='help-block help-block-error'>不能为空</span>")
		return;
	}
	$("#dept_form_name").parent().parent().removeClass("has-error");
	$(".help-block-error").remove();
	$.ajax({
                type: "POST",
                url:"http://localhost:8888/department/update",
                data:$('#department_edit').serialize(),// 你的formid
                error: function(request) {
                    alert("连接错误.");
                },
                success: function(data) {
                    alert("提交成功.");
					window.location.reload(); //刷新,更新数据
                }
            });
}

function submitFormCreate() {
	if($("#dept_form_name_create").val()=="") {
		$("#dept_form_name_create").parent().parent().addClass("has-error");
		$("#dept_form_name_create").parent().parent().append("<span class='help-block help-block-error'>不能为空</span>")
		return;
	}
	$("#dept_form_name_create").parent().parent().removeClass("has-error");
	$(".help-block-error").remove();
	$.ajax({
                type: "POST",
                url:"http://localhost:8888/department/insert",
                data:$('#department_create').serialize(),// 你的formid
                error: function(request) {
                    alert("连接错误.");
                },
                success: function(data) {
                    alert("提交成功.");
					window.location.reload(); //刷新,更新数据
                }
            });
}




$(document).ready(function(){
	$.getJSON("http://localhost:8888/department/all",null,function(data){
		$('#department_tree').jstree({
        'core': {
            'data': data,
            "themes": {
                "responsive": false
            }
        }
    	}).bind('changed.jstree', function(e,data){
			//获取当前选中节点的id
            var domId = data.instance.get_node(data.selected[0]).id;
            notifyInfo(domId);
       });
        
	});
	$.getJSON("http://localhost:8888/department/alloptionlabel",null,function(data){
		deptLabelJson=data;
		data.forEach(function(d){
			deptLabelHtml+="<option value='"+d.id+"'>"+d.text+"</option>";
		})
		$("#dept_form_superior_id").empty();
		$("#dept_form_superior_id_create").empty();
		$("#dept_form_superior_id").append(deptLabelHtml);
		$("#dept_form_superior_id_create").append(deptLabelHtml);
	});
	
	
});

