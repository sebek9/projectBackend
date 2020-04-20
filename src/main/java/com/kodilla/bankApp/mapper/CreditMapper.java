package com.kodilla.bankApp.mapper;

import com.kodilla.bankApp.domain.Credit;
import com.kodilla.bankApp.domain.dTo.CreditDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditMapper {
    public Credit mapToCredit(final CreditDto creditDto){
        return new Credit(
                creditDto.getId(),
                creditDto.getCreditName(),
                creditDto.getCreditType(),
                creditDto.getAmount(),
                creditDto.getStatus()
        );
    }
    public CreditDto mapToCreditDto(final Credit credit){
        return new CreditDto(
                credit.getId(),
                credit.getCreditName(),
                credit.getCreditType(),
                credit.getAmount(),
                credit.getStatus()
        );
    }

    public List<CreditDto>mapToCreditDtoList(final List<Credit>creditList){
        return creditList.stream()
                .map(p->new CreditDto(p.getId(),p.getCreditName(),p.getCreditType(),p.getAmount(),p.getStatus()))
                .collect(Collectors.toList());
    }
}
