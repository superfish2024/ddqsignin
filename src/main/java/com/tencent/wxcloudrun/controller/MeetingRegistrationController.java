package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.config.AjaxResult;
import com.tencent.wxcloudrun.dto.MeetingRegistration;
import com.tencent.wxcloudrun.dto.MeetingRegistrationVo;
import com.tencent.wxcloudrun.service.IMeetingRegistrationService;
import com.tencent.wxcloudrun.utils.DateUtil;
import com.tencent.wxcloudrun.utils.ExcelUtil;
import com.tencent.wxcloudrun.utils.PageInfo;
import com.tencent.wxcloudrun.utils.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 登记信息Controller
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Controller
@RequestMapping("/meetingRegistration/meetingRegistration")
public class MeetingRegistrationController
{
    private String prefix = "meetingRegistration";

    @Autowired
    private IMeetingRegistrationService meetingRegistrationService;

//    @RequiresPermissions("meetingRegistration:meetingRegistration:view")
    @GetMapping()
    public String meetingRegistration(MeetingRegistration meetingRegistration, ModelMap mmap)
    {
        mmap.put("meetingRegistration",meetingRegistration);
        return prefix + "/meetingRegistration";
    }

    /**
     * 查询登记信息列表
     */
//    @RequiresPermissions("meetingRegistration:meetingRegistration:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request, MeetingRegistration meetingRegistration)
    {


        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        int  pageSize = Integer.valueOf(request.getParameter("pageSize"));
        meetingRegistration.setLimitS((pageNum-1)*pageSize);
        meetingRegistration.setLimitE(pageSize);

        TableDataInfo tableDataInfo= meetingRegistrationService.selectMeetingRegistrationList(meetingRegistration);
        return tableDataInfo;
    }

    /**
     * 导出登记信息列表
     */
//    @RequiresPermissions("meetingRegistration:meetingRegistration:export")

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MeetingRegistration meetingRegistration)
    {
//        List<MeetingRegistration> list = meetingRegistrationService.selectMeetingRegistrationList(meetingRegistration);
//        ExcelUtil<MeetingRegistration> util = new ExcelUtil<MeetingRegistration>(MeetingRegistration.class);
//        return util.exportExcel(list, "meetingRegistration");
        return  null;
    }

    /**
     * 新增登记信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存登记信息
     */
//    @RequiresPermissions("meetingRegistration:meetingRegistration:add")

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MeetingRegistration meetingRegistration)
    {

        return AjaxResult.success(meetingRegistrationService.insertMeetingRegistration(meetingRegistration));
    }

    /**
     * 修改登记信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        MeetingRegistration meetingRegistration = meetingRegistrationService.selectMeetingRegistrationById(id);
        mmap.put("meetingRegistration", meetingRegistration);
        return prefix + "/edit";
    }

    /**
     * 修改保存登记信息
     */
//    @RequiresPermissions("meetingRegistration:meetingRegistration:edit")

    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MeetingRegistration meetingRegistration)
    {

        return AjaxResult.success(meetingRegistrationService.updateMeetingRegistration(meetingRegistration));
    }

    /**
     * 删除登记信息
     */
//    @RequiresPermissions("meetingRegistration:meetingRegistration:remove")

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {

        return AjaxResult.success(meetingRegistrationService.deleteMeetingRegistrationByIds(ids));
    }


    /**
     * 导入数据
     */
    @PostMapping("/importZfbData")
    @ResponseBody
    public AjaxResult importZfbData(MultipartFile file, boolean updateSupport) throws Exception
    {
        AjaxResult  ajaxResult = AjaxResult.error();
        try {

//        ExcelUtil<MeetingRegistrationVo> util = new ExcelUtil(MeetingRegistrationVo.class);
//        List<MeetingRegistrationVo> userList = util.importExcel(file.getInputStream());
//        //打款成功用户 标记处理邀请奖励
//        List<String > inviteList = new ArrayList<>();
            List<List<String>> dataList  =   ExcelUtil.importDataFromXls(file.getInputStream());
           ajaxResult =   meetingRegistrationService.importZfbData(dataList,updateSupport);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return  ajaxResult;
        }




    }

    @PostMapping( "/checkNumberUnique")
    @ResponseBody
    public String checkNumberUnique(MeetingRegistration meetingRegistration)
    {

        return  meetingRegistrationService.checkNumberUnique(meetingRegistration);
    }



    @GetMapping("/statisticsMeetingRegistrationSignIndex")
    public String statisticsMeetingRegistrationSignIndex(MeetingRegistration meetingRegistration, ModelMap mmap)
    {


        meetingRegistration.setCreateDate(DateUtil.dateToStrings(new Date()));
        mmap.put("meetingRegistration",meetingRegistration);
        return prefix + "/statisticsMeetingRegistrationSign";
    }
    @PostMapping("/statisticsMeetingRegistrationSign")
    @ResponseBody
    public TableDataInfo statisticsMeetingRegistrationSign(HttpServletRequest request,MeetingRegistration meetingRegistration)
    {



        TableDataInfo tableDataInfo= meetingRegistrationService.statisticsMeetingRegistrationSign(meetingRegistration);
        return tableDataInfo;
    }

    @GetMapping("/infoMeetingRegistrationSignIndex")
    public String infoMeetingRegistrationSignIndex(MeetingRegistration meetingRegistration, ModelMap mmap)
    {
        meetingRegistration.setCreateDate(DateUtil.dateToStrings(new Date()));
        mmap.put("meetingRegistration",meetingRegistration);

        return prefix + "/infoMeetingRegistrationSign";
    }
    @PostMapping("/infoMeetingRegistrationSign")
    @ResponseBody
    public TableDataInfo infoMeetingRegistrationSign(HttpServletRequest request,MeetingRegistration meetingRegistration)
    {



        TableDataInfo tableDataInfo= meetingRegistrationService.infoMeetingRegistrationSign(meetingRegistration);
        return tableDataInfo;
    }


}

