package com.shourov.springBatchDemo.configuration;

import com.shourov.springBatchDemo.dto.VisitorsDto;
import com.shourov.springBatchDemo.mapper.VisitorsFieldSetMapper;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
    @Bean
    @StepScope
    public FlatFileItemReader<VisitorsDto> flatFileItemReader(@Value("#{jobParameters['inputFile']}") final String visitorsFile) {
        FlatFileItemReader<VisitorsDto> reader = new FlatFileItemReader<>();
        reader.setName("VISITORS_READER");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }
    
    
    @Bean
    public LineMapper<VisitorsDto> lineMapper() {
        DefaultLineMapper<VisitorsDto> mapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        
        tokenizer.setDelimiter(",");
        tokenizer.setNames("id", "firstName", "lastName", "emailAddress", "phoneNumber", "address", "visitDate");
        tokenizer.setStrict(false);
        
        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(new VisitorsFieldSetMapper());
        
        return mapper;
    }
}
