package com.management.kintaikanri.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.kintaikanri.entity.LoginEntity;
import com.management.kintaikanri.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    /**
    *
    *  ログインIDから社員情報を取得
    *
    */
    @Transactional
    public String apiLogin(int loginId, String password)
    {
    	String result = null;

    	// ログイン情報取得
    	LoginEntity loginInfo = loginRepository.findLoginInfo(loginId);

    	// ログインIDが取得できなければ処理を返す
    	if(loginInfo == null) {
    		result = messageSource.getMessage("login.fail", new String[] {}, Locale.getDefault());

    		return result;
    	}

    	// パスワード一致確認
        if (passwordEncoder.matches(password, loginInfo.getPassword())) {
        	result = messageSource.getMessage("login.success", new String[] {}, Locale.getDefault());
        	logger.info(messageSource.getMessage("log.login.success", new String[] {loginInfo.getLoginId()}, Locale.getDefault()));

            return result;
        } else {
        	result = messageSource.getMessage("login.fail", new String[] {}, Locale.getDefault());
        	logger.info(messageSource.getMessage("log.login.error", new String[] {loginInfo.getLoginId()}, Locale.getDefault()));

            return result;
        }
    }
}
