package com.course.hr_worker.resources;

import com.course.hr_worker.entities.Worker;
import com.course.hr_worker.respositories.WorkerRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;
    @Autowired
    private WorkerRespository workerRespository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRespository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws InterruptedException {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("PORT = " + env.getProperty("local.server.port"));
        Worker worker = workerRespository.findById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(worker);
    }

}
