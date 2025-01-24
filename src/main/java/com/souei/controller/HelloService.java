package com.souei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
    private HelloMapper helloMapper;

    public List<HelloBean> selectName(){
        return helloMapper.selectEmpAll();
    }
}
