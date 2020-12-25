package com.goldcard.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldcard.dto.Results;
import com.goldcard.service.RedisService;

@RestController
public class PushDataController {
	@Autowired
	RedisService redisService;
	//public static String id = "1";
	private final static Logger log = LoggerFactory.getLogger(PushDataController.class);
	@PostMapping("/meterno")
	@ResponseBody
	public Results addToRedis(String meterno,String id) {
		Map<String,String> map = new HashMap<String,String>();
		Results results = new Results();
		if(StringUtils.isEmpty(id)){
			id = "1";
		}
		map.put("id", id);
		map.put("no", meterno);
		try {
			redisService.hmMap(meterno.substring(meterno.length()-10), map);
			results.setSuccess(true);
			results.setMessage("添加成功");
			log.info("将表号:"+meterno+",推送至redis成功");
		} catch (Exception e) {
			results.setSuccess(false);
			results.setMessage("添加失败");
			log.error("将表号:"+meterno+",推送至redis失败,失败原因:"+e.getMessage());
		}
		return results;
	}
}
