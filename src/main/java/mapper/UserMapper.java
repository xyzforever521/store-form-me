package mapper;

import entity.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapper {
    public User selectByUserName(String userName){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("selectByUserName", userName));
        return user;
    }
    public User selectByUserNo(Integer userNo){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("selectByUserNo", userNo));
        return user;
    }
    public List<User> selectTenUser(Integer page){
        List<User> list = (List<User>) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("selectTenUser", page));
        return list;
    }

    public void DeleteByUserNo(Integer userNo){
        MybatisUtils.executeUpdate(sqlSession -> sqlSession.delete("deleteByUserNo", userNo));
    }

    public void insertUser(User user){
        MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("insertUser", user));
    }

    public void iniUser(User user){
        MybatisUtils.executeUpdate(sqlSession -> sqlSession.insert("iniUser", user));
    }
}
