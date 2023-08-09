//package com.ai.ats.mapper;
//
//import com.ai.ats.dto.JobDTO;
//import org.mapstruct.BeanMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Mapper(componentModel = "spring")
//public interface JobMapper {
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateJobDTO(JobDTO jobDTO, @MappingTarget JobDTO jobDTOUpdate);
//}
