package com.alan.yx.springSource.chapter_5.factory_bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yinxing
 * @date 2019/12/5
 */

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] info = carInfo.split(",");
        car.setBrand(info[0]);
        car.setMaxSpeed(Integer.valueOf(info[1]));
        car.setPrice(Double.valueOf(info[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    /**
     * 接收逗号分隔符设置属性信息
     *
     * @param carInfo
     */
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getCarInfo() {
        return carInfo;
    }
}
