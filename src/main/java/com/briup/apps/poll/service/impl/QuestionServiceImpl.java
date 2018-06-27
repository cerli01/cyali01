package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.CourseExample;
import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService{

	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper  optionsMapper;
	
	@Override
	public List<Question> findAll() throws Exception {
		//创建空模板
		QuestionExample example = new QuestionExample();
		//调用QBE查询，并且将查询结果返回
		return questionMapper.selectByExample(example);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAll();
	}
	
	@Override
	public List<Question> query(String keywords) throws Exception {
		QuestionExample example = new QuestionExample();
		example.createCriteria().andNameLike(keywords);
		return questionMapper.selectByExample(example);
	}

	@Override
	public void deleteById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids){
			questionMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		//0.从 questuinVM中拆分出来question  options
		Question question = new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());
		question.setQuestiontype(questionVM.getQuestionType());
		
		List<Options> options=questionVM.getOptions();
				
		if(questionVM.getId()!=null){    //修改操作
					
		}else{      //保存操作
					//1.保存问题信息
			questionMapper.insert(question);
					//2.保存选项信息
			long id = question.getId();
			for(Options option:options){
				option.setQuestionId(id);
				optionsMapper.insert(option);
			}	
	     }
	 }
}
