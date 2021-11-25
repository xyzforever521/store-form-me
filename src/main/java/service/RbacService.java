package service;

import entity.Node;
import mapper.RbacMapper;

import java.util.List;

public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserNo(Integer userNo){
        return rbacMapper.selectNodeByUserNo(userNo);
    }
}
