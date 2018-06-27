package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "答案相关API接口")
@RestController
@RequestMapping("/answers")

public class AnswersController {
	@Autowired
	private IAnswersService answersService;

	@ApiOperation(value = "查询所有答案")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="查询出所有的班级答案信息",notes="每个答案信息中包含所属课调的信息")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM(){
		try {
			List<AnswersVM> list = answersService.finfAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value = "通过关键字查询答案")
	@GetMapping("queryAnswers")
	public MsgResponse queryAnswers(String keywords) {
		try {
			List<Answers> list = answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "插入答案")
	@PostMapping("saveOrUpdateAnswers")
	public MsgResponse saveOrUpdateAnswers(Answers answers) {
		try {
			if(answers!=null&&answers.getId()!=null){
				answersService.update(answers);
			}else{
				answersService.save(answers);
			}
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

//	@ApiOperation(value = "修改答案信息")
//	@PostMapping("updateAnswers")
//	public MsgResponse updateAnswers(Answers answers) {
//		try {
//			answersService.update(answers);
//			return MsgResponse.success("success", null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return MsgResponse.error(e.getMessage());
//		}
//	}

	@ApiOperation(value = "通过ID删除答案")
	@GetMapping("deleteByIdAnswers")
	public MsgResponse deleteByIdAnswers(long id) {
		try {
			answersService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "批量删除答案")
	@GetMapping("batchDeleteAnswers")
	public MsgResponse batchDeleteAnswers(long[] ids) {
		try {
			answersService.batchDelete(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
