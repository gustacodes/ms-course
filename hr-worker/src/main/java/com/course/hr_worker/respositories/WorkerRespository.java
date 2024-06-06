package com.course.hr_worker.respositories;

import com.course.hr_worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRespository extends JpaRepository<Worker, Long> {

}
