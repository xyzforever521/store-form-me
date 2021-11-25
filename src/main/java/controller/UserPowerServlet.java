package controller;

import entity.Node;
import entity.Role;
import entity.User;
import service.RbacService;
import service.RoleService;
import service.UserService;
import utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/userPower")
public class UserPowerServlet extends HttpServlet {
    private RbacService rbacService = new RbacService();
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uno = request.getParameter("uno");
        List<Node> nodes = rbacService.selectNodeByUserNo(Integer.parseInt(uno));
        List<Map> treeList = new ArrayList<>();
        Map module = null;
        for (Node node : nodes){
            if (node.getNodeType() == 1){
                module = new LinkedHashMap();
                module.put("node", node);
                module.put("children", new ArrayList());
                treeList.add(module);
            }else if(node.getNodeType() == 2){
                List children = (List)module.get("children");
                children.add(node);
            }
        }
        User user = userService.selectByUserNo(Integer.parseInt(uno));
        Role role = roleService.selectRoleByUserStatus(user.getUserStatus());
        String json = new ResponseUtils().put("nodeList", treeList).put("user", user).put("role", role).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
