package com.zane.androidupnpdemo.entity;

import android.support.annotation.Nullable;

import com.zane.androidupnpdemo.util.Utils;

import org.fourthline.cling.model.meta.Device;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 说明：单例设备列表, 保证全局只有一个设备列表
 * 作者：zhouzhan
 * 日期：17/6/30 11:25
 */

public class ClingDeviceList {

    private static ClingDeviceList INSTANCE = null;

    private Collection<ClingDevice> mClingDeviceList;

    private ClingDeviceList(){
        mClingDeviceList = new ArrayList<>();
    }

    public static ClingDeviceList getInstance() {
        if (Utils.isNull(INSTANCE)) {
            INSTANCE = new ClingDeviceList();
        }
        return INSTANCE;
    }

    public void removeDevice(ClingDevice device){
        mClingDeviceList.remove(device);
    }

    public void addDevice(ClingDevice device){
        mClingDeviceList.add(device);
    }

    @Nullable
    public ClingDevice getClingDevice(Device device){
        for (ClingDevice clingDevice : mClingDeviceList){
            Device deviceTemp = clingDevice.getDevice();
            if (deviceTemp != null && deviceTemp.equals(device)){
                return clingDevice;
            }
        }
        return null;
    }

    public boolean contain(Device device){
        for (ClingDevice clingDevice : mClingDeviceList){
            Device deviceTemp = clingDevice.getDevice();
            if (deviceTemp != null && deviceTemp.equals(device)){
                return true;
            }
        }
        return false;
    }

    public Collection<ClingDevice> getClingDeviceList() {
        return mClingDeviceList;
    }

    public void setClingDeviceList(Collection<ClingDevice> clingDeviceList) {
        mClingDeviceList = clingDeviceList;
    }

    public void destroy(){
        mClingDeviceList = null;
        INSTANCE = null;
    }
}
