package com.scent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scent.model.BasicResponse;
import com.scent.repo.HaveRepo;
import com.scent.service.HaveService;
import com.scent.entity.HaveList;
import com.scent.entity.User;

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
@RequestMapping("/have")
public class HaveController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	HaveRepo haveRepo;

	@Autowired
	HaveService haveService;

	@GetMapping("/listall")
	@ApiOperation(value = "모든 가지고 있는 목록 리스트", notes = "모든 가지고 있는 목록")
	public List<HaveList> listAll() {
		return haveService.getAll();
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "목록 조회", notes = "유저의 int id값을 넘겨서 가지고 있는 향수 목록 조회")
	public Map<String, Object> findList(@RequestParam int user_id) {
		Map<String, Object> response = new HashMap<String, Object>();

		List<HaveList> hl = haveService.getList(user_id);
		if (!hl.isEmpty()) {
			response.put("result", SUCCESS);
			response.put("havelist", hl);
		} else {
			response.put("result", FAIL);
			response.put("reason", "등록된 목록이 없습니다.");
		}
		return response;
	}
	
	@PostMapping("/insert")
	@ApiOperation(value = "목록 추가", notes = "유저 고유 id, 향수 고유 id 를 받아 목록에 추가한다.")
	public Map<String, Object> insertList(@RequestBody HaveList hlist) {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			if (haveService.insertList(hlist) > 0) {
				response.put("result", SUCCESS);
			} else {
				response.put("result", FAIL);
				response.put("reason", "이미 작성된 리뷰입니다.");
			}
		} catch (Exception e) {
			response.put("result", FAIL);
			response.put("reason", e.getMessage());
		}
		
		return response;
	}

	@PutMapping("/update")
	@ApiOperation(value = "리뷰 등록", notes = "목록 id를 받아 리뷰 내용, 별점을 저장한다.")
	public Map<String, Object> updateRev(@RequestBody HaveList hlist) {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			if (haveService.insertRev(hlist.getId(), hlist.getReview(), hlist.getScore()) > 0) {
				response.put("result", SUCCESS);
			} else {
				response.put("result", FAIL);
				response.put("reason", "이미 작성된 리뷰입니다.");
			}
		} catch (Exception e) {
			response.put("result", FAIL);
			response.put("reason", e.getMessage());
		}
		
		return response;
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value = "가지고 있는 목록 삭제", notes = "해당 목록의 고유 id를 받아 목록에서 제거한다.")
	public Map<String, Object> deleteList(@RequestParam int id) {
		Map<String, Object> response = new HashMap<String, Object>();

		if (haveService.deleteList(id) > 0) {
			response.put("result", SUCCESS);
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 목록이 없습니다.");
		}
		return response;
	}

	@PutMapping("/deleteRev/{id}")
	@ApiOperation(value = "리뷰 삭제", notes = "해당 목록의 고유 id를 받아 리뷰와 평점을 초기화 한다.")
	public Map<String, Object> deleteRev(@PathVariable("id") int id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (haveService.deleteRev(id) > 0) {
			response.put("result", SUCCESS);
		} else {
			response.put("result", FAIL);
			response.put("reason", "일치하는 목록이 없습니다.");
		}
		return response;
	}
}
