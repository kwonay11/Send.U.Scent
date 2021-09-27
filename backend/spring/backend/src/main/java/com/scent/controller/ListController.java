package com.scent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scent.entity.Perfume;
import com.scent.service.ListService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/search")
public class ListController {
	
	@Autowired
	ListService listService;
	
	@GetMapping(value = "/{title}")
	@ApiOperation(value = "향수 이름", notes = "검색어 포함하는 향수 다 가져오기")
	public ResponseEntity<List<Map<String, Object>>> searchWord(@PathVariable("title") String title,
			HttpServletResponse response) {
		List<Perfume> list = listService.findPerfumeTitle(title);
		List<Map<String, Object>> searchList = new ArrayList<>();

		if (!list.isEmpty()) {
			System.out.println("ddd");
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}


}
