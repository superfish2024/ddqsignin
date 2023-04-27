package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.config.AjaxResult;
import com.tencent.wxcloudrun.dto.MeetingRegistration;
import com.tencent.wxcloudrun.dto.MeetingRegistrationVo;
import com.tencent.wxcloudrun.utils.TableDataInfo;

import java.util.List;
import java.util.Map;

/**
 * 登记信息Service接口
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
public interface IMeetingRegistrationService 
{
    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    public MeetingRegistration selectMeetingRegistrationById(String id);

    /**
     * 查询登记信息
     *
     * @param ids 登记信息ID
     * @return 登记信息
     */
    public List<MeetingRegistration> selectMeetingRegistrationByIds(String ids);

    /**
     * 查询登记信息列表
     * 
     * @param meetingRegistration 登记信息
     * @return 登记信息集合
     */
    TableDataInfo   selectMeetingRegistrationList(MeetingRegistration meetingRegistration);

    /**
     * 新增登记信息
     * 
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    public int insertMeetingRegistration(MeetingRegistration meetingRegistration);

    /**
     * 新增登记信息
     *
     * @param list 登记信息
     * @return 结果
     */
    public int insertMeetingRegistrationList(List<MeetingRegistration> list);

    /**
     * 修改登记信息
     * 
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    public int updateMeetingRegistration(MeetingRegistration meetingRegistration);

    /**
     * 修改登记信息
     *
     * @param list 登记信息
     * @return 结果
     */
    public int updateMeetingRegistrationList(List<MeetingRegistration> list);
    /**
     * 批量删除登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMeetingRegistrationByIds(String ids);

    /**
     * 删除登记信息信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    public int deleteMeetingRegistrationById(String id);


    public AjaxResult importZfbData(List<List<String>> dataList );

    public AjaxResult sign(String phoneNumber);


    public String checkNumberUnique(MeetingRegistration meetingRegistration);


    /**
     * 统计签到报表
     * @param param
     * @return
     */
    public TableDataInfo  statisticsMeetingRegistrationSign(Map<String,Object> param);

    /**
     * 签到明细统计
     * @param param
     * @return
     */
    public TableDataInfo infoMeetingRegistrationSign(Map<String,Object> param);
}
