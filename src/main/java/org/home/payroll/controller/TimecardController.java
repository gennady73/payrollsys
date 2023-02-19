package org.home.payroll.controller;

import org.home.payroll.dto.TimecardDto;
import org.home.payroll.repository.EmployeeRepository;
import org.home.payroll.service.TimecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll/timecards")
public class TimecardController {

    private TimecardService timecardService;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public TimecardController(TimecardService timecardService,
                              EmployeeRepository employeeRepository) {
        this.timecardService = timecardService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimecardDto> getTimecardById(@PathVariable("id") int id) {
        TimecardDto timecard = timecardService.getTimecardById(id);
        if (timecard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(timecard, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<TimecardDto>> getTimecardsByEmployeeId(@PathVariable("employeeId") int employeeId) {
        List<TimecardDto> timecards = timecardService.getTimecardsByEmployeeId(employeeId);
        if (timecards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(timecards, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TimecardDto> addTimecard(@RequestBody TimecardDto timecardDto) {
        TimecardDto addedTimecard = timecardService.addTimecard(timecardDto);
        return new ResponseEntity<>(addedTimecard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimecardDto> updateTimecard(@PathVariable("id") int id, @RequestBody TimecardDto timecardDto) {
        TimecardDto updatedTimecard = timecardService.updateTimecard(id, timecardDto);
        if (updatedTimecard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTimecard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimecard(@PathVariable("id") int id) {
        if (timecardService.deleteTimecard(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
