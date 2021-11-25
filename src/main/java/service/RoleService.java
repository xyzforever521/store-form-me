package service;

import entity.Role;
import mapper.RoleMapper;

public class RoleService {
    private RoleMapper mapper = new RoleMapper();
    public Role selectRoleByUserStatus(Integer userStatus){
        Role role = mapper.selectRoleByUserStatus(userStatus);
        return role;
    }
}
