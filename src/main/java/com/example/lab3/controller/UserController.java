package com.example.lab3.controller;

import com.example.lab3.SqlSessionLoader;
import com.example.lab3.User;
import com.example.lab3.bean.ResponseBean;
import com.example.lab3.request.UserLoginRequest;
import com.example.lab3.request.UserRegisterRequest;
import com.example.lab3.response.ErrorResponse;
import com.example.lab3.response.SuccessResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseBean register(@RequestBody UserRegisterRequest request) throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("example.UserMapper.findUserByUsername",
                request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used",null);
        } else {
            sqlSession.insert("example.UserMapper.addUser", new
                    User(request.getUsername(), request.getPassword(), request.getEmail(),
                    request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new SuccessResponse("success",null); // use your generated token here.
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseBean login(@RequestBody UserLoginRequest request) throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("example.UserMapper.findUserByUsername",
                request.getUsername());
        if (user == null) {
            sqlSession.close();
            return new ErrorResponse("The username does not exist",null);
        } else {
            if (user.getPassword().equals(request.getPassword())){
                sqlSession.close();
                return new SuccessResponse("abc",null); // use your generated token here.
            }else {
                sqlSession.close();
                return new ErrorResponse("wrong password",null);
            }
        }
    }

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public ResponseBean allUser() throws
            IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<User> users = sqlSession.selectList("example.UserMapper.findAllUser");

        sqlSession.close();
        return new SuccessResponse("success",users);
    }
}
