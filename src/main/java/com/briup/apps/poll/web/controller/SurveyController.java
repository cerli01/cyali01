package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="评教相关接口")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	/**
	 * @return
	 */
	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询出所有的评教信息")
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list = surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询出所有的评教信息",notes="每个评教信息中包含所属课程、所属班级、班主任姓名和问卷名字的信息")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过关键字查询出评教信息")
	@GetMapping("querySurvey")
	public MsgResponse querySurvey(String keywords){
		try {
			List<Survey> list = surveyService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id删除评教信息")
	@GetMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(@RequestParam Long id){
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="添加评教信息")
	@PostMapping("saveSurvey")
	public MsgResponse saveCourse(Survey survey){
		try {
			surveyService.save(survey);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="修改评教信息")
	@PostMapping("updateSurvey")
	public MsgResponse updateSurvey(Survey survey){
		try {
			surveyService.update(survey);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除评教信息")
	@GetMapping("batchDeleteSurvey")
	public MsgResponse batchDeleteSurvey(long[] ids){
		try {
			surveyService.batchDelete(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
