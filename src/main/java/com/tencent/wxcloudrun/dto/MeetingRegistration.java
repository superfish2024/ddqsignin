package com.tencent.wxcloudrun.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tencent.wxcloudrun.config.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登记信息对象 meeting_registration
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Data
public class MeetingRegistration implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String id;

    /** 客户类别 */
    @Excel(name = "客户类别")
    private String customerType;

    /** 所属省区 */
    @Excel(name = "所属省区")
    private String provinceArea;

    /** 参会人名称 */
    @Excel(name = "参会人名称")
    private String attendeeName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    /** 是否参加工业旅游 */
    @Excel(name = "是否参加工业旅游")
    private String isTraveling;

    /** 随行人员 */
    @Excel(name = "随行人员")
    private String accompanyingPersonnel;

    /** 住宿酒店名称 */
    @Excel(name = "住宿酒店名称")
    private String hotelName;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNumber;

    /** 早餐用餐时间 */
    @Excel(name = "早餐用餐时间")
    private String breakfastTime;

    /** 中餐用餐时间 */
    @Excel(name = "中餐用餐时间")
    private String lunchTime;

    /** 晚餐用餐时间 */
    @Excel(name = "晚餐用餐时间")
    private String dinnerTime;

    /** 用餐地点 */
    @Excel(name = "用餐地点")
    private String mealLocation;

    /** 晚宴用餐时间 */
    @Excel(name = "晚宴用餐时间")
    private String banquetTime;

    /** 用餐地点 */
    @Excel(name = "用餐地点")
    private String banquetLocation;

    /** 晚宴坐席 */
    @Excel(name = "晚宴坐席")
    private String banquetSeating;

    /** 会议时间 */
    @Excel(name = "会议时间")
    private String meetingDate;

    /** 会议地点 */
    @Excel(name = "会议地点")
    private String meetingLocation;

    /** 旅游车辆安排 */
    @Excel(name = "旅游车辆安排")
    private String tourVehicleArrangement;

    /** 参观工厂车辆安排 */
    @Excel(name = "参观工厂车辆安排")
    private String factoryVisitVehicleArrangement;

    /** 会议坐席 */
    @Excel(name = "会议坐席")
    private String meetingSeating;

    /** 是否有已意向客户 */
    @Excel(name = "是否有已意向客户")
    private String hasIntentionalCustomers;

    /** 状态 1 有效2 无效 */
    @Excel(name = "状态 1 有效2 无效")
    private String expand1;

    /** 区域 */
    @Excel(name = "区域")
    private String expand2;

    /** 性别 */
    @Excel(name = "性别")
    private String expand3;

    /** 是否参加城市景点旅游 */
    @Excel(name = "是否参加城市景点旅游")
    private String expand4;

    /** 培训座席 */
    @Excel(name = "培训座席")
    private String expand5;
    /** 区域负责经理 */
    @Excel(name = "区域负责经理")
    private String expand6;
    /**  */
    @Excel(name = "")
    private String expand7;
    /**  */
    @Excel(name = "")
    private String expand8;
    /**  */
    @Excel(name = "")
    private String expand9;
    /**  */
    @Excel(name = "")
    private String expand10;


    String userid ;

    /** 创建时间 */
    private String createDate;

    private int limitS;
    private int limitE;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCustomerType(String customerType) 
    {
        this.customerType = customerType;
    }

    public String getCustomerType() 
    {
        return customerType;
    }
    public void setProvinceArea(String provinceArea) 
    {
        this.provinceArea = provinceArea;
    }

    public String getProvinceArea() 
    {
        return provinceArea;
    }
    public void setAttendeeName(String attendeeName) 
    {
        this.attendeeName = attendeeName;
    }

    public String getAttendeeName() 
    {
        return attendeeName;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setIsTraveling(String isTraveling) 
    {
        this.isTraveling = isTraveling;
    }

    public String getIsTraveling() 
    {
        return isTraveling;
    }
    public void setAccompanyingPersonnel(String accompanyingPersonnel) 
    {
        this.accompanyingPersonnel = accompanyingPersonnel;
    }

    public String getAccompanyingPersonnel() 
    {
        return accompanyingPersonnel;
    }
    public void setHotelName(String hotelName) 
    {
        this.hotelName = hotelName;
    }

    public String getHotelName() 
    {
        return hotelName;
    }
    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }
    public void setBreakfastTime(String breakfastTime) 
    {
        this.breakfastTime = breakfastTime;
    }

    public String getBreakfastTime() 
    {
        return breakfastTime;
    }
    public void setLunchTime(String lunchTime) 
    {
        this.lunchTime = lunchTime;
    }

    public String getLunchTime() 
    {
        return lunchTime;
    }
    public void setDinnerTime(String dinnerTime) 
    {
        this.dinnerTime = dinnerTime;
    }

    public String getDinnerTime() 
    {
        return dinnerTime;
    }
    public void setMealLocation(String mealLocation) 
    {
        this.mealLocation = mealLocation;
    }

    public String getMealLocation() 
    {
        return mealLocation;
    }
    public void setBanquetTime(String banquetTime) 
    {
        this.banquetTime = banquetTime;
    }

    public String getBanquetTime() 
    {
        return banquetTime;
    }
    public void setBanquetLocation(String banquetLocation) 
    {
        this.banquetLocation = banquetLocation;
    }

    public String getBanquetLocation() 
    {
        return banquetLocation;
    }
    public void setBanquetSeating(String banquetSeating) 
    {
        this.banquetSeating = banquetSeating;
    }

    public String getBanquetSeating() 
    {
        return banquetSeating;
    }
    public void setMeetingDate(String meetingDate) 
    {
        this.meetingDate = meetingDate;
    }

    public String getMeetingDate() 
    {
        return meetingDate;
    }
    public void setMeetingLocation(String meetingLocation) 
    {
        this.meetingLocation = meetingLocation;
    }

    public String getMeetingLocation() 
    {
        return meetingLocation;
    }
    public void setTourVehicleArrangement(String tourVehicleArrangement) 
    {
        this.tourVehicleArrangement = tourVehicleArrangement;
    }

    public String getTourVehicleArrangement() 
    {
        return tourVehicleArrangement;
    }
    public void setFactoryVisitVehicleArrangement(String factoryVisitVehicleArrangement) 
    {
        this.factoryVisitVehicleArrangement = factoryVisitVehicleArrangement;
    }

    public String getFactoryVisitVehicleArrangement() 
    {
        return factoryVisitVehicleArrangement;
    }
    public void setMeetingSeating(String meetingSeating) 
    {
        this.meetingSeating = meetingSeating;
    }

    public String getMeetingSeating() 
    {
        return meetingSeating;
    }
    public void setHasIntentionalCustomers(String hasIntentionalCustomers) 
    {
        this.hasIntentionalCustomers = hasIntentionalCustomers;
    }

    public String getHasIntentionalCustomers() 
    {
        return hasIntentionalCustomers;
    }
    public void setExpand1(String expand1) 
    {
        this.expand1 = expand1;
    }

    public String getExpand1() 
    {
        return expand1;
    }
    public void setExpand2(String expand2) 
    {
        this.expand2 = expand2;
    }

    public String getExpand2() 
    {
        return expand2;
    }
    public void setExpand3(String expand3) 
    {
        this.expand3 = expand3;
    }

    public String getExpand3() 
    {
        return expand3;
    }
    public void setExpand4(String expand4) 
    {
        this.expand4 = expand4;
    }

    public String getExpand4() 
    {
        return expand4;
    }
    public void setExpand5(String expand5) 
    {
        this.expand5 = expand5;
    }

    public String getExpand6() {
        return expand6;
    }

    public void setExpand6(String expand6) {
        this.expand6 = expand6;
    }

    public String getExpand7() {
        return expand7;
    }

    public void setExpand7(String expand7) {
        this.expand7 = expand7;
    }

    public String getExpand8() {
        return expand8;
    }

    public void setExpand8(String expand8) {
        this.expand8 = expand8;
    }

    public String getExpand9() {
        return expand9;
    }

    public void setExpand9(String expand9) {
        this.expand9 = expand9;
    }

    public String getExpand10() {
        return expand10;
    }

    public void setExpand10(String expand10) {
        this.expand10 = expand10;
    }

    public String getExpand5()
    {
        return expand5;
    }

    public int getLimitS() {
        return limitS;
    }

    public void setLimitS(int limitS) {
        this.limitS = limitS;
    }

    public int getLimitE() {
        return limitE;
    }

    public void setLimitE(int limitE) {
        this.limitE = limitE;
    }
}
