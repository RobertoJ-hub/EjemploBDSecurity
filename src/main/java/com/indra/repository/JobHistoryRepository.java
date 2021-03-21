package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.JobHistory;
import com.indra.model.JobHistoryEmbedded;

public interface JobHistoryRepository extends CrudRepository<JobHistory, JobHistoryEmbedded> {

}
