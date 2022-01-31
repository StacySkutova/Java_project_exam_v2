package com.boots.repository;

import com.boots.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long>{
	List<Word> findByUser(String user);
}
