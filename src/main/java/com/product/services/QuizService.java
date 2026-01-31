
package com.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.product.repository.QuizRepo;
import com.product.models.Quiz;
import com.product.models.Response;
import com.product.models.WrapperQuestion;
import com.product.quizInterface.QuizInterface;

@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;
	
//	@Autowired
//	QuestionRepository questionRepo;
	
	@Autowired
	QuizInterface quizInterface;
	
	
	public ResponseEntity<List<Integer>> createQuiz(String category, String title, int num) {
//		Pageable pageable=Pageable.ofSize(num);
		List<Integer> questionIds=quizInterface.generateQuestions(category, num).getBody(); //getting question Id
		Quiz q=new Quiz();
		q.setQuestions(questionIds); //setting question Id
		q.setTitle(title);
		quizRepo.save(q);
		return new ResponseEntity<>(questionIds,HttpStatus.OK);
	}


//	public ResponseEntity<List<WrapperQuestion>> getQuestionsById(int id) {
//		Optional<Quiz> quiz=quizRepo.findById(id);
//
////		List<Question> questionsFromDb=quiz.get().getQuestions();
////		List<WrapperQuestion> questionsForUser=new ArrayList<>();
////		
////		for(Question q:questionsFromDb) {
////			WrapperQuestion wq=new WrapperQuestion(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
////			questionsForUser.add(wq);
////		}
//		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
//	}


//	public ResponseEntity<Integer> getScore(int id, List<Response> response) {
//		int rightAnswers=0;
//		Quiz quiz=quizRepo.findById(id).get();
////		List<Question> questions=quiz.getQuestions();
////		int i=0;
////		for(Question q:questions) {
////			if(q.getRightAnswer().equals(response.get(i).getAnswer()))
////				rightAnswers++;
////			i++;
////		}
//		
//		return new ResponseEntity<>(rightAnswers,HttpStatus.OK);
//	}
}

