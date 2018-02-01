package org.charlie.kidsjobsdata.models.data;

import org.charlie.kidsjobsdata.models.Job;
import org.charlie.kidsjobsdata.models.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {
}
