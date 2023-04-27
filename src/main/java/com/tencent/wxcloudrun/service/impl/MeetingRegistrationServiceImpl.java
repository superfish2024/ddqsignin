package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.config.AjaxResult;
import com.tencent.wxcloudrun.dto.MeetingRegistration;
import com.tencent.wxcloudrun.dao.MeetingRegistrationMapper;
import com.tencent.wxcloudrun.dto.MeetingRegistrationVo;
import com.tencent.wxcloudrun.service.IMeetingRegistrationService;
import com.tencent.wxcloudrun.utils.DateUtil;
import com.tencent.wxcloudrun.utils.MyStringUtils;
import com.tencent.wxcloudrun.utils.TableDataInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public TableDataInfo   selectMeetingRegistrationList(MeetingRegistration meetingRegistration)

    {

        List<MeetingRegistration> meetingRegistrationList = new ArrayList<>();
        int  count = meetingRegistrationMapper.selectMeetingRegistrationListCount(meetingRegistration);
        if(count>0) {
            meetingRegistrationList = meetingRegistrationMapper.selectMeetingRegistrationList(meetingRegistration);
        }
        return getDataTable(meetingRegistrationList,count);
    }


    TableDataInfo getDataTable(List<?> list,int total)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(total);
        return rspData;
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
    @Transactional
    public AjaxResult importZfbData(List<List<String>> dataList ) {
        AjaxResult result = AjaxResult.error();
        StringBuilder err = new StringBuilder("");
        if(dataList!=null && dataList.size()>0){
            int i = 0;

            List<String >listPhoneNumber = new ArrayList<>();
            for (List<String> list :dataList){
                String phoneNumber = list.get(4);
                MeetingRegistration meetingRegistration  = new MeetingRegistration();
                meetingRegistration.setPhoneNumber(phoneNumber);

                if(StringUtils.isBlank(phoneNumber) || "0".equals(checkNumberUnique(meetingRegistration))){
                        if(StringUtils.isNotBlank(phoneNumber) ){
                            if(listPhoneNumber.contains(phoneNumber)){
                                err =new StringBuilder(err) .append("</br>").append("手机号：").append(meetingRegistration.getPhoneNumber()).append("在当前文件存在重复！");
                            }else{
                                listPhoneNumber.add(phoneNumber);
                            }
                        }
                } else{
                  err =new StringBuilder(err) .append("</br>").append("手机号：").append(meetingRegistration.getPhoneNumber()).append("已经存在！");
               }
            }


            if(StringUtils.isBlank(err.toString())) {
                for (List<String> list : dataList) {
                    MeetingRegistration meetingRegistration = new MeetingRegistration();


                    if (StringUtils.isNotBlank(list.get(1))) {
                        i++;
                        meetingRegistration.setCustomerType(list.get(0));
                        meetingRegistration.setProvinceArea(list.get(1));
                        meetingRegistration.setExpand2(list.get(2));

                        meetingRegistration.setAttendeeName(list.get(3));
                        meetingRegistration.setPhoneNumber(list.get(4));
                        meetingRegistration.setIsTraveling(list.get(5));
                        meetingRegistration.setAccompanyingPersonnel(list.get(6));
                        meetingRegistration.setHotelName(list.get(7));
                        meetingRegistration.setRoomNumber(list.get(8));
                        meetingRegistration.setBreakfastTime(list.get(9));
                        meetingRegistration.setLunchTime(list.get(10));
                        meetingRegistration.setDinnerTime(list.get(11));
                        meetingRegistration.setMealLocation(list.get(12));
                        meetingRegistration.setBanquetTime(list.get(13));
                        meetingRegistration.setBanquetLocation(list.get(14));
                        meetingRegistration.setBanquetSeating(list.get(15));
                        meetingRegistration.setMeetingDate(list.get(16));
                        meetingRegistration.setMeetingLocation(list.get(17));
                        meetingRegistration.setTourVehicleArrangement(list.get(18));

                        if (list.size() >= 20) {
                            meetingRegistration.setFactoryVisitVehicleArrangement(list.get(19));

                        }
                        if (list.size() >= 21) {
                            meetingRegistration.setMeetingSeating(list.get(20));

                        }
                        if (list.size() >= 22) {
                            meetingRegistration.setHasIntentionalCustomers(list.get(21));
                        }
                        meetingRegistration.setCreateDate(DateUtil.getCurrentDateTimeSSStr());
                        meetingRegistration.setExpand1("1");

                        meetingRegistration.setId(MyStringUtils.getUuid());
                        meetingRegistrationMapper.insertMeetingRegistration(meetingRegistration);

                    }
                }
            }
            if(StringUtils.isBlank(err.toString())) {
                result = AjaxResult.success("成功导入:" + i + "个客户");
            }else{
                result = AjaxResult.error(err.toString());
            }
        }

        return result;
    }

    @Override
    public AjaxResult sign(String phoneNumber) {
        AjaxResult ajaxResult = AjaxResult.error("签到异常");
        if(StringUtils.isNotBlank(phoneNumber)){
            MeetingRegistration meetingRegistration =  meetingRegistrationMapper.selectMeetingRegistrationByPhoneNumber(phoneNumber.trim());
            if(meetingRegistration!=null){
                MeetingRegistration s = new MeetingRegistration();
                s.setId(MyStringUtils.getUuid());
                s.setUserid(meetingRegistration.getId());
                meetingRegistrationMapper.insertcheckin(s);
                ajaxResult = AjaxResult.success("签到成功");
            }else{
                ajaxResult = AjaxResult.error("当前手机号未登记，请核对");
            }
        }else{
            ajaxResult = AjaxResult.error("请输入签到手机");
        }
        return ajaxResult;
    }

    @Override
    public String checkNumberUnique(MeetingRegistration meetingRegistration) {
        if(meetingRegistration!=null &&
                ( StringUtils.isNotBlank(meetingRegistration.getPhoneNumber())   )
        ){
            String id = meetingRegistration.getId();
            meetingRegistration.setId(null);
            List<MeetingRegistration> meetingRegistrationList   =  meetingRegistrationMapper.checkNumberUnique(meetingRegistration);
            if(meetingRegistrationList == null || meetingRegistrationList.size()==0){//不存在相关记录
                return "0";
            }else if(meetingRegistrationList.size()==1){
                if(StringUtils.isNotBlank(id)){//修改
                    if(id.equals(meetingRegistrationList.get(0).getId())){//自己修改
                        return "0";
                    }
                }
            }

        }


        return "1";
    }
}
