package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//bu classta yapılandırma ayarları verilecek
@ComponentScan("com.tpe")//bu icerisine girdiginiz path'de yer alan tüm componentları arar.
//default path : AppConfiguration classın bulundugu path tanımlıdır
public class AppConfiguration {
}
