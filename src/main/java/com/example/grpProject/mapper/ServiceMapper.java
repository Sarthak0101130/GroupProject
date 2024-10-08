package com.example.grpProject.mapper;

import com.example.grpProject.dto.ServiceDto;
import com.example.grpProject.entity.Service;

import java.util.Collections;
import java.util.stream.Collectors;

public class ServiceMapper {

    public static ServiceDto mapToServiceDto(Service service){
        return new ServiceDto(
                service.getId(),
                service.getName(),
                service.getClients() != null
                        ? service.getClients().stream()
                        .map(client -> client.getId())
                        .collect(Collectors.toList())
                        : Collections.emptyList(),
                service.getPrograms() != null
                        ? service.getPrograms().stream()
                        .map(program -> program.getId())
                        .collect(Collectors.toList())
                        : Collections.emptyList()
        );
    }

    public static Service mapToService(ServiceDto serviceDto){
        return new Service(
                serviceDto.getId(),
                serviceDto.getName(),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}
