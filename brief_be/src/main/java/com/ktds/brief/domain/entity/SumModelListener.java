package com.ktds.brief.domain.entity;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SumModelListener extends AbstractMongoEventListener<Sum> {
	
	private final SequenceGeneratorService sequenceGenerator;
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<Sum> event) {
		event.getSource().setId(sequenceGenerator.generateSequence(Sum.SEQUENCE_NAME));
	}

}
