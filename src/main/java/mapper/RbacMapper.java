package mapper;

import entity.Node;
import utils.MybatisUtils;

import java.util.List;

public class RbacMapper {
    public List<Node> selectNodeByUserNo(Integer userNo){
        List list = (List) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserNo", userNo));
        return list;
    }
}
