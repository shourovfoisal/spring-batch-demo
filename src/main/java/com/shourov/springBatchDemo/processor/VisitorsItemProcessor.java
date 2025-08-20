package com.shourov.springBatchDemo.processor;

import com.shourov.springBatchDemo.dto.VisitorsDto;
import com.shourov.springBatchDemo.mapper.VisitorsMapper;
import com.shourov.springBatchDemo.model.Visitors;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitorsItemProcessor implements ItemProcessor<VisitorsDto, Visitors> {
    private final VisitorsMapper mapper;
    
    @Override
    public Visitors process(VisitorsDto visitorsDto) {
        return mapper.toVisitors(visitorsDto);
    }
}
