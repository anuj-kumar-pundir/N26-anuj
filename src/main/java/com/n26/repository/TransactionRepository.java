package com.n26.repository;

import com.n26.model.Statistics;
import com.n26.model.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface TransactionRepository extends JpaRepository<Transcation, String> {

	@Query(value = "SELECT new com.n26.model.Statistics(sum(t.amount), avg(t.amount), max(t.amount), min(t.amount), count(t.id)) FROM Transcation t WHERE :timestamp - t.timestamp < 60")
	public Statistics find(@Param("timestamp") long timestamp);

}
