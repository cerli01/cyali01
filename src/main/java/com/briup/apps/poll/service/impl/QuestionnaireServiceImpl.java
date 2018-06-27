package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService{

	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
	
	@Override
	public List<Questionnaire> findAll() throws Exception {
		//创建空模板
		QuestionnaireExample example = new QuestionnaireExample();
		//调用QBE查询，并且将查询结果返回
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

//	@Override
//	public List<QuestionnaireVM> findAllQuestionnaireVM() throws Exception {
//		return questionnaireVMMapper.selectAll();
//	}
	
	@Override
	public List<Questionnaire> query(String keywords) throws Exception {
		QuestionnaireExample example = new QuestionnaireExample();
		example.createCriteria().andNameLike(keywords);
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionnaireMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids){
			questionnaireMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void save(Questionnaire questionnaire) throws Exception {
		questionnaireMapper.insert(questionnaire);
	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		questionnaireMapper.updateByPrimaryKeyWithBLOBs(questionnaire);
		
	}

//	@Override
//	public void saveOrUpdate(Questionnaire questionnaire) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
	
}
