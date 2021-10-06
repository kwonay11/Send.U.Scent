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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scent.entity.Perfume;
import com.scent.entity.perfmFilter;
import com.scent.service.FilterService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/listPage")
public class FilterController {

	@Autowired
	FilterService filterService;

	@GetMapping(value = "/default")
	@ApiOperation(value = "defalut 리스트", notes = "500개의 평점 4.0 이상 가져오기")
	public ResponseEntity<List<Map<String, Object>>> defaultlist(HttpServletResponse response) {
		List<Perfume> list = filterService.showAllList();
		List<Map<String, Object>> searchList = new ArrayList<>();

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				int perfId = list.get(i).getId();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				float perfScore = list.get(i).getRatingscore();
				String perfBrand = list.get(i).getBrand();
				map.put("perfume_id", perfId);
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				map.put("score", perfScore);
				map.put("brand", perfBrand);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}

	@GetMapping(value = "/search/{title}")
	@ApiOperation(value = "향수 이름 또는 브랜드 검색", notes = "검색어 포함하는 향수 다 가져오기")
	public ResponseEntity<List<Map<String, Object>>> searchTitle(@PathVariable("title") String title,
			HttpServletResponse response) {
		List<Perfume> list = filterService.findPerfumeTitle(title);
		List<Map<String, Object>> searchList = new ArrayList<>();

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				int perfId = list.get(i).getId();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				String perfBrand = list.get(i).getBrand();
				map.put("perfume_id", perfId);
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				map.put("brand", perfBrand);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}

	@GetMapping("/filter")
	@ApiOperation(value = "시간,성별,계절 입력 ", notes = "체크박스 값으로 필터링")
	public ResponseEntity<List<Map<String, Object>>> listCheckedOpt2(
			@RequestParam(value = "daynight", required = false) String daynight,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "season", required = false) String season, HttpServletResponse response) {

		//List<Perfume> list = new ArrayList<Perfume>();
		//list.addAll(filterService.findGrace());
		//System.out.println(filterService.findGrace().get(0));
		//list.addAll(filterService.findChecked(season, daynight, gender));
		List<Perfume> list=filterService.findChecked(season, daynight, gender);
		List<Map<String, Object>> searchList = new ArrayList<>();

		// list -> idList기반으로 Perfume객체 찾아와서 담기
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				int perfId = list.get(i).getId();
				String perfTitle = list.get(i).getTitle();
				String perfAccord = list.get(i).getAccords();
				String perfGender = list.get(i).getGender();
				String perfDaynight = list.get(i).getDaynight();
				String perfSeason = list.get(i).getSeason();
				String perfBrand = list.get(i).getBrand();				
				map.put("perfume_id", perfId);
				map.put("title", perfTitle);
				map.put("accords", perfAccord);
				map.put("gender", perfGender);
				map.put("daynight", perfDaynight);
				map.put("season", perfSeason);
				map.put("brand", perfBrand);
				searchList.add(map);
			}
		} else {
			System.out.println("해당 향수 없음");
		}
		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
	}
//	@GetMapping("/filter/list")	
//	@ApiOperation(value = "시간,성별,계절 입력 ", notes = "체크박스 값으로 필터링")
//	public ResponseEntity<List<Map<String, Object>>> listCheckedOpt2(List<String> filter,
//			HttpServletResponse response) {
//		
//		System.out.println("여기");
//		String season = filter.get(0);
//		String daynight = filter.get(1);
//		String gender = filter.get(2);
//		
//		System.out.print(season+""+daynight+""+gender);
//		
//		List<Perfume> list = filterService.findChecked(season, daynight, gender);
//		List<Map<String, Object>> searchList = new ArrayList<>();
//		
//		// list -> idList기반으로 Perfume객체 찾아와서 담기
//		if (!list.isEmpty()) {
//			for (int i = 0; i < list.size(); i++) {
//				Map<String, Object> map = new HashMap<>();
//				int perfId = list.get(i).getId();
//				String perfTitle = list.get(i).getTitle();
//				String perfAccord = list.get(i).getAccords();
//				String perfGender = list.get(i).getGender();
//				String perfDaynight = list.get(i).getDaynight();
//				String perfSeason = list.get(i).getSeason();				
//				map.put("perfume_id", perfId);
//				map.put("title", perfTitle);
//				map.put("accords", perfAccord);
//				map.put("gender", perfGender);
//				map.put("daynight", perfDaynight);
//				map.put("season", perfSeason);				
//				searchList.add(map);
//			}
//		} else {
//			System.out.println("해당 향수 없음");
//		}
//		return new ResponseEntity<List<Map<String, Object>>>(searchList, HttpStatus.OK);
//	}	

}
