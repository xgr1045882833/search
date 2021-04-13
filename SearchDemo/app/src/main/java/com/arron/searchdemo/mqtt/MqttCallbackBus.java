package com.arron.searchdemo.mqtt;

import com.arron.searchdemo.util.LogUtil;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * create by Aaron Xie
 * on 2021/4/13
 * description:
 */
public class MqttCallbackBus implements MqttCallbackExtended {
    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        LogUtil.i("connectComplete=" + reconnect);
        if (reconnect) {
            MqttManager.getInstance().subscribe("执行", 1);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        LogUtil.e("连接中断：" + cause.toString());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        LogUtil.i("topic=" + topic + ",MqttMessage=" + message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        LogUtil.i("交互完成：" + token.toString());
    }
}
