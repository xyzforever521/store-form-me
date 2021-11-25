package mapper;

import entity.Power;
import utils.MybatisUtils;

public class PowerMapper {
    public void userPower(Power power){
        MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("power", power));
    }
}
