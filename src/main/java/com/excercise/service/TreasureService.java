package com.excercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.excercise.model.TreasueHuntRequest;
import com.excercise.model.TreasueHuntResponse;

@Service
public class TreasureService {

	public TreasueHuntResponse treasueHunt(TreasueHuntRequest treasueHuntRequest) {
		TreasueHuntResponse treasueHuntResponse = new TreasueHuntResponse();
		System.out.println("treasueHuntRequest " + treasueHuntRequest.getData()[0][0]);
		String[][] data = treasueHuntRequest.getData();
		//initial values to start to read the array.
		int tensPlace = 0;
		int oncePlace = 0;
		//Generate the number taking location coordinates
		int generatedNumber = tensPlace * 10 + oncePlace;
		//find the actual number at given location
		int numberAtIndex = Integer.valueOf(data[tensPlace][oncePlace]);
		
		List<List<String>> row = new ArrayList<List<String>>();
		List<String> column = new ArrayList<String>();
		//push initial starting points.
		column.add(String.valueOf(tensPlace+1));
		column.add(String.valueOf(oncePlace+1));
		row.add(column);
		int count = treasueHuntRequest.getData().length *50;
		do {
			// if given 2D array is cyclic run the block 500 time only.
			if(row.size() == count){
				row = new ArrayList<List<String>>();
				break;
			}
			column = new ArrayList<String>();
			tensPlace = numberAtIndex / 10;
			oncePlace = numberAtIndex % 10;
			generatedNumber = tensPlace * 10 + oncePlace;
			numberAtIndex = Integer.valueOf(data[tensPlace - 1][oncePlace - 1]);

			column.add(String.valueOf(tensPlace));
			column.add(String.valueOf(oncePlace));

			System.out.println("tensPlcace :" + tensPlace);
			System.out.println("oncePlace :" + oncePlace);
			System.out.println("generatedNumber :" + generatedNumber);
			row.add(column);
		} while (generatedNumber != numberAtIndex);

		System.out.println("number :" + numberAtIndex);
		treasueHuntResponse.setRows(row);
		return treasueHuntResponse;
	}

}