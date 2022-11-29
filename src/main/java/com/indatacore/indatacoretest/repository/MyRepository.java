package com.indatacore.indatacoretest.repository;

import com.indatacore.indatacoretest.domaine.Etudiant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<Etudiant,Long> {
}
