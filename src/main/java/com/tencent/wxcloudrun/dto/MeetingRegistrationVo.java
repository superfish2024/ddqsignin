package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.config.Excel;
import com.tencent.wxcloudrun.utils.ExcelImport;
import lombok.Data;

import java.io.Serializable;

/**
 * 登记信息对象 meeting_registration
 * 
 * @author ruoyi
 * @date 2023-04-26
 */
@Data
public class MeetingRegistrationVo implements Serializable
{
    private static final long serialVersionUID = 1L;


    /** 客户类别 */
    @Excel(name = "客户类别")
    @ExcelImport(colNum = 0,colName = "客户类别")
    private String customerType;

    /** 所属省区 */
    @Excel(name = "所属省区")
    @ExcelImport(colNum = 1,colName = "所属省区")
    private String provinceArea;

    /** 参会人名称 */
    @Excel(name = "参会人名称")
    private String attendeeName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    /** 是否参加旅游 */
    @Excel(name = "是否参加旅游")
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

    /** 是否有已意向客户 */
    @Excel(name = "是否有已意向客户")
    private String expand1;




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


}
