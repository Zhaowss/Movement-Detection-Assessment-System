package ai.visualexerciseaid.serialport;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import lombok.SneakyThrows;

public class SerialPortListener implements SerialPortDataListener {


    private SerialPortCallback serialPortCallback;
    private Integer x;

    public SerialPortListener(SerialPortCallback serialPortCallback) {
        this.serialPortCallback = serialPortCallback;
    }

    @Override
    public int getListeningEvents() { //必须是return这个才会开启串口工具的监听
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @SneakyThrows
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortCallback != null) {
            serialPortCallback.dataAvailable();
        }
    }

}