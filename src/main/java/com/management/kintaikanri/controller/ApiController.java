package com.management.kintaikanri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.kintaikanri.service.LoginService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    LoginService loginService;

    /**
    *
    *  アプリAPI用
    *
    */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("loginId") int loginId, @RequestParam("password") String password) {

		// ログイン処理
		String result = loginService.apiLogin(loginId, password);

		return result;

	}
}
