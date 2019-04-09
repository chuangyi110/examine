package com.lzdn.examine.entity;

public class VehicleEntity {
    /**
     * 车辆号码
     */
    private String plateNumber;
    /**
     * 车牌类型
     */
    private String vehicleType;
    /**
     * 车架号VIN
     */
    private String vehicleIdentificationNumber;
    /**
     * 发动机号
     */
    private String engineNumber;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "plateNumber='" + plateNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleIdentificationNumber='" + vehicleIdentificationNumber + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                '}';
    }
}
