package com.shourov.springBatchDemo.mapper;

import com.shourov.springBatchDemo.dto.VisitorsDto;
import com.shourov.springBatchDemo.model.Visitors;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorsMapper {
    Visitors toVisitors(VisitorsDto visitorsDto);
}
