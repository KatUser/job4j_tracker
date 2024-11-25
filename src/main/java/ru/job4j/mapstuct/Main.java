package ru.job4j.mapstuct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstuct.mappers.StudentMapper;
import ru.job4j.mapstuct.model.StudentEntity;
import ru.job4j.mapstuct.dto.StudentDto;

public class Main {
    public static void main(String[] args) {
        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity studentEntity = new StudentEntity(0, "entity", "junior");
        StudentDto studentDto = new StudentDto(11, "dto", "middle");

        StudentDto fromEntity = studentMapper.getModelFromEntity(studentEntity);
        System.out.println("from Entity = " + fromEntity);

        StudentEntity fromDto = studentMapper.detEntityFromDto(studentDto);
        System.out.println("from Dto = " + fromDto);
    }
}
