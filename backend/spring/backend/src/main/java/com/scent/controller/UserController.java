package com.scent.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scent.entity.User;
import com.scent.list.model.BasicResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
		@ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
		@ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
		@ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@CrossOrigin(origins = "*")
@RestController // Json 형태로 결과값 반환(=RoesponseBody)
@RequiredArgsConstructor // final 객체를 Constructor Injection 생성자 주입(=Autowired)
@RequestMapping("/user")
public class UserController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String path = "";
	
	@GetMapping("/{id}")
	public ResponseEntity<Respon>
}
