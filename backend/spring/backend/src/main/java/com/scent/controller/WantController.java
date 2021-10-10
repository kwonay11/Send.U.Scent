package com.scent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scent.entity.HaveList;
import com.scent.entity.WantList;
import com.scent.model.BasicResponse;
import com.scent.repo.WantRepo;
import com.scent.service.WantService;

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
@RequestMapping("/like")
public class WantController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	WantRepo wantRepo;
	
	@Autowired
	WantService wantService;
	
	@GetMapping("/listall")
	@ApiOperation(value = "전체 목록 조회", notes = "전체 회원들의 좋아요 목록")
	public List<WantList> listAll() {
		return wantService.getAll();
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "목록 조회", notes = "유저의 int id값을 넘겨서 좋아요 누른 향수 목록 조회")
	public Map<String, Object> findList(@RequestParam int user_id) {
		Map<String, Object> response = new HashMap<String, Object>();

		List<WantList> wl = wantService.getList(user_id);
		if (!wl.isEmpty()) {
			response.put("result", SUCCESS);
			response.put("wantlist", wl);
		} else {
			response.put("result", FAIL);
			response.put("reason", "등록된 목록이 없습니다.");
		}
		return response;
	}
	
	@PostMapping("/insert")
	@ApiOperation(value = "목록 추가", notes = "유저 고유 id, 향수 고유 id 를 받아 목록에 추가한다.")
	public Map<String, Object> insertList(@RequestBody WantList wlist) {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			if (wantService.insertList(wlist)> 0) {
				response.put("result", SUCCESS);
			} else {
				response.put("result", FAIL);
				response.put("reason", "이미 등록된 목록입니다.");
			}
		} catch (Exception e) {
			response.put("result", FAIL);
			response.put("reason", e.getMessage());
		}
		
		return response;
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "좋아요 목록 삭제", notes = "해당 목록의 고유 id를 받아 목록에서 제거한다.")
	public Map<String, Object> deleteList(@RequestParam int id) {
		Map<String, Object> response = new HashMap<String, Object>();

		if (wantService.delete(id) > 0) {
			response.put("result", SUCCESS);
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 목록이 없습니다.");
		}
		return response;
	}
	
}
