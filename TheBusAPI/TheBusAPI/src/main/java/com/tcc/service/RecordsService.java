package com.tcc.service;

import com.tcc.model.Response;
import com.tcc.model.Records;
import com.tcc.repository.RecordsRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class RecordsService {

    private final RecordsRepository recordsRepository;
    private RestTemplate restTemplate;

    private MongoTemplate mongoTemplate;

    public RecordsService(RecordsRepository recordsRepository, RestTemplateBuilder restTemplateBuilder, MongoTemplate mongoTemplate) {
        this.recordsRepository = recordsRepository;
        this.restTemplate = restTemplateBuilder.build();
        this.mongoTemplate = mongoTemplate;
    }

    public Records salvarHorario(Records records) {
        return recordsRepository.save(records);
    }

    public List<Records> getHorario() {
      Response payload = this.restTemplate.getForObject("https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=cb96a73e-e18b-4371-95c5-2cf20e359e6c&q=t12", Response.class);
      List<Records> records = payload.getResult().getRecords();
      recordsRepository.saveAll(records);
      return sortRecords();
    }

    private List<Records> sortRecords() {
        Query query = new Query();
        query.addCriteria(Criteria.where("sentido").is("NORTESUL"));
        query.with(Sort.by(Sort.Direction.ASC, "horario_largada"));
        return mongoTemplate.find(query, Records.class);
    }

}
