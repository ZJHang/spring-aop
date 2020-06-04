package com.zjhang.service;

import com.zjhang.dao.StudentMapper;
import com.zjhang.domain.dto.StudentDTO;
import com.zjhang.domain.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengjh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {
    private final StudentMapper studentMapper;

    public Student insertStudent(StudentDTO studentDTO) {
        Student student = Student.builder()
                .sno(1140299149)
                .sname(studentDTO.getSname())
                .sage(studentDTO.getSage())
                .sex(studentDTO.getSex())
                .tel(studentDTO.getTel())
                .email(studentDTO.getEmail())
                .address(studentDTO.getAddress())
                .build();

        this.studentMapper.insertSelective(student);

        return student;
    }

    public Student updeteStudent(Integer studentId, StudentDTO studentDTO) {
        Student student = Student.builder()
                .id(studentId)
                .sname(studentDTO.getSname())
                .sage(studentDTO.getSage())
                .sex(studentDTO.getSex())
                .tel(studentDTO.getTel())
                .email(studentDTO.getEmail())
                .address(studentDTO.getAddress())
                .build();

        this.studentMapper.updateByPrimaryKeySelective(student);

        return student;
    }

    public Student queryStudent(Integer studentId) {
        return this.studentMapper.selectByPrimaryKey(studentId);
    }
}
