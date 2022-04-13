package com.pets;

import com.pets.util.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetHospitalInformationManageApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(TimeUtil.getTime());
    }

}
