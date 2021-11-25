package service;

import entity.Power;
import mapper.PowerMapper;

public class PowerService {
    public void userPower(Power power){
        PowerMapper powerMapper = new PowerMapper();
        powerMapper.userPower(power);
    }
}
