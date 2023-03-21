package coms.Groups.exceptionsGlobal;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Component
public class GlobalException {
	@ExceptionHandler(QuestionAlreadyExists.class)
	public QuestionNotFound getQuestionExce() {
		return new QuestionNotFound();
	}

	
	@ExceptionHandler(QuestionNotFound.class)
	public QuestionNotFound getQuestionError() {
		return new QuestionNotFound();
	}
	@ExceptionHandler(AnswerAlreadyExists.class)
	public AnswerAlreadyExists getException() {
		return new AnswerAlreadyExists();
	}
	
	@ExceptionHandler(AnswerNotFound.class)
	public AnswerNotFound getAnswerError() {
		return new AnswerNotFound();
	}

}
