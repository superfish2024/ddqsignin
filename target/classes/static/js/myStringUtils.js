/**
 * Created by hk on 2021/9/23.
 */



/**
 * 获取系统人员回填
 */
function  sysUserName( userNameList,value) {

        var html ="-" ;
        $.each(userNameList, function(index, dict) {
            // console.log("sysUserName-------"+dict.userId+"----"+value)
            if ("\""+dict.userId+"\"" == ('' + value) ||  dict.userId == ('' + value)) {

                html = dict.userName;
            }
        });
        return html;
  }