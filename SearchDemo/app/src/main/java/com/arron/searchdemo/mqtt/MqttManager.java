package com.arron.searchdemo.mqtt;

import com.arron.searchdemo.util.LogUtil;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

/**
 * create by Aaron Xie
 * on 2021/4/13
 * description:
 */
public class MqttManager {
    private static MqttManager mInstance = null;
    private MqttCallback mCallback;
    private static MqttClient client;
    private MqttConnectOptions conOpt;

    private MqttManager() {

    }

    public static MqttManager getInstance() {
        if (null == mInstance) {
            synchronized (MqttManager.class) {
                if (mInstance == null) {
                    mInstance = new MqttManager();
                }
            }
        }
        return mInstance;
    }

    public static void release() {
        if (mInstance != null) {
            mInstance = null;
        }
    }

    public void createConnect(String clientId, String topicId) {
        LogUtil.i("clientId" + clientId);
        String tmpDir = System.getProperty("java.io.tmpdir");
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence();
        try {
            conOpt = new MqttConnectOptions();
            conOpt.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
            conOpt.setCleanSession(false);
            conOpt.setUserName("bgy");
            conOpt.setPassword("123456".toCharArray());
            conOpt.setConnectionTimeout(10);
            conOpt.setKeepAliveInterval(120);
            conOpt.setAutomaticReconnect(true);
            client = new MqttClient("url", clientId, dataStore);
            client.setCallback(mCallback);
            conOpt.setWill(topicId, "close".getBytes(), 1, true);
            doConnect();
        } catch (Exception e) {
            LogUtil.e("createConnect :" + e.toString());
        }
    }

    public void doConnect() {
        if (client != null) {
            try {
                LogUtil.i("conOpt:" + conOpt);
                client.connect(conOpt);
            } catch (Exception e) {
                LogUtil.i("doConnect :" + e.toString());
            }
        }
    }

    public void publish(String topicName, int qos, byte[] payload) {
        if (client != null && client.isConnected()) {
            MqttMessage message = new MqttMessage(payload);
            message.setPayload(payload);
            message.setQos(qos);
            try {
                client.publish(topicName, message);
            } catch (MqttException e) {
                LogUtil.e("publish :" + e.toString());
            }
        }
    }

    public void publish(String topicName, int qos, String payload) {
        if (client != null && client.isConnected()) {
            MqttMessage message = new MqttMessage(payload.getBytes());
            message.setPayload(payload.getBytes());
            message.setQos(qos);
            try {
                client.publish(topicName, message);
            } catch (MqttException e) {
                LogUtil.e("publish :" + e.toString());
            }
        }
    }

    public void subscribe(String topicName, int qos) {
        if (client != null && client.isConnected()) {
            try {
                client.subscribe(topicName, qos);
            } catch (MqttException e) {
                LogUtil.e("subscribe:" + e.toString());
            }
        }
    }

    public void unsubscribe(String topicName) {
        if (client != null && client.isConnected()) {
            try {
                client.unsubscribe(topicName);
            } catch (MqttException e) {
                LogUtil.e("unsubscribe:" + e.toString());
            }
        }
    }

    public void disConnect() throws MqttException {
        if (client != null && client.isConnected()) {
            client.disconnect();
        }
    }

    public static boolean isConnect() {
        return client != null && client.isConnected();
    }
}
