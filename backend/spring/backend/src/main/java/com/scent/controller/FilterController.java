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
import com.scent.service.FilterService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/filter")
public class FilterController {

	@Autowired
	FilterService filterService;

	@GetMapping(value = "/title/{title}")
	@ApiOperation(value = "향수 이름", notes = "검색어 포함하는 향수 다 가져오기")
	public ResponseEntity<List<Map<String, Object>>> searchWord(@PathVariable("title") String title,
			HttpServletResponse response) {
		List<Perfume> list = filterService.findPerfumeTitle(title);
		List<Map<String, Object>> searchList = new ArrayList<>();

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				int perfId = list.get(i).getId();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				map.put("perfume_id", perfId);
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}

	@GetMapping(value = "/{checkedOpt}")
	@ApiOperation(value = "계절(spring,summer,autumn,winter), 시간(1,2), 성별(men,women)", notes = "계절, 시간, 성별 관련 옵션 여러개 들어옴")
	public ResponseEntity<List<Map<String, Object>>> listCheckedOpt(@PathVariable("checkedOpt") String checkedOpt,
			HttpServletResponse response) {
		// 들어온 string을 ","로 split해서 배열에 넣기
		String[] option = checkedOpt.split(",");

		List<Perfume> list = new ArrayList<>();
		List<Perfume> tempList = new ArrayList<>();
		List<Integer> idList = new ArrayList<>();
		List<Map<String, Object>> searchList = new ArrayList<>();

		for (int i = 0; i < option.length; i++) {
			System.out.println(option[i]);
			if (option[i].equals("spring") | option[i].equals("summer") | option[i].equals("autumn")
					| option[i].equals("winter")) {
				tempList = filterService.findSeason(option[i]);
			} else if (option[i].equals("1") | option[i].equals("2")) {
				tempList = filterService.findDayNight(option[i]);
			} else if (option[i].equals("men") | option[i].equals("women")) {
				tempList = filterService.findGender(option[i]);
			}
			// list내용 각각을 합치기
			// list.addAll(tempList);

			// idList에다가 id중복되지 않게 집어넣기
			for (int j = 0; j < tempList.size(); j++) {
				int id = tempList.get(j).getId();
				if (!idList.contains(id)) {
					idList.add(id);
					System.out.println(id);
				}
			}
		}

		System.out.println("여기");
		// list -> idList기반으로 Perfume객체 찾아와서 담기
		list = filterService.findPerfumeId(idList);
		System.out.println("여기2");
		if (!list.isEmpty()) {
			System.out.println("여기3");
//		 		for (int i = 0; i < tempList.size(); i++) {
			for (int i = 0; i < 100; i++) {
				Map<String, Object> map = new HashMap<>();
				int perfId = list.get(i).getId();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				map.put("perfume_id", perfId);
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}

//	@GetMapping(value = "/daynight/{daynight}")
//	@ApiOperation(value = "", notes = "밤낮 향수 다 가져오기")
//	public ResponseEntity<List<Map<String, Object>>> searchDayNight(@PathVariable("daynight")int daynight,
//			HttpServletResponse response) {
//		List<Perfume> list = listService.findDayNight(daynight);
//		List<Map<String, Object>> searchList = new ArrayList<>();
//
//		if (!list.isEmpty()) {
//			for (int i = 0; i < list.size(); i++) {
//				Map<String, Object> map = new HashMap<>();
//				int perfId = list.get(i).getId();
//				String perfTitle = list.get(i).getTitle();
//				String perfAccord = list.get(i).getAccords();
//				map.put("perfume_id", perfId);
//				map.put("title", perfTitle);
//				map.put("accords", perfAccord);
//				searchList.add(map);
//			}
//		} else {
//			System.out.println("해당 향수 없음");
//		}
//		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
//	}

}
