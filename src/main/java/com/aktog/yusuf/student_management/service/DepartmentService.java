package com.aktog.yusuf.student_management.service;

import com.aktog.yusuf.student_management.dto.converter.DepartmentDtoConverter;
import com.aktog.yusuf.student_management.entity.Faculty;
import com.aktog.yusuf.student_management.repository.DepartmentRepository;
import com.aktog.yusuf.student_management.dto.DepartmentDto;
import com.aktog.yusuf.student_management.dto.request.CreateDepartmentRequest;
import com.aktog.yusuf.student_management.dto.request.update.UpdateDepartmentRequest;
import com.aktog.yusuf.student_management.entity.Department;
import com.aktog.yusuf.student_management.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentDtoConverter departmentDtoConverter;
    private final FacultyRepository facultyRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             DepartmentDtoConverter departmentDtoConverter,
                             FacultyRepository facultyRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentDtoConverter = departmentDtoConverter;
        this.facultyRepository = facultyRepository;
    }


    public DepartmentDto createDepartment(CreateDepartmentRequest request) {
        Department department = new Department(
                request.getName(),
                request.getDepartmentCode(),
                request.getEnrollmentLimit(),
                facultyRepository.getById(request.getFacultyId())

        );
        return departmentDtoConverter.convert(departmentRepository.save(department));
    }

    public String deleteDepartment(Long departmentId) {
        Department department = departmentRepository.getById(departmentId);

        departmentRepository.deleteById(departmentId);

        return String.format("Department name:%s, id:%s has been deleted",
                department.getName(), department.getId());
    }

    public DepartmentDto updateDepartment(UpdateDepartmentRequest request,Long departmentId,Long facultyId){
        Department department = departmentRepository.getById(departmentId);
        Faculty faculty = facultyRepository.getById(facultyId);

        Department updated = new Department(
                department.getId(),
                request.getName(),
                request.getDepartmentCode(),
                request.getEnrollmentLimit(),
                faculty
        );

        return departmentDtoConverter.convert(departmentRepository.save(updated));
    }

    public List<Department> getALlDepartmentList(){
        return departmentRepository.findAll();
    }

    public List<DepartmentDto> getAllDepartmentDtoList(){
        return departmentDtoConverter.convert(departmentRepository.findAll());
    }

    public Department findByDepartmentId(Long departmentId){
        return departmentRepository.findById(departmentId).orElseThrow(EntityNotFoundException::new);
    }

    public DepartmentDto getDepartmentById(Long departmentId){
        return departmentDtoConverter.convert(departmentRepository.getById(departmentId));
    }

}