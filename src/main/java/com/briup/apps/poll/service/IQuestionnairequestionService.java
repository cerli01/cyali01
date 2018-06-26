package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.QuestionnaireQuestion;

public interface IQuestionnairequestionService {
	List<QuestionnaireQuestion> findAll() throws Exception;

	void save(QuestionnaireQuestion questionnairequestion) throws Exception;

	void update(QuestionnaireQuestion questionnairequestion) throws Exception;

	void deleteById(long id) throws Exception;
}
