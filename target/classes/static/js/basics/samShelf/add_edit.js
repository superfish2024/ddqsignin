var prefix = ctx + "basics/samShelf"

var validateFuns = {
    onkeyup: false,
    rules:{
        number:{
            minlength: 2,
            maxlength: 40,
            remote: {
                url: prefix + "/checkNumberUnique",
                type: "post",
                dataType: "json",
                data: {
                    "id": function() {
                        return $.common.trim($("#id").val());
                    },
                    "number": function() {
                        return $.common.trim($("#number").val());
                    }
                },
                dataFilter: function(data, type) {
                    return $.validate.unique(data);
                }
            }
        },
        name:{
            minlength: 2,
            maxlength: 40
        },

    },
    messages: {
        "number": {
            remote: "货架编号已经存在"
        }
    },
    focusCleanup: true
}