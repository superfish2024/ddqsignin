package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.AjaxResult;
import com.tencent.wxcloudrun.dto.MeetingRegistration;
import com.tencent.wxcloudrun.dao.MeetingRegistrationMapper;
import com.tencent.wxcloudrun.dto.MeetingRegistrationVo;
import com.tencent.wxcloudrun.service.IMeetingRegistrationService;
import com.tencent.wxcloudrun.utils.DateUtil;
import com.tencent.wxcloudrun.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 登记信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Service
public class MeetingRegistrationServiceImpl implements IMeetingRegistrationService
{
    @Autowired
    private MeetingRegistrationMapper meetingRegistrationMapper;

    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    @Override
    public MeetingRegistration selectMeetingRegistrationById(String id)
    {
        return meetingRegistrationMapper.selectMeetingRegistrationById(id);
    }

    /**
     * 查询登记信息
     *
     * @param ids 登记信息ID
     * @return 登记信息
     */
    @Override
    public List<MeetingRegistration> selectMeetingRegistrationByIds(String ids)
    {
//        return meetingRegistrationMapper.selectMeetingRegistrationByIds(Arrays.asList(Convert.toStrArray(ids)));
        return  null;
    }

    /**
     * 查询登记信息列表
     * 
     * @param meetingRegistration 登记信息
     * @return 登记信息
     */
    @Override
    public List<MeetingRegistration> selectMeetingRegistrationList(MeetingRegistration meetingRegistration)
    {
        return meetingRegistrationMapper.selectMeetingRegistrationList(meetingRegistration);
    }

    /**
     * 新增登记信息
     * 
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    @Override
    public int insertMeetingRegistration(MeetingRegistration meetingRegistration)
    {
        meetingRegistration.setId(MyStringUtils.getUuid());
        meetingRegistration.setCreateDate(DateUtil.DateToStr(new Date()) );
       return meetingRegistrationMapper.insertMeetingRegistration(meetingRegistration)         ;
    }
    /**
     * 新增登记信息
     *
     * @param list 登记信息
     * @return 结果
     */
    @Override
    public int insertMeetingRegistrationList(List<MeetingRegistration> list)
    {

        return meetingRegistrationMapper.insertMeetingRegistrationList(list);
    }
    /**
     * 修改登记信息
     * 
     * @param meetingRegistration 登记信息
     * @return 结果
     */
    @Override
    public int updateMeetingRegistration(MeetingRegistration meetingRegistration)
    {
        return meetingRegistrationMapper.updateMeetingRegistration(meetingRegistration);
    }

    /**
     * 修改登记信息
     *
     * @param list 登记信息
     * @return 结果
     */
    @Override
    public int updateMeetingRegistrationList(List<MeetingRegistration> list )
    {

        return meetingRegistrationMapper.updateMeetingRegistrationList(list);
    }


    /**
     * 删除登记信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMeetingRegistrationByIds(String ids )
    {
        List<String> list = Arrays.asList(ids.split(","));
        if(list!=null){
             for(String id: list){
                 MeetingRegistration meetingRegistration  = new MeetingRegistration();
                 meetingRegistration.setId(id);
                 meetingRegistration.setExpand1("2");
                 meetingRegistrationMapper.updateMeetingRegistration(meetingRegistration);
             }
        }
//        return meetingRegistrationMapper.deleteMeetingRegistrationByIds(Arrays.asList(Convert.toStrArray(ids)));
        return 1;
    }

    /**
     * 删除登记信息信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    @Override
    public int deleteMeetingRegistrationById(String id)
    {
        return meetingRegistrationMapper.deleteMeetingRegistrationById(id);
    }


    @Override
    public AjaxResult importZfbData(List<MeetingRegistrationVo> nUserExchangeImpZfbVoList, List<String> inviteList) {
        return null;
    }
}
