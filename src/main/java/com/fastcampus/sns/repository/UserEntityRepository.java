package com.fastcampus.sns.repository;

import com.fastcampus.sns.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUserName(String userName); // 검색 결과가 Null값이 될수 있기 때문에 Optional 타입으로 객체를 감싸준다.

}
