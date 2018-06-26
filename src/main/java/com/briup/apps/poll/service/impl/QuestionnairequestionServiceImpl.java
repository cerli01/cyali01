package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.UserExample;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.service.IQuestionnairequestionService;

@Service
public class QuestionnairequestionServiceImpl implements IQuestionnairequestionService {
	@Autowired
	private QuestionnaireQuestionMapper questionnairequestionMapper;

	@Override
	public List<QuestionnaireQuestion> findAll() throws Exception {
		// TODO Auto-generated method stub
		QuestionnaireQuestionExample example = new QuestionnaireQuestionExample();
		return questionnairequestionMapper.selectByExample(example);
	}

	@Override
	public void save(QuestionnaireQuestion questionnairequestion) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.insert(questionnairequestion);
	}

	@Override
	public void update(QuestionnaireQuestion questionnairequestion) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.updateByPrimaryKey(questionnairequestion);
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		questionnairequestionMapper.deleteByPrimaryKey(id);
	}

}
