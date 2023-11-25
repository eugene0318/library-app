package com.group.libraryapp.controller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;

//주어진 class를 controller로 등록 (api입구)
@RestController
public class CalculatorController {

	@GetMapping("/add")
	public int addTwoNumbers(CalculatorAddRequest request) {
		return request.getNumber1() + request.getNumber2();
	}

	@PostMapping("/multiply")
	public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
		return request.getNumber1() * request.getNumber2();
	}
}
