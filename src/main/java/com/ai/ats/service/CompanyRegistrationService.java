package com.ai.ats.service;

import com.ai.ats.dto.*;
import com.ai.ats.entity.jpa.CompanyRegistration;
import com.ai.ats.exception.*;
import com.ai.ats.repository.CompanyRegistrationJPARepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CompanyRegistrationService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CompanyRegistrationJPARepository companyRegistrationJPARepository;


    public CompanyRegistrationDTO addCompanyRegistration(CompanyRegistrationDTO companyRegistrationDTO) {

        CompanyRegistration companyRegistration;
        try {
            CompanyRegistration companyRegistrationMap  = modelMapper.map(companyRegistrationDTO, CompanyRegistration.class);
//            companyRegistrationMap.setDStatus(companyRegistrationDTO.isDStatus());

            companyRegistration = companyRegistrationJPARepository.save(companyRegistrationMap);
            log.error("Company added");

        } catch (Exception e) {
            log.error("Add a valid Company ");
            throw new CompanyRegistrationException("Company cant saved");

        }

        return modelMapper.map(companyRegistration, CompanyRegistrationDTO.class);
    }

    public CompanyRegistrationDTO getCompanyRegistration(int companyId) {

        return modelMapper.map(companyRegistrationJPARepository.findById(companyId)
                .orElseThrow(() -> new CompanyRegistrationNotFoundException("Company Registration Not found with email " + companyId)), CompanyRegistrationDTO.class);


    }

    public List<CompanyRegistrationDTO> getCompanyRegistrations() {
        List<CompanyRegistration> companyRegistrations = (List<CompanyRegistration>) companyRegistrationJPARepository.findAll();
        return modelMapper.map(companyRegistrations, new TypeToken<List<CompanyRegistrationDTO>>() {
        }.getType());

    }

    @Transactional
    public void deleteCompanyRegistration(int companyId) {

        try {
            long t = companyRegistrationJPARepository.deleteByCompanyId(companyId);
            if (t == 0) {
                throw new IllegalArgumentException();
            }
            log.info("company Registration deleted");
        } catch (Exception e) {
            log.error("company Id not found");
            throw new CompanyRegistrationNotFoundException("company Registration  Not found with  " + companyId);

        }

    }
    public CompanyRegistrationDTO addCompanySetup(int companyId, CompanySetupDTO companySetupDTO) {
        companySetupDTO.setEmployees(new ArrayList<>());
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        CompanyRegistration companyRegistration;
        try {
            if(companyRegistrationDTO.getCompanySetup() != null){
                throw new DataIntegrityViolationException("CompanySetup is already present ");
            }
            companyRegistrationDTO.setCompanySetup(companySetupDTO);
            companyRegistration = companyRegistrationJPARepository.save(modelMapper.map(companyRegistrationDTO, CompanyRegistration.class));
            log.error("CompanySetup added to companyId " + companyId);

        } catch (DataIntegrityViolationException e) {
            log.error("CompanySetup is already present " + companyId);
            e.printStackTrace();
            throw new CompanySetupException("CompanySetup is already present " + companyId);

        }
        catch (Exception e) {
            log.error("CompanySetup not added to companyId " + companyId);
            e.printStackTrace();
            throw new CompanyRegistrationException("CompanySetup not added to companyId " + companyId);

        }
        return modelMapper.map(companyRegistration, CompanyRegistrationDTO.class);

    }

    public CompanyRegistrationDTO deleteCompanySetup(int companyId) {
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        CompanyRegistration companyRegistration;
        try {

            if(companyRegistrationDTO.getCompanySetup() == null){
                throw new DataIntegrityViolationException("CompanySetup is not present ");
            }
            companyRegistrationDTO.setCompanySetup(null);
            companyRegistration = companyRegistrationJPARepository.save(modelMapper.map(companyRegistrationDTO, CompanyRegistration.class));
            log.error("CompanySetup deleted to companyId " + companyId);

        }
        catch (DataIntegrityViolationException e) {
            log.error("CompanySetup is already present " + companyId);
            e.printStackTrace();
            throw new CompanySetupNotFoundException("CompanySetup is not present" + companyId);

        }
        catch (Exception e) {
            log.error("CompanySetup not deleted to companyId " + companyId);
            e.printStackTrace();
            throw new CompanyRegistrationException("CompanySetup not deleted to companyId " + companyId);

        }
        return modelMapper.map(companyRegistration, CompanyRegistrationDTO.class);

    }

    public CompanyRegistrationDTO addEmployee(int companyId, EmployeeDTO employeeDTO) {
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        CompanyRegistration companyRegistration;
        try {
            companyRegistrationDTO.getCompanySetup().getEmployees().add(employeeDTO);
            companyRegistration = companyRegistrationJPARepository.save(modelMapper.map(companyRegistrationDTO, CompanyRegistration.class));
            log.error(" employee added to companyId " + companyId);

        }catch (DataIntegrityViolationException e){
            log.error("employee not present in " + companyId);
            e.printStackTrace();
            throw new EmployeeException("employee already present in " + companyId);

        }
        catch (Exception e) {
            log.error("employee not added to companyId " + companyId);
            e.printStackTrace();
            throw new CompanyRegistrationException("employee not added to companyId " + companyId);

        }
        return modelMapper.map(companyRegistration, CompanyRegistrationDTO.class);

    }

    public EmployeeDTO getEmployee(int companyId, int employeeId) {
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        EmployeeDTO employeeDTO;
        try {
            employeeDTO = companyRegistrationDTO.getCompanySetup().getEmployees().stream().filter(employee -> employee.getEmpId() == employeeId).findAny()
                    .orElseThrow(() -> new EmployeeNotFoundException(""));
        }catch (EmployeeNotFoundException e){
            log.error("employee is  present " + companyId);
            throw new EmployeeNotFoundException("employee not found with employee Id " + employeeId);
        }
        catch (NullPointerException e){
            log.error("CompanySetup is not present " + companyId);
            e.printStackTrace();
            throw new EmployeeNotFoundException("CompanySetup not present " + companyId);
        }
        catch (Exception e) {
            log.error("employee is not present " + companyId);
            e.printStackTrace();
            throw new CompanyRegistrationException("employee not present " + employeeId);

        }
        return employeeDTO;

    }

    public List<EmployeeDTO> getEmployees(int companyId) {
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        List<EmployeeDTO> employeesDTO;
        try {
            employeesDTO = companyRegistrationDTO.getCompanySetup().getEmployees();
        }catch (NullPointerException e){
            log.error("CompanySetup is not present " + companyId);
            e.printStackTrace();
            throw new JobNotFoundException("CompanySetup not present " + companyId);
        }
        catch (Exception e) {
            log.error("employee is not present ");
            e.printStackTrace();
            throw new CompanyRegistrationException("employee not present ");

        }
        return employeesDTO;

    }
    public CompanyRegistrationDTO deleteEmployee(int companyId, int employeeId) {
        CompanyRegistrationDTO companyRegistrationDTO = getCompanyRegistration(companyId);
        CompanyRegistration companyRegistration;
        try {
            boolean isEmployee = companyRegistrationDTO.getCompanySetup().getEmployees().removeIf(employee -> employee.getEmpId() == employeeId);
            companyRegistration = companyRegistrationJPARepository.save(modelMapper.map(companyRegistrationDTO, CompanyRegistration.class));
            log.error("employee removed to companyId " + companyId);
            if(!isEmployee){
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e) {
            log.error("employee not removed to companyId " + companyId);
            e.printStackTrace();
            throw new CompanyRegistrationException("employee not removed to companyId " + companyId);

        }
        return modelMapper.map(companyRegistration, CompanyRegistrationDTO.class);

    }


}
