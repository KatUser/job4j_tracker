package ru.job4j.mapstuct.mappers;

import org.mapstruct.Mapping;
import ru.job4j.mapstuct.dto.StudentSubjectDto;
import ru.job4j.mapstuct.model.StudentSubject;

public interface StudentSubjectMapper {
    @Mapping(target = "className", source = "classVal")
    @Mapping(target = "subject", source = "subject.name")
    StudentSubjectDto getModelFromEntity(StudentSubject studentSubject);
}