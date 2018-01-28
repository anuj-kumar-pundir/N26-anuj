package com.n26.controller;

import com.n26.model.Statistics;
import com.n26.model.Transcation;
import com.n26.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	public TransactionRepository transactionRepository;

	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public Statistics getStatistics() {
		return transactionRepository.find(Instant.now().getEpochSecond());
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	public ResponseEntity transcations(@RequestBody Transcation transcation) {
		if(Instant.now().getEpochSecond() - transcation.getTimestamp() > 60 ){
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		transactionRepository.save(transcation);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/currentTimeInSeconds", method = RequestMethod.GET)
	public long getCurrentTimeInSeconds() {
		return Instant.now().getEpochSecond();
	}
}
