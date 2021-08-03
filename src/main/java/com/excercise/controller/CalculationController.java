package com.excercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excercise.model.TreasueHuntRequest;
import com.excercise.model.TreasueHuntResponse;
import com.excercise.service.TreasureService;

@RestController
public class CalculationController {
	
	@Autowired
	private TreasureService treasureService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/hunt")
	public TreasueHuntResponse treasureHunt(@RequestBody TreasueHuntRequest treasueHuntRequest) {
		System.out.println(treasueHuntRequest);
		return treasureService.treasueHunt(treasueHuntRequest);
	}
}
