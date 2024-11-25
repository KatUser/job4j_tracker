package ru.job4j.mapstuct.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstuct.model.StudentEntity;
import ru.job4j.mapstuct.dto.StudentDto;

/**
 * @Mapper сообщает компилятору, что этот интерфейс относится к библиотеке MapStruct
 */
@Mapper
public interface StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity studentEntity);

    @InheritInverseConfiguration
    StudentEntity detEntityFromDto(StudentDto studentDto);

    /*
    @Mapping(target = "classVal", source="className")
    StudentEntity getEntityFromDto(StudentDto studentDto);
    */

    default StudentDto getModelFromEntityCustom(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setClassName(studentEntity.getClassVal());
        return studentDto;
    }
}
