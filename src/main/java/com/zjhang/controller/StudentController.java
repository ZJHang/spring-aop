package com.zjhang.controller;

import com.zjhang.aop.CheckAuth;
import com.zjhang.domain.dto.StudentDTO;
import com.zjhang.domain.entity.Student;
import com.zjhang.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengjh
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    private final StudentService studentService;

    /**
     * 插入学生信息
     *
     * @return
     */
    @PostMapping("/insertStudent")
    @CheckAuth(operator = "administrator")
    public Student insertStudent(@RequestBody StudentDTO studentDTO) {
        return this.studentService.insertStudent(studentDTO);
    }

    /**
     * 更新学生信息
     *
     * @param studentId
     * @param studentDTO
     * @return
     */
    @PostMapping("/updeteStudent")
    @CheckAuth(operator = "administrator")
    public Student updeteStudent(@RequestParam("studentId") Integer studentId,
                                 @RequestBody StudentDTO studentDTO) {
        return this.studentService.updeteStudent(studentId, studentDTO);
    }

    /**
     * 根据学生ID查询学生信息
     *
     * @param studentId
     * @return
     */
    @GetMapping("/queryStudent")
    @CheckAuth(operator = "general_user")
    public Student queryStudent(@RequestParam("studentId") Integer studentId) {
        return this.studentService.queryStudent(studentId);
    }
}
