package com.smart.delta.system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponse {
    private List<StudentDTO> studentDTOList;

    public StudentResponse(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }
}
