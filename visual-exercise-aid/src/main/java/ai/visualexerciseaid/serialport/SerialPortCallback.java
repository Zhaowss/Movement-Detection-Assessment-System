package ai.visualexerciseaid.serialport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerialPortCallback extends customcallback{

    public SerialPortCallback() {
    }

    public void dataAvailable() throws IOException {
        try {
            byte[] back = SerialPortManager.readSerialPortData();
            System.out.println("back-"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))+"--"+ConvertHexStrAndStrUtils.bytesToHexStr(back));
            String s = ConvertHexStrAndStrUtils.bytesToHexStr(back);
            System.out.println("rev--data:"+s);
            s=ConvertHexStrAndStrUtils.hexStrToStr(s);
            System.out.println("rev-----10---data:"+s);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}