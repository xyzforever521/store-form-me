package service;

import entity.User;
import mapper.UserMapper;
import utils.Md5Utils;
import utils.MybatisUtils;

import javax.security.auth.login.LoginException;
import java.util.List;

public class UserService {
    private UserMapper userMapper = new UserMapper();

    public User checkLogin(String userName, String password) throws LoginException {
        User user = userMapper.selectByUserName(userName);
        if (user == null){
            throw new LoginException("用户名不存在");
        }
        String md5 = Md5Utils.md5Digest(password, user.getUserNo());
        if (!md5.equals(user.getPassword())){
            throw new LoginException("密码错误");
        }
        return user;
    }

    public User selectByUserNo(Integer userNo){
        User user = userMapper.selectByUserNo(userNo);
        return user;
    }

    public List<User> selectTenUser(Integer page){
        return  (List<User>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("selectTenUser", ((page - 1) * 10)));
    }

    public void DeleteByUserNo(Integer userNo){
        MybatisUtils.executeUpdate(sqlSession -> sqlSession.delete("deleteByUserNo", userNo));
    }
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public void iniUser(User user){
        userMapper.iniUser(user);
    }
}
