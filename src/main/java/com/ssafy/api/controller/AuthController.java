package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.service.UserService;
import com.ssafy.db.entity.User;

/**
 * 인증 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginPostRes> login(@RequestBody UserLoginPostReq loginInfo) {
		String userId = loginInfo.getId();
		String password = loginInfo.getPassword();
		// 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
		// 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
		return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
	}
}
