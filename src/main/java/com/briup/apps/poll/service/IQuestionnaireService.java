package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;

public interface IQuestionnaireService {

	List<Questionnaire> findAll() throws Exception;
	
//	List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception;

	List<Questionnaire> query(String keywords) throws Exception;
	
//	void saveOrUpdate(Questionnaire questionnaire) throws Exception;
	
	void save(Questionnaire questionnaire) throws Exception;
	
	void update(Questionnaire questionnaire) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(long[] ids) throws Exception;
	
}
