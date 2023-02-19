package org.home.payroll.dto.mapper;

import org.home.payroll.domain.TimecardEntity;
import org.home.payroll.dto.TimecardDto;
import org.springframework.stereotype.Component;

@Component
public class TimeCardDtoMapper {

    public TimecardDto toDto(TimecardEntity entity) {
        TimecardDto dto = new TimecardDto();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setWorkDate(entity.getWorkDate());
        dto.setHoursWorked(entity.getHoursWorked());
        return dto;
    }

    public TimecardEntity toEntity(TimecardDto dto) {
        TimecardEntity entity = new TimecardEntity();
        entity.setId(dto.getId());
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setWorkDate(new java.sql.Date(dto.getWorkDate().getTime())); //FIXME
        entity.setHoursWorked(dto.getHoursWorked());
        return entity;
    }

    public void updateEntity(TimecardDto dto, TimecardEntity entity) {
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setWorkDate(new java.sql.Date(dto.getWorkDate().getTime())); //FIXME
        entity.setHoursWorked(dto.getHoursWorked());
    }
}

