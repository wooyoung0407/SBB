package com.example.ndtest;

import com.example.ndtest.Answer.Answer;
import com.example.ndtest.Answer.AnswerRepository;
import com.example.ndtest.Question.Question;
import com.example.ndtest.Question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Transactional
	@Test
	void testJpa() {
		Optional<Question> question = this.questionRepository.findById(2);
		assertTrue(question.isPresent());
		Question question1 = question.get();

		List<Answer> answerList = question1.getAnswerList();

		assertEquals(1,answerList.size());
		assertEquals("1차내용답변",answerList.get(0).getContent());
  	}

}
