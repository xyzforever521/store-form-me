package mapper;

import entity.Role;
import utils.MybatisUtils;

public class RoleMapper {
    public Role selectRoleByUserStatus(Integer userStatus){
        Role role = (Role) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("selectRoleByUserStatus", userStatus));
        return role;
    }
}
