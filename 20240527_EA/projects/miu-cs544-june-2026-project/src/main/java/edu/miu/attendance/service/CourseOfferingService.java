package edu.miu.attendance.service;

import edu.miu.attendance.dto.AttendanceRecordExcelDTO;
import edu.miu.attendance.dto.CourseOfferingDto;
import edu.miu.attendance.dto.CourseOfferingStudentAttendanceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseOfferingService {

    Page<CourseOfferingDto> findAll(Pageable pageable);

    CourseOfferingDto findById(long id);

    CourseOfferingDto saveCourseOffering(String username,CourseOfferingDto courseOfferingDto, Long courseOfferingId);

    CourseOfferingDto deleteCourseOffering(String username,long id);
    List<AttendanceRecordExcelDTO> attendanceExcelData(Long id);
    List<CourseOfferingDto> findByDate(String date) ;
    CourseOfferingStudentAttendanceDTO getCourseOfferingAttendanceByStudentId(String studentId, Long courseOfferingId);


}
