package com.tencent.wxcloudrun.dao;


import com.tencent.wxcloudrun.dto.MeetingRegistration;

import java.util.List;
import java.util.Map;

/**
 * 登记信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
public interface MeetingRegistrationMapper 
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
     * @param  list 登记信息ID
     * @return 登记信息
     */
    public List<MeetingRegistration> selectMeetingRegistrationByIds(List list);
    /**
     * 查询登记信息列表
     * 
     * @param meetingRegistration 登记信息
     * @return 登记信息集合
     */
    public List<MeetingRegistration> selectMeetingRegistrationList(MeetingRegistration meetingRegistration);
    public int selectMeetingRegistrationListCount(MeetingRegistration meetingRegistration);
    public List<MeetingRegistration> checkNumberUnique(MeetingRegistration meetingRegistration);

    /**
     * 新增登记信息
     * 
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    public int insertMeetingRegistration(MeetingRegistration meetingRegistration);


    /**
     * 新增list
     *
     * @param list
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
     * 修改
     *
     * @param list
     * @return 结果
     */
    public int updateMeetingRegistrationList(List<MeetingRegistration> list);

    /**
     * 删除登记信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    public int deleteMeetingRegistrationById(String id);

    /**
     * 批量删除登记信息
     * 
     * @param list 需要删除的数据ID
     * @return 结果
     */
    public int deleteMeetingRegistrationByIds(List list);

    /**
     * 查询登记信息
     *
     * @param id 登记信息ID
     * @return 登记信息
     */
    public MeetingRegistration selectMeetingRegistrationByPhoneNumber(String id);


    /**
     * 新增登记信息
     *
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    public int insertcheckin(MeetingRegistration meetingRegistration);


    /**
     * 统计签到报表
     * @param param
     * @return
     */
    public List<Map<String,Object>> statisticsMeetingRegistrationSign(Map<String,Object> param);

    /**
     * 签到明细统计
     * @param param
     * @return
     */
    public List<Map<String,Object>> infoMeetingRegistrationSign(Map<String,Object> param);
}
