package com.scent.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scent.entity.User;
import com.scent.model.BasicResponse;
import com.scent.repo.UserRepository;
import com.scent.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "UserController", description = "회원 관리 API", basePath = "/user")
public class UserController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	UserRepository userRepo;
	@Autowired
	UserService userService;

	@PostMapping("/join")
	@ApiOperation(value = "회원 가입", notes = "회원가입 JWT 토근 없음.")
	public ResponseEntity<Map<String, Object>> insertUser(@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();
		HttpStatus status = null;

		try {
			if (userService.insertUser(user) > 0) {
				response.put("result", SUCCESS);
			} else {
				response.put("result", FAIL);
				response.put("reason", "이미 존재하는 ID 입니다.");
			}
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			response.put("result", FAIL);
			response.put("reason", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(response, status);
	}

	@GetMapping("/info")
	@ApiOperation(value = "회원 정보 조회", notes = "해당 유저의 정보를 조회한다.")
	public Map<String, Object> findUser(@RequestParam String user_id) {
		Map<String, Object> response = new HashMap<String, Object>();

		Optional<User> user = userService.getUser(user_id);
		if (user.isPresent()) {
			response.put("result", SUCCESS);
			response.put("user", user.get());
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 회원정보가 없습니다. 회원 id를 확인해주세요.");
		}
		return response;
	}

	@PutMapping("/update")
	@ApiOperation(value = "회원 정보 수정", notes = "해당 유저의 정보를 수정한다.")
	public Map<String, Object> UpdateUser(@RequestBody User user) {
		Map<String, Object> response = new HashMap<String, Object>();

		if (userService.updateUser(user.getUser_id(), user.getPassword(), user.getNickname()) > 0) {
			response.put("result", SUCCESS);
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 회원정보가 없습니다. 사용자 id를 확인해주세요.");
		}

		return response;
	}

	@DeleteMapping("/delete/{user_id}")
	@ApiOperation(value = "회원 탈퇴", notes = "해당 유저의 정보를 삭제한다.")
	public Map<String, Object> DeleteUser(@RequestParam String user_id) {
		Map<String, Object> response = new HashMap<String, Object>();

		if (userService.deleteUser(user_id) > 0) {
			response.put("result", SUCCESS);
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 회원정보가 없습니다. 사용자 id를 확인해주세요.");
		}
		return response;

	}
}
