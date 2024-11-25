package ru.job4j.mapstuct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstuct.dto.DeliveryAddressDTO;
import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstuct.model.AddressEntity;
import ru.job4j.mapstuct.model.StudentEntity;

public class MainWithAddress {
    public static void main(String[] args) {
        DeliveryAddressMapper deliveryAddressMapper
                = Mappers.getMapper(DeliveryAddressMapper.class);

        StudentEntity studentEntity = new StudentEntity(0, "entity", "junior");
        StudentDto studentDto = new StudentDto(11, "dto", "middle");
        AddressEntity addressEntity = new AddressEntity(100, "entityCity", "entityState");

        DeliveryAddressDTO deliveryAddressDTO = deliveryAddressMapper
                .getDeliveryAddress(studentEntity, addressEntity);
        System.out.println(deliveryAddressDTO);
    }
}
