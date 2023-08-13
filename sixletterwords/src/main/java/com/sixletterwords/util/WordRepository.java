package com.sixletterwords.util;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sixletterwords.model.Word;

interface WordRepository extends JpaRepository<Word, Long> {

}
