package ru.job4j.mapstuct.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeliveryAddressDTO {
    private String name;
    private int houseNumber;
    private String city;
    private String state;
}
