var prefixII = ctx + "basics/samInspectionItem";
var prefix = ctx + "basics/samInspectionScheme"


var validateFuns = {
    onkeyup: false,
    rules:{
        name:{
            minlength: 2,
            maxlength: 40,
            remote: {
                url: prefix + "/checkUnique",
                type: "post",
                dataType: "json",
                data: {
                    "id": function() {
                        return $.common.trim($("#id").val());
                    },
                    "name": function() {
                        return $.common.trim($("#name").val());
                    }
                },
                dataFilter: function(data, type) {
                    return $.validate.unique(data);
                }
            }
        },
        code:{
            minlength: 2,
            maxlength: 40,
            remote: {
                url: prefix + "/checkUnique",
                type: "post",
                dataType: "json",
                data: {
                    "id": function() {
                        return $.common.trim($("#id").val());
                    },
                    "code": function() {
                        return $.common.trim($("#code").val());
                    }
                },
                dataFilter: function(data, type) {
                    return $.validate.unique(data);
                }
            }
        },
    },
    messages: {
        "name": {
            remote: "检验方案已经存在"
        },
        "code": {
            remote: "检验方案编码已经存在"
        }
    },
    focusCleanup: true
};

$(function() {
    // function query() {
    var options = {
        // url: prefixII + "/list",

        showToggle: false,
        showColumns: false,
        showRefresh: false,
        showSearch: false,
        pagination:false,
        modalName: "检验项目",
        pageSize:50,
        pageList:[50,100,250,500,1000,1500,2000,2500],
        columns: [
            {
                checkbox: true
            },
            {
                field : 'id',
                title : 'null',
                visible: false
            },
            {

                title : '序号'  ,
                formatter: function (value, row, index) {
                    return $.table.serialNumber(index);
                }
            },
            {
                field : 'code',
                title : '检验项目编码'
            },
            {
                field : 'name',
                title : '检验项目名称'
            },

        ]
    };
    $.table.init(options);


    intiData();
});


// 编辑时，初始表格数据
function  intiData(){

    if(samInspectionItemList ){
        $.each(samInspectionItemList, function (index, row) {
            insertRow(row)
        });
    }
}

/**
 * 查询检查项目
 */
function selectInspectionItem(){

    var width = $(window).width() *0.8;
    var height =  $(window).height()*0.9;

    if ($.common.isEmpty(width)) {
        width = 800;
    }
    if ($.common.isEmpty(height)) {
        height = ($(window).height() - 50);
    }

    var url="/basics/samInspectionItem/samInspectionItemSelect";

    // debugger;
    var options = {


        title: "检验项目选择",
        width: width,
        height: height,
        url: url,
        skin: 'layui-layer-gray',
        btn: ['关闭'],
        yes: function (index, layero) {

            layer.close(index);
            $.table.refresh();
        }
    };
    $.modal.openOptions(options);


}



function  getids(){
    var table  = $('#bootstrap-table').bootstrapTable('getData',false);
    var rows = [];
    $.each(table, function (index, row) {
        rows.push(row.id);
    });
    return rows.toString();
}

/* 新增表格行 */
function insertRow(rows){

    $("#" + table.options.id).bootstrapTable('insertRow', {
        index: 0, // 你想插入到哪，0表示第一行
        row: rows
    })



}


/* 删除指定表格行 */
function removeRow(){
    var ids = $.table.selectColumns("id");
    if (ids.length == 0) {
        $.modal.alertWarning("请至少选择一条记录");
        return;
    }
    $("#" + table.options.id).bootstrapTable('remove', {
        field: 'id',
        values: ids
    })
}
