package com.kodilla.bankApp.mapper;

import com.kodilla.bankApp.domain.Bond;
import com.kodilla.bankApp.domain.dTo.BondDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BondMapper {
    public Bond mapToBond(final BondDto bondDto){
        return new Bond(
                bondDto.getId(),
                bondDto.getIssuer(),
                bondDto.getUnits(),
                bondDto.getUnitValue()
        );
    }
    public BondDto mapToBondDto(final Bond bond){
        return new BondDto(
                bond.getId(),
                bond.getIssuer(),
                bond.getUnits(),
                bond.getUnitValue()
        );
    }

    public List<BondDto>mapToBondDtoList(final List<Bond>bondList){
        return bondList.stream()
                .map(p->new BondDto(p.getId(),p.getIssuer(),p.getUnits(),p.getUnitValue()))
                .collect(Collectors.toList());
    }
}
