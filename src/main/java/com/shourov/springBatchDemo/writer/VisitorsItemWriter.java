package com.shourov.springBatchDemo.writer;

import com.shourov.springBatchDemo.model.Visitors;
import com.shourov.springBatchDemo.repository.VisitorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitorsItemWriter implements ItemWriter<Visitors> {
    private final VisitorsRepository repository;

    @Override
    public void write(Chunk<? extends Visitors> chunk) {
        repository.saveAll(chunk.getItems());
    }
}
