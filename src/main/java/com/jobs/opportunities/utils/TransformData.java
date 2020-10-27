package com.jobs.opportunities.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TransformData {

    public <E> List<E> transformToDTO (String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<E> listObject = new ArrayList<>();
        try {
            listObject = objectMapper.readValue(jsonString, new TypeReference<List<E>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return listObject;
    }
}
