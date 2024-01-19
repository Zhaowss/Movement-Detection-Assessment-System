package ai.visualexerciseaid.serialport;

import com.fazecast.jSerialComm.SerialPort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class SerialPortManager {


    public static final int SERIAL_BAUD_RATE = 115200;

    public static volatile boolean SERIAL_PORT_STATE = false;

    public static volatile SerialPort SERIAL_PORT_OBJECT = null;

    public static List<String> getSerialPortList() {
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        List<String> portNameList = new ArrayList<String>();
        for (SerialPort serialPort : serialPorts) {
            System.out.println(serialPort.getSystemPortName());
            portNameList.add(serialPort.getSystemPortName());
        }
        portNameList = portNameList.stream().distinct().collect(Collectors.toList());
        return portNameList;
    }

    public static void connectSerialPort(String portName, SerialPortListener serialPortListener) {
        try {
            SerialPort serialPort = SerialPortManager.openSerialPort(portName, SERIAL_BAUD_RATE);
            TimeUnit.MILLISECONDS.sleep(2000);
            serialPort.addDataListener(serialPortListener);
            if (serialPort.isOpen()) {
                SERIAL_PORT_OBJECT = serialPort;
                SERIAL_PORT_STATE = true;
                System.out.println(portName + "-- start success");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static SerialPort openSerialPort(String portName, Integer baudRate) {
        SerialPort serialPort = SerialPort.getCommPort(portName);
        if (baudRate != null) {
            serialPort.setBaudRate(baudRate);
        }
        if (!serialPort.isOpen()) {
            serialPort.openPort(1000);

        } else {
            return serialPort;
        }
        serialPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
        serialPort.setComPortParameters(baudRate, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING, 1000, 1000);
        System.out.println("串口打开成功");
        return serialPort;
    }

    public static void closeSerialPort() {
        if (SERIAL_PORT_OBJECT != null && SERIAL_PORT_OBJECT.isOpen()) {
            SERIAL_PORT_OBJECT.closePort();
            SERIAL_PORT_STATE = false;
            SERIAL_PORT_OBJECT = null;
        }
    }

    public static void sendSerialPortData(byte[] content) {
        if (SERIAL_PORT_OBJECT != null && SERIAL_PORT_OBJECT.isOpen()) {
            SERIAL_PORT_OBJECT.writeBytes(content, content.length);
        }
    }

    public static byte[] readSerialPortData() {
        if (SERIAL_PORT_OBJECT != null && SERIAL_PORT_OBJECT.isOpen()) {
            byte[] reslutData = null;
            try {
                if (!SERIAL_PORT_OBJECT.isOpen()) {
                    return null;
                }
                ;
                int i = 0;
                while (SERIAL_PORT_OBJECT.bytesAvailable() > 0 && i++ < 5) Thread.sleep(20);
                byte[] readBuffer = new byte[SERIAL_PORT_OBJECT.bytesAvailable()];
                int numRead = SERIAL_PORT_OBJECT.readBytes(readBuffer, readBuffer.length);
                if (numRead > 0) {
                    reslutData = readBuffer;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return reslutData;
        }
        return null;
    }

}