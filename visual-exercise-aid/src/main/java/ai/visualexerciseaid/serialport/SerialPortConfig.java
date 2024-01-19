package ai.visualexerciseaid.serialport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerialPortConfig {

    @Bean
    public SerialPortManager SerialPortManager() {
        return new SerialPortManager();
    }

    @Bean
    public SerialPortListener SerialPortListener(SerialPortCallback serialPortCallback) {
        return new SerialPortListener(serialPortCallback);
    }

    @Bean
    public SerialPortCallback SerialPortCallback() {
        return new SerialPortCallback();
    }

}