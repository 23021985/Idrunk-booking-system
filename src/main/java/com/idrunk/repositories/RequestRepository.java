package com.idrunk.repositories;

import com.idrunk.models.Request;

import com.idrunk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByUsername(User user);
}