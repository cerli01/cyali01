package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServiceImpl implements ISurveyService{

	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired SurveyVMMapper surveyVMMapper;
	
	@Override
	public List<Survey> findAll() throws Exception {
		//创建空模板
		SurveyExample example = new SurveyExample();
		//调用QBE查询，并且将查询结果返回
		return surveyMapper.selectByExample(example);
	}

	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		return surveyVMMapper.selectAll();
	}
	
	@Override
	public List<Survey> query(String keywords) throws Exception {
		SurveyExample example = new SurveyExample();
		example.createCriteria().andCodeLike(keywords);
//		example.createCriteria().andStatusLike(keywords);
		return surveyMapper.selectByExample(example);
	}

	@Override
	public void save(Survey survey) throws Exception {
		surveyMapper.insert(survey);
	}

	@Override
	public void update(Survey survey) throws Exception {
		surveyMapper.updateByPrimaryKey(survey);
	}

	@Override
	public void deleteById(long id) throws Exception {
		surveyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids){
			surveyMapper.deleteByPrimaryKey(id);
		}
	}

}
