var prefix = ctx + "basics/samInspectionItem";
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
            remote: "检验项目已经存在"
        },
        "code": {
            remote: "检验项目编码已经存在"
        }
    },
    focusCleanup: true
}