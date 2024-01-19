package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.websocket.WebSocket;
import ai.visualexerciseaid.serialport.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Controller
@RequestMapping("/serialPort")
public class SerialPortController {
    private String receivedData;

    @Autowired
    private SerialPortManager serialPortManager;

    @Resource
    private WebSocket webSocket;

    private SerialPortListener serialPortListener = new SerialPortListener(new SerialPortCallback() {
        @Override
        public void dataAvailable() throws IOException {

            System.out.println("______________________________________");
            byte[] back = SerialPortManager.readSerialPortData();
            System.out.println("back-" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())) + "--" + ConvertHexStrAndStrUtils.bytesToHexStr(back));
            String s = ConvertHexStrAndStrUtils.bytesToHexStr(back);

            System.out.println("Received data: " + s);
            receivedData = s;
            webSocket.broadcast(ConvertHexStrAndStrUtils.hexStrToStr(receivedData));
        }
    });

    @GetMapping("/list")
    public List<String> listPorts() {
        SerialPortManager.connectSerialPort("COM1", serialPortListener);
        List<String> portList = serialPortManager.getSerialPortList();

        if (!portList.isEmpty()) {
            return portList;
        }
        return null;
    }


    @PostMapping("/send/{hexData}")
    @ResponseBody
    public String sendPorts(@PathVariable("hexData") String hexData) {
        SerialPortManager.connectSerialPort("COM1", serialPortListener);
        if (serialPortManager.SERIAL_PORT_STATE) {
            serialPortManager.sendSerialPortData(ConvertHexStrAndStrUtils.hexStrToBytes(hexData));
            System.out.println(hexData + "has sended");
            return "success";
        }
        return "fail";
    }

    @GetMapping("/broadcast")
    public void GetPorts() {
        System.out.println("begin 实时通讯" + receivedData);
    }

}