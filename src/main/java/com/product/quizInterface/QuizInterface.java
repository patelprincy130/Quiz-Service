package com.product.quizInterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.models.Response;
import com.product.models.WrapperQuestion;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	@GetMapping("question/generate")
	@ResponseBody
	public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam int numOfQues);
	
	@PostMapping("question/getQuestionById")
	@ResponseBody
	public ResponseEntity<List<WrapperQuestion>> getQuestionsById(@RequestBody List<Integer> ids);
	
	@PostMapping("question/getScore")
	@ResponseBody
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
