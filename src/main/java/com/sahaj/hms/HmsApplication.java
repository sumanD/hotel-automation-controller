package com.sahaj.hms;

import com.sahaj.hms.service.EquipmentControllerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmsApplication implements CommandLineRunner {

    @Autowired
    private EquipmentControllerImpl equipmentControllerImpl;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HmsApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        String a = "a";
    }

    @Override
    public void run(String... strings) throws Exception {
        equipmentControllerImpl.control();
    }
}
