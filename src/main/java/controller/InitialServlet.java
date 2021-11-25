package controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Power;
import entity.User;
import mapper.UserMapper;
import service.PowerService;
import service.UserService;
import utils.Md5Utils;
import utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/ini")
public class InitialServlet extends HttpServlet {
    private UserService userService = new UserService();
    private PowerService powerService = new PowerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        ResponseUtils resp = null;
        Map result = new LinkedHashMap<>();
        try{
            UserMapper userMapper = new UserMapper();
            User user = (User)userMapper.selectByUserName(userName);
            Power power = new Power();
            power.setRoleId(1);
            power.setUserNo(user.getUserNo());
            powerService.userPower(power);
            String md5 = Md5Utils.md5Digest(user.getPassword(), user.getUserNo());
            user.setPassword(md5);
            userService.DeleteByUserNo(user.getUserNo());
            userService.iniUser(user);
            resp = new ResponseUtils().put("user", user);
        }catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }
}
