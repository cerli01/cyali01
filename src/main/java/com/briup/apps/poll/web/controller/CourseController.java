package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	/**
	 * @return
	 */
	@Autowired
	private ICourseService courseService;
	
	@ApiOperation(value="查询出所有的课程信息")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过关键字查询出课程信息")
	@GetMapping("queryCourse")
	public MsgResponse queryCourse(String keywords){
		try {
			List<Course> list = courseService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id删除课程信息")
	@GetMapping("deleteCourseById")
	public MsgResponse deleteCourseById(@RequestParam Long id){
		try {
			courseService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="批量删除课程信息")
	@GetMapping("batchDeleteCourse")
	public MsgResponse batchDeleteCourse(long[] ids){
		try {
			courseService.batchDelete(ids);	
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或修改修改课程信息",notes="如果课程id不为空，表示更新操作;如果课程id为空，表示保存操作")
	@PostMapping("saveOrUpdateCourse")
	public MsgResponse saveOrUpdateCourse(Course course){
		try {
			if(course!=null&&course.getId()!=null){
				courseService.update(course);
			}else{
				courseService.save(course);
			}		
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
		
}
















