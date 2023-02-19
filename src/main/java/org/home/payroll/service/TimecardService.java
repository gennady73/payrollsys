package org.home.payroll.service;

import org.home.payroll.domain.TimecardEntity;
import org.home.payroll.dto.TimecardDto;
import org.home.payroll.dto.mapper.TimeCardDtoMapper;
import org.home.payroll.repository.TimecardRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimecardService {

    private final TimecardRepository timecardRepository;

    private final TimeCardDtoMapper timeCardDtoMapper;

    public TimecardService(TimecardRepository timecardRepository) {

        this.timecardRepository = timecardRepository;
        this.timeCardDtoMapper = new TimeCardDtoMapper();
    }

    public TimecardEntity save(TimecardEntity timecardEntity) {
        return timecardRepository.save(timecardEntity);
    }

    public List<TimecardEntity> getAllTimecards() {
        return timecardRepository.findAll();
    }

    public TimecardDto getTimecardById(int id) {
        TimecardEntity timecardEntity = timecardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Timecard not found with id " + id));
       return timeCardDtoMapper.toDto(timecardEntity);
    }

    public List<TimecardDto> getTimecardsByEmployeeId(int employeeId) {
        List<TimecardDto> timecardDtoList = timecardRepository.findByEmployeeId(employeeId)
            .stream().map(timecardEntity -> {
                return new TimeCardDtoMapper().toDto(timecardEntity);
            }).collect(Collectors.toList());

        return timecardDtoList;
    }

    public TimecardDto addTimecard(TimecardDto timecardDto) {
        TimecardEntity timecardEntity = timecardRepository.save(timeCardDtoMapper.toEntity(timecardDto));
        TimecardDto addedTimecard = timeCardDtoMapper.toDto(timecardEntity);
        return addedTimecard;
    }

    public TimecardDto updateTimecard(int id, TimecardDto timecardDto) {
        TimecardEntity timecardEntity = timecardRepository.save(timeCardDtoMapper.toEntity(timecardDto));
        TimecardDto addedTimecard = timeCardDtoMapper.toDto(timecardEntity);
        return addedTimecard;
    }

    public boolean deleteTimecard(int id) {
        TimecardEntity timecardEntity = timecardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Timecard not found with id " + id));
        timecardRepository.delete(timecardEntity);
        return timecardRepository.findById(id) == null;
    }
}
