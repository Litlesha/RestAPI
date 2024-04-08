package com.RestApi.RestApi.Repository;

import com.RestApi.RestApi.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
